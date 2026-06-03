class TicketSoporte(titular: String, prioridadInicial: Int) {

    val titular: String = titular

    private var prioridad: Int = prioridadInicial

    internal val codigoTicket: String =
        "TK-${(100000..999999).random()}"

    // Advertencia eliminada: Se quitó 'open' porque la clase es final
    protected fun calcularPrioridadCompleta(): Int = prioridad + 1

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
    val ticket = TicketSoporte("Ana Garcia", 1)

    ticket.escalarTicket(2)
    ticket.cerrarTicket(true)

    println("Titular: ${ticket.titular}")
    println("Prioridad final: ${ticket.consultarPrioridad()}")
}