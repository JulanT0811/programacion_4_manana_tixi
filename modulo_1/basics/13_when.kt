fun main() {
    println("Controles de Flujo when")
    println("Escribe codigo")
    val codigo = readLine()?.toIntOrNull()?: 0
    val especialidad = when(codigo){
        1->"Medicina general"
        2-> "Pedriatria"
        3-> "Cardiologia"
        4-> "Ginecologia"
        5-> "Neurologia"
        6-> "Dermatologia"
        else -> "Especialidad no registrada en el sistema"
    }
    println("Especialidad: $especialidad")

}


** ejemplo en clase 
fun main() {
    println("--- Sistema de Muestras de Laboratorio ---")
    println("Ingrese el codigo de la muestra (1-5):")
    
    val codigo = readLine()?.toIntOrNull() ?: 0
    
    val resultado = when(codigo) {
        1 -> "Tipo: Sangre venosa | Tiempo estimado: 4 horas"
        2 -> "Tipo: Orina | Tiempo estimado: 2 horas"
        3 -> "Tipo: Heces | Tiempo estimado: 24 horas"
        4 -> "Tipo: Hisopado nasofaríngeo | Tiempo estimado: 6 horas"
        5 -> "Tipo: Biopsia | Tiempo estimado: 72 horas"
        else -> "Código no reconocido. Por favor, verifique el sistema."
    }
    
    println(resultado)
}