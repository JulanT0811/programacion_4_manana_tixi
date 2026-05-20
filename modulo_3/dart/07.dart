import 'dart:io';

void main() {


  /*print("Ingrese un numero:");
  int num = int.parse(stdin.readLineSync()!);
  print("El numero es: $num");

  if (num > 0) {
    print('El numero $num es positivo');
  } else if (num < 0) {
    print('El numero $num es negativo');
  } else {
    print('El numero $num es 0');
  }
}
 */
/*t("$nota");

  if (nota >= 7) {
    print('aprovado');
  }
  else if (nota < 7) {
    print('reprobado');
  }
}*/

print("Ingrese el año:");
  int anio = int.parse(stdin.readLineSync()!);
  print("El año es: $anio");
  if (anio % 4 == 0) {
    print('el año es bisiesto');
  } else if (anio % 100) {
    print('el año no es bisiesto');
  } else if (anio % 400) {
    print('el año es bisiesto');
  } else {
    print('el año no es bisiesto');
  }