import * as readlineSync from 'readline-sync';

function main(): void {
  const TOTAL = 6; // Límite de 6 vehículos[cite: 1]
  let totalInventario = 0; // Acumulador de dinero total[cite: 1]
  let lujo = 0; // Contador de vehículos de lujo[cite: 1]

  for (let i = 1; i <= TOTAL; i++) {
    const modelo = readlineSync.question(`Vehiculo ${i} Modelo: `);
    const precio = parseFloat(readlineSync.question(`Vehiculo ${i} Precio (USD): `)); // parseFloat para dinero[cite: 1]

    let segmento: string;

    if (precio < 15000) {
      segmento = 'Economico';
    } else if (precio <= 30000) {
      segmento = 'Medio';
    } else if (precio <= 60000) {
      segmento = 'Premium';
    } else {
      segmento = 'Lujo';
      lujo++; // Suma 1 si es de lujo[cite: 1]
    }

    totalInventario += precio; // Acumula el precio actual en el total[cite: 1]
    console.log(`[${modelo}] $${precio.toFixed(2)} -> Segmento ${segmento}`);
  }

  console.log('');
  console.log('=== RESUMEN DEL INVENTARIO ===');
  console.log(`Valor total del inventario: $${totalInventario.toFixed(2)}`);
  console.log(`Vehiculos segmento lujo : ${lujo} de ${TOTAL}`);
}

main();