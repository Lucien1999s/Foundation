package ttu.animal;

public class brontosaurus extends animal{
    int heights = (int) (Math.random()*(600+500+1))+500;
    public brontosaurus(String name,String type){
        super(name, type);
    }
    public brontosaurus(){
        super("哥吉拉","brontosaurus");
    }
    int height(){
        return heights;
    }
    public String toString(){
        return "I'm "+name+",is "+type+",height = "+heights+" cm";
    }
}

