/*package DesignPatterns;

import java.util.Vector;

public class Observable {
    Vector<Observer> list;
    public void registerObserver(Observer ob){list.add(ob); }
    public void unregisterObserver(Observer ob){ list.remove(ob);}

    private void notifyObservers(){
        for(Observer ob : list)
            ob.notify ();
    }
}
*/