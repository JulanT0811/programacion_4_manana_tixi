fun main() {
    println("Controles de flujo iteraciones - Ciclos repetitivos For")
    
    println("For con rango (Dias de retencion)")
    for (i in 1..5) {
        println("Dia $i: Revisando backups...")
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
  
    println("For con listas (Tecnicos activos)")
    val tecnicos = listOf("Julian", "Maria", "Jose")
    for (tecnico in tecnicos) {
        println("Tecnico asignado: $tecnico")
    }
  
    println("For con listas index valor (Prioridad de atencion)")
    for ((index, tecnico) in tecnicos.withIndex()) {
        println("Nivel $index -> Especialista: $tecnico")
    }
  
    println("For con break (Busqueda de error critico)")
    for (i in 1..10) {
        if (i == 5) {
            println("Error critico encontrado en linea $i. Deteniendo escaneo.")
            break
        }
    }
  
    println("For con continue (Saltar tickets resueltos)")
    for (i in 1..10) {
        if (i == 3) {
            println("Ticket $i ya esta resuelto, saltando...")
            continue
        }
        println("Procesando ticket #$i")
    }
  
    println("For con continue y break combinado")
    for (i in 1..10) {
        if (i == 3) continue 
            println("Limite de tickets por turno alcanzado.")
            break
        }
        println("Atendiendo incidencia #$i")
    }


    val servidores = listOf(
        Triple("Servidor-Web", 45.5, 30),
        Triple("Base-Datos", 120.2, 85),
        Triple("API-Gateway", 15.0, 96)
    )

    println("\n--- Reporte de Estado de Infraestructura ---")
    for ((posicion, servidor) in servidores.withIndex()) {
        val (id, latencia, cargaCpu) = servidor
        
        val alertaLatencia = if (latencia >= 100.0) "LENTO" else "OK"
        val alertaCarga = if (cargaCpu > 90) "SOBRECARGA" else "ESTABLE"
        
        println("Nodo $posicion - $id - Latencia: $latencia ms ($alertaLatencia) - CPU: $cargaCpu% ($alertaCarga)")
    }
}