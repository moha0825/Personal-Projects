// Written by Patel710 and Moha0825

import java.util.Scanner;
// Creating BattleboatsBoard class
public class BattleboatsBoard {
    private int row;
    private int column;
    int [][] Arr; // non-static array
    public static boolean debug;
    private Boats[] boat_list;
    // Defining the variables
    public BattleboatsBoard(int row, int column) {
        this.row = row;
        this.column = column;
        Arr = new int[row][column]; // array for the rows and columns of the board
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                Arr[i][j] = 0;
            }
        }
    }
    // Getters
    public int getRow() {
        return getRow();
    }
    public int getColumn() {
        return getColumn();
    }

    // Setters
    public void setRow(int m) {
        row = m;
    }
    public void setColumn(int n) {
        column = n;
    }

    // Method to represent objects as a string
    public String toString() {
        String s = "";
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (Arr[i][j] == 0){
                    s += "_ ";
                }
                else if(Arr[i][j] > 0 || Arr[i][j] == -1){
                    s += "X ";
                }
                else{
                    s += Arr[i][j] + " ";
                }
            }
            s += "\n";
        }
        return s;
    }

    // Initializes the correct number of boats based on board dimensions
    public void Boats() {
        int numBoat = 0;
        if (row == 3 || column == 3) {
            numBoat = 1;
            //System.out.println("case 1");
        } else if ((3 < row && row <= 6) || (3 < column && column <= 6)) {
            numBoat = 2;
            //System.out.println("case 2");
        } else if ((6 < row && row <= 8) || (6 < column && column <= 8)) {
            numBoat = 3;
            //System.out.println("case 3");
        } else if ((8 < row && row <= 10) || (8 < column && column <= 10)) {
            numBoat = 4;
            //System.out.println("this is an 8 x 10 board");
        } else if ((10 < row && row <= 12) || (10 < column && column <= 12)) {
            numBoat = 6;
            //System.out.println("case 4");
        }
        boat_list = new Boats[numBoat];
        boolean fit = true;
        for (int i = 0; i < numBoat; i++) {
            fit = true;
            while (fit) {
                double a = Math.random(); // randomly placing boats
                int x = 0;
                x = (int) Math.floor(a * row); // rounding numbers down to nearest whole number
                double b = Math.random();
                int y = 0;
                y = (int) Math.floor(b * column);
                double c = Math.random();
                int z = 0;
                z = (int) Math.floor(c * 2);
                if (x + 1 < row && x + 2 < row && z == 1) { // Vertical Placement
                    if (Arr[x][y] == 0 && Arr[x + 1][y] == 0 && Arr[x + 2][y] == 0) {
                        Arr[x][y] = 1;
                        Arr[x + 1][y] = 1;
                        Arr[x + 2][y] = 1;
                        fit = false;
                        Boats n = new Boats(x, y, true);
                        boat_list[i]=n;
                    }
                } else if (y + 1 < row && y + 2 < row && z == 0) { // Horizontal Placement
                    if (Arr[x][y] == 0 && Arr[x][y + 1] == 0 && Arr[x][y + 2] == 0) {
                        Arr[x][y] = 1;
                        Arr[x][y + 1] = 1;
                        Arr[x][y + 2] = 1;
                        fit = false;
                        Boats n = new Boats(x, y, false);
                        boat_list[i]=n;
                    }
                }
            }
        }
    }

    public void printboard(){
      String s = "";
      for (int i = 0; i < row; i++) {
          for (int j = 0; j < column; j++) {
              s += Arr[i][j];
          }
          s += "\n";
      }
       System.out.println(s);
    }

    // Main method to take user input and print output results.
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Would you like to enter debug mode? (Yes/No) ");
        String deb = s.nextLine();
        if(deb.equals("Yes")){
          debug = true;
        } else {
          debug = false;
        }

        //System.out.println("Would you like to run in debug mode? (Yes or No): ");
        System.out.println("Enter number of rows: ");
        int row = s.nextInt();
        System.out.println("Enter number of columns: ");
        int column = s.nextInt();
        System.out.println("\n");

        if (row <= 2 || row >= 13 || column <= 2 || column >= 13) {
            return ;
        }

        BattleboatsBoard a = new BattleboatsBoard(row,column);
        a.Boats();
        boolean drone = true;
        int count = 1;
        while (drone){
            if(debug){ // if user enter debug mode, these guidelines are printed along with a board
              System.out.println("0: No boat, not guessed.");
              System.out.println("1: Yes boat, not guessed.");
              System.out.println("-1: Yes boat, guessed.");
              System.out.println("-2: No boat, guessed.");
              System.out.println();
              a.printboard();
            }
            System.out.println("Turn: " + count); // shows the turn number the player is on
            System.out.println("Do you want to send a drone? (Yes or No) ");
            Scanner sy = new Scanner(System.in);
            String d = sy.nextLine();
            System.out.println("Please enter coordinate x: ");
            int x = s.nextInt();
            System.out.println("Please enter coordinate y: ");
            int y = s.nextInt();
            if (d.equals("Yes")){
                count += 4;
                for(int i = 0; i < row;i++){
                    for(int j = 0; j < column; j++){
                        if (i == x||j == y){
                            if(a.Arr[i][j] == 1 || a.Arr[i][j] == -1){
                                System.out.print("X ");
                            }else{
                                System.out.print("0 ");
                            }
                        }else{
                            System.out.print("_ ");
                        }
                    }
                    System.out.print("\n");
                }
            }
            else if (d.equals("No")) {
                count += 1;
                // when boat is hit
                if(x < row && y < column){
                  if (a.Arr[x][y] == 1) {
                      System.out.println("Hit");
                      a.Arr[x][y] = -1;
                      for (int i = 0; i < a.boat_list.length; i++){ // From here to
                        if (a.boat_list[i].coordinateOnBoat(x, y)){
                          boolean sunk = a.boat_list[i].hitBoat();
                          if(sunk){
                            System.out.println("Sunk"); // when boat is fully hit - sunk
                          }
                        }
                      }
                  } else if (a.Arr[x][y] == 0) {
                      System.out.println("Miss"); // if boat is not found
                      a.Arr[x][y] = -2;

                  } else {
                      System.out.println("Penalty: Skip 1 turn");
                      count += 1;
                  }
            } else {
              System.out.println("Penalty: Skip 1 turn");
              count += 1;
            }

            }
            drone = false;
            for (int i = 0;i<a.Arr.length;i++){
                for(int j = 0;j<a.Arr.length;j++){
                    if(a.Arr[i][j]>0){
                        drone = true;
                    }
                }
            }

        }
    }
}
