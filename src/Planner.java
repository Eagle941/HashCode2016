
public class Planner {
    //0. Parse and instantiate
	int width;
	int height;
	Point2D[] warehouses;
    //1. Divide map into voronoi regions
	int[][] map = Voronoi.buildVoronoiMap(warehouses, width, height);
    //2. Sort areas by number of orders that need to be delivered there
    //3. Send drones to warehouse in order (one to each or as many as necessary?)
    //4. Each drone will load as many products as it can for houses that are close by each other
    // (but we prefer a single drone to fill out one order)
    //5. Deliver to the house in order of distance from warehouse
    //6. Go to next closest warehouse with the most orders to be fulfilled in that area

    public static void main(String[] args){
        System.out.println("Hello world");
    }
}