fun main() {
    println(" Verificacion Logica de Soporte ")
    
    val esAdministrador = true
    val tienePermisoCierre = false
    val ticketEstaAbierto = true
    
    println("&& - AND Logico")
    println("¿Es administrador y tiene permiso?: $esAdministrador && $tienePermisoCierre = ${esAdministrador && tienePermisoCierre}")
    println("¿Es administrador y el ticket esta abierto?: $esAdministrador && $ticketEstaAbierto = ${esAdministrador && ticketEstaAbierto}")
    
    println("OR Logico")
    println("¿Es administrador o tiene permiso?: $esAdministrador || $tienePermisoCierre = ${esAdministrador || tienePermisoCierre}")
    println("¿El ticket esta abierto o es administrador?: $ticketEstaAbierto || $esAdministrador = ${ticketEstaAbierto || esAdministrador}")
    
    println("! NOT Logico")
    println("¿El ticket NO esta abierto?: ${!ticketEstaAbierto}")
    println("¿NO es administrador?: ${!esAdministrador}")
}