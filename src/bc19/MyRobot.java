package bc19;

public class MyRobot extends BCAbstractRobot {


  RobotController unit = null;

  int unitType = -1;

  /*
  public MyRobot() {
    unitType = -1;
    unit = null;
    initialized = false;
    // 0 stands for Castle
    // 1 stands for Church
    // 2 stands for Pilgrim
    // 3 stands for Crusader
    // 4 stands for Prophet
    // 5 stands for Preacher


  }
  */

  public Action turn() {

    if (unit == null) {

      unitType = me.unit;

      switch(unitType){
        case 0:
          unit = new Castle(this);
          break;
        case 1:
          unit = new Church(this);
          break;
        case 2:
          unit = new Pilgrim(this);
          break;
        case 3:
          unit = new Crusader(this);
          break;
        case 4:
          unit = new Prophet(this);
          break;
        case 5:
          unit = new Preacher(this);
          break;
        default:
          log("Invalid Unit Type - not in range 0-5");
          return null;
      }

    }

    return unit.turn();
  }

}