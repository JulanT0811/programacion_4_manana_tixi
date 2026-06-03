enum class EstadoTicket(val descripcion: String, val esTerminal: Boolean) {
    NUEVO      ("Ticket recibido",        false),
    ASIGNADO   ("Asignado a técnico",     false),
    EN_PROCESO ("Siendo solucionado",     false),
    RESUELTO   ("Solucionado con éxito",  true),
    CERRADO    ("Ticket cerrado",         true);

    fun puedeTransicionarA(siguiente: EstadoTicket): Boolean = when (this) {
        NUEVO      -> siguiente == ASIGNADO
        ASIGNADO   -> siguiente == EN_PROCESO
        EN_PROCESO -> siguiente == RESUELTO || siguiente == CERRADO
        else       -> false
    }
}

fun main() {
    val estado = EstadoTicket.EN_PROCESO
    println(estado.descripcion)
    println(estado.esTerminal)

    val icono = when (estado) {
        EstadoTicket.NUEVO      -> "📥"
        EstadoTicket.ASIGNADO   -> "👤"
        EstadoTicket.EN_PROCESO -> "🛠️"
        EstadoTicket.RESUELTO   -> "✅"
        EstadoTicket.CERRADO    -> "🔒"
    }
    println(icono)

    println(estado.puedeTransicionarA(EstadoTicket.RESUELTO))
}