import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';

void main() {
  testWidgets('Test de carga basica de soporte', (WidgetTester tester) async {
    await tester.pumpWidget(
      const MaterialApp(
        home: Scaffold(
          body: Text('Mesa de Ayuda'),
        ),
      ),
    );
    expect(find.text('Mesa de Ayuda'), findsOneWidget);
  });
}
