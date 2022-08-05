package ttu.animal;

public  class elephant extends animal {
    int heights =(int) (Math.random()*(350-320+1))+320;
    public elephant(String name,String type){
        super(name, type);
    }
    public elephant(){
        super("你的鼻子怎麼那麼長","elephant");
    }
    int height(){
        return heights;
    }
    public String toString(){
        return "I'm "+name+",is "+type+",height = "+heights+" cm";
    }
}
