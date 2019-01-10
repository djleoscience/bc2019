package bc19;

import java.util.*;

public class Utils {
  public static Coord getClosest(Coord start, List<Coord> others, BCAbstractRobot logger) {

    int min = 99999999;
    int resultX = -1;
    int resultY = -1;

    if (others.size() == 0 ) {
      throw new BCException("Can't find closest of empty list");
    }

    for (Coord c : others) {

      if (c == null) {
        //logger.log("Coord in util was null");
        continue;
      }

      //logger.log("Coords util sees => x:"+c.x+" y:"+c.y);


      int xDif = start.x - c.x;
      int yDif = start.y - c.y;

      int distSquared = (xDif * xDif) + (yDif * yDif);

      if (distSquared < min) {
        min = distSquared;
        resultX = c.x;
        resultY = c.y;
      }
    }

    if (resultX == -1 && resultY == -1) {
      throw new BCException("Could not find closest coord. Check Utils.java");
    }

    return new Coord(resultX, resultY);

  }

  public static int randRange(int min, int max) {
    return ( min + (int)(Math.random() * ((max - min) + 1)) );
  }
}
