import { useState, type ReactNode } from 'react';
import {
  Modal,
  Pressable,
  SafeAreaView,
  ScrollView,
  StyleSheet,
  Text,
  View,
} from 'react-native';

// ┌──────────────────────────────────────────────────────────────────┐
// │  Sistema de Tickets de Soporte Técnico - Componentes React Native│
// │  Cambia este número y guarda (Ctrl+S) para navegar entre pasos. │
// │  1  Paso 1  Props tipadas — TarjetaTicket                        │
// │  2  Paso 2  children y composición — Card reutilizable          │
// │  3  Paso 3  Props opcionales y BadgeEstado                      │
// │  4  Paso 4  ScrollView y SafeAreaView — Catálogo de Tickets      │
// │  5  Paso 5  Modal de confirmación de resolución de ticket       │
// │  6  Paso 6  Pantalla completa — Detalle e Historial de Ticket    │
// └──────────────────────────────────────────────────────────────────┘
const PASO = 1;

export default function Index() {
  switch (PASO) {
    case 1:
      return <Paso1 />;
    case 2:
      return <Paso2 />;
    case 3:
      return <Paso3 />;
    case 4:
      return <Paso4 />;
    case 5:
      return <Paso5 />;
    case 6:
      return <Paso6 />;
    default:
      return (
        <View style={estilosBase.centrado}>
          <Text>Paso {PASO}: crea el componente primero</Text>
        </View>
      );
  }
}

// ═══════════════════════════════════════════════════════════════════
// COMPONENTES COMPARTIDOS (Tickets de Soporte Técnico)
// ═══════════════════════════════════════════════════════════════════

interface CardProps {
  titulo: string;
  subtitulo?: string;
  children: ReactNode;
}

function Card({ titulo, subtitulo, children }: CardProps) {
  return (
    <View style={estilosCard.card}>
      <View style={estilosCard.cardCabecera}>
        <Text style={estilosCard.cardTitulo}>{titulo}</Text>
        {subtitulo && <Text style={estilosCard.cardSubtitulo}>{subtitulo}</Text>}
      </View>
      <View style={estilosCard.cardCuerpo}>{children}</View>
    </View>
  );
}

function FilaInfo({ etiqueta, valor }: { etiqueta: string; valor: string }) {
  return (
    <View style={estilosCard.fila}>
      <Text style={estilosCard.etiqueta}>{etiqueta}</Text>
      <Text style={estilosCard.valor}>{valor}</Text>
    </View>
  );
}

export type EstadoTicket = 'abierto' | 'en_proceso' | 'pendiente' | 'resuelto' | 'cerrado';

const COLOR_ESTADO: Record<EstadoTicket, { fondo: string; texto: string }> = {
  abierto: { fondo: '#e3f2fd', texto: '#1565c0' },
  en_proceso: { fondo: '#fff8e1', texto: '#f57f17' },
  pendiente: { fondo: '#f3e5f5', texto: '#7b1fa2' },
  resuelto: { fondo: '#e8f5e9', texto: '#2e7d32' },
  cerrado: { fondo: '#eceff1', texto: '#455a64' },
};

const ICONO_ESTADO: Record<EstadoTicket, string> = {
  abierto: '●',
  en_proceso: '◐',
  pendiente: '⏳',
  resuelto: '✓',
  cerrado: '✕',
};

function BadgeEstado({
  estado,
  tamaño = 12,
  mostrarIcono = false,
}: {
  estado: EstadoTicket;
  tamaño?: number;
  mostrarIcono?: boolean;
}) {
  const colores = COLOR_ESTADO[estado];

  return (
    <View style={[estilosBase.badge, { backgroundColor: colores.fondo }]}>
      {mostrarIcono && (
        <Text style={{ color: colores.texto, fontSize: tamaño, fontWeight: '700' }}>
          {ICONO_ESTADO[estado]}{' '}
        </Text>
      )}
      <Text style={{ color: colores.texto, fontSize: tamaño, fontWeight: '600' }}>
        {estado.replace('_', ' ').toUpperCase()}
      </Text>
    </View>
  );
}

function ModalConfirm({
  visible,
  titulo,
  mensaje,
  etiquetaConfirmar = 'Confirmar',
  etiquetaCancelar = 'Cancelar',
  onConfirmar,
  onCancelar,
}: {
  visible: boolean;
  titulo: string;
  mensaje: string;
  etiquetaConfirmar?: string;
  etiquetaCancelar?: string;
  onConfirmar: () => void;
  onCancelar: () => void;
}) {
  return (
    <Modal visible={visible} transparent animationType="fade" onRequestClose={onCancelar}>
      <Pressable style={estilosModal.fondo} onPress={onCancelar}>
        <Pressable style={estilosModal.dialogo} onPress={() => {}}>
          <Text style={estilosModal.titulo}>{titulo}</Text>
          <Text style={estilosModal.mensaje}>{mensaje}</Text>
          <View style={estilosModal.botones}>
            <Pressable style={[estilosModal.btn, estilosModal.btnCancelar]} onPress={onCancelar}>
              <Text style={estilosModal.txtCancelar}>{etiquetaCancelar}</Text>
            </Pressable>
            <Pressable style={[estilosModal.btn, estilosModal.btnConfirmar]} onPress={onConfirmar}>
              <Text style={estilosModal.txtConfirmar}>{etiquetaConfirmar}</Text>
            </Pressable>
          </View>
        </Pressable>
      </Pressable>
    </Modal>
  );
}

// ═══════════════════════════════════════════════════════════════════
// PASO 1 — Props tipadas (TarjetaTicket)
// ═══════════════════════════════════════════════════════════════════

interface TarjetaTicketProps {
  codigo: string;
  asunto: string;
  solicitante: string;
  prioridad: string;
  slaHoras: number;
}

function TarjetaTicket({ codigo, asunto, solicitante, prioridad, slaHoras }: TarjetaTicketProps) {
  return (
    <View style={estilos1.tarjeta}>
      <Text style={estilos1.nombreEquipo}>[{codigo}] {asunto}</Text>
      <Text style={estilos1.datoPantalla}>Solicitante: {solicitante} · Prioridad: {prioridad}</Text>
      <Text style={estilos1.datoPrecio}>SLA Tiempo Límite: {slaHoras}h</Text>
    </View>
  );
}

function Paso1() {
  return (
    <View style={estilos1.fondo}>
      <Text style={estilos1.encabezado}>🎫 Mesa de Ayuda - Tickets de Soporte Técnico</Text>
      <TarjetaTicket codigo="TICK-101" asunto="Falla de conectividad VPN en servidor principal" solicitante="Carlos Gómez" prioridad="Crítica" slaHoras={2} />
      <TarjetaTicket codigo="TICK-102" asunto="Error al procesar pago con tarjeta en pasarela" solicitante="María López" prioridad="Alta" slaHoras={4} />
      <TarjetaTicket codigo="TICK-103" asunto="Solicitud de nueva licencia de software CAD" solicitante="Juan Pérez" prioridad="Media" slaHoras={24} />
    </View>
  );
}

// ═══════════════════════════════════════════════════════════════════
// PASO 2 — children y composición
// ═══════════════════════════════════════════════════════════════════

function Paso2() {
  return (
    <View style={estilos2.fondo}>
      <Text style={estilos2.titulo}>Detalle de Ticket de Soporte</Text>
      <Card titulo="TICK-101 — Conectividad VPN" subtitulo="Incidencia Nivel 2 · Infraestructura & Redes">
        <FilaInfo etiqueta="Solicitante" valor="Carlos Gómez (Finanzas)" />
        <FilaInfo etiqueta="Categoría" valor="Redes & VPN" />
        <FilaInfo etiqueta="Prioridad" valor="Crítica" />
        <FilaInfo etiqueta="Técnico Asignado" valor="Ing. Ana Martínez" />
        <FilaInfo etiqueta="SLA Restante" valor="1h 45m" />
        <FilaInfo etiqueta="Estado" valor="En Proceso" />
      </Card>
      <Card titulo="Métricas de Atención SLA">
        <FilaInfo etiqueta="Primera Respuesta" valor="15 min (Cumplido)" />
        <FilaInfo etiqueta="Tiempo Estimado Solución" valor="2 horas" />
        <FilaInfo etiqueta="Canal de Origen" valor="Portal Web / Chat" />
      </Card>
    </View>
  );
}

// ═══════════════════════════════════════════════════════════════════
// PASO 3 — Props opcionales y BadgeEstado
// ═══════════════════════════════════════════════════════════════════

interface FilaTicketProps {
  codigo: string;
  asunto: string;
  solicitante: string;
  estado: EstadoTicket;
  prioridad: string;
  slaHoras?: number;
}

function FilaTicket({ codigo, asunto, solicitante, estado, prioridad, slaHoras }: FilaTicketProps) {
  return (
    <View style={estilos3.fila}>
      <View style={{ gap: 2, flex: 1, paddingRight: 8 }}>
        <Text style={estilos3.nombreEquipo}>[{codigo}] {asunto}</Text>
        <Text style={estilos3.precioTexto}>
          {solicitante} · Prioridad {prioridad} {slaHoras ? `(SLA ${slaHoras}h)` : ''}
        </Text>
      </View>
      <View style={{ alignItems: 'flex-end', gap: 4 }}>
        <BadgeEstado estado={estado} mostrarIcono tamaño={11} />
      </View>
    </View>
  );
}

function Paso3() {
  return (
    <View style={estilos3.fondo}>
      <Text style={estilos3.titulo}>Bandeja de Tickets de Soporte</Text>
      <FilaTicket codigo="TICK-101" asunto="Falla en VPN Corporativa" solicitante="Carlos G." estado="en_proceso" prioridad="Alta" slaHoras={2} />
      <FilaTicket codigo="TICK-102" asunto="Impresora Contabilidad offline" solicitante="María L." estado="abierto" prioridad="Media" slaHoras={8} />
      <FilaTicket codigo="TICK-103" asunto="Creación de correo nuevo usuario" solicitante="Juan P." estado="resuelto" prioridad="Baja" />
      <FilaTicket codigo="TICK-104" asunto="Falla de disco en servidor BD" solicitante="Admin" estado="pendiente" prioridad="Crítica" slaHoras={1} />
      <FilaTicket codigo="TICK-105" asunto="Actualización de Antivirus ERP" solicitante="Soporte" estado="cerrado" prioridad="Baja" />
    </View>
  );
}

// ═══════════════════════════════════════════════════════════════════
// PASO 4 — ScrollView y SafeAreaView (Catálogo de Tickets)
// ═══════════════════════════════════════════════════════════════════

const TICKETS_DEMO = [
  { id: '1', codigo: 'TICK-101', departamento: 'Finanzas', asunto: 'Caída de acceso VPN', prioridad: 'Crítica', slaPct: 85, tecnico: 'Ana M.' },
  { id: '2', codigo: 'TICK-102', departamento: 'Ventas', asunto: 'Falla en lector de código de barras', prioridad: 'Alta', slaPct: 60, tecnico: 'Pedro R.' },
  { id: '3', codigo: 'TICK-103', departamento: 'Recursos Humanos', asunto: 'Solicitud de laptop para nuevo ingreso', prioridad: 'Media', slaPct: 95, tecnico: 'Sofía T.' },
  { id: '4', codigo: 'TICK-104', departamento: 'Sistemas', asunto: 'Reemplazo de disco SAS en servidor NAS', prioridad: 'Crítica', slaPct: 40, tecnico: 'Carlos L.' },
  { id: '5', codigo: 'TICK-105', departamento: 'Contabilidad', asunto: 'Error al exportar reporte Excel ERP', prioridad: 'Media', slaPct: 75, tecnico: 'Ana M.' },
  { id: '6', codigo: 'TICK-106', departamento: 'Logística', asunto: 'Configuración de Wi-Fi en bodega 3', prioridad: 'Alta', slaPct: 90, tecnico: 'Luis K.' },
  { id: '7', codigo: 'TICK-107', departamento: 'Dirección', asunto: 'Restablecimiento de contraseña correo', prioridad: 'Alta', slaPct: 100, tecnico: 'Pedro R.' },
  { id: '8', codigo: 'TICK-108', departamento: 'Marketing', asunto: 'Instalación de paquete Adobe CC', prioridad: 'Baja', slaPct: 50, tecnico: 'Sofía T.' },
];

function BarraSLA({ pct, etiqueta }: { pct: number; etiqueta: string }) {
  const color = pct < 50 ? '#c62828' : pct < 80 ? '#f57f17' : '#2e7d32';

  return (
    <View style={estilos4.barraFila}>
      <Text style={estilos4.barraEtiqueta}>{etiqueta}</Text>
      <View style={estilos4.barraFondo}>
        <View style={[estilos4.barraRelleno, { width: `${pct}%` as any, backgroundColor: color }]} />
      </View>
      <Text style={[estilos4.barraPct, { color }]}>{pct}% SLA</Text>
    </View>
  );
}

function TarjetaTicketNodo({ codigo, departamento, asunto, prioridad, slaPct, tecnico }: (typeof TICKETS_DEMO)[0]) {
  return (
    <View style={estilos4.nodo}>
      <View style={{ flexDirection: 'row', justifyContent: 'space-between', alignItems: 'baseline' }}>
        <Text style={estilos4.nodoNombre}>[{codigo}] {asunto}</Text>
        <Text style={estilos4.nodoSpec}>{departamento} · {prioridad}</Text>
      </View>
      <Text style={{ fontSize: 11, color: '#90a4ae' }}>Técnico: {tecnico}</Text>
      <BarraSLA pct={slaPct} etiqueta="SLA" />
    </View>
  );
}

function Paso4() {
  return (
    <SafeAreaView style={estilos4.safeArea}>
      <View style={estilos4.header}>
        <Text style={estilos4.headerTitulo}>🎫 Dashboard General de Tickets</Text>
        <Text style={estilos4.headerSub}>{TICKETS_DEMO.length} tickets activos en cola de soporte</Text>
      </View>
      <ScrollView
        style={estilos4.scroll}
        contentContainerStyle={estilos4.scrollContenido}
        showsVerticalScrollIndicator={false}
      >
        {TICKETS_DEMO.map((t) => (
          <TarjetaTicketNodo key={t.id} {...t} />
        ))}
      </ScrollView>
    </SafeAreaView>
  );
}

// ═══════════════════════════════════════════════════════════════════
// PASO 5 — Modal de confirmación de resolución de ticket
// ═══════════════════════════════════════════════════════════════════

function Paso5() {
  const [modalVisible, setModalVisible] = useState(false);
  const [resolucionConfirmada, setResolucionConfirmada] = useState<string | null>(null);

  return (
    <SafeAreaView style={estilos5.safeArea}>
      <Text style={estilos5.titulo}>Gestión de Ticket #TICK-101</Text>
      <Text style={estilos5.subtitulo}>Falla en VPN Corporativa · Solicitante: Carlos Gómez</Text>
      <View>
        <Pressable
          style={estilos5.botonAccion}
          onPress={() => {
            setResolucionConfirmada(null);
            setModalVisible(true);
          }}
        >
          <Text style={estilos5.textoAccion}>Marcar Ticket como Resuelto</Text>
        </Pressable>
      </View>
      {resolucionConfirmada && (
        <View style={estilos5.resultado}>
          <Text style={estilos5.textoResultado}>{resolucionConfirmada}</Text>
        </View>
      )}
      <ModalConfirm
        visible={modalVisible}
        titulo="Confirmar Resolución de Ticket"
        mensaje={`¿Deseas marcar como RESUELTO el Ticket TICK-101?
Se notificará al usuario Carlos Gómez y se registrará el cumplimiento de SLA.`}
        etiquetaConfirmar="Resolver Ticket"
        onConfirmar={() => {
          setModalVisible(false);
          setResolucionConfirmada(
            '✅ Ticket TICK-101 resuelto con éxito a las ' + new Date().toLocaleTimeString(),
          );
        }}
        onCancelar={() => setModalVisible(false)}
      />
    </SafeAreaView>
  );
}

// ═══════════════════════════════════════════════════════════════════
// PASO 6 — Pantalla completa de detalle e historial de ticket
// ═══════════════════════════════════════════════════════════════════

function BotonAccion({ etiqueta, color, onPress }: { etiqueta: string; color: string; onPress: () => void }) {
  return (
    <Pressable
      style={({ pressed }) => [
        estilos6.botonAccion,
        { backgroundColor: color },
        pressed && { opacity: 0.75 },
      ]}
      onPress={onPress}
    >
      <Text style={estilos6.textoBotonAccion}>{etiqueta}</Text>
    </Pressable>
  );
}

function Paso6() {
  const [modalVisible, setModalVisible] = useState(false);
  const [accionPendiente, setAccionPendiente] = useState<string>('');
  const [log, setLog] = useState<string[]>([]);

  function pedirConfirmacion(accion: string) {
    setAccionPendiente(accion);
    setModalVisible(true);
  }

  function ejecutarAccion() {
    const entrada = `[${new Date().toLocaleTimeString()}] Accion "${accionPendiente}" registrada para Ticket TICK-101`;
    setLog((prev) => [entrada, ...prev]);
    setModalVisible(false);
  }

  return (
    <SafeAreaView style={estilos6.safeArea}>
      <View style={estilos6.cabecera}>
        <View>
          <Text style={estilos6.cabNombre}>Ticket #TICK-101: Conectividad VPN</Text>
          <Text style={estilos6.cabIp}>Finanzas · Prioridad Crítica · Ing. Ana Martínez</Text>
        </View>
        <BadgeEstado estado="en_proceso" mostrarIcono tamaño={12} />
      </View>

      <ScrollView contentContainerStyle={estilos6.scrollContenido} showsVerticalScrollIndicator={false}>
        <Card titulo="Ficha Técnica del Incidente" subtitulo="Última actualización: Hace 5 minutos">
          <FilaInfo etiqueta="Solicitante" valor="Carlos Gómez (Finanzas)" />
          <FilaInfo etiqueta="Categoría" valor="Infraestructura & Redes" />
          <FilaInfo etiqueta="Servicio Afectado" valor="Gateway OpenVPN Principal" />
          <FilaInfo etiqueta="Tiempo Restante SLA" valor="1 hora 20 minutos" />
          <FilaInfo etiqueta="Impacto Operativo" valor="Alto (15 usuarios sin acceso)" />
        </Card>
        <Card titulo="Políticas de Soporte & Escalamiento">
          <FilaInfo etiqueta="Nivel de Atención" valor="Soporte Técnico Nivel 2" />
          <FilaInfo etiqueta="Horario SLA" valor="24/7 Cobertura Crítica" />
          <FilaInfo etiqueta="Reapertura" valor="Permitida dentro de 72 horas" />
        </Card>
        <Card titulo="Acciones Técnicas Disponibles">
          <View style={estilos6.gridAcciones}>
            <BotonAccion etiqueta="Asignar Técnico" color="#1565c0" onPress={() => pedirConfirmacion('Reasignación de Técnico')} />
            <BotonAccion etiqueta="Resolver Ticket" color="#2e7d32" onPress={() => pedirConfirmacion('Cierre por Solución')} />
            <BotonAccion etiqueta="Escalar Incidencia" color="#6a1b9a" onPress={() => pedirConfirmacion('Escalamiento a Nivel 3')} />
            <BotonAccion
              etiqueta="Reporte PDF"
              color="#d81b60"
              onPress={() => pedirConfirmacion('Generar Informe de Incidencia')}
            />
          </View>
        </Card>
        {log.length > 0 && (
          <Card titulo="Historial de Auditoría & Cambios">
            {log.map((e, i) => (
              <Text key={i} style={estilos6.entradaLog}>
                {e}
              </Text>
            ))}
          </Card>
        )}
      </ScrollView>

      <ModalConfirm
        visible={modalVisible}
        titulo={`Confirmar: ${accionPendiente}`}
        mensaje={`¿Deseas ejecutar "${accionPendiente}" en el Ticket TICK-101?
Esta acción quedará registrada en la bitácora de soporte.`}
        etiquetaConfirmar="Confirmar"
        onConfirmar={ejecutarAccion}
        onCancelar={() => setModalVisible(false)}
      />
    </SafeAreaView>
  );
}

// ═══════════════════════════════════════════════════════════════════
// ESTILOS DE TICKETS DE SOPORTE TÉCNICO
// ═══════════════════════════════════════════════════════════════════

const estilosBase = StyleSheet.create({
  centrado: { flex: 1, justifyContent: 'center', alignItems: 'center' },
  badge: {
    flexDirection: 'row',
    alignItems: 'center',
    borderRadius: 4,
    paddingHorizontal: 6,
    paddingVertical: 2,
  },
});

const estilosCard = StyleSheet.create({
  card: {
    backgroundColor: '#ffffff',
    borderRadius: 12,
    overflow: 'hidden',
    shadowColor: '#000',
    shadowOpacity: 0.07,
    shadowRadius: 6,
    shadowOffset: { width: 0, height: 2 },
    elevation: 3,
  },
  cardCabecera: { backgroundColor: '#1565c0', paddingHorizontal: 16, paddingVertical: 12, gap: 2 },
  cardTitulo: { fontSize: 16, fontWeight: '700', color: '#ffffff' },
  cardSubtitulo: { fontSize: 12, color: '#bbdefb' },
  cardCuerpo: { padding: 12, gap: 8 },
  fila: { flexDirection: 'row', justifyContent: 'space-between', alignItems: 'center' },
  etiqueta: { fontSize: 13, color: '#546e7a', fontWeight: '500' },
  valor: { fontSize: 13, color: '#1a1a1a', fontWeight: '600' },
});

const estilosModal = StyleSheet.create({
  fondo: {
    flex: 1,
    backgroundColor: 'rgba(0,0,0,0.55)',
    justifyContent: 'center',
    alignItems: 'center',
  },
  dialogo: {
    backgroundColor: '#ffffff',
    borderRadius: 16,
    padding: 24,
    width: '85%',
    gap: 12,
    shadowColor: '#000',
    shadowOpacity: 0.2,
    shadowRadius: 12,
    shadowOffset: { width: 0, height: 6 },
    elevation: 10,
  },
  titulo: { fontSize: 17, fontWeight: '700', color: '#1a1a1a' },
  mensaje: { fontSize: 14, color: '#546e7a', lineHeight: 20 },
  botones: { flexDirection: 'row', gap: 10, marginTop: 4 },
  btn: { flex: 1, borderRadius: 8, paddingVertical: 12, alignItems: 'center' },
  btnCancelar: { backgroundColor: '#f5f5f5' },
  btnConfirmar: { backgroundColor: '#2e7d32' },
  txtCancelar: { color: '#424242', fontWeight: '600', fontSize: 14 },
  txtConfirmar: { color: '#ffffff', fontWeight: '700', fontSize: 14 },
});

const estilos1 = StyleSheet.create({
  fondo: { flex: 1, backgroundColor: '#f0f4f8', padding: 20, paddingTop: 60, gap: 12 },
  encabezado: { fontSize: 18, fontWeight: '700', color: '#1a237e', marginBottom: 4 },
  tarjeta: {
    backgroundColor: '#ffffff',
    borderRadius: 10,
    padding: 16,
    gap: 4,
    shadowColor: '#000',
    shadowOpacity: 0.06,
    shadowRadius: 4,
    shadowOffset: { width: 0, height: 2 },
    elevation: 2,
  },
  nombreEquipo: { fontSize: 16, fontWeight: '600', color: '#1a1a1a' },
  datoPantalla: { fontSize: 13, color: '#1565c0' },
  datoPrecio: { fontSize: 13, color: '#2e7d32', fontWeight: '700' },
});

const estilos2 = StyleSheet.create({
  fondo: { flex: 1, backgroundColor: '#f0f4f8', padding: 20, paddingTop: 60, gap: 16 },
  titulo: { fontSize: 20, fontWeight: '700', color: '#1a237e' },
});

const estilos3 = StyleSheet.create({
  fondo: { flex: 1, backgroundColor: '#f0f4f8', padding: 20, paddingTop: 60, gap: 8 },
  titulo: { fontSize: 20, fontWeight: '700', color: '#1a237e', marginBottom: 8 },
  fila: {
    backgroundColor: '#ffffff',
    borderRadius: 10,
    paddingHorizontal: 16,
    paddingVertical: 14,
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
    shadowColor: '#000',
    shadowOpacity: 0.05,
    shadowRadius: 3,
    shadowOffset: { width: 0, height: 1 },
    elevation: 1,
  },
  nombreEquipo: { fontSize: 14, fontWeight: '600', color: '#1a1a1a' },
  precioTexto: { fontSize: 12, color: '#1565c0', fontWeight: '500' },
});

const estilos4 = StyleSheet.create({
  safeArea: { flex: 1, backgroundColor: '#0d1b2a' },
  header: {
    paddingHorizontal: 20,
    paddingTop: 16,
    paddingBottom: 12,
    borderBottomWidth: 1,
    borderBottomColor: '#1c2e40',
  },
  headerTitulo: { fontSize: 20, fontWeight: '700', color: '#e3f2fd' },
  headerSub: { fontSize: 12, color: '#78909c', marginTop: 2 },
  scroll: { flex: 1 },
  scrollContenido: { padding: 16, gap: 10, paddingBottom: 40 },
  nodo: { backgroundColor: '#132232', borderRadius: 10, padding: 14, gap: 8, borderWidth: 1, borderColor: '#1c3548' },
  nodoNombre: { fontSize: 14, fontWeight: '700', color: '#e3f2fd' },
  nodoSpec: { fontSize: 12, color: '#4fc3f7' },
  barraFila: { flexDirection: 'row', alignItems: 'center', gap: 8 },
  barraEtiqueta: { fontSize: 11, color: '#78909c', width: 36 },
  barraFondo: { flex: 1, height: 6, backgroundColor: '#1c3548', borderRadius: 3, overflow: 'hidden' },
  barraRelleno: { height: '100%', borderRadius: 3 },
  barraPct: { fontSize: 11, fontWeight: '600', width: 55, textAlign: 'right' },
});

const estilos5 = StyleSheet.create({
  safeArea: { flex: 1, backgroundColor: '#f0f4f8', padding: 24, paddingTop: 60 },
  titulo: { fontSize: 22, fontWeight: '700', color: '#1a237e' },
  subtitulo: { fontSize: 14, color: '#546e7a', marginTop: 4, marginBottom: 32 },
  botonAccion: { backgroundColor: '#2e7d32', borderRadius: 10, paddingVertical: 14, alignItems: 'center' },
  textoAccion: { color: '#fff', fontWeight: '700', fontSize: 15 },
  resultado: { marginTop: 24, backgroundColor: '#e8f5e9', borderRadius: 8, padding: 14 },
  textoResultado: { color: '#2e7d32', fontSize: 13, fontWeight: '600' },
});

const estilos6 = StyleSheet.create({
  safeArea: { flex: 1, backgroundColor: '#f0f4f8' },
  cabecera: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
    paddingHorizontal: 20,
    paddingVertical: 14,
    backgroundColor: '#ffffff',
    borderBottomWidth: 1,
    borderBottomColor: '#e0e7ef',
  },
  cabNombre: { fontSize: 16, fontWeight: '700', color: '#1a237e' },
  cabIp: { fontSize: 12, color: '#78909c', marginTop: 2 },
  scrollContenido: { padding: 16, gap: 14, paddingBottom: 40 },
  gridAcciones: { flexDirection: 'row', flexWrap: 'wrap', gap: 10 },
  botonAccion: { borderRadius: 8, paddingVertical: 10, paddingHorizontal: 16, minWidth: '45%', alignItems: 'center' },
  textoBotonAccion: { color: '#ffffff', fontWeight: '600', fontSize: 14 },
  entradaLog: { fontSize: 11, color: '#2e7d32', lineHeight: 18 },
});
