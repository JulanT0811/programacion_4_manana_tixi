void main() {
  List<String> departamentos = ['Soporte Técnico', 'Redes', 'Hardware'];
  var prioridades = [1, 2, 3];

  print(departamentos[0]);
  print(departamentos.length);
  departamentos.add('Software');
  departamentos.remove('Hardware');

  Map<String, int> colaTickets = {
    'Error de login': 1,
    'Fallo de impresora': 2,
    'Actualización de sistema': 3,
  };

  print(colaTickets['Error de login']);
  print(colaTickets['Fallo de red']);
  colaTickets['Cambio de contraseña'] = 4;

  Set<String> etiquetas = {'urgente', 'bloqueante', 'informativo'};
  etiquetas.add('urgente');
  print(etiquetas.length);

  var soporteBasico = ['Consulta', 'Sugerencia'];
  var soporteAvanzado = ['Error Crítico', 'Falla de Hardware'];
  var todosLosTickets = [...soporteBasico, ...soporteAvanzado];
  print(todosLosTickets);

  bool mostrarUrgentes = true;
  var ticketsActivos = [
    'Consulta General',
    'Soporte Técnico',
    if (mostrarUrgentes) 'Error Crítico',
  ];

  var tiemposEspera = [10, 30, 60];
  var tiemposConMargen = [for (var t in tiemposEspera) t + 5];
  print(tiemposConMargen);
}