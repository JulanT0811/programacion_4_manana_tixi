import 'dart:io';

void main() {
  int totalTickets = 0;
  int totalTecnicos = 0;

  print('Registro de tickets de soporte técnico');
  print('');

  while (true) {
    stdout.write('Ingrese las horas dedicadas al ticket: ');
    String? inputHoras = stdin.readLineSync();
    if (inputHoras == null) break;
    double? horas = double.tryParse(inputHoras);
    if (horas == null) {
      print('Número inválido.');
      continue;
    }
    if (horas <= 0) {
      break;
    }

    stdout.write('Ingrese la cantidad de tickets resueltos: ');
    String? inputTickets = stdin.readLineSync();
    if (inputTickets == null) break;
    int? tickets = int.tryParse(inputTickets);
    if (tickets == null) {
      print('Cantidad de tickets inválida.');
      continue;
    }

    double ticketsPorHora = tickets / horas;
    String clasificacion;
    if (ticketsPorHora < 2) {
      clasificacion = 'Eficiencia baja';
    } else if (ticketsPorHora <= 5) {
      clasificacion = 'Eficiencia normal';
    } else {
      clasificacion = 'Eficiencia alta';
    }

    print('Tickets resueltos por hora: ${ticketsPorHora.toStringAsFixed(2)} - $clasificacion');

    totalTickets += tickets;
    totalTecnicos++;
  }

  print('');
  print('Resumen de Soporte');
  print('Total de tickets resueltos: $totalTickets');
  print('Cantidad de técnicos registrados: $totalTecnicos');

  if (totalTecnicos > 0) {
    double promedio = totalTickets / totalTecnicos;
    print('Promedio de tickets por técnico: ${promedio.toStringAsFixed(2)}');
  } else {
    print('Promedio de tickets por técnico: 0.00');
  }
}