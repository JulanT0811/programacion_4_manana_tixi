fun main() {
    val prioridad: Byte = 1
    println("Nivel de prioridad (Byte): $prioridad")

    val ticketsDelDia: Short = 320
    println("Tickets atendidos hoy (Short): $ticketsDelDia")

    val ticketID: Int = 12_500_340
    println("ID del Ticket (Int): $ticketID")

    val timestampApertura: Long = 1712995200000L
    println("Fecha de apertura en ms (Long): $timestampApertura")

    println("\n--- Metricas de Rendimiento (Decimales) ---")
  
    val cargaServidor: Float = 75.5f
    println("Carga del procesador (Float): $cargaServidor%")

    val latenciaPromedio: Double = 12.458932
    println("Latencia de respuesta (Double): $latenciaPromedio ms")

    println("\n--- Datos Inferidos y Metadatos ---")
  
    val usuarioAsignado = "Julian Tixi"
    val intentosFallidos = 3

    println("Tecnico: $usuarioAsignado")
    println("Tipo de dato tecnico: ${usuarioAsignado::class.simpleName}")

    println("Intentos de solucion: $intentosFallidos")
    println("Tipo de dato intentos: ${intentosFallidos::class.simpleName}")
}