// lib/screens/pantalla_servidores.dart
import 'package:flutter/material.dart';
import '../models/servidor_ssh.dart';
import '../widgets/fila_servidor.dart';
import '../widgets/tarjetaservidorgrid.dart';

class PantallaServidores extends StatefulWidget {
  const PantallaServidores({super.key});
  @override
  State<PantallaServidores> createState() => _PantallaServidoresState();
}

class _PantallaServidoresState extends State<PantallaServidores> {
  final _servidores = [
    ServidorSSH(id:'1', nombre:'Falla de Conectividad VPN Corporativa', ip:'TICK-101 (Redes)', puerto:2, usuario:'Carlos Gómez', so:'Crítica', ssl:true, favorito:true),
    ServidorSSH(id:'2', nombre:'Error en Pasarela de Pago con Tarjeta', ip:'TICK-102 (Finanzas)', puerto:4, usuario:'María López', so:'Alta', ssl:true),
    ServidorSSH(id:'3', nombre:'Solicitud de Licencia Software CAD', ip:'TICK-103 (Diseño)', puerto:24, usuario:'Juan Pérez', so:'Media', ssl:false),
    ServidorSSH(id:'4', nombre:'Impresora de Contabilidad sin Respuesta', ip:'TICK-104 (Hardware)', puerto:8, usuario:'Ana Martínez', so:'Baja', ssl:false),
  ];

  bool _modoGrid = false; // false = lista, true = cuadrícula

  void _toggleFavorito(int i) =>
      setState(() => _servidores[i].favorito = !_servidores[i].favorito);

  void _eliminar(int i) => setState(() => _servidores.removeAt(i));

  @override
  Widget build(BuildContext context) {
    final cs = Theme.of(context).colorScheme;

    return Scaffold(
      appBar: AppBar(
        title: Text('Tickets de Soporte (${_servidores.length})'),
        backgroundColor: cs.primaryContainer,
        foregroundColor: cs.onPrimaryContainer,
        actions: [
          IconButton(
            icon: Icon(_modoGrid ? Icons.list : Icons.grid_view),
            onPressed: () => setState(() => _modoGrid = !_modoGrid),
            tooltip: _modoGrid ? 'Vista lista' : 'Vista cuadrícula',
          ),
        ],
      ),
      body: _modoGrid
          ? GridView.builder(
              padding: const EdgeInsets.all(12),
              gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(
                crossAxisCount: 2,
                childAspectRatio: 1.1,
                crossAxisSpacing: 8,
                mainAxisSpacing: 8,
              ),
              itemCount: _servidores.length,
              itemBuilder: (ctx, i) => TarjetaServidorGrid(
                servidor: _servidores[i],
                onFavorito: () => _toggleFavorito(i),
                onEliminar: () => _eliminar(i),
              ),
            )
          : ListView.separated(
              itemCount: _servidores.length,
              separatorBuilder: (_, __) => const Divider(height: 1, indent: 72),
              itemBuilder: (ctx, i) => FilaServidor(
                servidor: _servidores[i],
                onFavorito: () => _toggleFavorito(i),
                onEliminar: () => _eliminar(i),
              ),
            ),
    );
  }
}