void main() {
  final tickets = ['Error de red', 'Fallo de hardware', 'Actualización', 'Consulta', 'Seguridad'];

  for (final ticket in tickets) {
    print(ticket);
  }

  tickets.forEach((t) => print(t.toLowerCase()));

  final colaPrioridad = {'Ticket 001': 1, 'Ticket 002': 2, 'Ticket 003': 3, 'Ticket 004': 4};
  for (final entrada in colaPrioridad.entries) {
    print('${entrada.key} → prioridad ${entrada.value}');
  }

  for (final caracter in 'TK-99'.split('')) {
    print(caracter);
  }
}