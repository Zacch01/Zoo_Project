package animals;

import diet.Herbivore;
import mobility.Point;
import utilities.MessageUtility;

public class Giraffe extends Animal{
    private double neckLength;

    public Giraffe(String name){
        super(name,new Point(50,0));
        setWeight(450);
        this.neckLength = 1.5;
        setdiet(new Herbivore());
    }

    public Giraffe(String name,Point p){
        super(name,new Point(p.getx(), p.gety()));
        setWeight(450);
        this.neckLength = 1.5;
        setdiet(new Herbivore());
    }

    public void chew(){
        MessageUtility.logSound(getName(),"Bleats and Stomps its legs, then chews");
    }

    public String roar_or_chew(){
        return "Chew";
    }

    public boolean setNeckLength( double lenght)
    {
        if (lenght<=2.5 && lenght>=1)
        {
            this.neckLength = lenght;
            return true;
        }
        return false;
    }
}
