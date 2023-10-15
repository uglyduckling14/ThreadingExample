package org.example;

public class Main {
    public static void main(String[] args) {

        TaskQueue task = new TaskQueue();
        ResultTable table = new ResultTable();

        int numOfThreads = Runtime.getRuntime().availableProcessors();
        for(int i=0; i< numOfThreads; i++){
            WorkerThread thread = new WorkerThread(task, table);
            thread.start();
        }
    }
}