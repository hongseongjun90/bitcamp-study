package com.eomcs.basic.ex06x.assignment;

public class Test03 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    int width = Console.inputInt();

    if (width % 2 == 0)
      width--;

    int spaceSize = width >> 1;
    int line = 0; 
    while (line++ < width) {
      if (line % 2 == 0) {
        continue;
      }

      Graphic.drawLine(spaceSize, ' ');
      spaceSize--;

      Graphic.drawLine(line, '*');

      System.out.println();
    }
  }
}

