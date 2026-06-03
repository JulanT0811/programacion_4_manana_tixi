data class Ticket(
    val id: Int,
    val titulo: String,
    val prioridad: Int,
    val departamento: String,
    val resuelto: Boolean = false
)

fun main() {
    val t1 = Ticket(101, "Error de red", 5, "Soporte Técnico")
    val t2 = Ticket(101, "Error de red", 5, "Soporte Técnico")
    val t3 = Ticket(102, "Fallo de hardware", 9, "Infraestructura")

    println(t1)

    println(t1 == t2)
    println(t1 == t3)

    val prioridadAlta = t1.copy(prioridad = 10)
    val ticketResuelto = t1.copy(resuelto = true)

    val (id, titulo, prioridad) = t1
    println("$id: $titulo — Prioridad: $prioridad")

    listOf(t1, t3).forEach { (id2, titulo2, prioridad2) ->
        println("[$id2] $titulo2: Prioridad $prioridad2")
    }
}