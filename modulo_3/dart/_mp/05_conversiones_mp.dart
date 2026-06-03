void main() {
  
  int totalTickets = 15;
  double ticketsDecimal = totalTickets.toDouble();
  String textoTickets = totalTickets.toString();

  int id = int.parse('25');
  double prioridad = double.parse('9.99');

  
  int? codigoTicket = int.tryParse('TK-ERROR'); 
  double? nivelIngresado = double.tryParse('6.99'); 


  Object datos = 'Ticket Soporte Técnico'; 
  if (datos is String) {
    print("Longitud del texto: ${datos.length}");
  }

  
  Object objeto = 'Ticket Redes';
  String tipo = objeto as String;
  print("Tipo de ticket: $tipo");


  String? idReferencia = null;
  int longitud = idReferencia?.length ?? 0;
  print("Longitud de referencia: $longitud");


  print("Infinito: ${double.infinity}");
  print("NaN (No es un número): ${double.nan}");
  print("Máximo finito: ${double.maxFinite}");
}