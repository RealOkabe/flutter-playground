import 'package:flutter/material.dart';

const url = "https://www.kickstarter.com";

void main() {
  runWebviewApp();
}

void runWebviewApp() {
  runApp(MaterialApp(
    home: Scaffold(
      appBar: AppBar(
        title: const Text(url),
      ),
    ),
  )
  );
  }