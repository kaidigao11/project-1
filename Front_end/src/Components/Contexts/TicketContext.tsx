import { createContext, ReactNode, useState } from "react";



export interface Ticket {
    ticketId: number;
    submittedBy: string;
    amount: number;
    ticketDescription: string;
    ticketStatus: string;
    ticketChangeable: boolean;
}

interface TicketContextType {
    ticket: Ticket | null;
    createTicket:  (ticketId: number, submittedBy: string,
        amount: number,
        ticketDescription: string,
        ticketStatus: string,
        ticketChangeable: boolean) => void;
    clearTicket: () => void;
}

export const TicketContext = createContext<TicketContextType | undefined>(undefined);

interface TicketProviderProps {
    children: ReactNode;
}

export const TicketProvider: React.FC<TicketProviderProps> = ({children}) => {
    const [ticket, setTicket] = useState<Ticket | null>(null);
    
    const login = ( ticketId: number,
        submittedBy: string,
        amount: number,
        ticketDescription: string,
        ticketStatus: string,
        ticketChangeable: boolean) => {
        setTicket({ticketId, submittedBy, amount, ticketDescription, ticketStatus, ticketChangeable});
    }
    const logout = () => {
        setTicket(null);
    }

    return (
        <TicketContext.Provider value={{ticket, createTicket(){}, clearTicket(){}}}>
            {children}
        </TicketContext.Provider>
    )
}
