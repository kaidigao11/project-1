import { createContext, ReactNode, useState } from "react";



export interface Employee {
    employeeId: number;
    username: string;
    password: String;
    isAdmin: boolean;
}

interface EmployeeContextType {
    employee: Employee | null;
    login:  (employeeId: number, username:string, password:string,isAdmin:boolean) => void;
    logout: () => void;
}

export const EmployeeContext = createContext<EmployeeContextType | undefined>(undefined);

interface EmployeeProviderProps {
    children: ReactNode;
}

export const EmployeeProvider: React.FC<EmployeeProviderProps> = ({children}) => {
    const [employee, setEmployee] = useState<Employee | null>(null);
    
    const login = (employeeId:number, username:string, password:string, isAdmin:boolean) => {
        setEmployee({employeeId, username, password, isAdmin});
    }
    const logout = () => {
        setEmployee(null);
    }

    return (
        <EmployeeContext.Provider value={{employee, login, logout}}>
            {children}
        </EmployeeContext.Provider>
    )
}
