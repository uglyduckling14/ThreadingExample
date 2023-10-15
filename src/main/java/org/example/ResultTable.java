package org.example;

import java.util.HashMap;

public class ResultTable {
    private HashMap<Integer, Integer> result;

    public ResultTable(){
        result = new HashMap<>();
    }

    public void add(int key, int value){
        synchronized (result){
            result.put(key, value);
        }
    }

    public int getVal(int key){
        synchronized (result){
            return result.get(key);
        }
    }
}
