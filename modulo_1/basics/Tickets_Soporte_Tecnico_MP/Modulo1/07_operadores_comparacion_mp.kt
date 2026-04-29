fun main() {
    println(" Validaciones de Sistema de Soporte ")
    
    val ticketsAbiertos = 10
    val limiteAlerta = 8
    val ticketsCerrados = 10
    val prioridadMinima = 5
    
    println("¿Tickets abiertos igual a cerrados?")
    println("$ticketsAbiertos == $ticketsCerrados : ${ticketsAbiertos == ticketsCerrados}")

    println("¿Tickets distintos a prioridad minima?")
    println("$ticketsAbiertos != $prioridadMinima : ${ticketsAbiertos != prioridadMinima}")

    println("¿Supera el limite de alerta?")
    println("$ticketsAbiertos > $limiteAlerta : ${ticketsAbiertos > limiteAlerta}")

    println("¿Esta por debajo del limite?")
    println("$ticketsAbiertos < $limiteAlerta : ${ticketsAbiertos < limiteAlerta}")

    println("¿Es menor o igual a la capacidad?")
    println("$ticketsAbiertos <= 15 : ${ticketsAbiertos <= 15}")

    println("¿Es mayor o igual al umbral critico?")
    println("$ticketsAbiertos >= 10 : ${ticketsAbiertos >= 10}")
}