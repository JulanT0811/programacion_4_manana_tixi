fun main() {
    println("Funciones del Sistema de Soporte")
    
    val estado = obtenerEstadoSistema()
    println("Estado actual: $estado")
    
    val totalTickets: Int = calcularTotalTickets(12, 8)
    println("Total de tickets hoy: $totalTickets")
    
    println("Tickets pendientes: ${calcularPendientesExpresion(20, 5)}")
    println(calcularPendientesExpresion(10, 2))
    println(calcularPendientesInferido(15, 7))
    
    asignarTicketATecnico("Julian")
}

fun obtenerEstadoSistema(): String {
    return "Servidores Operativos"
}

fun calcularTotalTickets(abiertos: Int, cerrados: Int): Int {
    return abiertos + cerrados
}

fun calcularPendientesExpresion(total: Int, resueltos: Int): Int = total - resueltos

fun calcularPendientesInferido(total: Int, resueltos: Int) = total - resueltos

fun asignarTicketATecnico(nombre: String) {
    println("Ticket asignado exitosamente al tecnico: $nombre")
}