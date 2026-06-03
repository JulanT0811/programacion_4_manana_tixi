class TicketSoporte {
  final String idTicket;
  final String descripcion;
  double costoServicio;
  bool _resuelto = false;

  TicketSoporte({
    required this.idTicket,
    required this.descripcion,
    required this.costoServicio,
  });

  bool get resuelto => _resuelto;
  String get estado => _resuelto ? 'resuelto' : 'pendiente';

  set estadoResuelto(bool valor) {
    _resuelto = valor;
    print('Ticket $idTicket: ${valor ? "marcado como completado" : "marcado como en proceso"}');
  }

  void resolver() {
    _resuelto = true;
    print('Ticket $idTicket ($descripcion) cerrado con un costo de \$${costoServicio.toStringAsFixed(2)}');
  }

  void aplicarCargoExtra(double porcentaje) {
    costoServicio = costoServicio * (1 + porcentaje / 100);
    print('Ticket $idTicket con ${porcentaje}% de recargo. Nuevo costo: \$${costoServicio.toStringAsFixed(2)}');
  }

  String resumen() => 'ID: $idTicket | Descripción: $descripcion | Costo: \$${costoServicio.toStringAsFixed(2)} | Estado: $estado';

  @override
  String toString() => 'TicketSoporte($idTicket, \$${costoServicio.toStringAsFixed(2)}, $estado)';
}

void main() {
  final soporteRed = TicketSoporte(
    idTicket: 'TK-001',
    descripcion: 'Fallo en conexión de red',
    costoServicio: 150.0,
  );

  soporteRed.aplicarCargoExtra(5);
  print(soporteRed.estado);
  print(soporteRed.resumen());
  print(soporteRed);

  soporteRed.estadoResuelto = true;
  print(soporteRed.resuelto);
}