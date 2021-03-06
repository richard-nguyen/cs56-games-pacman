package edu.ucsb.cs56.projects.games.pacman;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Grid {
    final int blockSize = 24;
    final int nrOfBlocks = 15;
    final int scrSize = nrOfBlocks * blockSize;
    
    //Real level data
    final short leveldata1[] =
    { 19, 26, 26, 26, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 22,
      21, 0,  0,  0,  17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,
      21, 0,  0,  0,  17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20, 
      21, 0,  0,  0,  17, 16, 16, 24, 16, 16, 16, 16, 16, 16, 20, 
      17, 18, 18, 18, 16, 16, 20, 0,  17, 16, 16, 16, 16, 16, 20,
      17, 16, 16, 16, 16, 16, 20, 0,  17, 16, 16, 16, 16, 24, 20, 
      25, 16, 16, 16, 24, 24, 28, 0,  25, 24, 24, 16, 20, 0,  21, 
      1,  17, 16, 20, 0,  0,  0,  0,  0,  0,  0,  17, 20, 0,  21,
      1,  17, 16, 16, 18, 18, 22, 0,  19, 18, 18, 16, 20, 0,  21,
      1,  17, 16, 16, 16, 16, 20, 0,  17, 16, 16, 16, 20, 0,  21, 
      1,  17, 16, 16, 16, 16, 20, 0,  17, 16, 16, 16, 20, 0,  21,
      1,  17, 16, 16, 16, 16, 16, 18, 16, 16, 16, 16, 20, 0,  21,
      1,  17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0,  21,
      1,  25, 24, 24, 24, 24, 24, 24, 24, 24, 16, 16, 16, 18, 20,
      9,  8,  8,  8,  8,  8,  8,  8,  8,  8,  25, 24, 24, 24, 28 };

    final short leveldata2[] = 
    {  0,  0, 19, 18, 18, 18, 18, 18, 18, 18, 18, 18, 22,  0,  0,
       0, 19, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 22,  0,
      19, 16, 16, 16, 16, 16, 24, 24, 24, 16, 16, 16, 16, 16, 22,
      17, 16, 16, 16, 16, 20,  0,  0,  0, 17, 16, 16, 16, 16, 20,
      17, 16, 16, 16, 16, 20,  0,  0,  0, 17, 16, 16, 16, 16, 20,
      17, 16, 16, 24, 24, 28,  0,  0,  0, 25, 24, 24, 16, 16, 20,
      17, 16, 20,  0,  0,  0,  0,  0,  0,  0,  0,  0, 17, 16, 20,
      17, 16, 20,  0,  0,  0,  0,  0,  0,  0,  0,  0, 17, 16, 20,
      17, 16, 20,  0,  0,  0,  0,  0,  0,  0,  0,  0, 17, 16, 20,
      17, 16, 16, 18, 18, 22,  0,  0,  0, 19, 18, 18, 16, 16, 20,
      17, 16, 16, 16, 16, 20,  0, 23,  0, 17, 16, 16, 16, 16, 20,
      17, 16, 16, 16, 16, 20,  0, 21,  0, 17, 16, 16, 16, 16, 20,
      25, 16, 16, 16, 16, 16, 18, 16, 18, 16, 16, 16, 16, 16, 28,
       0, 25, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 28,  0,
       0,  0, 25, 24, 24, 24, 24, 24, 24, 24, 24, 24, 28,  0,  0 };


    final short leveldata3[] = 
    { 19, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 22,
      17, 16, 24, 24, 16, 16, 16, 16, 16, 24, 24, 24, 24, 16, 20,
      17, 20,  0,  0, 17, 16, 16, 16, 20,  0,  0,  0,  0, 17, 20,
      17, 20,  0,  0, 17, 16, 16, 16, 20,  0,  0,  0,  0, 17, 20,
      17, 16, 18, 18, 16, 16, 16, 16, 16, 18, 22,  0,  0, 17, 20,
      17, 16, 16, 16, 16, 16, 24, 24, 24, 16, 20,  0,  0, 17, 20,
      17, 16, 16, 16, 16, 20,  0,  0,  0, 17, 16, 18, 18, 16, 20,
      17, 16, 16, 16, 16, 20,  0,  0,  0, 17, 16, 16, 16, 16, 20,
      17, 16, 24, 24, 16, 20,  0,  0,  0, 17, 16, 16, 16, 16, 20,
      17, 20,  0,  0, 17, 16, 18, 18, 18, 16, 16, 16, 16, 16, 20,
      17, 20,  0,  0, 25, 24, 16, 16, 16, 16, 16, 24, 24, 16, 20,
      17, 20,  0,  0,  0,  0, 17,  0, 16, 16, 20,  0,  0, 17, 20,
      17, 20,  0,  0,  0,  0, 17, 16, 16, 16, 20,  0,  0, 17, 20,
      17, 16, 18, 18, 18, 18, 16, 16, 16, 16, 16, 18, 18, 16, 20,
      25, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 28 };


    final short leveldata4[] =
    { 19, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 22,
      17, 16, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 16, 20,
      17, 20,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 17, 20,
      17, 16, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 16, 20,
      17, 16, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 16, 20,
      17, 20,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 17, 20,
      17, 16, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 16, 20,
      17, 16, 24, 24, 24, 24, 24, 16, 24, 24, 24, 24, 24, 16, 20,
      17, 20,  0,  0,  0,  0,  0, 21,  0,  0,  0,  0,  0, 17, 20,
      17, 20,  0, 19, 18, 18, 18, 16, 18, 18, 18, 22,  0, 17, 20,
      17, 20,  0, 17, 16, 16, 16, 16, 16, 16, 16, 20,  0, 17, 20,
      17, 20,  0, 25, 24, 24, 24, 24, 24, 24, 24, 28,  0, 17, 20,
      17, 20,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 17, 20,
      17, 16, 18, 18, 18, 18, 22,  0, 19, 18, 18, 18, 18, 16, 20,
      25, 24, 24, 24, 24, 24, 28,  0, 25, 24, 24, 24, 24, 24, 28};

    final short leveldata5[] =
    {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
       0,  0, 19, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 22,  0,
       0,  0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,  0,
       0,  0, 17, 16, 16, 16, 24, 24, 24, 24, 24, 24, 16, 20,  0,
       0,  0, 17, 16, 16, 20,  0,  0,  0,  0,  0,  0, 17, 20,  0,
       0,  0, 17, 16, 16, 20,  0,  0,  0,  0,  0,  0, 25, 28,  0,
       0,  0, 17, 16, 16, 16, 18, 18, 18, 18, 22,  0,  0,  0,  0,
       0,  0, 17, 16, 16, 16, 16, 16, 16, 16, 20,  0,  0,  0,  0,
       0,  0, 25, 24, 16, 16, 16, 16, 16, 16, 16, 18, 18, 18, 22,
       0,  0,  0,  0, 17, 16, 16, 16, 16, 16, 24, 16, 16, 16, 20,
       0,  0,  0,  0, 17, 16, 16, 16, 16, 20,  0, 17, 16, 16, 20,
       19, 18, 18, 26, 16, 24, 24,  0, 24, 28,  0, 17, 16, 16, 20,
       17, 16, 20,  0, 21,  0,  0, 21,  0,  0,  0, 17, 16, 16, 20,
       17, 16, 20,  0, 21,  0, 19, 16, 22,  0,  0, 25, 24, 24, 28,
       25, 24, 28,  0, 29,  0, 25, 24, 28,  0,  0,  0,  0,  0,  0};
    
      short[] screenData;
      Color mazeColor, dotColor;

      /**
       * Constructor for Board object
       */
      public Grid() {
          screenData = new short[nrOfBlocks * nrOfBlocks];
          mazeColor = new Color(5, 100, 5);
          dotColor = new Color(192, 192, 0);
      }
      
      /**
       * Checks if there are any pellets left for Pacman to eat, and restarts the game on the next board in a 
       * higher difficulty if finished
       * @return A boolean indicating whether or not the maze is finished
       */
      public boolean checkMaze() {
          short i = 0;
          boolean finished = true;

          while (i < nrOfBlocks * nrOfBlocks && finished) {
              if ((screenData[i] & 48) != 0)
                  finished = false;
              i++;
          }
          return finished;
      }
      
      /**
       * Initialize level
       */
      public void levelInit(int numBoardsCleared) {
          for (int i = 0; i < nrOfBlocks * nrOfBlocks; i++) {
              if (numBoardsCleared%3 == 0)
                  screenData[i] = leveldata1[i];
              else if (numBoardsCleared%3 == 1)
                  screenData[i] = leveldata2[i];
              else if (numBoardsCleared%3 == 2)
                  screenData[i] = leveldata3[i];
              else if (numBoardsCleared%5 == 3)
                  screenData[i] = leveldata4[i];
              else if (numBoardsCleared%3 == 4)
                  screenData[i] = leveldata5[i];
          }
      }
      
      /**
       * Draws the maze that serves as a playing field.
       * @param g2d a Graphics2D object
       */
      public void drawMaze(Graphics2D g2d) {
          short i = 0;
          int x, y;

          for (y = 0; y < scrSize; y += blockSize) {
              for (x = 0; x < scrSize; x += blockSize) {
                  g2d.setColor(mazeColor);
                  g2d.setStroke(new BasicStroke(2));

                  if ((screenData[i] & 1) != 0) // draws left
                  {
                      g2d.drawLine(x, y, x, y + blockSize - 1);
                  }
                  if ((screenData[i] & 2) != 0) // draws top
                  {
                      g2d.drawLine(x, y, x + blockSize - 1, y);
                  }
                  if ((screenData[i] & 4) != 0) // draws right
                  {
                      g2d.drawLine(x + blockSize - 1, y, x + blockSize - 1,
                                   y + blockSize - 1);
                  }
                  if ((screenData[i] & 8) != 0) // draws bottom
                  {
                      g2d.drawLine(x, y + blockSize - 1, x + blockSize - 1,
                                   y + blockSize - 1);
                  }
                  if ((screenData[i] & 16) != 0) // draws point
                  {
                      g2d.setColor(dotColor);
                      g2d.fillRect(x + 11, y + 11, 2, 2);
                  }
                  i++;
              }
          }
      }
}
