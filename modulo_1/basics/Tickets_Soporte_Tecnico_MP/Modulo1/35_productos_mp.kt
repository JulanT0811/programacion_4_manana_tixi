data class Categoria(val id: Int, val nombre: String)

data class Ticket(
    val id: Int,
    val asunto: String,
    val prioridad: Int,
    val stockAsignado: Int,
    val categoria: Categoria,
    val activo: Boolean = true
) {
    val disponible: Boolean get() = activo && stockAsignado > 0
    val prioridadImpacto: Double get() = prioridad * 1.5

    fun aplicarEscalado(factor: Double): Ticket {
        require(factor in 0.0..10.0) { "Factor debe ser entre 0 y 10" }
        return copy(prioridad = (prioridad * factor).toInt())
    }
}

object GestorTickets {
    private val categorias = mutableListOf(
        Categoria(1, "Redes"),
        Categoria(2, "Hardware"),
        Categoria(3, "Software")
    )
    private val tickets = mutableListOf<Ticket>()
    private var siguienteId = 1

    fun agregarTicket(asunto: String, prioridad: Int, stock: Int, categoriaId: Int): Ticket? {
        val categoria = categorias.find { it.id == categoriaId } ?: return null
        val ticket = Ticket(siguienteId++, asunto, prioridad, stock, categoria)
        tickets.add(ticket)
        return ticket
    }

    fun listar(): List<Ticket> = tickets.toList()
    fun activos(): List<Ticket> = tickets.filter { it.disponible }
    fun porCategoria(id: Int): List<Ticket> = tickets.filter { it.categoria.id == id }
    fun buscar(query: String): List<Ticket> =
        tickets.filter { it.asunto.contains(query, ignoreCase = true) }
}

fun main() {
    GestorTickets.agregarTicket("Fallo de red", 5, 2, 1)
    GestorTickets.agregarTicket("Monitor apagado", 2, 0, 2)
    GestorTickets.agregarTicket("Error de compilación", 8, 1, 3)
    GestorTickets.agregarTicket("Actualización OS", 4, 3, 3)

    println("=== Todos los tickets ===")
    GestorTickets.listar().forEach { t ->
        val estado = if (t.disponible) "✅" else "❌"
        println("$estado ${t.asunto} — Prioridad: ${t.prioridadImpacto}")
    }

    println("\n=== Activos con escalado de prioridad ===")
    GestorTickets.activos()
        .map { it.aplicarEscalado(1.2) }
        .forEach { println("  ${it.asunto}: ${it.prioridad}") }
}