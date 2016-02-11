
public class Voronoi {
	
	public static double pointDist(Point2D point1, Point2D point2) {
        // ADD CODE HERE
    	int x1 = point1.getX();
    	int y1 = point1.getY();
    	int x2 = point2.getX();
    	int y2 = point2.getY();
    	int xs = (x1-x2)*(x1-x2);
    	int ys = (y1-y2)*(y1-y2);
    	return Math.sqrt(ys+xs);
    }

    public static int findClosestPoint(Point2D point, Point2D[] sites) {
        int returnIndex = -1;
    	double tempDist = 20000 ;
    	for(int i =0; i <sites.length;i++){
    		if(pointDist(point,sites[i]) < tempDist){
    			tempDist = pointDist(point,sites[i]);
    			returnIndex = i;
    		}
    	}
    	return returnIndex;
    }

    public static int[][] buildVoronoiMap(Point2D[] sites, int width, int height) {
        int[][] indexmap = new int[width][height];
        for(int i =0; i<width;i++){
        	for(int j=0; j<height;j++){
        		Point2D cell = new Point2D(i,j);
        		indexmap[i][j] = findClosestPoint(cell, sites);
        	}
        }
        return indexmap;
    }

	
}
