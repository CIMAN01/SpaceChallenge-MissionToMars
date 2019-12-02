/** Udacity Java Course - Space Challenge Project: Mission To Mars
 ** by CIMAN01 (December 2017 / modified November 2019)
 **/

// Create an Item class that includes a String name and an int weight that will represent an item
// to be carried by the rockets

public class Item {
    // instance variables
    private String name; // name of the item to be carried
    private int weight; // weight of the item to be carried

    // Constructor
    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    // name instance setter method
    void setName(String name) {
        this.name = name;
    }

    // weight instance setter methods
    void setWeight(int weight) {
        this.weight = weight;
    }

    // name instance getter method
    public String getName() {
        return name;
    }

    // weight instance getter method
    public int getWeight() {
        return weight;
    }
}
