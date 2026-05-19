fun main() {
    println("Controles de Flujo when con condiciones arbitrarias")
    println("Escriba código:") 
    
    println("Prioridad del ticket (1-100):")
    val prioridad = readLine()?.toIntOrNull() ?: 0
    
    println("¿Tiene contrato de soporte activo? (s/n):")
    val tieneContrato = readLine()?.trim()?.lowercase() == "s"
    
    val nivelPlan = if (tieneContrato) {
        println("Nivel del plan (BRONCE / PLATA / ORO):")
        readLine()?.trim()?.uppercase() ?: ""
    } else ""

    val costoServicio = when {
        // Estructura idéntica al original
        !tieneContrato && prioridad < 18 -> 0.0
        !tieneContrato && prioridad >= 65 -> 15.0
        !tieneContrato -> 45.0
        nivelPlan == "BRONCE" -> 20.0
        nivelPlan == "PLATA" -> 10.0
        nivelPlan == "ORO" -> 0.0
        else -> 30.0
    }

    println("Costo del servicio técnico: $${"%.2f".format(costoServicio)}")
}