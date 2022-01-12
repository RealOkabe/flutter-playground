import 'package:flutter/material.dart';

// Everything in flutter is a widget
// main is the starting point of the application
// runApp is the function that the main function is supposed to run. It is the default one
// const MaterialApp is preferred as flutter recommends making constructors constant
// textAlign is a property of the Text widget which is used to align the text
// By default textAlign is set to TextAlign.left

void main() =>
  runApp(
    const MaterialApp(
      home: Center(
        child: Text(
            "Hello Flutter!",
          textAlign: TextAlign.center,
        ),
      ),
    ),
  );