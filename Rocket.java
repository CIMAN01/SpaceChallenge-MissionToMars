/**
 ** Udacity Java Course - Space Challenge Project: Mission To Mars
 ** by CIMAN01 (December 2017 / modified November 2019)
 **/


/**
 Create a class Rocket that implements the SpaceShip Interface and hence implements all the methods above.
 1. launch and land methods in the Rocket class should always return true. When U1 and U2 classes extend
 the Rocket class they will override these methods to return true or false based on the actual
 probability of each type.
 2. carry and canCarry should be implemented here and will not need to be overridden in the U1 and U2
 classes.
 **/

public class Rocket implements SpaceShip {
    // instance data
    private int rocketCost; // rocket Cost
    private int rocketWeight; // rocket Weight
    private int currentRocketWeight; // rocket Current Weight (with cargo) in kilograms
    private int maxWeight; // Max weight (with cargo) in kilograms

    // Rocket constructor
    public Rocket() {
        rocketCost = 0;
        rocketWeight = 0;
        maxWeight = 0;
        currentRocketWeight = 0;
    }

    // indicates whether or not launch is successful (override by U1/U2 class)
    public boolean launch() {
        return true; // method should always return true.
    }

    // indicates whether or not landing is successful (override by U1/U2 class)
    public boolean land() {
        return true; // method should always return true.
    }

    // a method that takes an Item as an argument and returns true if the rocket can carry
    // such item or false if it will exceed the weight limit.
    public boolean canCarry(Item item) {
        return currentRocketWeight + item.getWeight() <= maxWeight;
    }

    // a method that also takes an Item object and updates the current weight of the rocket.
    public void carry(Item item) {
        currentRocketWeight += item.getWeight();
        setCurrentRocketWeight(currentRocketWeight);
    }

    // Setters:

    // set the rocket cost
    public void setRocketCost(int rocketCost) { this.rocketCost = rocketCost; }
    // set the rocket weight
    public void setRocketWeight(int rocketWeight) { this.rocketWeight = rocketWeight; }
    // set the current rocket weight
    public void setCurrentRocketWeight(int currentRocketWeight) { this.currentRocketWeight = currentRocketWeight; }
    // set the maximum weight
    public void setMaxWeight(int maxWeight) { this.maxWeight = maxWeight; }

    // Getters:

    // return the cost
    public int getCost() { return rocketCost; }
    // return the weight of the rocket
    public int getRocketWeight() { return rocketWeight; }
    // return the current weight
    public int getCurrentRocketWeight() { return currentRocketWeight; }
    // return the maximum weight
    public int getMaxWeight() { return maxWeight; }
}
