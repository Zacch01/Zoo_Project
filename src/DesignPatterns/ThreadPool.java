package DesignPatterns;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import animals.*;

public class ThreadPool {
    private Executor executor;
    final int NUMBER_OF_ANIMALS = 10;

    public ThreadPool(){
        // Execute ten threads simultaneously
        executor = Executors.newFixedThreadPool (NUMBER_OF_ANIMALS);
    }
    public void addtopoll(Animal animal){
        executor.execute(animal);
    }

    public void end(){
        ((ExecutorService) executor).shutdown();
    }
}
