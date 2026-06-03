abstract class ElementoSoporte {
  String get titulo;
  double calcularCostoTotal();
}

class TicketHardware extends ElementoSoporte {
  final double costo;
  final String componente;
  TicketHardware(this.componente, this.costo);
  @override String get titulo => 'Soporte Hardware: $componente';
  @override double calcularCostoTotal() => costo * 1.12;
}

class TicketSoftware extends ElementoSoporte {
  final double costo;
  final String software;
  TicketSoftware(this.software, this.costo);
  @override String get titulo => 'Soporte Software: $software';
  @override double calcularCostoTotal() => costo * 1.12 * 0.90;
}

class TicketConsultoria extends ElementoSoporte {
  final double costo;
  final String servicio;
  TicketConsultoria(this.servicio, this.costo);
  @override String get titulo => 'Consultoría: $servicio';
  @override double calcularCostoTotal() => costo;
}

void imprimirCostoFinal(ElementoSoporte elemento) {
  print('${elemento.titulo}: \$${elemento.calcularCostoTotal().toStringAsFixed(2)}');
}

void main() {
  final colaSoporte = <ElementoSoporte>[
    TicketHardware('Servidor', 500.0),
    TicketSoftware('Base de Datos', 300.0),
    TicketConsultoria('Optimización de Red', 150.0),
  ];

  for (final e in colaSoporte) {
    imprimirCostoFinal(e);
  }

  final masCostoso = colaSoporte.reduce((a, b) =>
      a.calcularCostoTotal() > b.calcularCostoTotal() ? a : b);
  print('\nTicket con mayor costo: ${masCostoso.titulo}');
}