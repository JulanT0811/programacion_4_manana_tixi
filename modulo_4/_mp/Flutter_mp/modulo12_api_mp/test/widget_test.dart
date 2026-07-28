import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';

void main() {
  testWidgets('Test basico de modulo 12', (WidgetTester tester) async {
    await tester.pumpWidget(
      const MaterialApp(
        home: Scaffold(
          body: Text('API REST Tickets'),
        ),
      ),
    );
    expect(find.text('API REST Tickets'), findsOneWidget);
  });
}
