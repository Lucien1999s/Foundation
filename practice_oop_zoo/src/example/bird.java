package example;

public class bird extends animal implements flyer{
    public bird(String name,String type){
        super(name,type);
    }
    public bird(){
        super("Lucifer","bird");
    }
    public void move(){
        System.out.println("I'm "+name+",I can fly");
    }
    public String toString(){
        return "I'm "+name+",is "+type;
    }
    public void fly(){
        System.out.println("I'm "+name+",I am a flyer.");
    }
}
