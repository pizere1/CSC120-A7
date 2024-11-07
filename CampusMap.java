import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }
    public void showOptions(){
        for(Building b : buildings){
            System.out.println("Here are the options at "+ b.getName());
            System.out.println("----------------------------------------");
            b.showOptions();
        }
    }
    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        House Tyler= new House("Tyler House", "4 Green Street Northampton, MA 01063", 4, true, 50, false);
        myMap.addBuilding(Tyler);
        myMap.addBuilding(new House("Chase House", "45 Elm street Northampton, MA 01063", 3, true, 90, false));
        myMap.addBuilding(new House(50));
        myMap.addBuilding(new House(50, false));
        Cafe Compass_Cafe=new Cafe("Compass Cafe", "7 Neilson drive Northampton, MA 01063", 1, false, 100, 100,100, 60);
        myMap.addBuilding(Compass_Cafe);
        myMap.addBuilding(new Cafe());
        Library Neilson= new Library("Neilson library", "7 Neilson drive Northampton, MA 01063", 3, true);
        myMap.addBuilding(Neilson);
        myMap.addBuilding(new Library());
        myMap.addBuilding(new Library("43 Elm street Northampton, MA 01063"));
        System.out.println(myMap);
        System.out.println("Welcome to the campus tour");
        myMap.showOptions();
        System.out.println("---------------------------------------------");
        Compass_Cafe.enter();
        Compass_Cafe.exit();
        Neilson.enter();
        Neilson.goUp();
        Neilson.goToFloor(3);
        Neilson.goToFloor(1);
        Neilson.exit();
        Tyler.enter();
        Tyler.goToFloor(3);
        Tyler.goDown();
        Tyler.goToFloor(1);
        Tyler.exit();
    }
}
