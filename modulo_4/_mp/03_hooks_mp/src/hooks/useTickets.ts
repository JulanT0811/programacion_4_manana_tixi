import { useState } from 'react';

export interface TicketSoporte {
  id: string;
  codigo: string;
  asunto: string;
  solicitante: string;
  departamento: string;
  prioridad: 'Baja' | 'Media' | 'Alta' | 'Crítica';
  estado: 'abierto' | 'en_proceso' | 'resuelto' | 'cerrado';
  tecnico: string;
  slaMinutos: number;
}

const TICKETS_INICIALES: TicketSoporte[] = [
  {
    id: '1',
    codigo: 'TICK-101',
    asunto: 'Falla de conectividad VPN corporativa',
    solicitante: 'Carlos Gómez',
    departamento: 'Finanzas',
    prioridad: 'Crítica',
    estado: 'en_proceso',
    tecnico: 'Ing. Ana Martínez',
    slaMinutos: 120,
  },
  {
    id: '2',
    codigo: 'TICK-102',
    asunto: 'Error al procesar tarjeta de crédito',
    solicitante: 'María López',
    departamento: 'Ventas',
    prioridad: 'Alta',
    estado: 'abierto',
    tecnico: 'Sin Asignar',
    slaMinutos: 240,
  },
  {
    id: '3',
    codigo: 'TICK-103',
    asunto: 'Instalación de software de diseño gráfico',
    solicitante: 'Juan Pérez',
    departamento: 'Marketing',
    prioridad: 'Baja',
    estado: 'resuelto',
    tecnico: 'Pedro Rodríguez',
    slaMinutos: 1440,
  },
];

export function useTickets() {
  const [tickets, setTickets] = useState<TicketSoporte[]>(TICKETS_INICIALES);

  const resolverTicket = (id: string) => {
    setTickets((prev) =>
      prev.map((t) => (t.id === id ? { ...t, estado: 'resuelto' } : t))
    );
  };

  const asignarTecnico = (id: string, nuevoTecnico: string) => {
    setTickets((prev) =>
      prev.map((t) =>
        t.id === id ? { ...t, tecnico: nuevoTecnico, estado: 'en_proceso' } : t
      )
    );
  };

  const agregarTicket = (nuevo: Omit<TicketSoporte, 'id'>) => {
    const id = (tickets.length + 1).toString();
    setTickets((prev) => [...prev, { ...nuevo, id }]);
  };

  return {
    tickets,
    resolverTicket,
    asignarTecnico,
    agregarTicket,
  };
}
