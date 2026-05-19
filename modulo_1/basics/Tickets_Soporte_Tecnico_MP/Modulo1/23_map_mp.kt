fun main() {
    println("Map Inmutable (Asignacion de Tecnicos a Areas)")
    val asignaciones = mapOf(
        "Redes" to "Julian",
        "Base de Datos" to "Maria",
        "Seguridad" to "Pedro",
        "Soporte Local" to "Ana"
    )
    
    // Acceso a elementos
    println(asignaciones["Redes"])
    println(asignaciones["Hardware"]) // Retornara null
    
    // Uso de getOrDefault
    println(asignaciones.getOrDefault("Redes", "Sin asignar"))
    println(asignaciones.getOrDefault("Hardware", "Sin asignar"))
    
    println(asignaciones)
    println("Areas registradas: ${asignaciones.keys}")
    println("Tecnicos asignados: ${asignaciones.values}")
    println("Entradas completas: ${asignaciones.entries}")
    
    // Iteracion del mapa
    for ((area, tecnico) in asignaciones) {
        println("Area: $area - Responsable: $tecnico")
    }
  
    println("\nMap mutable (Inventario de Repuestos de Soporte)")
    val inventario = mutableMapOf(
        "Laptops" to 10,
        "Cargadores" to 15,
        "Teclados" to 12,
        "Cables HDMI" to 25
    )
    
    // Agregar elemento nuevo
    inventario["Discos SSD"] = 8
    println("Inventario con SSD: $inventario")
    
    // Actualizar cantidad (stock recibido)
    inventario["Laptops"] = 20
    println("Stock de Laptops actualizado: $inventario")
    
    // Eliminar elemento (item descontinuado)
    inventario.remove("Cables HDMI")
    println("Despues de eliminar Cables HDMI: $inventario")
    
    // Uso de getOrPut: Agrega si no existe, si existe mantiene el valor actual
    inventario.getOrPut("Pantallas") { 5 }
    println("Intento con Pantallas (nuevo): $inventario")
    
    inventario.getOrPut("Teclados") { 50 } // No cambiara porque ya existe
    println("Intento con Teclados (ya existia): $inventario")
}