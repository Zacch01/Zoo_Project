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
}
