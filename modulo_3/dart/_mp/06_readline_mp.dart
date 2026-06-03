import 'dart:io';

void main() {
  print("Ingrese el ID del ticket:");
  String? idTicket = stdin.readLineSync();
  print("Consultando: $idTicket");

  print("Ingrese la prioridad del ticket (1-10):");
  int prioridad = int.parse(stdin.readLineSync()!);
  print("Prioridad asignada: $prioridad");

  print("Ingrese el tiempo estimado de resolución (horas):");
  double tiempo = double.parse(stdin.readLineSync()!);
  print("Tiempo estimado: $tiempo horas");

  print("");
  print("CÁLCULO DE COSTO DE SERVICIO");
  print('Ingrese el costo base del soporte:');
  double costoBase = double.parse(stdin.readLineSync()!);

  print('Ingrese el porcentaje de cargo adicional por urgencia:');
  double cargo = double.parse(stdin.readLineSync()!);

  double total = costoBase + (costoBase * cargo / 100);

  print('Total del servicio: \$${total.toStringAsFixed(2)}');

  print("Ingrese la prioridad para validación:");
  int nivel = int.parse(stdin.readLineSync()!);
  print("El nivel es: $nivel");

  if (nivel > 5) {
    print('Prioridad alta');
  } else if (nivel < 5 && nivel > 0) {
    print('Prioridad baja');
  } else {
    print('Prioridad estándar');
  }
}