fun main() {
    val cliente = "Pamela"
    val apellidoCliente = "Itaz"
    val ticketId = 4502
    val estado = "Abierto"
    val tiempoEstimadoHoras = 2

    println("Notificacion: Nuevo ticket asignado a $cliente")

    val encabezadoReporte = "CLIENTE: ${cliente.uppercase()} ${apellidoCliente.uppercase()}"
    println(encabezadoReporte)

    println("Resolucion estimada en: ${tiempoEstimadoHoras + 1} horas (incluye tiempo de diagnostico)")

    val resumenTicket = """
        |DATOS DEL TICKET DE SOPORTE
        |---------------------------
        |Ticket ID: #$ticketId
        |Usuario: $cliente $apellidoCliente
        |Estado Actual: [${estado.uppercase()}]
        |Acceso Prioritario: ${if (estado == "Abierto") "REQUERIDO" else "NO PRIORITARIO"}
        |
        |Mensaje: El sistema detecto una incidencia en el modulo de base de datos.
    """.trimMargin()

    println(resumenTicket)
}