import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';

void main() {
  testWidgets('Test basico de modulo 8', (WidgetTester tester) async {
    await tester.pumpWidget(
      const MaterialApp(
        home: Scaffold(
          body: Text('Tickets Material 3'),
        ),
      ),
    );
    expect(find.text('Tickets Material 3'), findsOneWidget);
  });
}
