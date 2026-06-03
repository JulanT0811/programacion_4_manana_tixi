interface Resoluble {
    fun atender(ticketId: Int): Boolean
    val tipo: String
}

class SoporteTecnico(val departamento: String) : Resoluble {
    override val tipo = "Soporte Técnico"
    override fun atender(ticketId: Int): Boolean {
        println("🛠️ Resolviendo ticket #$ticketId en $departamento")
        return true
    }
}

class SoporteFacturacion(val email: String) : Resoluble {
    override val tipo = "Facturación"
    override fun atender(ticketId: Int): Boolean {
        println("🧾 Gestionando cobros para ticket #$ticketId enviado a $email")
        return true
    }
}

class SoporteGeneral : Resoluble {
    override val tipo = "Soporte General"
    override fun atender(ticketId: Int): Boolean {
        println("ℹ️ Atendiendo ticket #$ticketId de forma genérica")
        return true
    }
}

class SoporteUrgente(val nivel: String) : Resoluble {
    override val tipo = "Urgente"
    override fun atender(ticketId: Int): Boolean {
        println("🚨 Atendiendo ticket #$ticketId con prioridad $nivel")
        return true
    }
}

fun gestionarTicket(ticketId: Int, canal: Resoluble) {
    println("Procesando solicitud a través de ${canal.tipo}...")
    val exito = canal.atender(ticketId)
    println(if (exito) "✅ Ticket resuelto" else "❌ Ticket pendiente")
}

fun main() {
    val canales: List<Resoluble> = listOf(
        SoporteTecnico("Redes"),
        SoporteFacturacion("admin@empresa.com"),
        SoporteGeneral(),
        SoporteUrgente("Crítica")
    )

    canales.forEach { gestionarTicket(501, it) }

    for (canal in canales) {
        println("$canal")
    }
}