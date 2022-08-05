package example;

public class fish extends animal implements swimmer {
    public fish(String name, String type) {
        super(name, type);
    }

    public fish() {
        super("Mame", "fish");
    }

    public void move() {
        System.out.println("I'm " + name + ",I can swim.");
    }

    public String toString() {
        return "I'm " + name + ",is " + type;
    }

    public void swim() {
        System.out.println("I'm " + name + ",exI am a swimmer");
    }
}
