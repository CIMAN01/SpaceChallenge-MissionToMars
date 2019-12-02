/** Udacity Java Course - Space Challenge Project: Mission To Mars
 ** by CIMAN01 (December 2017 / modified November 2019)
 **/


/**
 Create a SpaceShip Interface that includes the definitions of these methods:
 1. launch: a method that returns either true or false indicating if the launch was successful
 or if the rocket has crashed.
 2. land: a method that also returns either true or false based on the success of the landing.
 3. canCarry: a method that takes an Item as an argument and returns true if the rocket can carry
 such item or false if it will exceed the weight limit.
 4. carry: a method that also takes an Item object and updates the current weight of the rocket.
 **/

public interface SpaceShip {
    // launch method will return true if rocket takes off or false if it crashes.
    boolean launch();

    // land method will return true if rocket lands or false if it crashes.
    boolean land();

    // canCarry method takes an Item as an argument and returns true if the rocket can carry
    // such item or false if it exceeds the maximum weight limit.
    boolean canCarry(Item item);

    // carry method takes an item object and updates the current weight of the rocket.
    void carry(Item item);
}
