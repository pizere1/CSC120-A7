import java.util.ArrayList;
public class House extends Building {
    /**
     * Attributes
     * Arraylist for the residents
     *Boolean attribute for whether the house has a dining room or not
     */
    private ArrayList<String> residents;
    private final boolean hasDiningRoom;
    private final int maxcapacity;
    public boolean haselevator;

    /**
     * Constructor for the House subclass
     * @param name takes in the name of the house
     * @param address takes in the location adress of the house
     * @param nFloors takes in the number of the house floors
     */
    public House(String name, String address, int nFloors, boolean hasDiningRoom, int maxcapacity, boolean haselevator) {
        super(name, address, nFloors, haselevator);
        this.hasDiningRoom = hasDiningRoom;
        this.maxcapacity = maxcapacity;
        residents = new ArrayList<>(maxcapacity);
        System.out.println("You have built a house: 🏠 called " + this.getName());
    }

    /**
     * overloaded constructor to create a default house only with the maximum capacity
     * @param maxcapacity takes in the maximum capacity of the house
     */
    public House(int maxcapacity){
        super();
        this.hasDiningRoom = false;
        this.maxcapacity = maxcapacity;
    }

    /**
     * overloaded constructor for creating a house only with maximum capacity and dining room plan known
     * @param maxcapacity takes in the maximum capacity of the house
     * @param hasDiningRoom whether the house has a dining room or not
     */
    public House(int maxcapacity, boolean hasDiningRoom){
        super();
        this.hasDiningRoom = hasDiningRoom;
        this.maxcapacity = maxcapacity;
        residents = new ArrayList<>(maxcapacity);
    }

    /**
     * Overriden method to show actions possibly done when interacting with the house
     */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + hasDiningRoom() \n + nResidents()\n + moveIn()\n + moveout()\n");
        if(this.nFloors>1){
            System.out.println("goUp() \n + goDown()\n");
            if(this.haselevator){
                System.out.println("goToFloor(n)\n");
            }
        }
    }

    /**
     * overridden method for traveling between adjacent floors
     * @param floorNum takes in the desired floor number to go to
     */
    public void goToFloor(int floorNum) {
        if(!this.haselevator) {
            super.goToFloor(floorNum);
        } else{
            throw new RuntimeException("Sorry! no elevator so can't travel between non-adjacent floors");
        }
    }

        /**
         * method to  verify if the house has a dining room
         * @return true if it has a dining room or false if otherwise
         */
    public boolean hasDiningRoom(){
        if(this.hasDiningRoom){
            System.out.println(this.name + "has a dining room");
            return true;
        } else{
            System.out.println(this.name + " has no dining room");
            return false;
        }
    }

    /**
     * method to show the number of residents currently living in the house
     * @return the size of the house
     */
    public int nResidents(){
        if(residents == null){
            System.out.println("There are no residents in the house.");
            return 0;
        } else{
            return residents.size();
        }
    }

    /**
     * method for adding a new resident
     * @param name takes in the name of the resident
     * notifies user that the resident can't be added if the houselist contains the resident or
     * if the house is full
     * adds the new resident if otherwise
     */
    public void moveIn(String name){
        if(residents.contains(name)){
            System.out.println("Resident is already in the house.");
        } else{
            if(residents.size()>=maxcapacity){
                System.out.println("The house is full, cannot add this person to this house");
            } else{
                residents.add(name);
            }
        }
    }

    /**
     * the method for moving out a resident
     * @param name take the name of the resident
     * notifies when the resident is not found
     * @return their name with whether they were removed from the house or not
     */
    public String moveOut(String name){
        if(!residents.contains(name)){
            System.out.println("Resident "+name+" does not live in this house.");
            return name;
        }
        else{
            residents.remove(name);
            return name+" has been removed from the house.";
        }
    }

    /**
     * method to verify if someone is a resident of the house
     * @param person takes in the name of the person
     * @return true if the person lives there or false if otherwise
     */
    public boolean isResident(String person){
        return residents.contains(person);
    }

    /**
     * toString function for formatted output
     * @return the house details
     */
    public String toString() {
        return super.toString() + " which can house "+maxcapacity+" students and it's " + hasDiningRoom + " that it has a dining room";
    }
}

