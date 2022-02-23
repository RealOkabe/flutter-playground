import 'package:flutter/material.dart';
import 'package:webview_flutter/webview_flutter.dart';

const url = "https://www.kickstarter.com";

void main() {
  runWebviewApp();
}

void runWebviewApp() {
  WebViewController controller;
  runApp(MaterialApp(
    home: Scaffold(
      body: const WebView(
        initialUrl: url,
        javascriptMode: JavascriptMode.unrestricted,
      ),
    ),
  )
  );
  }