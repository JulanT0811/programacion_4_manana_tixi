import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';

void main() {
  testWidgets('Test basico de modulo 10', (WidgetTester tester) async {
    await tester.pumpWidget(
      const MaterialApp(
        home: Scaffold(
          body: Text('Riverpod Tickets'),
        ),
      ),
    );
    expect(find.text('Riverpod Tickets'), findsOneWidget);
  });
}
