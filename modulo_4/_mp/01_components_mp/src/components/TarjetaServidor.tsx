import { Text, View } from 'react-native';

export interface TarjetaTicketProps {
  codigo: string;
  asunto: string;
  solicitante: string;
  prioridad?: string;
  estado?: string;
}

export function TarjetaServidor({ codigo, asunto, solicitante, prioridad = 'Alta' }: TarjetaTicketProps) {
  return (
    <View style={{ padding: 12, backgroundColor: '#ffffff', borderRadius: 8, marginVertical: 4 }}>
      <Text style={{ fontWeight: '700', fontSize: 16, color: '#0f172a' }}>[{codigo}] {asunto}</Text>
      <Text style={{ color: '#475569', fontSize: 13 }}>Usuario: {solicitante} · Prioridad: {prioridad}</Text>
    </View>
  );
}
