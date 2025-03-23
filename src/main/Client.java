package main;

public class Client {
    public static void main(String[] args) {

        MyHashMap<Integer, String> map = new MyHashMap<>();
        map.put(3, "Jim");
        map.put(3, "Ved");
        map.put(6, "Dwight");
        map.put(5, "Kevin");
        map.put(3, "Pam");
        map.put(4, "Alex");
        map.put(1, "X");
        map.put(4, "Meta");
        map.put(5, "Maeve");

        System.out.println(map.get(3));
        System.out.println(map.get(6));
        System.out.println(map.get(5));
        System.out.println(map.get(50));
        System.out.println(map.containsKey(44));
        System.out.println(map.containsKey(3));
        map.remove(6);
        System.out.println(map.get(6));
        System.out.println(map.size());
    }
}
