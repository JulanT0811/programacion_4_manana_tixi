// lib/providers/servidores_provider.dart
import 'package:flutter_riverpod/flutter_riverpod.dart';
import '../models/servidor_ssh.dart';

// NotifierProvider — estado de tickets de soporte técnico en Riverpod
class ServidoresNotifier extends Notifier<List<ServidorSSH>> {
  @override
  List<ServidorSSH> build() => [
    ServidorSSH(id:'1', nombre:'TICK-101: Caída de Conectividad VPN Corporativa', ip:'Carlos Gómez (Finanzas)', puerto:2, ssl:true, favorito:true),
    ServidorSSH(id:'2', nombre:'TICK-102: Error al Procesar Pago con Tarjeta', ip:'María López (Ventas)', puerto:4, ssl:true),
    ServidorSSH(id:'3', nombre:'TICK-103: Solicitud de Licencia Software CAD', ip:'Juan Pérez (Diseño)', puerto:24, ssl:false),
    ServidorSSH(id:'4', nombre:'TICK-104: Impresora de Contabilidad Fuera de Línea', ip:'Ana Martínez (Hardware)', puerto:8, ssl:false),
  ];

  void toggleFavorito(String id) {
    state = state.map((s) =>
        s.id == id
          ? ServidorSSH(id:s.id, nombre:s.nombre, ip:s.ip,
                        puerto:s.puerto, ssl:s.ssl,
                        favorito:!s.favorito)
          : s
    ).toList();
  }

  void eliminar(String id) {
    state = state.where((s) => s.id != id).toList();
  }

  void agregar(ServidorSSH servidor) {
    state = [...state, servidor];
  }
}

final servidoresProvider =
    NotifierProvider<ServidoresNotifier, List<ServidorSSH>>(
  ServidoresNotifier.new,
);

// Filtro de búsqueda — estado primitivo
final busquedaProvider = StateProvider<String>((ref) => '');

// Provider DERIVADO — tickets filtrados
final servidoresFiltradosProvider = Provider<List<ServidorSSH>>((ref) {
  final todos = ref.watch(servidoresProvider);
  final busqueda = ref.watch(busquedaProvider);

  if (busqueda.isEmpty) return todos;

  final q = busqueda.toLowerCase();
  return todos.where((s) =>
      s.nombre.toLowerCase().contains(q) || s.ip.toLowerCase().contains(q)
  ).toList();
});