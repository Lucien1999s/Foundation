package ttu.animal;

public class tiger extends animal{
    int heights = (int) (Math.random()*(110-80+1))+80;
    public tiger(String name,String type){
        super(name, type);
    }
    public tiger(){
        super("喵喵","tiger");
    }
    int height(){
        return heights;
    }
    public String toString(){
        return "I'm "+name+",is "+type+",height = "+heights+" cm";
    }
}
