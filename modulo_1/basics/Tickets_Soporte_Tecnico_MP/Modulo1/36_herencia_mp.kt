open class Ticket(val id: Int, val prioridad: String) {
    open fun procesar() = println("Procesando ticket #$id con prioridad $prioridad")
    open fun obtenerInfo() = "Ticket #$id"

    fun registrarLog() = println("Log registrado para el ticket #$id")
}

class TicketSoporteTecnico(id: Int) : Ticket(id, "Alta") {
    override fun procesar() {
        super.procesar()
        println("(Notificando al equipo de ingeniería)")
    }
    override fun obtenerInfo() = "${super.obtenerInfo()}, tipo: Soporte Técnico"
}

class TicketConsultas(id: Int, val esUrgente: Boolean) : Ticket(id, "Baja") {
    override fun obtenerInfo() =
        "${super.obtenerInfo()}, tipo: Consulta ${if (esUrgente) "urgente" else "estándar"}"
}

fun main() {
    val ticketTecnico = TicketSoporteTecnico(101)
    ticketTecnico.procesar()

    val ticketConsulta = TicketConsultas(102, true)
    println(ticketConsulta.obtenerInfo())

    ticketTecnico.registrarLog()
}