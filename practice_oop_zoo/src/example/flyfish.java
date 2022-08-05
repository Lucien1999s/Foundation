package example;

public class flyfish extends fish implements swimmer,flyer{
    public flyfish(String name,String type){
        super(name,type);
    }
    public flyfish(){
        super("Tommy","flyfish");
    }
    public String toString(){
        return "I'm "+name+",is "+type;
    }
    public void fly(){
        System.out.println("I'm "+name+",I am a flyer.");
    }
}
