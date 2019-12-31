// Written by Patel710 and Moha0825

public class CelestialDatabase{
    private List<Star> list;
    public CelestialDatabase(String type){
        if (type.equals("array")){
            list = new ArrayList<Star>();
        }
        else if(type.equals("linked")){
            list = new LinkedList<Star>();
        }
    }
    public boolean add(Star s){
        return list.add(s);
    }
    public Star find(String name){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getName().contains(name)) {
                return list.get(i);
            }
        }
        return null;
    }

    public Star findSun(){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) instanceof Sequence){
                Sequence s = (Sequence) list.get(i);
                if (s.isSun()){
                    return s;
                }
            }
        }
        return null;
    }

    public Star remove(int index){
        return list.remove(index);
    }

    public Star get(int index){
        return list.get(index);
    }

    public void sort(){
        list.sort(true);
        // sort the list in order of mass based on compareTo method
    }
    public Star[] getStarsByType(String type){
        Star x [];
        int count = 0;
        for (int i = 0; i < list.size(); i++){
            if(type.equals("redgiant") && list.get(i) instanceof RedGiant){
                count++;
            }else if(type.equals("sequence") && list.get(i) instanceof Sequence){
                count++;
            } else if(type.equals("whitedrawf") && list.get(i) instanceof WhiteDrawf){
                count++;
            }
        }
        x = new Star[count];
        count = 0;
        for (int i = 0; i < list.size(); i++){
            if(type.equals("redgiant") && list.get(i) instanceof RedGiant){
                x[count] = list.get(i);
                count++;

            }else if(type.equals("sequence") && list.get(i) instanceof Sequence){
                x[count] = list.get(i);
                count++;
            } else if(type.equals("whitedrawf") && list.get(i) instanceof WhiteDrawf){
                x[count] = list.get(i);
                count++;
            }
        }
        for(int i = 0; i < x.length; i++){
            System.out.println(x[i]);
        }
        return x;
    }
    public Star[] listBlackHoles(){
        Star x [];
        int count = 0;
        for (int i = 0; i < list.size(); i++){
            if(list.get(i) instanceof RedGiant){
                RedGiant r = (RedGiant) list.get(i);
                if (r.isBlackHole()){
                    count++;
                }
            }
        }
        x = new Star[count];
        count = 0;
        for (int i = 0; i < list.size(); i++){
            if(list.get(i) instanceof RedGiant){
                RedGiant r = (RedGiant) list.get(i);
                if (r.isBlackHole()){
                    x[count] = list.get(i);
                    count++;
                }
            }
        }
        for(int i = 0; i < x.length; i++){
            System.out.println(x[i]);
        }
        return x;
    }
    public Star[] getTopKHeaviestStar(int k){
        Star x [] = new Star[k];
        list.sort(false);
        for (int i = 0; i < k; i++){
            x[i] = list.get(i);
        }
        for(int i = 0; i < x.length; i++){
            System.out.println(x[i]);
        }
        return x;
    }
    public int[] countStars(){
        int[] count = new int[3];
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) instanceof Sequence){
                count[0] += 1;
            }else if(list.get(i) instanceof RedGiant){
                count[1] += 1;
            }else if(list.get(i) instanceof WhiteDrawf){
                count[2] += 1;
            }
        }
        System.out.println("[" + count[0] + "," + count[1] + "," + count[2] + "]");
        return count;
    }
    public String toString(){
        return list.toString();
    }
    public static void main(String[] args){
        Sequence s = new Sequence("Lubna", 30, 50);
        RedGiant r = new RedGiant("Zeel", 40, 70);
        WhiteDrawf w = new WhiteDrawf("Street", 60, 100);
        CelestialDatabase c = new CelestialDatabase("linked");
        System.out.println(c.add(s));
        System.out.println(c.add(r));
        System.out.println(c.add(w));
        System.out.println(c.findSun());
        //System.out.println(c.remove(0));
        System.out.println(c.get(2));
        c.sort();
        c.getStarsByType("sequence");
        c.listBlackHoles();
        c.getTopKHeaviestStar(2);
        c.countStars();
    }


}
