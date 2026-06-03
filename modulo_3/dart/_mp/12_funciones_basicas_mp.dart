void saludarSoporte() {
  print('Bienvenido al Sistema de Soporte Técnico');
}

double calcularCostoBaseSinParametro() {
  return 500.0 + 150.0;
}

double calcularTotalTicket(double costo, double impuesto) {
  return costo + (costo * impuesto);
}

double calcularDescuentoTicket(double costo, double porcentaje) => costo * (1 - porcentaje / 100);

void imprimirCabecera(String titulo) {
  print('─── $titulo ───');
}

String formatearCosto(double costo) => '\$${costo.toStringAsFixed(2)}';

formatearCostoSinTipo(double costo) => '\$${costo.toStringAsFixed(2)}';

String construirDetalleTicket(String tipo, String prioridad, [int? id]) {
  if (id != null) {
    return '$tipo — Prioridad: $prioridad — ID: $id';
  }
  return '$tipo — Prioridad: $prioridad';
}

String construirDetalleTicketV2(String tipo, String prioridad, [int id = 0]) {
  return '$tipo — Prioridad: $prioridad — ID: $id';
}

void main() {
  print(calcularTotalTicket(200.0, 0.12));
  print(calcularDescuentoTicket(200.0, 5));
  imprimirCabecera('Gestión de Tickets');

  print(formatearCosto(150.50));
  print(formatearCostoSinTipo(300.0));

  print(construirDetalleTicket('Redes', 'Alta'));
  print(construirDetalleTicket('Hardware', 'Media', 101));
  print(construirDetalleTicketV2('Software', 'Baja'));
}