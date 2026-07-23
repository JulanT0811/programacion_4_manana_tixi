import * as readlineSync from 'readline-sync';

interface ResumenMembresia {
  precioBase: number;
  subtotal: number;
  descuento: number;
  total: number;
  nombre: string;
}

function calcularMembresia(plan: number, meses: number): ResumenMembresia {
  let precioBase: number;
  let descuentoPct: number;
  let nombre: string;

  // ✏️ MODIFICAR AQUÍ: Precios, porcentajes de descuento o nombres de planes
  switch (plan) {
    case 1:
      nombre = 'Basico';
      precioBase = 25.0;
      descuentoPct = 0.0; // 0%
      break;
    case 2:
      nombre = 'Estandar';
      precioBase = 40.0;
      descuentoPct = 0.05; // 5%
      break;
    case 3:
      nombre = 'Premium';
      precioBase = 65.0;
      descuentoPct = 0.10; // 10%
      break;
    case 4:
      nombre = 'Elite';
      precioBase = 90.0;
      descuentoPct = 0.15; // 15%
      break;
    default:
      nombre = 'Desconocido';
      precioBase = 0;
      descuentoPct = 0;
  }

  const subtotal = precioBase * meses;
  const descuento = subtotal * descuentoPct;
  const total = subtotal - descuento;

  return { precioBase, subtotal, descuento, total, nombre };
}

function main(): void {
  // ✏️ MODIFICAR AQUÍ: Opciones mostradas al usuario en la consola
  const plan = parseInt(
    readlineSync.question('Plan (1-Basico, 2-Estandar, 3-Premium, 4-Elite): '),
    10
  );
  const meses = parseInt(
    readlineSync.question('Cantidad de meses a contratar: '),
    10
  );

  const r = calcularMembresia(plan, meses);

  console.log('');
  console.log('=== RESUMEN DE MEMBRESIA ===');
  console.log(`Precio mensual: $${r.precioBase.toFixed(2)}`);
  console.log(`Subtotal      : $${r.subtotal.toFixed(2)}`);
  console.log(`Descuento     : $${r.descuento.toFixed(2)}`);
  console.log(`Total a pagar : $${r.total.toFixed(2)}`);
}

main();