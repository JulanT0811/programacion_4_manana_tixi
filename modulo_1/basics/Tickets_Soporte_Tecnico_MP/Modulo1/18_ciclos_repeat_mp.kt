import java.util.Scanner
fun main() {
    val scanner = Scanner(System.`in`)
    println("Controles de flujo iteraciones - ciclos repetitivos - ciclo while")
    
    println("While basico (Intentos de acceso)")
    var contador = 1
    while (contador <= 5) {
        println("Intento numero $contador")
        contador++
    }
    
    println("Do While (Verificacin de hardware)")
    contador = 1
    do {
        println("Escaneando componente $contador")
        contador++
    } while (contador <= 5)
    
    println("Break continue (Procesando solicitudes)")
    contador = 0
    while (contador < 10) {
        contador++
        if (contador == 3) continue
        if (contador == 7) break
        println("Solicitud ID: $contador procesada")
    }
    
    println("Bucle infinito con break")
    while (true) {
        println("Escribe 'salir' para terminar la sesión")
        val entrada = scanner.nextLine().lowercase()
        if (entrada == "salir") break
        println("Comando registrado: $entrada")
    }
    
    println("Menú de opciones de Soporte")
    while (true) {
        println("1. Estado del Sistema 2. Limpiar Cache 3. Ver Logs4. Salir")
        val cod = scanner.nextLine().toIntOrNull() ?: 0
        
        val menu = when (cod) {
            1 -> "Estado del Sistema"
            2 -> "Limpiar Cache"
            3 -> "Ver Logs"
            4 -> "salir"
            else -> "Opcion invalida"
        }
        
        println("Opción elegida: $cod")
        
        if (cod == 1) println("Sistema operando con normalidad")
        if (cod == 2) println("Cache del servidor liberada")
        if (cod == 3) println("Mostrando últimas 10 líneas del log")
        
        if (menu == "salir") break
        println("Resultado: $menu")
    }
    
    println("Configuración de monitoreo de carga de red")
    println("¿Cuántas muestras de tráfico desea tomar?")
    val mediciones = scanner.nextLine().toIntOrNull() ?: 0
    var totalCarga = 0

    for (i in 1..mediciones) {
        println("Medición $i (paquetes por segundo en 15 seg.)")
        val paquetes = scanner.nextLine().toIntOrNull() ?: 0
        totalCarga += paquetes * 4
    }

    if (mediciones > 0) {
        val promedioCarga = totalCarga / mediciones
        println("Carga de red promedio: $promedioCarga pps")
        println("Estado del tráfico: ${
            when {
                promedioCarga < 60 -> "Bajo tráfico"
                promedioCarga <= 100 -> "Tráfico Normal"
                else -> "Congestión de Red"
            }
        }")
    } else {
        println("No se realizaron mediciones")
    }
}