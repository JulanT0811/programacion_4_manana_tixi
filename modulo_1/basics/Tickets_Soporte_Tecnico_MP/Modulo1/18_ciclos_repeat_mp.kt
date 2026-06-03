fun main() {
    println("Controles de flujo iteraciones - ciclos repetitivos - ciclo while")
    
    println("While basico (Intentos de acceso)")
    var contador = 1
    while(contador <= 5){
        println("Intento numero $contador")
        contador++
    }
    
    println("Do While (Verificacion de hardware)")
    contador = 1
    do {
        println("Escaneando componente $contador")
        contador++
    } while(contador <= 5)
    
    println("Break continue (Procesando solicitudes)")
    contador = 1
    while(contador <= 10){
        contador++
        if(contador == 3) continue 
        if(contador == 7) break    
        println("Solicitud ID: $contador procesada")
    }
   
    var entrada: String
    while(true){
        println("Escribe 'salir' para terminar la sesion")
        entrada = readLine()?.lowercase() ?: ""
        if(entrada == "salir") break
        println("Comando registrado: $entrada")
    }
   
    var cod: Int
    while(true){
        println("\nMenu de opciones de Soporte")
        println("1. Estado del Sistema\n2. Limpiar Cache\n3. Ver Logs\n4. Salir")
        cod = readLine()?.toIntOrNull() ?: 0 
        
        val menu = when(cod){
            1 -> "Estado del Sistema"
            2 -> "Limpiar Cache"
            3 -> "Ver Logs"
            4 -> "salir"
            else -> "Opcion invalida"
        }
        
        println("Opcion elegida: $cod")
        
        if(cod == 1) {
            println("Sistema operando con normalidad")
        }
        if(cod == 2) {
            println("Cache del servidor liberada")
        }
        if(cod == 3) {
            println("Mostrando ultimas 10 lineas del log")
        }
        
        if(menu == "salir") break
        println("Resultado: $menu")
    }
   
    println("\nConfiguracion de monitoreo de carga de red")
    println("¿Cuantas muestras de trafico desea tomar?")
    val mediciones = readLine()?.toIntOrNull() ?: 0
    var totalCarga = 0

    repeat(mediciones){ i ->
        println("Medicion ${i + 1} (paquetes por segundo en 15 seg.)")
        val paquetes = readLine()?.toIntOrNull() ?: 0
        totalCarga += paquetes * 4 

    if (mediciones > 0) {
        val promedioCarga = totalCarga / mediciones
        println("Carga de red promedio: $promedioCarga pps")
        println("Estado del trafico: ${
            when {
                promedioCarga < 60 -> "Bajo trafico"
                promedioCarga <= 100 -> "Trafico Normal"
                else -> "Congestion de Red"
            }
        }")
    } else {
        println("No se realizaron mediciones")
    }
}