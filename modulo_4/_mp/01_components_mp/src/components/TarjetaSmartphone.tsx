import { Text, View } from 'react-native';

export interface TarjetaTicketProps {
  codigo: string;
  asunto: string;
  solicitante: string;
  prioridad: 'Baja' | 'Media' | 'Alta' | 'Crítica';
  estado?: string;
}

export function TarjetaTicket({ codigo, asunto, solicitante, prioridad }: TarjetaTicketProps) {
  return (
    <View style={{ padding: 12, backgroundColor: '#ffffff', borderRadius: 8, marginVertical: 4 }}>
      <Text style={{ fontWeight: '700', fontSize: 16, color: '#1e293b' }}>[{codigo}] {asunto}</Text>
      <Text style={{ color: '#64748b', fontSize: 13 }}>Solicitante: {solicitante} · Prioridad: {prioridad}</Text>
    </View>
  );
}

// Alias para mantener compatibilidad
export const TarjetaSmartphone = TarjetaTicket;
