package example;

public class waterplane implements flyer,swimmer {
    protected String name,type;
    public waterplane(String name,String type){
        this.name = name;
        this.type = type;
    }
    public waterplane(){
        this.name="PBY Catalina";
        this.type="waterplane";
    }
    public String toString(){
        return "I'm "+name+",is a "+type;
    }
    public void fly(){
        System.out.println("I'm "+name+",I am a flyer.");
    }
    public void swim(){
        System.out.println("I'm "+name+",I am a swimmer.");
    }
}
