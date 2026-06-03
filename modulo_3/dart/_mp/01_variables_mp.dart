void main() {
  var soporte = 'Hardware';
  var prioridad = 3;
  var tiempoRespuesta = 24.5;
  var estaAbierto = true;

  String categoria = 'Redes';
  int ticketsPendientes = 5;
  double tasaDeExito = 0.95;
  bool requiereRevision = false;

  final idTicket = 'TK-998877';

  const impuestoServicio = 0.12;
  const nombreDepartamento = 'Soporte Técnico Especializado';

  final fechaRegistro = DateTime.now();

  print('$soporte $categoria — Prioridad: $prioridad | Pendientes: $ticketsPendientes | ID: $idTicket');
}