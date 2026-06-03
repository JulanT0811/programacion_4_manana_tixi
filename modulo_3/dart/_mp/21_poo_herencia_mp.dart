class TicketSoporte {
  final String categoria;
  final int anio;

  TicketSoporte(this.categoria, this.anio);

  String descripcion() => 'Ticket de soporte técnico';

  void mostrarInfo() {
    print('$categoria ($anio) — ${descripcion()}');
  }
}

class TicketHardware extends TicketSoporte {
  final String componente;
  TicketHardware(super.categoria, super.anio, this.componente);

  @override
  String descripcion() => 'Soporte de hardware para $componente';

  void diagnosticar() => print('Realizando pruebas en $componente...');
}

class TicketSoftware extends TicketSoporte {
  final String sistema;
  TicketSoftware(super.categoria, super.anio, this.sistema);

  @override
  String descripcion() => 'Soporte de software en $sistema';

  void actualizar() => print('Aplicando parches en $sistema...');
}

void main() {
  final hardware = TicketHardware('Mantenimiento', 2026, 'Monitor');
  final software = TicketSoftware('Incidencia', 2026, 'Windows 11');

  hardware.mostrarInfo();
  software.mostrarInfo();

  hardware.diagnosticar();
  software.actualizar();
}