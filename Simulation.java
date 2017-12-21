/**  Udacity Java Course - Space Challenge Project: Mission To Mars
 **  by CIMAN01 (December 2017)
 **/


 /** A simulation class that is responsible for reading item data and filling up the rockets. **/


import java.util.*;
import java.io.*;


public class Simulation {

    // Constructor
    Simulation(){
    }

    /** this method loads all items from a text file and returns an ArrayList of Items. LoadItems should
        read the text file line by line and create an Item object for each and then add it to an ArrayList
        of Items. The method should then return that ArrayList. **/

    public ArrayList<Item> loadItems(String txtFile) {

        ArrayList<Item> itemArrayList = new ArrayList<>();

        try {
            // create the object file for phase-x.txt
            File file = new File(txtFile);

            // create the object scanner for object file
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {

                // read the next line
                String line = scanner.nextLine();

                // split each line by "=" and take 1st item as item name and 2nd item as weight in kg
                String[] singleItem = line.split("=");

                // converting String portion to integer and store in weight
                int weight = Integer.valueOf(singleItem[1]);

                // store item name
                String name = singleItem[0];

                // adding new Item to the phaseOne ArrayList
                itemArrayList.add(new Item(name, weight));

            }

            scanner.close(); // close scanner

        } catch (FileNotFoundException e) {
            e.printStackTrace();
          }

        return itemArrayList;  // return ArrayList of Items

    }

    /** this method takes the ArrayList of Items returned from loadItems and starts creating U1 rockets.
    It first tries to fill up 1 rocket with as many items as possible before creating a new rocket object
    and filling that one until all items are loaded. The method then returns the ArrayList of those
    U1 rockets that are fully loaded. **/

    public ArrayList<Rocket> loadU1(ArrayList<Item> itemArrayList) {

        // create ArrayList object fleetU1
        ArrayList<Rocket> fleetU1 = new ArrayList<>();

        // create a new object
        Rocket rocketU1 = new U1();

        // for each item in the arrayList  of items
        for (Item item : itemArrayList) {
            // fill up the rockets with as many items as possible.
            if (rocketU1.canCarry(item)) {
                    fleetU1.add(rocketU1); // add those rockets to the fleet.
            // create new rocket object after rockets are full.
            } else {
                rocketU1 = new U1(); // create new U1 rocket.
                fleetU1.add(rocketU1); // add rocket to the fleet.
                rocketU1.carry(item); // add items to rocket.
              }
        }
        return fleetU1; // return the ArrayList of those U1 rockets that are fully loaded.
    }

    /** this method also takes the ArrayList of Items and starts creating U2 rockets and filling them with those
    items the same way as with U1 until all items are loaded. The method then returns the ArrayList of those U2
    rockets that are fully loaded. **/

    public ArrayList<Rocket> loadU2(ArrayList<Item> itemArrayList) {

        // create ArrayList object fleetU2
        ArrayList<Rocket> fleetU2 = new ArrayList<>();

        Rocket rocketU2 = new U2();

        for (Item item : itemArrayList) {

            if (rocketU2.canCarry(item)) {
                fleetU2.add(rocketU2);
            } else {
                rocketU2 = new U2();
                fleetU2.add(rocketU2);
                rocketU2.carry(item);
            }
        }
        return fleetU2;
    }

    /** this method takes an ArrayList of Rockets and calls launch and land methods for each of the rockets in
    the ArrayList. Every time a rocket explodes or crashes (i.e if launch or land return false) it will have to
    send that rocket again. All while keeping track of the total budget required to send each rocket safely to
    Mars. runSimulation then returns the total budget required to send all rockets (including the crashed ones.)**/

    public int runSimulation(ArrayList<Rocket> rockets) {

        int totalBudget = 0; // total cost

        // for each new rocket...
        for (Rocket newRocket : rockets) {
            // ...add the cost
            totalBudget += newRocket.getCost();
            // while also adding the cost of the ones that failed.
            while (!newRocket.launch() || !newRocket.land()) {
                totalBudget += newRocket.getCost();
            }
        }
        // Returns the total budget required to send all rockets (including the crashed ones).
        return totalBudget;
    }
}

