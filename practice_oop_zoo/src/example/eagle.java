package example;

public class eagle extends bird implements flyer{
    public eagle(String name,String type){
        super(name, type);
    }
    public eagle(){
        super("god","eagle");
    }
    public String toString(){
        return "I'm "+name+",is "+type;
    }
}
