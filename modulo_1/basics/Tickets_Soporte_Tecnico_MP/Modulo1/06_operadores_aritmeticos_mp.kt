fun main() {
    println("Sistema de Gestion de Tickets de Soporte")

    val ticketsAbiertos = 15
    val ticketsResueltosHoy = 3

    println("Estadisticas del Turno:")
    println("Total de tickets en historial: $ticketsAbiertos + $ticketsResueltosHoy = ${ticketsAbiertos + ticketsResueltosHoy}")

    println("Tickets pendientes de asignar: $ticketsAbiertos - $ticketsResueltosHoy = ${ticketsAbiertos - ticketsResueltosHoy}")

    val tiempoPorTicketMin = 20
    println("Tiempo estimado restante: $ticketsAbiertos * $tiempoPorTicketMin = ${ticketsAbiertos * tiempoPorTicketMin} minutos")

    val tecnicosDisponibles = 2
    println("Tickets por tecnico: $ticketsAbiertos / $tecnicosDisponibles = ${ticketsAbiertos / tecnicosDisponibles}")

    println("Tickets que sobran tras reparto equitativo: $ticketsAbiertos % $tecnicosDisponibles = ${ticketsAbiertos % tecnicosDisponibles}")

    println(" Actualizacion de Estado del Ticket ")

    var prioridadTicket = 10
    println("Prioridad inicial: $prioridadTicket")

    prioridadTicket += 15
    println("Urgencia aumentada (+15): $prioridadTicket")

    prioridadTicket -= 5
    println("Prioridad ajustada (-5): $prioridadTicket")

    prioridadTicket *= 2
    println("Prioridad VIP (x2): $prioridadTicket")

    prioridadTicket /= 4
    println("Prioridad tras asignacion senior (/4): $prioridadTicket")

    println(" Contadores de Interacciones ")

    var interaccionesCliente = 1
    println("Interaccion inicial: $interaccionesCliente")

    interaccionesCliente++
    println("Nuevo mensaje recibido (incremento): $interaccionesCliente")

    var intentosDeCierre = 3
    intentosDeCierre--
    println("Intentos de cierre restantes (decremento): $intentosDeCierre")
}