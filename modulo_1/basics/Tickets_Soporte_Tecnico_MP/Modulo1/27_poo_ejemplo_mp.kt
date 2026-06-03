class Ticket(val asunto: String, val nivelUrgencia: Int)

class TicketDetallado(val asunto: String, val nivelUrgencia: Int) {
    fun obtenerResumen() = "Ticket: $asunto con nivel de urgencia $nivelUrgencia"
    fun esCritico() = nivelUrgencia >= 5
}

fun main() {
    val t = Ticket("Error de red", 3)
    println(t.asunto)
    println(t.nivelUrgencia)

    val t2 = TicketDetallado("Fallo en servidor", 6)
    println(t2.obtenerResumen())
    println(t2.esCritico())
}