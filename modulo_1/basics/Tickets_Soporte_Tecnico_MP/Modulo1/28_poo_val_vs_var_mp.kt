class TicketInmutable(val id: Int, val prioridad: Int)

class ContadorTickets(var cantidad: Int = 0) {
    fun registrarTicket() { cantidad++ }
    fun limpiarContador() { cantidad = 0 }
}

class RegistroTemporal(asunto: String) {
    val asuntoMayusculas = asunto.uppercase()
}