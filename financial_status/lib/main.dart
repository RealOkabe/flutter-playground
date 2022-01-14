import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    home: Scaffold(
      appBar: AppBar(
        title: Center(child: Text(getStatusText(true))
        ),
        backgroundColor: getAppBarColor(true),
      ),
      backgroundColor: getAppBarColor(true),
      ),
    ),
  );
}

String getStatusText(bool isRich) {
  if(isRich) {
    return "I am Rich";
  }
  return "I am Poor";
}

MaterialAccentColor getAppBarColor(bool isRich) {
  if(isRich) {
    return Colors.indigoAccent;
  }
  return Colors.redAccent;
}