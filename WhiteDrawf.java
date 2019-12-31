// Written by Patel710 and Moha0825

public class WhiteDrawf extends Star {
    public WhiteDrawf(String name, double mass, double size){
        super(name, mass, size);
    }
    public boolean isBlackHole(){
        return false;
    }
    public String toString(){
        return "< " + super.getName() + " > : A WhiteDwarf with mass = < " +
                super.getMass() + " > KG and size = < " + super.getSize() + "> miles.";
    }
}
