import 'dart:io';

void main() {
  double costoServicio = 999.99;

  if (costoServicio >= 1000) {
    print('Soporte Premium');
  } else if (costoServicio >= 500) {
    print('Soporte Avanzado');
  } else if (costoServicio >= 200) {
    print('Soporte Estándar');
  } else {
    print('Soporte Básico');
  }

  String tipoSoporte = costoServicio >= 800 ? 'Soporte prioritario' : 'Soporte regular';
  print(tipoSoporte);

  String? tecnicoAsignado;
  String display = tecnicoAsignado != null ? tecnicoAsignado.toUpperCase() : 'Sin técnico asignado';

  String display2 = tecnicoAsignado?.toUpperCase() ?? 'Sin técnico asignado';
  print(display2);
}