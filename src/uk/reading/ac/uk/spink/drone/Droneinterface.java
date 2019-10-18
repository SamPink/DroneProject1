package uk.reading.ac.uk.spink.drone;

import java.util.Scanner;

class DroneInterface {

    private Scanner s;								// scanner used for input from user
    private DroneArena myArena;				// arena in which drones are shown
    /**
     * constructor for DroneInterface
     * sets up scanner used for input and the arena
     * then has main loop allowing user to enter commands
     */
    public DroneInterface() {
        s = new Scanner(System.in);			// set up scanner for user input
        myArena = new DroneArena(10, 20);	// create arena of size 20*6

        char ch = ' ';
        do {
            System.out.print("Enter (A)dd drone, get (I)nformation, (D)isplay Drones or e(X)it > ");
            ch = s.next().charAt(0);
            s.nextLine();
            switch (ch) {
                case 'A' :
                case 'a' :
                    myArena.addDrone();	// add a new drone to arena
                    break;
                case 'I' :
                case 'i' :
                    System.out.print(myArena.toString());
                    break;
                case 'x' : 	ch = 'X';				// when X detected program ends
                    break;
                case 'd':
                case 'D':
                    toDisplay();
            }
        } while (ch != 'X');						// test if end

        s.close();									// close scanner
    }

    void toDisplay() {
        ConsoleCanvas c = new ConsoleCanvas(myArena.getSizeX(), myArena.getSizeY());
        myArena.showDrones(c);
        System.out.println(c.toString());
    }


    public static void main(String[] args) {
        DroneInterface r = new DroneInterface();	// just call the interface
    }

}
