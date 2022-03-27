package mobility;

public class Point {
    private int x;
    private int y;

    static private final int xmax = 800,ymax=600,xmin=0,ymin=0;

    public Point(int x, int y) {
        if((xmin<=x && x<=xmax)&&(ymin<=y && y<=ymax))
        {
            this.x=x;
            this.y=y;
        }
        else{
            this.x = 0;
            this.y =0;
        }
    }
    public boolean setpoint(int x,int y)
    {
        if((xmin<=x && x<=xmax)&&(ymin<=y && y<=ymax))
        {
            this.x=x;
            this.y=y;
            return true;
        }
        return false;
    }
    public int getx()
    {
        return this.x;
    }

    public int gety()
    {
        return this.y;
    }

    public static boolean checkBoundaries(Point pointToCheck){
        return (xmin<= pointToCheck.getx() && pointToCheck.getx()<=xmax)&&(ymin<= pointToCheck.gety() && pointToCheck.gety() <=ymax);
    }
}
