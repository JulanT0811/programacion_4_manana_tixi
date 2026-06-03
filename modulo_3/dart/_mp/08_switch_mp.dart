void main() {
  String estadoTicket = 'EN_PROCESO';

  switch (estadoTicket) {
    case 'ABIERTO':
      print('Esperando asignación de técnico');
    case 'EN_PROCESO':
      print('Soporte técnico trabajando en el ticket');
    case 'PENDIENTE':
      print('Esperando respuesta del usuario');
    case 'RESUELTO':
      print('Problema solucionado');
    case 'CERRADO':
      print('Ticket finalizado');
    default:
      print('Estado desconocido');
  }

  estadoTicket = 'EN_PROCESO';

  String descripcion = switch (estadoTicket) {
    'ABIERTO'    => 'Abierto — esperando técnico',
    'EN_PROCESO' => 'En proceso — ticket en manos del especialista',
    'PENDIENTE'  => 'Pendiente — esperando información del usuario',
    'RESUELTO'   => 'Resuelto — solución aplicada',
    'CERRADO'    => 'Cerrado — proceso concluido',
    'ESCALADO'   => 'Escalado — derivado a departamento superior',
    _            => 'Estado de ticket desconocido',
  };

  print(descripcion);
  print('');

  int prioridad = 2;

  String nivelPrioridad = switch (prioridad) {
    1 || 2          => 'Prioridad Alta (Urgente)',
    3 || 4          => 'Prioridad Media (Estándar)',
    5 || 6 || 7     => 'Prioridad Baja (Informativo)',
    _               => 'Prioridad no registrada',
  };

  print(nivelPrioridad);

  double tiempoResolucion = 48.0;

  String clasificacion = switch (tiempoResolucion) {
    double t when t <= 4.0  => '⚡ RÁPIDO — resolución inmediata',
    double t when t <= 24.0 => '⏱️ NORMAL — dentro de plazo',
    double t when t <= 48.0 => '⚠️ DEMORADO — requiere atención',
    double t when t > 48.0  => '❌ CRÍTICO — fuera de SLA',
    _                       => '❓ TIEMPO NO VÁLIDO',
  };

  print(clasificacion);
}