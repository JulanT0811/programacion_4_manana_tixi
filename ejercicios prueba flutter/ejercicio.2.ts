import * as readlineSync from 'readline-sync';

// Definición de la interfaz requerida por el profesor[cite: 1]
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

  // Switch para los planes fijos del gimnasio[cite: 1]
  switch (plan) {
    case 1:
      nombre = 'Basico'; precioBase = 25.0; descuentoPct = 0.0; break;
    case 2:
      nombre = 'Estandar'; precioBase = 40.0; descuentoPct = 0.05; break;
    case 3:
      nombre = 'Premium'; precioBase = 65.0; descuentoPct = 0.10; break;
    case 4:
      nombre = 'Elite'; precioBase = 90.0; descuentoPct = 0.15; break;
    default:
      nombre = 'Desconocido'; precioBase = 0; descuentoPct = 0;
  }

  const subtotal = precioBase * meses;
  const descuento = subtotal * descuentoPct;
  const total = subtotal - descuento;

  // Retorna el objeto estructurado bajo la interfaz[cite: 1]
  return { precioBase, subtotal, descuento, total, nombre };
}

function main(): void {
  const plan = parseInt(readlineSync.question('Plan (1-Basico, 2-Estandar, 3-Premium, 4-Elite): '), 10);
  const meses = parseInt(readlineSync.question('Cantidad de meses a contratar: '), 10);

  const r = calcularMembresia(plan, meses);

  console.log('');
  console.log('=== RESUMEN DE MEMBRESIA ===');
  console.log(`Precio mensual: $${r.precioBase.toFixed(2)}`);
  console.log(`Subtotal      : $${r.subtotal.toFixed(2)}`);
  console.log(`Descuento     : $${r.descuento.toFixed(2)}`);
  console.log(`Total a pagar : $${r.total.toFixed(2)}`);
}

main();