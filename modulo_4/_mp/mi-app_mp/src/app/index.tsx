import { ReactNode } from 'react';
import { StyleSheet, Text, View } from 'react-native';

// ┌──────────────────────────────────────────────────────────────────┐
// │  Sistema de Tickets de Soporte Técnico - mi-app_mp               │
// │  Cambia este número y guarda (Ctrl+S) para navegar entre pasos. │
// │  1  Paso 1  Props tipadas — TarjetaTicket                        │
// │  2  Paso 2  children y composición — Card reutilizable          │
// └──────────────────────────────────────────────────────────────────┘
const PASO = 1;

export default function Index() {
  switch (PASO) {
    case 1:
      return <Paso1 />;
    case 2:
      return <Paso2 />;
    default:
      return (
        <View style={styles.centrado}>
          <Text>Paso {PASO}: crea el componente primero</Text>
        </View>
      );
  }
}

// ─── Paso 1 — Props tipadas ──────────────────────────────────────────

interface TarjetaTicketProps {
  codigo: string;
  asunto: string;
  solicitante: string;
  prioridad: string;
}

function TarjetaTicket({ codigo, asunto, solicitante, prioridad }: TarjetaTicketProps) {
  return (
    <View style={styles.tarjeta}>
      <Text style={styles.nombreServidor}>[{codigo}] {asunto}</Text>
      <Text style={styles.datoDireccion}>Solicitante: {solicitante}</Text>
      <Text style={styles.datoSistema}>Prioridad: {prioridad}</Text>
    </View>
  );
}

function Paso1() {
  return (
    <View style={styles.fondo}>
      <Text style={styles.encabezado}>🎫 Bandeja de Tickets de Soporte Técnico</Text>
      <TarjetaTicket codigo="TICK-101" asunto="Falla de conectividad VPN corporativa" solicitante="Carlos Gómez" prioridad="Crítica" />
      <TarjetaTicket codigo="TICK-102" asunto="Error en pasarela de pagos al procesar" solicitante="María López" prioridad="Alta" />
      <TarjetaTicket codigo="TICK-103" asunto="Solicitud de licencia de software de diseño" solicitante="Juan Pérez" prioridad="Media" />
    </View>
  );
}

// ─── Paso 2 — Composition & Children ─────────────────────────────────

interface CardProps {
  titulo: string;
  subtitulo?: string;
  children: ReactNode;
}

function Card({ titulo, subtitulo, children }: CardProps) {
  return (
    <View style={estilos2.card}>
      <View style={estilos2.cardCabecera}>
        <Text style={estilos2.cardTitulo}>{titulo}</Text>
        {subtitulo && <Text style={estilos2.cardSubtitulo}>{subtitulo}</Text>}
      </View>
      <View style={estilos2.cardCuerpo}>{children}</View>
    </View>
  );
}

function FilaInfo({ etiqueta, valor }: { etiqueta: string; valor: string }) {
  return (
    <View style={estilos2.fila}>
      <Text style={estilos2.etiqueta}>{etiqueta}</Text>
      <Text style={estilos2.valor}>{valor}</Text>
    </View>
  );
}

function Paso2() {
  return (
    <View style={estilos2.fondo}>
      <Text style={estilos2.titulo}>Detalle de Incidencia de Soporte</Text>

      <Card titulo="TICK-101 — Falla VPN Corporativa" subtitulo="Incidencia Nivel 2 · Redes">
        <FilaInfo etiqueta="Solicitante" valor="Carlos Gómez (Finanzas)" />
        <FilaInfo etiqueta="Impacto" valor="Alto (15 usuarios afectados)" />
        <FilaInfo etiqueta="Técnico Asignado" valor="Ing. Ana Martínez" />
        <FilaInfo etiqueta="Tiempo Restante SLA" valor="1h 45m" />
        <FilaInfo etiqueta="Estado Actual" valor="En Proceso de Diagnóstico" />
      </Card>

      <Card titulo="Métricas de Atención SLA">
        <FilaInfo etiqueta="Primera Respuesta" valor="15 min (Cumplido)" />
        <FilaInfo etiqueta="Tiempo Máximo Solución" valor="2 horas" />
        <FilaInfo etiqueta="Canal de Entrada" valor="Portal Mesa de Ayuda" />
      </Card>
    </View>
  );
}

const styles = StyleSheet.create({
  fondo: { flex: 1, backgroundColor: '#f0f4f8', padding: 20, paddingTop: 60, gap: 12 },
  centrado: { flex: 1, justifyContent: 'center', alignItems: 'center' },
  encabezado: { fontSize: 18, fontWeight: '700', color: '#1a237e', marginBottom: 4 },
  tarjeta: { backgroundColor: '#ffffff', borderRadius: 10, padding: 16, gap: 4, elevation: 2 },
  nombreServidor: { fontSize: 16, fontWeight: '600', color: '#1a1a1a' },
  datoDireccion: { fontSize: 13, color: '#1565c0' },
  datoSistema: { fontSize: 13, color: '#c62828', fontWeight: '700' },
});

const estilos2 = StyleSheet.create({
  fondo: { flex: 1, backgroundColor: '#f0f4f8', padding: 20, paddingTop: 60, gap: 16 },
  titulo: { fontSize: 20, fontWeight: '700', color: '#1a237e' },
  card: { backgroundColor: '#ffffff', borderRadius: 12, overflow: 'hidden', elevation: 3 },
  cardCabecera: { backgroundColor: '#1565c0', paddingHorizontal: 16, paddingVertical: 12, gap: 2 },
  cardTitulo: { fontSize: 16, fontWeight: '700', color: '#ffffff' },
  cardSubtitulo: { fontSize: 12, color: '#bbdefb' },
  cardCuerpo: { padding: 12, gap: 8 },
  fila: { flexDirection: 'row', justifyContent: 'space-between', alignItems: 'center' },
  etiqueta: { fontSize: 13, color: '#546e7a', fontWeight: '500' },
  valor: { fontSize: 13, color: '#1a1a1a', fontWeight: '600' },
});
