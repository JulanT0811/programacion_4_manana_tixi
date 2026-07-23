import * as readlineSync from 'readline-sync';
function main() {
    // 1. CAMBIO APLICADO: Ahora el enunciado pide 3 estudiantes
    const TOTAL = 3;
    // 2. CAMBIO APLICADO: Ahora contamos alumnos excelentes
    let alumnosExcelencia = 0;
    for (let i = 1; i <= TOTAL; i++) {
        // 3. CAMBIO APLICADO: Ahora preguntamos por nombre y nota
        const nombre = readlineSync.question(`Estudiante ${i} Nombre:`);
        const nota = parseInt(readlineSync.question(`Estudiante ${i} Nota final: `), 10);
        // Ajustamos las variables al nuevo contexto (ya no hay costo monetario)
        let estado;
        // 4. CAMBIO APLICADO: Estructura idéntica, pero con los nuevos rangos de notas
        if (nota === 0) {
            estado = 'Reprobado directo';
        }
        else if (nota <= 6) {
            estado = 'Supletorio';
        }
        else if (nota <= 9) {
            estado = 'Aprobado normal';
        }
        else {
            estado = 'Excelencia';
            alumnosExcelencia++; // Incrementamos el nuevo contador si la nota es mayor a 9
        }
        // 5. CAMBIO APLICADO: Imprimimos los nuevos datos (ya no usamos .toFixed porque la nota es entera)
        console.log(`[${nombre}] Nota: ${nota} -> Condicion: ${estado}`);
    }
    console.log('');
    console.log('=== RESUMEN ===');
    // 6. CAMBIO APLICADO: Mostramos el total de la nueva estadística
    console.log(`Alumnos con excelencia: ${alumnosExcelencia}`);
}
main();
