package main;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap<K, V> {
    private static final int INITIAL_CAPACITY = 5; //initial capacity of the bucket
    private List<MyNode<K, V>> bucket; //bucket array i.e. array of linked list
    private int capacity; //capacity of the bucket
    private int size; //number of elements in the map or the total number of nodes present.
    private static class MyNode<K, V> { //class to store key value pairs.
        K key;
        V value;
        public MyNode(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap(){ //constructor
        bucket = new ArrayList<>();
        capacity = INITIAL_CAPACITY;
        for (int i=0;i<capacity;i++){
            bucket.add(null);
        }
    }

    public void put(K key, V value){

    }

    public boolean containsKey(K key){

    }

    public V get(K key){

    }

    public void remove(K key){

    }

}
