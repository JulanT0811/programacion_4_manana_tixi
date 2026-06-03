void main() {
  final asunto = 'Error de red';
  final prioridad = 5;

  print('Asunto: $asunto');

  print('${asunto.toUpperCase()} tiene una prioridad de ${prioridad * 2}');

  final resumenTicket = '''
Asunto:    $asunto
Prioridad: $prioridad
Estado:    ${prioridad >= 5 ? 'Urgente' : 'Normal'}
  ''';
  print(resumenTicket);

  final rutaLogs = r'logs\tickets\error_001.log';
  print(rutaLogs);

  final etiqueta = 'Ticket ID: ' + 'TK-101' + ' — procesando';
  print(etiqueta);

  print('ticket'.toUpperCase());
  print('  soporte  '.trim());
  print('Fallo crítico'.contains('Fallo'));
  print('Ticket-101'.replaceAll('-', ':'));
  print('Redes,Hardware,Software'.split(','));
  print('Soporte'.substring(0, 3));
  print('Prioridad'.startsWith('Pri'));
  print('99'.padLeft(4, '0'));
}