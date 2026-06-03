class TicketSoporte(titular: String, prioridadInicial: Int) {

    val titular: String = titular

    private var prioridad: Int = prioridadInicial

    internal val codigoTicket: String =
        "TK-${(100000..999999).random()}"

    protected open fun calcularPrioridadCompleta(): Int = prioridad + 1

    fun escalarTicket(nivel: Int) {
        require(nivel > 0) { "El nivel debe ser positivo" }
        prioridad += nivel
        println("Ticket escalado: Nivel aumentado | Prioridad actual: ${consultarPrioridad()}")
    }

    fun cerrarTicket(confirmado: Boolean): Boolean {
        if (!confirmado) {
            println("Cierre cancelado")
            return false
        }
        prioridad = 0
        println("Ticket cerrado correctamente")
        return true
    }

    fun consultarPrioridad(): String = prioridad.toString()
}

fun main() {
    val ticket = TicketSoporte("Ana García", 1)

    ticket.escalarTicket(2)
    ticket.cerrarTicket(true)

    println(ticket.titular)
    println(ticket.consultarPrioridad())
}