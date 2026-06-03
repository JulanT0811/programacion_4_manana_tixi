fun main() {
    println("Set Inmutable (IDs de Servidores Unicos)")

    val servidoresIds = setOf(101, 102, 103, 104, 108, 104, 101, 103)
    println("IDs de servidores: ${servidoresIds}")
  
    println("\nOperaciones de conjuntos (Tickets por Area)")
    val ticketsRed = setOf(2, 4, 6, 8, 10)
    val ticketsSoftware = setOf(3, 6, 9, 12)
    
    println("Tickets de Red: ${ticketsRed}")
    println("Tickets de Software: ${ticketsSoftware}")

    println("Union (Todos los tickets): ${ticketsRed union ticketsSoftware}")
    
    println("Interseccion (Tickets hibridos): ${ticketsRed intersect ticketsSoftware}")
    
 
    println("Substraccion (Solo Red): ${ticketsRed subtract ticketsSoftware}")
    
    println("Set de Red: ${ticketsRed}")
    println("Set de Software: ${ticketsSoftware}")
    
    println("\nSet mutable (Etiquetas de Tecnologia)")
    val etiquetas = mutableSetOf("kotlin", "java", "reactnative")
    println(etiquetas)
    
 
    etiquetas.add("kotlin")
    println("Despues de intentar agregar 'kotlin' repetido: $etiquetas")
    

    etiquetas.add("javascript")
    println("Despues de agregar 'javascript': $etiquetas")
    

    etiquetas.remove("java")
    println("Despues de eliminar 'java': $etiquetas")
    
    println("Verificar si existe tecnologia 'kotlin': ${"kotlin" in etiquetas}")
    println("Verificar si existe tecnologia 'java': ${"java" in etiquetas}")
}