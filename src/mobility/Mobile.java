package mobility;

public abstract class Mobile implements Ilocatable {

    private Point location;
    private double totaldistance;

    public Mobile(Point p)
    {
        this.location = new Point(p.getx(),p.gety());
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
        //check distance meaning
        double tmp =this.totaldistance;
        addTotalDistance(calcDistance(p));
        if (!setLocation(p)){
            return 0;
        }
        return (this.totaldistance-tmp);
    }

    public Point getLocation() {
        return this.location;
    }


    public boolean setLocation(Point p) {
        return this.location.setpoint(p.getx(), p.gety());
    }
}
