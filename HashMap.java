import sun.awt.SunHints;

import java.sql.SQLOutput;
import java.util.Arrays;

public class HashMap<K,V> implements Map<K,V> {
private Entry[] list;
private int size = 0; // REMEMBER SIZE IS OF ZERO
//  This constructor will create an array of the specified length.
    public HashMap(int buckets){
        list = new Entry[buckets];
    }

//    This constructor will create a default base array of length 64.
    public HashMap(){
        list = new Entry[64];
    }

    public void display(){ // This is the display for the map
        String s = "";
        if(size == 0){ // If the display is a size of zero
            System.out.println("{}");
        }
        else if (size == 1){ // If the display is a size of one
            System.out.println( "{" + list[0].getKey() + ": " + list[0].getValue() + "}");
        }
        else{ // If the display is of any size
            for(int i = 0;i < list.length - 1; i++){
                if(list[i] != null){
                    Entry<K,V> curr = list[i];
                    while(curr != null){
                        s += curr.getKey() + ": " + curr.getValue() + ", ";
                        curr = curr.getNext();
                    }
                }
            }
            System.out.println("{" + s.substring(0,s.length()-2) + "}"); // substring is removing the extra comma at the end
        }
    }
    private int hash(K key){  // Maybe think of a better hash function
        String s = String.valueOf(key);
        char[] chars = s.toCharArray();
        int total = 0;
        for(char ch : chars){
            total += (int)ch;
        }
        return total;
    }
    @Override
    public void clear() { // Works!
        Arrays.fill(list, null);
        size = 0;
    }
    // This method returns true if the Map contains a mapping for the specified key,
    // and false otherwise.
    @Override
    public boolean containsKey(K key) {  // Checks to see if the text contains the key looked for in the textscan file
        int index = hash(key) % list.length;
        if (!list[index].getKey().equals(key)){
            return false;
        }
        return true;
    }
    // This method returns true if the Map contains a mapping for the specified value,
    // and false otherwise.
    @Override
    public boolean containsValue(V value) { // Checks to see if the text contains the value looked for in textscan file
        // int index =  % list.length;
        while(size != 0){
            if(list[value].getValue().equals(value)) {
                return true;
        }
        return false;
        // for(int i = 0; i < list.length; i++){
           //if(list[i].getValue().equals(value)){
             //   return true;
        // }
        // return Boolean.parseBoolean(null);
    }
    // This method returns the value to which the specified key is mapped.
    // If the Map does not contain the specified key, the method instead returns null.
    @Override
    public V get(K key) { // Works!
        int index = hash(key) % list.length;
        if(this.containsKey(key)){
            return (V) list[index].getValue();
        }
        else{
            return null;
        }
    }

    @Override
    public boolean isEmpty() { // CHECKS IF THE DISPLAY IS EMPTY
        if(size == 0){
            return true;
        }
        return false;
    }
    // This method associates the specified key with the specified value in the Map
    // and returns the newly associated value,
    // if the specified key is not already associated with a non-null value.
    // If the specified key is already associated with a non-null value,
    // the association is left unchanged, and the current value is returned instead.
    @Override
    public V put(K key, V value) {
        Entry<K,V> entry = new Entry(key, value, null);
        int index= hash(key) % list.length;
        Entry<K,V> exist = list[index];
        if(exist == null){           //if no key already exists
            list[index] = entry;      //add key to list at index
            size++;
        }
        else{
            while(exist.getNext() != null){
                if(exist.getKey().equals(key)){
                    exist.setValue(value);
                    return value;
                }
                exist = exist.getNext();                  // Don't return duplicates
            }
            if(exist.getKey().equals(key)){
                return value;
            }
            else{
                exist.setNext(entry);
                size++;
            }
        }
        return null;
    }
    // This method removes and returns the mapping for the specified key in the Map
    // if it is present, and returns null otherwise.
    @Override
    public V remove(K key) {
        int index = hash(key) % list.length;
        if (list[index] != null){
            Entry curr = list[index];
            while(curr!=null){
                if(curr.getKey().equals((key))){
                    V rem = (V) curr.getValue();
                    curr.setValue(null);
                    return rem;
                }
                curr = curr.getNext();
            }
        }
        return null;
    }
//    If the specified key is already mapped to a value, this
//    method will return the previous value associated with the key and replace it will the input
//    value. If the specified key is not mapped to a value, this method will simply return null,
//    altering nothing in the HashMap.
    @Override
    public V replace(K key, V value) {  //Works, but need to check edge cases.
        int index = hash(key) % list.length;
        if(list[index].getValue()!= null){
            V prev = (V) list[index].getValue();
            list[index].setValue(value);
            return prev;
        }
        else{
            return null;
        }
    }

    @Override
    public int size() {
        return size;
    }
}
