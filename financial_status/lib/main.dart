import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    home: Scaffold(
      appBar: AppBar(
        title: Center(
            child: Text(getStatusText(true))
        ),
        backgroundColor: getStatusColor(true),
      ),
      body: Center(
          child: Image(
            image: getStatusImage(true),
          ),
      ),
      backgroundColor: getStatusColor(true),
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

MaterialAccentColor getStatusColor(bool isRich) {
  if(isRich) {
    return Colors.indigoAccent;
  }
  return Colors.redAccent;
}

AssetImage getStatusImage(bool isRich) {
  if(isRich) {
    return const AssetImage('assets/images/rich.jpg');
  }
  return const AssetImage('assets/images/poor.jpg');
}