fun main() {
    val ticketId = "TK-2026-001"
    val tecnicoAsignado = "Julián"
    val categoria = "Infraestructura"
    
    var estado = "Abierto"
    var tiempoTranscurridoHoras = 0
    
    tiempoTranscurridoHoras = tiempoTranscurridoHoras + 2
    estado = "En Progreso"
    
    println("Actualización de Estado: $estado")
    println("Horas invertidas hasta ahora: $tiempoTranscurridoHoras")
    

    tiempoTranscurridoHoras = tiempoTranscurridoHoras + 1
    estado = "Resuelto"
    
    println("<< RESUMEN DEL CASO >>")
    println("El ticket $ticketId de la categoría $categoria ha sido finalizado.")
    println("Responsable: $tecnicoAsignado")
    println("Estado final: $estado")
    println("Tiempo total: $tiempoTranscurridoHoras horas")
}