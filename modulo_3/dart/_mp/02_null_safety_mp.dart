void main() {
  String descripcion = 'Fallo de red';

  String? codigoError = null;
  codigoError = 'ERR-404';

  String? severidad = 'Crítica';

  print(severidad?.length);

  String mensajeFinal = severidad ?? 'Prioridad normal';
  print(mensajeFinal);

  String severidadSegura = severidad!;

  if (codigoError != null) {
    print(codigoError.length);
  }

  late String idTicket;
  idTicket = 'TK-1001';
  print(idTicket);
}