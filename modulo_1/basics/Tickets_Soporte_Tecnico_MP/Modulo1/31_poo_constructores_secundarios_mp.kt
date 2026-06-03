class TicketSoporte(val anchoPrioridad: Double, val altoSeveridad: Double) {
    val impacto: Double get() = anchoPrioridad * altoSeveridad
    val esfuerzo: Double get() = 2 * (anchoPrioridad + altoSeveridad)

    constructor(valorUnico: Double) : this(valorUnico, valorUnico)
    constructor(ancho: Int, alto: Int) : this(ancho.toDouble(), alto.toDouble())

    override fun toString() = "Ticket(${anchoPrioridad}x${altoSeveridad}) | impacto=${impacto}"
}

fun main() {
    val t1 = TicketSoporte(5.0, 3.0)
    val t2 = TicketSoporte(4.0)
    val t3 = TicketSoporte(6, 2)

    println(t1)
    println(t2)
    println(t3)
}