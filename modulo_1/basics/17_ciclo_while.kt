fun main() {
    println("Controles de flujo iteraciones. Ciclos repetitivos. Ciclo While")
    println("While Basico")
    var contador = 1
    while (contador <= 5) {
        println(contador)
        contador++
    }

    println("Do while")
    contador = 1
    do {
        println(contador)
        contador++
    } while (contador <= 5)

    println("Breack continue")
    contador = 1 
    while (contador <= 10) {
        contador ++;
        if (contador == 3) continue
        if (contador == 7) break
        println(contador)
    }


    var input: String 
    while(true){
        println("Escribe 'Salir' para terminar")
        input = readLine()?.lowercase()?:""
        if (input=="salir")break
        println("Usted ingresó: $input")
    }
}


//ejercicico con while

fun main() {
    var input: String

    while (true) {
        println("Menu de opciones")
        println("Opciones: Saludar, Sumar, Tabla, Salir")
        print("¿Que desea hacer?: ")

        input = readLine()?.lowercase() ?: ""

        when (input) {
            "saludar" -> {
                println("Saludar")
            }
            "sumar" -> {
                println("Sumar")
            }
            "tabla" -> {
                println("Tabla")
            }
            "salir" -> {
                println("Saliendo")
                break 
            }
            else -> {
                println("Usted ingreso: '$input',  opcion no valida.")
            }
        }
    }
}