fun main() {
    println("Listas-Inmutable (Servidores Activos)")
    val servidores = listOf("web", "db", "api", "db", "proxy")

    println("Size: ${servidores.size}")
    println("Mostrar el elemento indice 0: ${servidores[0]}")
    println("Mostrar el primer elemento: ${servidores.first()}")
    println("Mostrar el ultimo elemento: ${servidores.last()}")

    println("Mostrar el elemento indice 2: ${servidores.get(2)}")
    println("Mostrar indice contenido elemento: ${servidores.indexOf("db")}")
    println("Verificar existencia de elemento: ${servidores.contains("api")}")
    println("Verificar existencia de un elemento: ${"db" in servidores}")

    // Sublista
    println("Sublista: ${servidores.subList(1, 3)}")
    println("Tomar los primeros 2 elementos: ${servidores.take(2)}")
    println("Suprimir tres primeros elementos: ${servidores.drop(3)}")
    println("Tomar los ultimos 2 elementos: ${servidores.takeLast(2)}")

    for (servidor in servidores) {
        println("Servidor: $servidor")
    }

    println("Listas-Mutable (Tecnicos de Turno)")
    val tecnicos = mutableListOf("juan", "pedro", "maria", "ana")
    println(tecnicos)
    tecnicos.add("jorge")
    println(tecnicos)
    tecnicos.add(0, "julian")
    println(tecnicos)
    tecnicos.remove("jorge")
    println(tecnicos)
    tecnicos[1] = "luis"
    println(tecnicos)
    
    println("Array Deque (Cola de Prioridad)")
    val deque = ArrayDeque<Int>()
    println(deque)
    deque.addFirst(101) 
    println(deque)
    deque.addLast(102)  
    println(deque) 
    deque.addLast(103)
    println(deque)
    deque.removeFirst() 
    println(deque)
    deque.removeLast()  
    println(deque)
}