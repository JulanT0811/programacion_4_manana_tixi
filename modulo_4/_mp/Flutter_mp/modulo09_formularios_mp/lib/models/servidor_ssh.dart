// lib/models/servidor_ssh.dart
// Modelo de Ticket de Soporte Técnico para Módulo 09
class ServidorSSH {
  final String id;
  final String nombre; // Asunto del ticket
  final String ip;     // Código / Categoría del ticket (ej: "TICK-101 (Redes)")
  final int    puerto; // SLA horas
  final String usuario; // Solicitante
  final String so;      // Prioridad (Crítica, Alta, Media, Baja)
  final bool   ssl;      // ¿Urgente?
  bool         favorito; // Guardado en destacados

  ServidorSSH({
    required this.id,
    required this.nombre,
    required this.ip,
    required this.puerto,
    required this.usuario,
    required this.so,
    required this.ssl,
    this.favorito = false,
  });
}

// Alias para Tickets de Soporte
typedef TicketSoporte = ServidorSSH;