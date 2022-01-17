import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

bool isRich = true;

void main() {
  runCustomApp(true);
}

void runCustomApp(bool isRich) {
  runApp(MaterialApp(
    home: Scaffold(
      appBar: AppBar(
        title: Center(
            child: Text(getStatusText(isRich))
        ),
        backgroundColor: getStatusColor(isRich),
      ),
      body: Center(
        child: Image(
          image: getStatusImage(isRich),
        ),
      ),
      backgroundColor: getStatusColor(isRich),
      bottomNavigationBar: BottomAppBar(
        color: getStatusColor(isRich),
        child: Row(children: [
          const Text("Poor"),
          Switch(value: isRich, onChanged: (bool newValue) {
            isRich = newValue;
            runCustomApp(isRich);
          }),
          const Text("Rich"),
        ],
          mainAxisAlignment: MainAxisAlignment.center,
        ),
      ),
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