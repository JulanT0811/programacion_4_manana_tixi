import * as readlineSync from 'readline-sync';

function tarifaPorCategoria(cat: number): number {
  // ✏️ MODIFICAR AQUÍ: Tarifas por noche según cada categoría
  if (cat === 1) return 45.0;
  else if (cat === 2) return 75.0;
  else if (cat === 3) return 130.0;
  else if (cat === 4) return 220.0;
  else return 0.0;
}

function main(): void {
  let totalRecaudado = 0;
  let altoValor = 0;
  let totalReservas = 0;

  console.log('=== SISTEMA DE RESERVAS HOTEL ===');
  console.log('(Ingrese 0 noches para finalizar)');
  console.log('');

  // ✏️ MODIFICAR AQUÍ: Condición de parada (0 noches)
  let noches = parseInt(
    readlineSync.question(`Reserva ${totalReservas + 1} Noches: `),
    10
  );

  while (noches !== 0) {
    const cat = parseInt(
      readlineSync.question('Categoria habitacion (1-4): '),
      10
    );

    const tarifa = tarifaPorCategoria(cat);
    const total = tarifa * noches;

    totalReservas++;
    totalRecaudado += total;

    // ✏️ MODIFICAR AQUÍ: Umbral de reserva de "Alto Valor" (por defecto > $300)
    if (total > 300) altoValor++;

    console.log(`Tarifa/noche: $${tarifa.toFixed(2)} | Total: $${total.toFixed(2)}`);
    console.log('');

    noches = parseInt(
      readlineSync.question(`Reserva ${totalReservas + 1} Noches: `),
      10
    );
  }

  // ✏️ MODIFICAR AQUÍ: Umbral para definir "Ocupacion alta" (por defecto > $3000)
  const estado = totalRecaudado > 3000 ? 'Ocupacion alta' : 'Ocupacion normal';

  console.log('=== INFORME DE CIERRE ===');
  console.log(`Total reservas atendidas: ${totalReservas}`);
  console.log(`Total recaudado        : $${totalRecaudado.toFixed(2)}`);
  console.log(`Reservas de alto valor : ${altoValor}`);
  console.log(`Estado de ocupacion    : ${estado}`);
}

main();