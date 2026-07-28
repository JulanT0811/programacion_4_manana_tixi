class ServidorSSH {
  final String id;
  final String nombre;
  final String ip;
  final int    puerto;
  final bool   ssl;

  const ServidorSSH({
    required this.id,
    required this.nombre,
    required this.ip,
    required this.puerto,
    required this.ssl,
  });
}

// Lista simulada de Tickets de Soporte Técnico
const servidoresSimulados = [
  ServidorSSH(id: '1', nombre: 'TICK-101: Caída de Conectividad VPN', ip: 'Carlos Gómez (Finanzas)', puerto: 2, ssl: true),
  ServidorSSH(id: '2', nombre: 'TICK-102: Error al Procesar Pago', ip: 'María López (Ventas)', puerto: 4, ssl: true),
  ServidorSSH(id: '3', nombre: 'TICK-103: Solicitud de Licencia CAD', ip: 'Juan Pérez (Diseño)', puerto: 24, ssl: false),
];