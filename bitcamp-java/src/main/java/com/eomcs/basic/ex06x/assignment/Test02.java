package com.eomcs.basic.ex06x.assignment;

public class Test02 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    int width = Console.inputInt();

    int line = 0;
    while (line++ < width) {
      Graphic.drawLine(line);
      System.out.println();
    }  
    line--;

    while (line-- >= 1) {
      Graphic.drawLine(line);
      System.out.println();

    }
  }
}



