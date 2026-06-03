void main() {
  final costos = [299.99, 999.99, 149.99, 1299.99];

  final costosConImpuesto = costos.map((c) => c * 1.12);
  print(costosConImpuesto.toList());

  final tiposTicket = ['Redes', 'Hardware', 'Software'];
  final etiquetas = tiposTicket.map((t) => 'Ticket de: $t');
  print(etiquetas.toList());

  final costosTickets = [149.99, 499.99, 999.99, 299.99, 1299.99, 89.99];

  final ticketsPrioritarios = costosTickets.where((c) => c > 700);
  print(ticketsPrioritarios.toList());

  final ticketsEstandar = costosTickets.where((c) => c >= 200 && c <= 700);
  print(ticketsEstandar.toList());

  final tiemposResolucion = [15.0, 23.0, 9.8, 31.0, 7.5];

  final tiempoTotal = tiemposResolucion.reduce((acum, tiempo) => acum + tiempo);
  print('Total horas: ${tiempoTotal.toStringAsFixed(2)}');

  final tiempoTotalFold = tiemposResolucion.fold(0.0, (acum, tiempo) => acum + tiempo);
  print('Total horas (fold): ${tiempoTotalFold.toStringAsFixed(2)}');

  final tiempoMaximo = tiemposResolucion.reduce((a, b) => a > b ? a : b);
  print('Tiempo máximo registrado: $tiempoMaximo');
}