fun main() {
  println("Listado de Tickets")
  val tickets = listOf(101, 102, 103, 104, 105, 106, 107, 108, 109, 110)
  println(tickets)
  val idsPriorizados = tickets.map { it * 10 }
  println(idsPriorizados)
  val ticketsFormateados = tickets.map { "Ticket-$it" }
  println(ticketsFormateados)

  println("Filtrado de Tickets")
  val ticketsAbiertos = tickets.filter { it % 2 == 0 }
  println(ticketsAbiertos)
  val ticketsUrgentes = tickets.filter { it > 105 }
  println(ticketsUrgentes)
  val ticketsUrgentesAbiertos = tickets.filter { it % 2 == 0 && it > 105 }
  println(ticketsUrgentesAbiertos)
  val ticketsCerrados = tickets.filterNot { it % 2 == 0 }
  println(ticketsCerrados)

  val mezclaSoporte = listOf(101, "Error Crítico", 102, "Consulta General", true, 142)
  val descripciones = mezclaSoporte.filterIsInstance<String>()
  println(descripciones)

  println("Cálculo de Carga (Reduce)")
  val cargaTickets = listOf(5, 10, 15, 20, 25)
  val cargaTotal = cargaTickets.reduce { acc, n -> acc + n }
  println(cargaTotal)
  val factorCrecimiento = cargaTickets.reduce { acc, n -> acc * n }
  println(factorCrecimiento)

  println("Carga Inicial (Fold)")
  val cargaBaseTotal = cargaTickets.fold(100) { acc, n -> acc + n }
  println(cargaBaseTotal)
  val cargaBaseProducto = cargaTickets.fold(100) { acc, n -> acc * n }
  println(cargaBaseProducto)

  println("Ordenar Tickets")
  println("Antiguos primero: ${tickets.sorted()}")
  println("Recientes primero: ${tickets.sortedDescending()}")
  println("Prioridad alta: ${tickets.sortedBy { -it }}")

  println("Estadísticas de Soporte")
  println("Total reportado: ${tickets.sum()}")
  println("Promedio ID: ${tickets.average()}")
  println("Ticket menor: ${tickets.minOrNull()}")
  println("Ticket mayor: ${tickets.maxOrNull()}")
  println("Tickets de alta prioridad: ${tickets.count { it > 104 }}")

  println("Búsqueda de Tickets")
  println("Primer ticket encontrado: ${tickets.find { it > 104 }}")
  println("Último ticket encontrado: ${tickets.findLast { it > 104 }}")
  println("¿Existen tickets pendientes?: ${tickets.any { it > 104 }}")
  println("¿Todos los tickets están validados?: ${tickets.all { it > 0 }}")
  println("¿Ningún ticket supera el límite?: ${tickets.none { it > 200 }}")
}