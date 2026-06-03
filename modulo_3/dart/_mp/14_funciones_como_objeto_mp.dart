double calcularCargos(double costo) => costo * 1.12;
double calcularDescuento(double costo) => costo * 0.90;

void main() {
  double Function(double) operacion;

  operacion = calcularCargos;
  print(operacion(500.0));

  operacion = calcularDescuento;
  print(operacion(500.0));

  final estrategiasDeCosto = <double Function(double)>[calcularCargos, calcularDescuento];
  for (final fn in estrategiasDeCosto) {
    print(fn(1000.0));
  }
}