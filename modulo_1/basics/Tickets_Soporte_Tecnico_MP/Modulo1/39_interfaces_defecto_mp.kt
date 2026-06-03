interface Exportable {
    val idTicket: String
    fun exportar(): String
    val formato: String get() = "CSV"
}

interface Verificable {
    val reportes: List<String>
    val estaAprobado: Boolean get() = reportes.isEmpty()

    fun verificar(): Boolean
    fun listarReportes() {
        if (reportes.isEmpty()) println("Sin incidencias")
        else reportes.forEach { println("  ⚠️ $it") }
    }
}

data class TicketSoporte(
    override val idTicket: String,
    val usuario: String,
    val descripcion: String,
    val prioridad: Int
) : Exportable, Verificable {

    override fun exportar() =
        "$idTicket|$usuario|$descripcion|$prioridad"

    override val reportes: List<String> get() = buildList {
        if (usuario.isBlank()) add("El usuario no puede estar vacío")
        if (descripcion.length < 10) add("La descripción es demasiado corta")
        if (prioridad !in 1..10) add("La prioridad debe estar entre 1 y 10")
    }

    override fun verificar() = estaAprobado
}

fun main() {
    val ticket1 = TicketSoporte("T001", "Carlos", "Fallo en conexión de red", 8)
    val ticket2 = TicketSoporte("T002", "", "Error", 15)

    fun procesarExportable(e: Exportable) = println("→ ${e.exportar()}")
    fun procesarVerificable(v: Verificable) {
        println("Aprobado: ${v.estaAprobado}")
        v.listarReportes()
    }

    procesarExportable(ticket1)
    procesarVerificable(ticket1)
    procesarVerificable(ticket2)
}