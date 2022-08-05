package example;

abstract public class animal {
    protected String name,type;

    public animal(String name,String type){
        this.name = name;
        this.type = type;
    }

    abstract void move();

    public String toString(){return "I'm "+name+",is "+type;}
}
