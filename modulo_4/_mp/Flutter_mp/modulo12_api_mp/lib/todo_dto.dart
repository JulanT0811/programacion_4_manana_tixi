// DTO de Ticket / Tarea de Soporte Técnico desde API
class TodoDto {
  final int id;
  final String title;
  final bool completed;

  const TodoDto({
    required this.id,
    required this.title,
    required this.completed,
  });

  bool get pendiente => !completed;
  String get ticketCodigo => 'TICK-${100 + id}';
  String get estadoTexto => completed ? 'RESUELTO' : 'EN PROCESO';

  factory TodoDto.fromJson(Map<String, dynamic> json) => TodoDto(
    id: json['id'] as int,
    title: json['title'] as String,
    completed: json['completed'] as bool,
  );
}