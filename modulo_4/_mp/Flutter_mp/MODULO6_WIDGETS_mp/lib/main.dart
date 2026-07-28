// lib/main.dart
import 'package:flutter/material.dart';
import 'widgets/catalogo_basicos.dart';
import 'widgets/etiqueta.dart';
import 'widgets/servicio_estado.dart';
import 'widgets/contador_limitado.dart';
import 'widgets/reloj.dart';
import 'widgets/pantalla_contexto.dart';
import 'widgets/indicador.dart';

// ┌──────────────────────────────────────────────────────────────────┐
// │  Sistema de Tickets de Soporte Técnico - Módulo 6 (Flutter)      │
// │  Cambia este número y guarda (Ctrl+S) para navegar entre pasos. │
// │  1  Paso 1   StatelessWidget mínimo — Saludo Soporte            │
// │  2  Paso 1b  Widgets básicos — catálogo                         │
// │  3  Paso 2   StatelessWidget con parámetros (Etiquetas Ticket)  │
// │  4  Paso 3   StatefulWidget / Estado de Ticket                  │
// │  5  Paso 3b  Parámetros en StatefulWidget                       │
// │  6  Paso 4   Ciclo de vida con Timer / SLA                      │
// │  7  Paso 5   BuildContext                                        │
// │  8  Paso 6   Composición de widgets (Métricas de Soporte)       │
// └──────────────────────────────────────────────────────────────────┘
const int paso = 8;

void main() => runApp(
  MaterialApp(
    debugShowCheckedModeBanner: false,
    home: switch (paso) {
      1 => const Scaffold(body: Center(child: Saludo())),
      2 => const CatalogoBasicos(),
      3 => const Scaffold(
            body: Center(
              child: Wrap(
                spacing:    12,
                runSpacing: 8,
                children: [
                  Etiqueta(texto: 'Abierto',    color: Colors.blue,   icono: Icons.check_circle,   relleno: true),
                  Etiqueta(texto: 'En Proceso', color: Colors.orange, icono: Icons.hourglass_empty, relleno: true),
                  Etiqueta(texto: 'Resuelto',   color: Colors.green,  icono: Icons.check,          relleno: true),
                  Etiqueta(texto: 'Crítico',    color: Colors.red,    icono: Icons.warning,        fontSize: 16, relleno: true),
                  Etiqueta(texto: 'SLA OK',     color: Colors.teal,   icono: Icons.timer,          fontSize: 11, relleno: true),
                ],
              ),
            ),
          ),
      4 => const Scaffold(
            body: Center(
              child: ServicioEstado(nombre: 'Ticket TICK-101 (VPN)'),
            ),
          ),
      5 => Scaffold(
            body: Center(
              child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  ContadorLimitado(
                    etiqueta: 'Reintentos de conexión SLA',
                    limite:   3,
                    color:    Colors.red,
                    onLimite: () => debugPrint('¡Escalado a Nivel 3!'),
                  ),
                  const SizedBox(height: 40),
                  ContadorLimitado(
                    etiqueta: 'Tickets asignados a técnico',
                    limite:   10,
                    color:    Colors.indigo,
                  ),
                ],
              ),
            ),
          ),
      6 => Scaffold(
            appBar: AppBar(title: const Text('Tiempo SLA Restante')),
            body: const Center(child: Reloj()),
          ), 
      7 => const PantallaContexto(),   
      8 => Scaffold(
            body: Center(
              child: Wrap(
                spacing:    32,
                runSpacing: 24,
                alignment:  WrapAlignment.center,
                children: const [
                  Indicador(label: 'Tickets activos',   valor: '12',
                            color: Colors.indigo, icono: Icons.confirmation_number),
                  Indicador(label: 'Incidencias críticas', valor: '2',
                            color: Colors.red,   icono: Icons.warning_amber,
                            subtitulo: 'Requieren atención'),
                  Indicador(label: 'Tickets resueltos', valor: '48',
                            color: Colors.green, icono: Icons.check_circle),
                  Indicador(label: 'Cumplimiento SLA',  valor: '98.5%',
                            color: Colors.teal, subtitulo: 'Últimos 30 días'),
                ],
              ),
            ),
          ),
      _ => Scaffold(
        body: Center(child: Text('Paso $paso: crea el widget primero')),
      ),
    },
  ),
);

class Saludo extends StatelessWidget {
  const Saludo({super.key});

  @override
  Widget build(BuildContext context) {
    return const Text(
      'Mesa de Ayuda\nTickets de Soporte Técnico',
      style: TextStyle(
        fontSize: 28,
        fontWeight: FontWeight.bold,
        letterSpacing: 2,
        color: Colors.indigo,
        shadows: [Shadow(color: Colors.black26, blurRadius: 4, offset: Offset(2,2))],
      ),
      textAlign: TextAlign.center,
      overflow: TextOverflow.fade,
      maxLines: 2,
    );
  }
}