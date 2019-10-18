package uk.reading.ac.uk.spink.drone;

import java.util.Arrays;

public class ConsoleCanvas {

    char [][] box = new char[10][20];

    public ConsoleCanvas(int row, int col) {
        for (int i = 0; i < row; i++) { //Rows
            for (int j = 0; j < col; j++) { //Columns
                if (i == 0 || i == row-1 || j == 0 || j == col-1){
                    //System.out.print("#");
                    box[i][j] = '#';
                } else{
                   // System.out.print(" ");
                    box[i][j] = ' ';
                }
            }
            //System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        ConsoleCanvas c = new ConsoleCanvas(10, 20);
        System.out.println(c.printBox());
        //c.showIt(4,3,"d");
    }

    private String printBox() {
        String map ="";
        for (int i = 0; i <10 ; i++) {
            for (int j = 0; j <20 ; j++) {
                map += box[i][j];
            }
            map += "\n";
        }
        return map;
    }


    private void showIt(int i, int i1, String d) {
    }
}
