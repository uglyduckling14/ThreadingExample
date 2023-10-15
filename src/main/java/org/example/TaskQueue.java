package org.example;

import java.util.ArrayList;
import java.util.LinkedList;

import static java.util.Collections.shuffle;

public class TaskQueue {
    private LinkedList<Task> taskQueue;
    private int numDigits;
    private int numDots;

    public TaskQueue(){
        this.taskQueue = new LinkedList<Task>();
        prepopulate();
    }

    private void prepopulate(){
        ArrayList<Integer> randomTime = randomize();
        for(int i = 1; i<=1000; i++){
            Task task = new Task(i, randomTime.get(i));
            enqueue(task);
        }
    }

    private ArrayList<Integer> randomize(){
        ArrayList<Integer> randomTime = new ArrayList<Integer>(1002);
        for(int i = 1; i<= 1001; i++){
            randomTime.add(i);
        }
        shuffle(randomTime);
        return randomTime;
    }

    public void enqueue(Task task){
        synchronized (task){
            taskQueue.add(task);
        }
    }

    public synchronized Task dequeue(){
        if(!taskQueue.isEmpty()){
            if(numDigits<9){
                numDigits++;
            }else{
                System.out.print(".");
                numDigits=0;
                numDots++;
            }
            if(numDots>19){
                System.out.println();
                numDots=0;
            }
            return taskQueue.removeFirst();
        } else {
            return null;
        }
    }

    public synchronized boolean isEmpty(){
        return taskQueue.isEmpty();
    }
}

class Task{
    public int priority;
    public int digit;

    public Task(int digit, int priority){
        this.digit = digit;
        this.priority = priority;
    }
}
