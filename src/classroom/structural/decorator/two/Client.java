package classroom.structural.decorator.two;

/**
 * @author : Cattle_Horse
 * @date : 2023/10/31 10:47
 * @description : 装饰模式课堂练习2
 */
public class Client {
    public static void main(String[] args) {
        Order order = new Coffee();
        System.out.println("order.getDescription() = " + order.getDescription());
        System.out.println("order.cost() = " + order.cost());
        System.out.println("------------------------------------------------------");

        System.out.println("加一份牛奶");
        order = new Milk(order);
        System.out.println("order.getDescription() = " + order.getDescription());
        System.out.println("order.cost() = " + order.cost());
        System.out.println("------------------------------------------------------");


        System.out.println("加一份巧克力");
        order = new Chocolate(order);
        System.out.println("order.getDescription() = " + order.getDescription());
        System.out.println("order.cost() = " + order.cost());
        System.out.println("------------------------------------------------------");

        System.out.println("加一份巧克力");
        order = new Chocolate(order);
        System.out.println("order.getDescription() = " + order.getDescription());
        System.out.println("order.cost() = " + order.cost());
        System.out.println("------------------------------------------------------");
    }
}

/**
 * 订单抽象类
 */
abstract class Order {
    private String description;
    private double price;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * 计算花费
     *
     * @return double类型 花费
     */
    public abstract double cost();
}

class Coffee extends Order {
    public Coffee() {
        setPrice(5.0);
        setDescription("咖啡");
    }

    @Override
    public double cost() {
        return getPrice();
    }
}

/**
 * 装饰抽象类
 */
abstract class Decorator extends Order {
    protected Order order;

    public Decorator(Order order) {
        this.order = order;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " " + super.getPrice() + " && " + order.getDescription();
    }
}

class Milk extends Decorator {
    public Milk(Order order) {
        super(order);
        setPrice(2.0);
        setDescription("牛奶");
    }

    @Override
    public double cost() {
        return super.getPrice() + order.cost();
    }
}

class Chocolate extends Decorator {
    public Chocolate(Order order) {
        super(order);
        setPrice(3.0);
        setDescription("巧克力");
    }

    @Override
    public double cost() {
        return super.getPrice() + order.cost();
    }
}
