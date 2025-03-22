package homework.bridge;

/**
 * @author : Cattle_Horse
 * @date : 2023/11/11 20:49
 * @description :
 */
public class Client {
    public static void main(String[] args) {
        Coffee coffee = new JorumCoffee();
        coffee.setTaste(new Lemon());
        System.out.println(coffee.display());
        coffee.setTaste(new Milk());
        System.out.println(coffee.display());
    }
}

interface Taste {
    String display();
}

class Sugar implements Taste {
    @Override
    public String display() {
        return this.getClass().getSimpleName();
    }
}

class Milk implements Taste {
    @Override
    public String display() {
        return this.getClass().getSimpleName();
    }
}

class Lemon implements Taste {
    @Override
    public String display() {
        return this.getClass().getSimpleName();
    }
}

abstract class Coffee {
    Taste taste;

    public String display() {
        return taste.display();
    }

    public void setTaste(Taste taste) {
        this.taste = taste;
    }
}

class SmallCoffee extends Coffee {
    @Override
    public String display() {
        return this.getClass().getSimpleName() + " add " + super.display();
    }
}

class MediumCoffee extends Coffee {
    @Override
    public String display() {
        return this.getClass().getSimpleName() + " add " + super.display();
    }
}

class JorumCoffee extends Coffee {
    @Override
    public String display() {
        return this.getClass().getSimpleName() + " add " + super.display();
    }
}
