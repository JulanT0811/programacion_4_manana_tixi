class TicketSoporte(val solicitante: String, val correo: String) {
    val solicitanteNormalizado: String
    val dominioCorreo: String

    init {
        require(solicitante.isNotBlank()) { "El nombre del solicitante no puede estar vacío" }
        require(correo.contains("@")) { "Correo electrónico inválido: $correo" }

        solicitanteNormalizado = solicitante.trim().lowercase()
        dominioCorreo = correo.substringAfter("@")
    }
}

fun main() {
    val t = TicketSoporte("  Juan Pérez  ", "juan@soporte.com")
    println(t.solicitanteNormalizado)
    println(t.dominioCorreo)
}