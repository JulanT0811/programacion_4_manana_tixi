import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';

void main() {
  testWidgets('Test basico de modulo 9', (WidgetTester tester) async {
    await tester.pumpWidget(
      const MaterialApp(
        home: Scaffold(
          body: Text('Formularios de Tickets'),
        ),
      ),
    );
    expect(find.text('Formularios de Tickets'), findsOneWidget);
  });
}
