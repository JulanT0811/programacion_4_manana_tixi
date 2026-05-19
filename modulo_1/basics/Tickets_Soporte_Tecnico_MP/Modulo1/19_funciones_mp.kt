// Online Kotlin compiler to run Kotlin program online
// Sistema de Tickets de Soporte Tecnico

fun main() {
    println("Funciones del Sistema de Soporte")
    
    // Llamada a funcion con retorno de String
    val estado = obtenerEstadoSistema()
    println("Estado actual: $estado")
    
    // Llamada a funcion de suma (conteo de tickets)
    val totalTickets: Int = calcularTotalTickets(12, 8)
    println("Total de tickets hoy: $totalTickets")
    
    // Llamada a funciones de expresion directa (prioridad/resta)
    println("Tickets pendientes: ${calcularPendientesExpresion(20, 5)}")
    println(calcularPendientesExpresion(10, 2))
    println(calcularPendientesInferido(15, 7))
    
    // Llamada a funcion que no retorna valor (Unit)
    asignarTicketATecnico("Julian")
}

// Funcion estandar con retorno explicito
fun obtenerEstadoSistema(): String {
    return "Servidores Operativos"
}

// Funcion con parametros y retorno Int
fun calcularTotalTickets(abiertos: Int, cerrados: Int): Int {
    return abiertos + cerrados
}

// Funcion tipo expresion (cuerpo de expresion)
fun calcularPendientesExpresion(total: Int, resueltos: Int): Int = total - resueltos

// Funcion con tipo inferido
fun calcularPendientesInferido(total: Int, resueltos: Int) = total - resueltos

// Funcion que realiza una accion (Unit)
fun asignarTicketATecnico(nombre: String) {
    println("Ticket asignado exitosamente al tecnico: $nombre")
}