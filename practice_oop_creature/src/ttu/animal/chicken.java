package ttu.animal;

public class chicken extends animal{
    int heights = (int) (Math.random()*(60+30+1))+30;
    public chicken(String name,String type){
        super(name, type);
    }
    public chicken(){
        super("畜生","chicken");
    }
    int height(){
        return heights;
    }
    public String toString(){
        return "I'm "+name+",is "+type+",height = "+heights+" cm";
    }
}

