import * as readlineSync from 'readline-sync';

function main(): void {
  // ✏️ MODIFICAR AQUÍ: Número de vehículos a evaluar
  const TOTAL = 6; 
  let totalInventario = 0;
  let lujo = 0;

  for (let i = 1; i <= TOTAL; i++) {
    const modelo = readlineSync.question(`Vehiculo ${i} Modelo: `);
    const precio = parseFloat(
      readlineSync.question(`Vehiculo ${i} Precio (USD): `)
    );

    let segmento: string;

    // ✏️ MODIFICAR AQUÍ: Límites numéricos de cada segmento de precio
    if (precio < 15000) {
      segmento = 'Economico';
    } else if (precio <= 30000) {
      segmento = 'Medio';
    } else if (precio <= 60000) {
      segmento = 'Premium';
    } else {
      segmento = 'Lujo';
      lujo++;
    }

    totalInventario += precio;
    console.log(`[${modelo}] $${precio.toFixed(2)} -> Segmento ${segmento}`);
  }

  console.log('');
  console.log('=== RESUMEN DEL INVENTARIO ===');
  console.log(`Valor total del inventario: $${totalInventario.toFixed(2)}`);
  console.log(`Vehiculos segmento lujo  : ${lujo} de ${TOTAL}`);
}

main();