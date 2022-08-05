package ttu.animal;

public class giraffe extends animal{
    int heights = (int) (Math.random()*(550+500+1))+500;
    public giraffe(String name,String type){
        super(name, type);
    }
    public giraffe(){
        super("輕舞飛揚","giraffe");
    }
    int height(){
        return heights;
    }
    public String toString(){
        return "I'm "+name+",is "+type+",height = "+heights+" cm";
    }
}