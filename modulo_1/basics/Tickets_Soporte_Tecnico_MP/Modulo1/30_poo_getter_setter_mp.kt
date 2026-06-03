class PrioridadTicket(nivel: Int) {

    var nivel: Int = nivel
        set(value) {
            require(value in 1..10) { "La prioridad debe estar entre 1 y 10" }
            field = value
        }

    val esUrgente: Boolean
        get() = nivel >= 8

    val esInformativo: Boolean
        get() = nivel <= 3

    val etiqueta: String
        get() = when {
            nivel >= 8 -> "Critico"
            nivel >= 6 -> "Alto"
            nivel >= 4 -> "Medio"
            else -> "Bajo"
        }
}

fun main() {
    val ticket = PrioridadTicket(7)
    println("Prioridad: ${ticket.nivel} | Etiqueta: ${ticket.etiqueta}")
    println("¿Es urgente?: ${ticket.esUrgente}")

    ticket.nivel = 9
    println("Nueva prioridad: ${ticket.nivel} → ${ticket.etiqueta}")
}