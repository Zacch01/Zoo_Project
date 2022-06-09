package DesignPatterns;

import graphics.ZooFrame;
import graphics.ZooPanel;
import java.util.Observable;
import java.util.Observer;

public class ZooController extends Thread implements Observer {

    @Override
    public void update(Observable arg0, Object arg1) {
        synchronized (this){
        ZooPanel.getInstance(ZooFrame.getInstance()).manageZoo();}
    }
}
