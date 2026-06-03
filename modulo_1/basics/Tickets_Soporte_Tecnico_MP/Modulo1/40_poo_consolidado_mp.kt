sealed class ActualizacionTicket(val idTicket: Int, val detalle: String) {
    abstract fun formatear(): String

    data class Correo(
        val destinatario: String,
        val asunto: String,
        val cuerpo: String
    ) : ActualizacionTicket(0, cuerpo) {
        override fun formatear() =
            "📧 Correo → $destinatario\n   Asunto: $asunto\n   ${detalle.take(50)}..."
    }

    data class NotificacionApp(val dispositivo: String, val icono: String = "🔔")
        : ActualizacionTicket(0, "") {
        override fun formatear() = "$icono App → $dispositivo: Actualización en ticket"
    }

    data class MensajeSms(val telefono: String, val texto: String)
        : ActualizacionTicket(0, texto) {
        override fun formatear() = "📱 SMS → $telefono: ${texto.take(160)}"
    }

    object RegistroInterno : ActualizacionTicket(0, "") {
        override fun formatear() = "📋 Registro interno de ticket"
    }
}

interface ProcesadorActualizacion {
    val canal: String
    fun ejecutar(actualizacion: ActualizacionTicket): Boolean
}

class ServicioCorreo : ProcesadorActualizacion {
    override val canal = "Correo"
    override fun ejecutar(a: ActualizacionTicket): Boolean {
        if (a !is ActualizacionTicket.Correo) return false
        println("  [CORREO] → ${a.destinatario}")
        return true
    }
}

class ServicioApp : ProcesadorActualizacion {
    override val canal = "App"
    override fun ejecutar(a: ActualizacionTicket): Boolean {
        if (a !is ActualizacionTicket.NotificacionApp) return false
        println("  [APP] → ${a.dispositivo}")
        return true
    }
}

class DespachadorTickets(private val servicios: List<ProcesadorActualizacion>) {

    fun procesar(actualizacion: ActualizacionTicket) {
        println(actualizacion.formatear())
        val exito = servicios.any { it.ejecutar(actualizacion) }
        if (!exito) println("  ⚠️ Sin canal de notificación disponible")
        println()
    }
}

fun main() {
    val despachador = DespachadorTickets(listOf(ServicioCorreo(), ServicioApp()))

    listOf(
        ActualizacionTicket.Correo("cliente@test.com", "Ticket Actualizado", "El estado cambió a resuelto."),
        ActualizacionTicket.NotificacionApp("Android-Carlos"),
        ActualizacionTicket.MensajeSms("+593999999999", "Tu ticket ha sido escalado"),
        ActualizacionTicket.RegistroInterno
    ).forEach { despachador.procesar(it) }
}