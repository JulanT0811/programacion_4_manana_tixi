import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';

void main() {
  testWidgets('Test basico de modulo 7', (WidgetTester tester) async {
    await tester.pumpWidget(
      const MaterialApp(
        home: Scaffold(
          body: Text('Tickets Layout'),
        ),
      ),
    );
    expect(find.text('Tickets Layout'), findsOneWidget);
  });
}
