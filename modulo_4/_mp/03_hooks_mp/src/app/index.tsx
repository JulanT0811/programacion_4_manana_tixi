import { Pressable, SafeAreaView, ScrollView, StyleSheet, Text, View } from 'react-native';
import { useTickets } from '../hooks/useTickets';

export default function Index() {
  const { tickets, resolverTicket, asignarTecnico } = useTickets();

  return (
    <SafeAreaView style={styles.safeArea}>
      <View style={styles.header}>
        <Text style={styles.titulo}>🎫 Módulo 03: Hooks en Tickets de Soporte</Text>
        <Text style={styles.subtitulo}>Gestión de estado reactivo con useTickets()</Text>
      </View>

      <ScrollView contentContainerStyle={styles.contenido}>
        {tickets.map((ticket) => (
          <View key={ticket.id} style={styles.card}>
            <View style={styles.cardHeader}>
              <Text style={styles.codigo}>[{ticket.codigo}]</Text>
              <View style={[styles.badge, ticket.estado === 'resuelto' ? styles.badgeResuelto : styles.badgeProceso]}>
                <Text style={styles.badgeText}>{ticket.estado.toUpperCase()}</Text>
              </View>
            </View>

            <Text style={styles.asunto}>{ticket.asunto}</Text>
            <Text style={styles.info}>Solicitante: {ticket.solicitante} ({ticket.departamento})</Text>
            <Text style={styles.info}>Técnico: {ticket.tecnico} · Prioridad: {ticket.prioridad}</Text>

            {ticket.estado !== 'resuelto' && (
              <View style={styles.acciones}>
                <Pressable style={[styles.btn, styles.btnAsignar]} onPress={() => asignarTecnico(ticket.id, 'Ing. Carlos Ruiz')}>
                  <Text style={styles.btnText}>Asignar C. Ruiz</Text>
                </Pressable>
                <Pressable style={[styles.btn, styles.btnResolver]} onPress={() => resolverTicket(ticket.id)}>
                  <Text style={styles.btnText}>Resolver</Text>
                </Pressable>
              </View>
            )}
          </View>
        ))}
      </ScrollView>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  safeArea: { flex: 1, backgroundColor: '#f0f4f8' },
  header: { padding: 20, paddingTop: 40, backgroundColor: '#1a237e' },
  titulo: { fontSize: 18, fontWeight: '700', color: '#ffffff' },
  subtitulo: { fontSize: 13, color: '#bbdefb', marginTop: 4 },
  contenido: { padding: 16, gap: 14 },
  card: { backgroundColor: '#ffffff', borderRadius: 12, padding: 16, gap: 8, elevation: 2 },
  cardHeader: { flexDirection: 'row', justifyContent: 'space-between', alignItems: 'center' },
  codigo: { fontSize: 15, fontWeight: '700', color: '#1a237e' },
  asunto: { fontSize: 15, fontWeight: '600', color: '#0f172a' },
  info: { fontSize: 13, color: '#64748b' },
  badge: { borderRadius: 4, paddingHorizontal: 8, paddingVertical: 3 },
  badgeResuelto: { backgroundColor: '#e8f5e9' },
  badgeProceso: { backgroundColor: '#fff8e1' },
  badgeText: { fontSize: 11, fontWeight: '700', color: '#1e293b' },
  acciones: { flexDirection: 'row', gap: 10, marginTop: 8 },
  btn: { flex: 1, paddingVertical: 8, borderRadius: 6, alignItems: 'center' },
  btnAsignar: { backgroundColor: '#1565c0' },
  btnResolver: { backgroundColor: '#2e7d32' },
  btnText: { color: '#ffffff', fontWeight: '600', fontSize: 13 },
});
