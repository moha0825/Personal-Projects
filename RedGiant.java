// Written by Patel710 and Moha0825

public class RedGiant extends Star {
    public RedGiant(String name, double mass, double size){
        super(name,mass,size);
    }
    public boolean isSuperGiant(){
        if (super.getMass() > 100 && super.getSize() > 100){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean isBlackHole(){
        if (isSuperGiant()){
            return true;
        }
        else{
            return false;
        }
    }
    public String toString(){
        if (isSuperGiant()){
            return "< " + super.getName() + " >: A SuperGiant with mass = < " + super.getMass() +
                    " > KG and size = < " + super.getSize() + " > miles";
        }
        else{
            return "< " + super.getName() + " >: A RedGiant with mass = < " + super.getMass() +
                    " > KG and size = < " + super.getSize() + " > miles";
        }
    }
}
