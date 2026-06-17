import 'package:flutter/material.dart';

class CatalogoBasicos extends StatelessWidget {
  const CatalogoBasicos({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Widgets básicos')),
      body: ListView(
        padding: const EdgeInsets.all(16),
        children: [
          Text(
            'nginx-proxy: En línea',
            style: TextStyle(
              fontSize: 20,
              fontWeight: FontWeight.bold,
              color: Colors.green,
              letterSpacing: 0.5,
              fontStyle: FontStyle.normal,
              decoration: TextDecoration.combine([
                TextDecoration.underline,
                TextDecoration.lineThrough,
              ]),
              shadows: const [
                Shadow(
                  color: Colors.black26,
                  blurRadius: 4,
                  offset: Offset(2, 2),
                ),
              ],
            ),
          ),
          const SizedBox(height: 8),
          const SizedBox(
            width: double.infinity,
            child: Text(
              'api-gateway-produccion-region-us-east-version-2-debug-logs → sin respuesta (TextOverflow.fade)',
              textAlign: TextAlign.center,
              maxLines: 1,
              overflow: TextOverflow.fade,
            ),
          ),
          const SizedBox(height: 8),
          const SizedBox(
            width: double.infinity,
            child: Text(
              'api-gateway-produccion-region-us-east-version-2-debug-logs → sin respuesta (TextOverflow.clip)',
              textAlign: TextAlign.center,
              maxLines: 1,
              overflow: TextOverflow.clip,
            ),
          ),
          const SizedBox(height: 8),
          const SizedBox(
            width: double.infinity,
            child: Text(
              'api-gateway-produccion-region-us-east → sin respuesta. Este es un texto bastante más largo para demostrar cómo aparece la segunda línea cuando cambiamos maxLines a 2.',
              textAlign: TextAlign.center,
              maxLines: 2,
              overflow: TextOverflow.ellipsis,
            ),
          ),
          const SizedBox(height: 8),
          const SizedBox(
            width: double.infinity,
            child: Text(
              'api-gateway-produccion-region-us-east → sin respuesta. Este es un texto largo que no debería saltar de línea porque softWrap está desactivado.',
              textAlign: TextAlign.center,
              softWrap: false,
              overflow: TextOverflow.fade,
            ),
          ),
          const SizedBox(height: 8),
          const SizedBox(
            width: double.infinity,
            child: Text(
              'api-gateway-produccion-region-us-east-version-2-debug-logs → sin respuesta. Este es un texto extremadamente largo y detallado que sirve para demostrar cómo funciona la alineación justificada (TextAlign.justify) en Flutter. Al justificar el texto, los espacios entre las palabras se distribuyen de manera uniforme para que el texto ocupe todo el ancho disponible tanto en el margen izquierdo como en el derecho.',
              textAlign: TextAlign.justify,
            ),
          ),
          const SizedBox(height: 8),
          const Text.rich(
            TextSpan(children: [
              TextSpan(
                text: 'Estado: ',
                style: TextStyle(fontWeight: FontWeight.w600),
              ),
              TextSpan(
                text: 'CRÍTICO',
                style: TextStyle(color: Colors.red, fontWeight: FontWeight.bold),
              ),
              TextSpan(
                text: ' — última revisión hace 5 min',
                style: TextStyle(color: Colors.grey, fontSize: 12),
              ),
            ]),
          ),
          const SizedBox(height: 8),
          const SelectableText(
            '10.0.0.12:5432',
            style: TextStyle(fontFamily: 'monospace', fontSize: 14),
          ),
          const Divider(height: 32),
        ],
      ),
    );
  }
}
