fun main() {
    println("Controles de Flujo When con bloques de codigos")
    println("Asunto del ticket: ")
    val asuntoTicket = readLine()?.trim()?.lowercase() ?: "Sin descripción"
    
    println("Prioridad del Ticket (CRITICA/ALTA/MEDIA/BAJA)")
    val prioridad = readLine()?.trim()?.uppercase() ?: ""
    
    when (prioridad) {
        "CRITICA" -> {
            println("ALERTA CRÍTICA: Ticket: $asuntoTicket")
            println("Notificar al Administrador de Sistemas de inmediato")
            println("Activar protocolo de recuperación ante desastres")
        }
        "ALTA" -> {
            println("PRIORIDAD ALTA: Ticket: $asuntoTicket")
            println("Asignar técnico de nivel 2 con urgencia")
            println("Tiempo de respuesta estimado: 30 minutos")
        }
        "MEDIA" -> {
            println("PRIORIDAD MEDIA: Ticket: $asuntoTicket")
            println("Asignar a la cola general de soporte")
        }
        "BAJA" -> {
            println("PRIORIDAD BAJA: Ticket: $asuntoTicket - Procesar según disponibilidad")
        }
        else -> println("Prioridad no reconocida")
    }
}