abstract class TicketSoporte {
  String get titulo;
  double calcularCostoConImpuestos();
  double calcularCostoConDescuento();

  void mostrarResumen() {
    print('$titulo — costo con impuestos: \$${calcularCostoConImpuestos().toStringAsFixed(2)}, '
          'con descuento: \$${calcularCostoConDescuento().toStringAsFixed(2)}');
  }
}

class TicketHardware extends TicketSoporte {
  final double costo;
  final String componente;
  TicketHardware(this.componente, this.costo);

  @override String get titulo => 'Soporte Hardware: $componente (\$${costo.toStringAsFixed(2)})';
  @override double calcularCostoConImpuestos() => costo * 1.12;
  @override double calcularCostoConDescuento() => costo * 0.95;
}

class TicketSoftware extends TicketSoporte {
  final double costo;
  final String software;
  TicketSoftware(this.software, this.costo);

  @override String get titulo => 'Soporte Software: $software (\$${costo.toStringAsFixed(2)})';
  @override double calcularCostoConImpuestos() => costo * 1.12;
  @override double calcularCostoConDescuento() => costo * 0.90;
}

void main() {
  final tickets = <TicketSoporte>[
    TicketHardware('Disco Duro', 200.0),
    TicketSoftware('Sistema Operativo', 150.0),
  ];
  for (final t in tickets) {
    t.mostrarResumen();
  }
}