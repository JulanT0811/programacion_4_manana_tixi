class GestionPresupuestoTicket {
  final String idTecnico;
  double _presupuesto;

  GestionPresupuestoTicket(this.idTecnico, double presupuestoInicial)
      : _presupuesto = presupuestoInicial;

  double get presupuesto => _presupuesto;

  void asignarFondos(double monto) {
    if (monto <= 0) throw ArgumentError('El monto debe ser positivo');
    _presupuesto += monto;
    print('Fondos asignados: \$$monto. Presupuesto actual: \$$_presupuesto');
  }

  void descontarCosto(double monto) {
    if (monto <= 0) throw ArgumentError('El monto debe ser positivo');
    if (monto > _presupuesto) throw StateError('Presupuesto insuficiente para cubrir el costo');
    _presupuesto -= monto;
    print('Costo descontado: \$$monto. Presupuesto restante: \$$_presupuesto');
  }
}

void main() {
  final presupuesto = GestionPresupuestoTicket('TEC-001', 2000.0);

  presupuesto.asignarFondos(500.0);
  presupuesto.descontarCosto(850.50);
  print('Presupuesto disponible: \$${presupuesto.presupuesto}');
}