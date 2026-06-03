fun main() {
    println("Funciones-Parametros por defecto")
    
    println(registrarTicket("Error de red", 5, "Soporte Nivel 1", true))
    println(registrarTicket("Pantalla azul"))
    println(registrarTicket("Fallo de login", 2))
    println(registrarTicket("Base de datos", 1, "DBA"))
    
    println(registrarTicket(prioridad = 3, asunto = "Recuperar clave", esUrgente = false))
}

fun registrarTicket(
    asunto: String,
    prioridad: Int = 4,      
    area: String = "General", 
    esUrgente: Boolean = false 
): String {
    val estado = if (esUrgente) "URGENTE" else "NORMAL"
    return "Ticket[Asunto: $asunto, Prioridad: $prioridad, Area: $area, Estado: $estado]"
}