/*package DesignPatterns;

import graphics.ZooFrame;
import graphics.ZooPanel;

import java.util.Observable;


public class ZooController extends Thread implements Observer {
    public void run()
    {
        notify();
    }


    @Override
    public void notify()
    {
        while(true)
            ZooPanel.getInstance(ZooFrame.getInstance()).manageZoo();
    }
}*/

package DesignPatterns;

import graphics.ZooFrame;
import graphics.ZooPanel;
import java.util.Observable;
import java.util.Observer;

public class ZooController extends Thread implements Observer {

    @Override
    public void update(Observable arg0, Object arg1) {
        ZooPanel.getInstance(ZooFrame.getInstance()).manageZoo();
    }
}
