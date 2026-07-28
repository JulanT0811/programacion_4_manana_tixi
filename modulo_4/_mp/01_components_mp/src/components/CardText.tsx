import { ReactNode } from 'react';
import { Text, View } from 'react-native';

interface CardProps {
  children: ReactNode;
  titulo: string;
}

export function Card({ titulo, children }: CardProps) {
  return (
    <View style={{ backgroundColor: '#ffffff', borderRadius: 10, padding: 14, marginVertical: 6 }}>
      <Text style={{ fontSize: 16, fontWeight: '700', color: '#1e293b', marginBottom: 8 }}>{titulo}</Text>
      {children}
    </View>
  );
}

// Ejemplo de uso en Sistema de Tickets de Soporte Técnico:
// <Card titulo="TICK-101: Falla de Red VPN">
//   <Text>Solicitante: Juan Pérez · Departamento: Finanzas</Text>
//   <Text>Estado: En Proceso · Técnico: Ing. Ana Martínez</Text>
// </Card>
