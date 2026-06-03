class TicketSoporte {
  final String categoria;
  final String prioridad;
  final double costo;
  final bool requiereAtencion;

  TicketSoporte({
    required this.categoria,
    required this.prioridad,
    required this.costo,
    this.requiereAtencion = true,
  });

  TicketSoporte.soporteBasico({required this.categoria, required this.prioridad})
      : costo = 50.0,
        requiereAtencion = false;

  TicketSoporte.soporteCritico({required this.categoria, required this.prioridad})
      : costo = 500.0,
        requiereAtencion = true;

  factory TicketSoporte.desdeCodigo(String codigo) {
    final partes = codigo.split('-');
    return TicketSoporte(
      categoria: partes[0],
      prioridad: partes[1],
      costo: double.tryParse(partes[2]) ?? 0.0,
    );
  }

  @override
  String toString() =>
      '${requiereAtencion ? "⚠️" : "✅"} $categoria [$prioridad] — Costo: \$${costo.toStringAsFixed(2)}';
}

void main() {
  final t1 = TicketSoporte(categoria: 'Redes', prioridad: 'Alta', costo: 200.0);
  final t2 = TicketSoporte.soporteBasico(categoria: 'Software', prioridad: 'Baja');
  final t3 = TicketSoporte.soporteCritico(categoria: 'Servidor', prioridad: 'Urgente');
  final t4 = TicketSoporte.desdeCodigo('Hardware-Media-150.0');

  print(t1);
  print(t2);
  print(t3);
  print(t4);
}