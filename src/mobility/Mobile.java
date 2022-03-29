package mobility;

public abstract class Mobile implements Ilocatable {

    private Point location;
    private double totaldistance;

    public Mobile(Point p)
    {
        setLocation(p);
        this.totaldistance = 0;
    }

    public void addTotalDistance(double d)
    {
        this.totaldistance+=d;
    }

    public double calcDistance(Point p)
    {
        return Math.sqrt(Math.pow(getLocation().getx() - p.getx(), 2) + (Math.pow(getLocation().gety() - p.gety(), 2)));
    }
    public double move(Point p)
    {
        double distance = calcDistance(p);
        if (setLocation(p)) {
            addTotalDistance(distance);
            return distance;
        }
        return 0;
    }

    public Point getLocation() {
        return this.location;
    }


    public boolean setLocation(Point p) {
        if (Point.checkBoundaries(p)) {
            this.location = new Point(p);
            return true;
        }
        return false;
    }
}
