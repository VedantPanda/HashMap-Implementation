package main;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap<K, V> {
    private static final int INITIAL_CAPACITY = 5; //initial capacity of the bucket
    private List<MyNode<K, V>> bucket; //bucket array i.e. array of linked list
    private int capacity; //capacity of the bucket
    private int size; //number of elements in the map or the total number of nodes present.
    private static class MyNode<K, V> { //class to store key value pairs.
        private final K key;
        private V value;
        private MyNode<K, V> next;
        public MyNode(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap(){ //constructor
        bucket = new ArrayList<>();
        capacity = INITIAL_CAPACITY;
        fillBucketWithCapacity(bucket);
    }

    public void put(K key, V value){ //puts the pair in the map if key is not present else updates the value.
        int bucketIndex = getBucketIndex(key);
        MyNode<K, V> head = bucket.get(bucketIndex);
        while (head!=null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        MyNode<K, V> newNode = new MyNode<>(key, value);
        head = bucket.get(bucketIndex);
        newNode.next = head;
        bucket.set(bucketIndex, newNode);
        double loadFactor = (1.0*size) / capacity;
        System.out.println("Load Factor is "+loadFactor);
        if(loadFactor > 0.7){
            rehash();
        }
    }

    public boolean containsKey(K key){
        int bucketIndex = getBucketIndex(key);
        MyNode<K, V> head = bucket.get(bucketIndex);
        while(head!=null){
            if(head.key.equals(key)){
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public V get(K key){
        int bucketIndex = getBucketIndex(key);
        MyNode<K, V> head = bucket.get(bucketIndex);
        while(head!=null){
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public void remove(K key){
        int bucketIndex = getBucketIndex(key);
        MyNode<K, V> head = bucket.get(bucketIndex);
        MyNode<K, V> prev = null;
        while(head!=null){
            if(head.key.equals(key)){
                if(prev==null){
                    bucket.set(bucketIndex, head.next);
                }
                else{
                    prev.next = head.next;
                }
                size--;
                return;
            }
            prev = head;
            head = head.next;
        }

    }

    public int size(){
        return size;
    }

    private int getBucketIndex(K key){
        return key.hashCode()%capacity;
    }

    private void rehash(){
        System.out.println("Rehashing...");
        List<MyNode<K, V>> temp = bucket;
        bucket = new ArrayList<>();
        capacity *= 2;
        size = 0;
        fillBucketWithCapacity(bucket);
        for (MyNode<K, V> head : temp) {
            while (head != null) {
                put(head.key, head.value);
                head = head.next;
            }
        }
    }

    private void fillBucketWithCapacity(List<MyNode<K, V>> bucket){
        for (int i=0;i<capacity;i++){
            bucket.add(null);
        }
    }

}
