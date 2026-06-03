import 'dart:io';

void main() {
  for (int i = 0; i < 5; i++) {
    print('Ticket #$i en revisión');
  }

  for (int i = 0; i <= 100; i += 25) {
    print('Progreso de resolución: $i%');
  }

  for (int i = 5; i >= 1; i--) {
    print('Prioridad de tickets pendientes: $i');
  }

  print("GENERAR REPORTE DE TIEMPOS - Ingrese el tiempo total de resolución en horas:");
  double horas = double.parse(stdin.readLineSync()!);
  for (int i = 1; i <= 12; i++) {
    print('Reporte $i de 12: ${(horas / 12).toStringAsFixed(2)} horas por fase');
  }
}