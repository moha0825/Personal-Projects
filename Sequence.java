// Written by Patel710 and Moha0825

public class Sequence extends Star{
    public Sequence(String name, double mass, double size){
        super(name, mass, size);
    }
    public boolean isSun(){
        if (super.getMass() == 2 && super.getSize() == 430){
            return true;
        }
        else{
            return false;
        }
    }
    public String toString(){
        return "< " + super.getName() + " >: A Sequence Star with mass = < " + super.getMass() +
                " > KG; Size = < " + super.getSize() + " > miles";
    }
    public boolean isBlackHole(){
        if (super.getMass() > 1000 && super.getSize() < 50){
            return true;
        }
        else{
            return false;
        }
    }
}
