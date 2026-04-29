fun main() {
    println(" METRICAS DE SOPORTE TECNICO ")
    
    val ticketsResueltos = 10
    val tiempoTotalHoras = 2
    
    println("Suma de incidentes (Total hoy):")
    println("Resueltos + Pendientes: ${ticketsResueltos + 5}")
    
    println("Resta (Diferencia de carga):")
    println("Meta - Logrado: ${20 - ticketsResueltos}")
    
    println("Multiplicacion (Costo operativo):")
    println("$ticketsResueltos tickets * $15/hora = $${ticketsResueltos * 15}")
    
    println("Division (Promedio de resolucion):")
    println("$ticketsResueltos tickets / $tiempoTotalHoras horas = ${ticketsResueltos / tiempoTotalHoras} tickets por hora")
    
    println("Modulo (Distribucion de tickets en turnos):")
    
    println("Ticket #11 % 2 técnicos = ${11 % 2} (Determina a quien le toca)")

    println("\n CONTROL DE CARGA (Asignacion Compuesta) ")
    var ticketsEnCola = 10
    
    ticketsEnCola += 5 
    println("Nuevos reportes (+=5): $ticketsEnCola")
    
    ticketsEnCola -= 3 
    println("Tickets resueltos (-=3): $ticketsEnCola")
    
    ticketsEnCola *= 2 
    println("Emergencia critica (*=2): $ticketsEnCola")
    
    ticketsEnCola /= 2  
    println("Division de carga (/=2): $ticketsEnCola")

    
    var intentosDeAcceso = 0
    intentosDeAcceso++ 
    println("\nIntento fallido de login: $intentosDeAcceso")
    
    intentosDeAcceso-- 
    println("Contador reseteado: $intentosDeAcceso")
}