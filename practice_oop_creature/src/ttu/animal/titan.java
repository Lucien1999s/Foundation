package ttu.animal;

public class titan extends animal{
    int heights = (int) (Math.random()*(6000-800+1))+800;
    public titan(String name,String type){
        super(name, type);
    }
    public titan(){
        super("鎧之巨人","titan");
    }
    int height(){
        return heights;
    }
    public String toString(){
        return "I'm "+name+",is "+type+",height = "+heights+" cm";
    }
}
