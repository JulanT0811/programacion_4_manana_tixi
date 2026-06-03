void registrarTicket({
  required String tipo,
  required String severidad,
  bool esUrgente = false,
  int tiempoEstimado = 24,
}) {
  final estadoUrgencia = esUrgente ? 'Urgente' : 'Normal';
  print('Registrando ticket de $tipo ($severidad) — Prioridad: $estadoUrgencia (ETA: $tiempoEstimado horas)');
}

void main() {
  registrarTicket(
    tipo: 'Redes',
    severidad: 'Alta',
    esUrgente: true,
    tiempoEstimado: 4,
  );

  registrarTicket(
    tipo: 'Hardware',
    severidad: 'Media',
  );
}