import java.util.Arrays;

public class Testing {


    public static void main(String[] args) {

//        TestObj testObj = new TestObj("First");
//        updateName(testObj);
//
//        System.out.println(testObj.name);
//
//        int c1 = 12;
//        int c2 = 23;
//        int c3 = 1234;
//
//        System.out.printf("%-22s%-22s%-22s\n", "Column 1", "Column 2", "Column 3");
//        System.out.printf("%-22d%-22d%-22d\n", c1, c2, c3);
        double dimension = 5;

        double[] center = new double[]{dimension/2, dimension/2};//center of grid
        double[] coordObj = new double[]{3,3};//coord of obj on grid

        double[] initObj = new double[]{-13.2, 2};//coord of initObj
        double slope = getSlope(center, coordObj);

        double distance  = getDistance(center, coordObj);
        System.out.println("Center: " +  Arrays.toString(center) + "    CoordObj: " + Arrays.toString(coordObj));
        System.out.println("Distance: " + distance);

        double[] newCoord = getNewCoord(coordObj, slope, distance);
        double[] newCoord2 = getNewCoord(initObj, slope, distance);
        System.out.println( " New CoordObj: " + Arrays.toString(newCoord));
        System.out.println( " New CoordObj2: " + Arrays.toString(newCoord2));

        double distanceNewObj  = getDistance(initObj, newCoord2);
        System.out.println("Center: " +  Arrays.toString(initObj) + "    CoordObj: " + Arrays.toString(newCoord2));
        System.out.println("Distance: " + distanceNewObj);


    }


    public static void updateName(TestObj testObj) {
        testObj.name = "NotFirst";
        testObj = new TestObj("Third");
    }

    static final int x = 0;
    static final int y = 1;
    private static double getSlope(double[] center, double[] coordObj){

        double m = (coordObj[y] - center[y]) / (coordObj[x] - center[x]);
        return m;
    }

    private static double[] getNewCoord(double[] currentCoord, double slope, double distance){
        //y=mx+b
        double r = Math.sqrt((1 + Math.pow(slope,2)));
        double newY = currentCoord[y] + (distance * slope / r);
        double newX = currentCoord[x] + (distance/r);
        return new double[]{newX, newY};
    }

    private static double getDistance(double[] firstCoord, double[] secondCoord){
        double xDif = Math.pow((secondCoord[x] - firstCoord[x]),2);
        double yDif = Math.pow((secondCoord[y] - firstCoord[y]),2);
        return Math.sqrt( yDif +  xDif);
    }
}
