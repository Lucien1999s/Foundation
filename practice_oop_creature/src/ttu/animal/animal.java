package ttu.animal;

import ttu.sort.ICanCompare;

abstract public class animal implements ICanCompare {
    protected String name,type;

    abstract  int height();
    public animal(String name,String type){
        this.name=name;
        this.type=type;
    }
    public int compare(ICanCompare i){
        animal s = (animal) i;
        return (int)(this.height() - s.height());
    }
    public String toString(){return "I'm "+name+",is "+type;}
}
