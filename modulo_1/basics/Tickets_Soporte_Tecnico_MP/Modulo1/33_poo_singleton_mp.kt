object ConfiguracionTicket {
    val servidor: String = "soporte.empresa.com"
    val puerto: Int = 8080
    private val tokenAcceso: String = "tk-secreto-987"

    fun urlBase() = "https://$servidor:$puerto"
    fun cabeceras() = mapOf("Authorization" to "Bearer $tokenAcceso")
}

class Ticket private constructor(val id: Int, val asunto: String) {
    companion object {
        private var contadorTickets = 0

        fun crear(asunto: String, categoria: String): Ticket? {
            if (asunto.isBlank() || categoria.isBlank()) return null
            return Ticket(++contadorTickets, asunto.trim())
        }

        const val ESTADO_DEFECTO = "abierto"
    }
}

fun main() {
    println(ConfiguracionTicket.urlBase())

    val t = Ticket.crear("Fallo de conexión", "Redes")
    println(t)
}