// Written by Patel710 and Moha0825

public class Boats {
    private boolean horizontal;
    static int size = 3;
    int x;
    int y;
    int hitsleft;

    public Boats(int x, int y, boolean horizontal){
          this.x = x;
          this.y = y;
          this.horizontal = horizontal;
          this.hitsleft = size;
    }

    //checks to see if the input coordinate is a hit on the boat
    public boolean coordinateOnBoat(int x, int y) {
      if (horizontal) {
        if ((x >= this.x) && (x < this.x + size) && (this.y == y)) {
          return true;
        }
      } else { //handles vertical case
        if ((y <= this.y) && (y > this.y + size) && (this.x == x)) {
          return true;
        }
      }

      return false;
    }

    //decrements hitsleft and returns if the boat has been sunk
    public boolean hitBoat() {
      hitsleft --;
      if (hitsleft == 0) {
        return true;
      } else {
        return false;
      }
    }
}
