/**  Udacity Java Course - Space Challenge Project: Mission To Mars
 **  by CIMAN01 (December 2017)
 **/


/**
Create a class Rocket that implements the SpaceShip Interface and hence implements all the methods above.

1. launch and land methods in the Rocket class should always return true. When U1 and U2 classes extend
   the Rocket class they will override these methods to return true or false based on the actual
   probability of each type.

2. carry and canCarry should be implemented here and will not need to be overridden in the U1 and U2
   classes.

**/

import java.util.*;

public class Rocket implements SpaceShip {

    public int rocketCost;                  // rocket Cost

    public int rocketWeight;                // rocket Weight
    public int rocketMaxWeight;             // rocket Max Weight (with cargo) in kilograms
    public int currentRocketWeight;         // rocket Current Weight (with cargo) in kilograms

    public int cargoCarried;                // Rocket cargo Carried in kilograms
    public int cargoLimit;                  // rocket Cargo Limit in kilograms

    public double chanceOfExplosion;        // Chance of launch explosion
    public double chanceOfCrash;            // Chance of landing crash

    public double percent;

    // Constructor
    public Rocket() {
        rocketCost = 0;
        rocketWeight = 0;
        rocketMaxWeight = 0;
        currentRocketWeight = 0;
        cargoLimit = 0;
        cargoCarried = 0;
    }

    // indicates whether or not launch is successful (overridden by U1/U2 class)
    public boolean launch(){
        return true;
    } // method should always return true.

    // indicates whether or not landing is successful (overridden by U1/U2 class)
    public boolean land(){
        return true;
    } // method should always return true.

    // a method that takes an Item as an argument and returns true if the rocket can carry
    // such item or false if it will exceed the weight limit.
    public boolean canCarry(Item item){
        if ((currentRocketWeight + item.weight) <= rocketMaxWeight) {
            return true;
        } else {
            System.out.println("Warning: rocket exceeds the weight limit");
            System.out.println();
            return false;
        }
    }

    // a method that also takes an Item object and updates the current weight of the rocket.
    public int carry(Item item) {
        currentRocketWeight += item.weight;
        System.out.println(String.format("Current rocket weight is: %d", currentRocketWeight));
        return currentRocketWeight;
    }

    // a method that returns the cost of the rocket.
    public int getCost() {
        return rocketCost;
    }
}

