import * as readlineSync from 'readline-sync';

function main(): void {
  // ✏️ MODIFICAR AQUÍ: Cambia la cantidad total de vehículos a procesar
  const TOTAL = 5; 
  let tarifaMaxima = 0;

  for (let i = 1; i <= TOTAL; i++) {
    const placa = readlineSync.question(`Vehiculo ${i} Placa: `);
    const horas = parseInt(
      readlineSync.question(`Vehiculo ${i} Horas estacionado: `),
      10
    );

    let costo: number;
    let categoria: string;

    // ✏️ MODIFICAR AQUÍ: Ajusta los rangos de horas y los costos por hora
    if (horas === 0) {
      costo = 0;
      categoria = 'Gratis';
    } else if (horas <= 2) { // 1 a 2 horas
      costo = horas * 1.50; // $1.50 por hora
      categoria = 'Tarifa normal';
    } else if (horas <= 5) { // 3 a 5 horas
      costo = horas * 1.00; // $1.00 por hora (reducida)
      categoria = 'Tarifa reducida';
    } else { // Más de 5 horas
      costo = 8.00; // Tarifa máxima fija
      categoria = 'Tarifa maxima';
      tarifaMaxima++;
    }

    console.log(`[${placa}] ${horas} h -> ${categoria} $${costo.toFixed(2)}`);
  }

  console.log('');
  console.log('=== RESUMEN ===');
  console.log(`Vehiculos con tarifa maxima: ${tarifaMaxima}`);
}

main();