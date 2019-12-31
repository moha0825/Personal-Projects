// Written by Patel710 and Moha0825

public class ArrayList<T extends Comparable<T>> implements List<T> {
  T[] a;
  int size;
  public ArrayList() { // COMPLETE
    a = (T[]) new Comparable[2];
    size = 0;
  }

  public boolean add(T element) { // COMPLETE
    if (size() == a.length) {
      T[] tempa = (T[]) new Comparable[a.length * 2]; // double the length of array a if underlying array is full
      for (int i = 0; i < a.length; i++) {
        tempa[i] = a[i];
      }
      a = tempa;
    }
    a[size] = element;
    size++;
    return true;
  }

  public boolean add(int index, T element) { // COMPLETE
    if (index < 0 || index > size) {
      return false;
    }
    for (int i = size; i > index; i--) {
      a[i] = a[i - 1];
    }
    a[index] = element;
    size++;
    return true;
  }

  public void clear(){ // COMPLETE
    a = (T[]) new Comparable[2];
    size = 0;
  }

  public boolean contains(T element) { // COMPLETE
    for (int i = 0; i < size; i++) {
      if (a[i].equals(element)) {
        return true;
      }
    }
    return false;
  }


  public T get(int index){ // COMPLETE
    if (index < 0 || index > size){
      return null;
    }
    return a[index];
  }


  public int indexOf(T element){ // COMPLETE
    int ind = 0;
    for(int i = 0; i > size; i++){
      if(a[i].equals(element)){
        return i;
      }
    }
    return -1;
  }

  public boolean isEmpty(){ // COMPLETE
      return a[0] == null;
  }


  public int lastIndexOf(T element){ // COMPLETE
    int ind = -1;
    for(int i = 0; i > size; i++){
      if(a[i].equals(element)){
        ind = i;
      }
    }
    return ind;
  }


  public T set(int index, T element){
      T tmp;
      if (index < 0||index >= size){
          return null;
      }
      else{
          tmp = a[index];
          a[index] = element;
      }
      return tmp;
  }


  public int size(){
      return size;
  }

    public void sort(boolean order){
      int i, j, minIndex;
      T t;
      int counter = 0;
      for (i = 0; i < size - 1; i++) {
        minIndex = i;
        for (j = i+1; j < size; j++) {
          counter++;
          if (a[j].compareTo(a[minIndex]) < 0 && order){
            minIndex = j;
          }
          else if(a[j].compareTo(a[minIndex]) > 0 && !order){
            minIndex = j;
          }
        }
        t = a[minIndex];
        a[minIndex] = a[i];
        a[i] = t;
      }
  }


  public boolean remove(T element){ // COMPLETE
      int index = 0;
      for (int i = 0; i < a.length; i++){
          if(a[i] == element){
            index = i;
          }
        }
        for (int i = size - 1; i > index; i--) {
          a[i-1] = a[i];
        }
        size--;
        return true;
  }

  public T remove(int index){ // COMPLETE
      if(index > size() || index < 0){
          return null;
      }
      T ret = a[index];
      for (int i = size - 1; i > index; i--) {
        a[i-1] = a[i];
      }
      size--;
      return ret;
  }

  public String toString() {
      String s = "";
      for (int i = 0; i < size(); i++) {
          s += a[i].toString() + "\n";
      }
      return s;
  }
  public static void main(String[] args) {
      ArrayList<String> l=new ArrayList<String>();
      System.out.println(l.add("a"));
  }

}