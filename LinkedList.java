// Written by Patel710 and Moha0825

public class LinkedList<T extends Comparable<T>> implements List<T> {
    NGen<T> head;
    int size;
    public LinkedList() { // COMPLETE
        head = null;
        size = 0;
    }

    public boolean add(T element) { // COMPLETE
        if (head == null){
            head = new NGen<T>(element, null);
            // return true;
        }
        else{
            NGen<T> curNode = head;
            while (curNode.getNext()!=null){
                curNode = curNode.getNext();
            }
            curNode.setNext(new NGen<T>(element,null));
        }
        size++;
        return true;
    }

    public boolean add(int index, T element) { // COMPLETE
        int count = 0;
        NGen<T> curNode = head;
        for(int i = 0; i <size; i++){
            if (index == i+1){
                NGen<T> next = curNode.getNext();
                curNode.setNext(new NGen<T>(element,next));
                size++;
                return true;
            }
            curNode = curNode.getNext();
        }
        return false;
    }


    public void clear(){ // COMPLETE
        head = null;
        size = 0;
    }

    public boolean contains(T element) { // COMPLETE
        NGen<T> curNode = head;
        for (int i = 0; i < size; i++) {
            if (curNode.getData().equals(element)) {
                return true;
            }
            curNode = curNode.getNext();
        }
        return false;
    }

    public T get(int index){ // COMPLETE
        NGen<T> curNode = head;
        for(int i = 0; i < size; i++){
            if (index == i){
                return curNode.getData();
            }
            curNode = curNode.getNext();
        }
        return null;
    }

    public int indexOf(T element){ // COMPLETE
        NGen<T> curNode = head;
        int i=0;
        while (curNode!=null){
            if(curNode.getData().equals(element)){
                return i;
            }
            i++;
            curNode = curNode.getNext();
        }
        return -1;
    }

    public boolean isEmpty(){ // COMPLETE
        return head == null;
    }

    public int lastIndexOf(T element){ // COMPLETE
        int ind = -1;
        NGen<T> curNode = head;
        for(int i = 0; i > size; i++){
            if(curNode.getData().equals(element)){
                ind = i;
            }
            curNode = curNode.getNext();
        }
        return ind;
    }

    public T set(int index, T element){ // COMPLETE
        T tmp =null;
        NGen<T> curNode = head;
        int count = 0;
        if (head == null){
            return null;
        }
        else{
            while(curNode!=null){
                if(index == count){
                    tmp = curNode.getData();
                    curNode.setData(element);
                }
                count++;

            }
        }
        return tmp;
    }

    public int size(){ // COMPLETE
        int currIndex = 0;
        NGen<T> curNode = head;
        while (curNode != null){
            curNode = curNode.getNext();
            currIndex += 1;
        }
        return currIndex;
    }

    public void sort(boolean order){
        int i, j;
        NGen<T> minIndex, runner;
        NGen<T> curNode = head;
        T t;
        int counter = 0;
        for (i = 0; i < size - 1; i++) {
            minIndex = curNode;
            runner = curNode.getNext();
            for (j = i+1; j < size; j++) {
                if (runner.getData().compareTo(minIndex.getData()) < 0 && order){
                    minIndex = runner;}
                else if(runner.getData().compareTo(minIndex.getData()) > 0 && !order){
                    minIndex = runner;
                }
                runner = runner.getNext();
            }
            t = curNode.getData();
            curNode.setData(minIndex.getData());
            minIndex.setData(t);
            curNode = curNode.getNext();
        }
    }

    public boolean remove(T element){
        int index = 0;
        NGen<T> curNode = head;
        NGen<T> previous = head;
        if(head.getData().equals(element)){
            head = head.getNext();
            size--;
            return true;
        }
        for(int i = 0; i < size; i++){
            if(curNode.getData().equals(element)){
                previous.setNext(curNode.getNext());
                size--;
                return true;
            }
            previous = curNode;
            curNode = curNode.getNext();
        }
        return false;
    }

    public T remove(int index){
        NGen<T> curNode = head;
        NGen<T> previous = head;
        T t;
        if (index == 0){
            t = head.getData();
            head = head.getNext();
            size--;
            return t;
        }
        for(int i = 1; i < size; i++){
            if (index == i){
                t = curNode.getData();
                previous.setNext(curNode.getNext());
                size--;
                return t;
            }
            previous = curNode;
            curNode = curNode.getNext();
        }
        return null;
    }
    public String toString(){
        String s = "";
        for(int i = 0; i < size(); i++){
            s += get(i);
        }
        return s;
    }
}
