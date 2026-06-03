fun main() {
    println("Controles de flujo iteraciones - Ciclos repetitivos For")

    println("For con rango (Dias de retención)")
    for (i in 1..5) {
        println("Día $i: Revisando backups...")
    }

    println("For con rango (Escaneo de puertos)")
    for (i in 1 until 5) {
        println("Escaneando puerto 808$i...")
    }

    println("For con pasos (Mantenimiento cada 3 horas)")
    for (i in 1..10 step 3) {
        println("Hora $i: Ejecutando script de limpieza...")
    }

    println("For descendente (Cuenta regresiva reinicio)")
    for (i in 10 downTo 1) {
        println("Reiniciando sistema en $i...")
    }

    println("For con listas (Técnicos activos)")
    val tecnicos = listOf("Julian", "Maria", "Jose")
    for (tecnico in tecnicos) {
        println("Técnico asignado: $tecnico")
    }

    println("For con listas index valor (Prioridad de atención)")
    for ((index, tecnico) in tecnicos.withIndex()) {
        println("Nivel $index -> Especialista: $tecnico")
    }

    println("For con break (Búsqueda de error crítico)")
    for (i in 1..10) {
        if (i == 5) {
            println("Error crítico encontrado en línea $i. Deteniendo escaneo.")
            break
        }
    }

    println("For con continue (Saltar tickets resueltos)")
    for (i in 1..10) {
        if (i == 3) {
            println("Ticket $i ya está resuelto, saltando...")
            continue
        }
        println("Procesando ticket #$i")
    }

    println("For con continue y break combinado")
    for (i in 1..10) {
        if (i == 3) continue
        if (i == 7) {
            println("Límite de tickets por turno alcanzado.")
            break
        }
        println("Atendiendo incidencia #$i")
    }

    val servidores = listOf(
        mapOf("id" to "Servidor-Web", "latencia" to 45.5, "cpu" to 30),
        mapOf("id" to "Base-Datos", "latencia" to 120.2, "cpu" to 85),
        mapOf("id" to "API-Gateway", "latencia" to 15.0, "cpu" to 96)
    )

    println("\n--- Reporte de Estado de Infraestructura ---")
    for ((posicion, servidor) in servidores.withIndex()) {
        val id = servidor["id"]
        val latencia = servidor["latencia"] as Double
        val cargaCpu = servidor["cpu"] as Int

        val alertaLatencia = if (latencia >= 100.0) "LENTO" else "OK"
        val alertaCarga = if (cargaCpu > 90) "SOBRECARGA" else "ESTABLE"

        println("Nodo $posicion - $id - Latencia: $latencia ms ($alertaLatencia) - CPU: $cargaCpu% ($alertaCarga)")
    }
}