class TicketSoporte(
    val id: Int,
    val titulo: String,
    val prioridad: Int,
    private val estadoProcesado: Boolean
) {
    val esUrgente: Boolean
        get() = prioridad > 5

    val puedeCerrarse: Boolean
        get() = estadoProcesado

    override fun toString() = "Ticket #$id: $titulo [Prioridad: $prioridad]"
}

fun main() {
    val ticket = TicketSoporte(501, "Error en inicio de sesión", 8, true)

    println(ticket.esUrgente)
    println(ticket.puedeCerrarse)
}