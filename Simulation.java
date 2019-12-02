/**  Udacity Java Course - Space Challenge Project: Mission To Mars
 **  by CIMAN01 (December 2017 / modified November 2019)
 **/

/** A simulation class that is responsible for reading item data and filling up the rockets. **/

import java.util.*;
import java.io.*;

public class Simulation {

    // empty constructor
    Simulation(){
    }

    /** this method loads all items from a text file and returns an ArrayList of Items. LoadItems should
     read the text file line by line and create an Item object for each and then add it to an ArrayList
     of Items. The method should then return that ArrayList. **/

    public ArrayList<Item> loadItems(String text) {
        // create an ArrayList object called payload
        ArrayList<Item> payload = new ArrayList<>();
        // try statement for opening the text file
        try {
            // create a file object for phase-x.txt
            File file = new File(text);
            // create a scanner object to process text file
            Scanner scan = new Scanner(file);
            // while there is text to processed
            while (scan.hasNextLine()) {
                // read the next line
                String line = scan.nextLine();
                // split each line by "=" and take 1st item as item name and 2nd item as weight
                String[] singleItem = line.split("=");
                // store item name in string variable name
                String name = singleItem[0];
                // converting String portion to integer and store in weight
                int weight = Integer.parseInt(singleItem[1]);
                // adding new Item to the phaseOne ArrayList
                payload.add(new Item(name, weight));
            }
            scan.close(); // don't forget we need to close scanner object
        // catch statement for missing file
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return payload;  // return ArrayList of Items
    }

    /** this method takes the ArrayList of Items returned from loadItems and starts creating U1 rockets.
     It first tries to fill up 1 rocket with as many items as possible before creating a new rocket object
     and filling that one until all items are loaded. The method then returns the ArrayList of those
     U1 rockets that are fully loaded. **/

    public ArrayList<Rocket> loadU1 (ArrayList<Item> payload) {
        // create ArrayList object fleetU1
        ArrayList<Rocket> fleetU1 = new ArrayList<>();
        // create a new object
        Rocket rocketU1 = new U1();
        // for each item in the payload
        for (Item item : payload) {
            // if there is room
            if (rocketU1.canCarry(item)) {
                // fill up the rocket with as many items as possible
                rocketU1.carry(item);
            // else create new a rocket object
            } else {
                fleetU1.add(rocketU1); // add fully loaded rocket to the fleet of rockets
                rocketU1 = new U1(); // create a new U1 rocket.
                rocketU1.carry(item); // and start adding items to that rocket
            }
        }
        return fleetU1; // return the ArrayList of those U1 rockets that are fully loaded
    }

    /** this method also takes the ArrayList of Items and starts creating U2 rockets and filling them with those
     items the same way as with U1 until all items are loaded. The method then returns the ArrayList of those U2
     rockets that are fully loaded. **/

    public ArrayList<Rocket> loadU2 (ArrayList<Item> payload) {
        // create ArrayList object fleetU2
        ArrayList<Rocket> fleetU2 = new ArrayList<>();
        // create a new object
        Rocket rocketU2 = new U2();
        // for each item in the payload
        for (Item item : payload) {
            // if there is room
            if (rocketU2.canCarry(item)) {
                // fill up the rocket with as many items as possible
                rocketU2.carry(item);
                // else create new a rocket object
            } else {
                fleetU2.add(rocketU2); // add fully loaded rocket to the fleet of rockets
                rocketU2 = new U2(); // create a new U1 rocket.
                rocketU2.carry(item); // and start adding items to that rocket
            }
        }
        return fleetU2; // return the ArrayList of those U1 rockets that are fully loaded
    }

        /**
         this method takes an ArrayList of Rockets and calls launch and land methods for each of the rockets in
         the ArrayList. Every time a rocket explodes or crashes (i.e if launch or land return false) it will have to
         send that rocket again. All while keeping track of the total budget required to send each rocket safely to
         Mars. runSimulation then returns the total budget required to send all rockets (including the crashed ones.)
         **/

        public int runSimulation (ArrayList<Rocket> rockets) {
            // total budget required to send all rockets (including crashed ones)
            int totalBudget = 0; // total cost of all rockets launched
            // for each rocket
            for (Rocket r : rockets) {
                do {
                    // add the cost to the total budget
                    totalBudget += r.getCost();
                    // while not reaching mars, we keep sending a new rocket and adding the cost
                    } while (!(r.launch() && r.land()));
            }
            // return the total budget required to send all rockets (including the crashed ones)
            return totalBudget;
        }
}
