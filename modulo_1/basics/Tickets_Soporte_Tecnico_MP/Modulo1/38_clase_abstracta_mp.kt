abstract class Ticket(val tipo: String) {
    abstract val prioridad: Int
    abstract val cargaTrabajo: Int
    abstract fun descripcion(): String

    fun compararPrioridad(otro: Ticket): String = when {
        prioridad > otro.prioridad -> "$tipo tiene mayor prioridad que ${otro.tipo}"
        prioridad < otro.prioridad -> "$tipo tiene menor prioridad que ${otro.tipo}"
        else -> "$tipo y ${otro.tipo} tienen la misma prioridad"
    }

    override fun toString() = "${descripcion()} | Prioridad: $prioridad"
}

class TicketTecnico(val nivelDificultad: Int) : Ticket("Soporte Técnico") {
    override val prioridad: Int get() = nivelDificultad * 2
    override val cargaTrabajo: Int get() = nivelDificultad * 5
    override fun descripcion() = "Ticket técnico de nivel $nivelDificultad"
}

class TicketFacturacion(val monto: Double) : Ticket("Facturación") {
    override val prioridad: Int get() = if (monto > 1000) 10 else 5
    override val cargaTrabajo: Int get() = 2
    override fun descripcion() = "Ticket de facturación por $$monto"
}

class TicketConsulta(val tiempoEspera: Int) : Ticket("Consulta") {
    override val prioridad: Int get() = if (tiempoEspera > 24) 8 else 3
    override val cargaTrabajo: Int get() = 1
    override fun descripcion() = "Ticket de consulta con espera de $tiempoEspera horas"
}

fun main() {
    val tickets: List<Ticket> = listOf(
        TicketTecnico(4),
        TicketFacturacion(1500.0),
        TicketConsulta(48)
    )

    tickets.forEach { println(it) }

    val urgente = tickets.maxByOrNull { it.prioridad }
    println("\nTicket más urgente: ${urgente?.tipo}")

    println(tickets[0].compararPrioridad(tickets[1]))
}