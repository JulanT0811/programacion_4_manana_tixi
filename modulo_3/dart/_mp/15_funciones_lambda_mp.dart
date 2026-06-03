void main() {
  final calcularImpuesto = (double costo) => costo * 0.12;
  print(calcularImpuesto(500.0));

  final calcularCostoFinal = (double costo, double descuento) {
    final montoDescuento = costo * (descuento / 100);
    return costo - montoDescuento;
  };
  print(calcularCostoFinal(1000.0, 10.0));

  final prioridades = [1, 5, 2, 8, 3];
  prioridades.sort((a, b) => b.compareTo(a));
  print(prioridades);
}