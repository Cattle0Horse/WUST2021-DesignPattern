package homework.strategy;


public class Client {
    public static void main(String[] args) {
        Book cs = new Book("计算机", 100.0, new ComputerDiscount());
        Book en = new Book("英语", 288.9, new EnglishDiscount());
        System.out.println(cs.getName() + " 折扣前:" + cs.getPrice() + " 折扣后:" + cs.getDiscountedPrice());
        System.out.println(en.getName() + " 折扣前:" + cs.getPrice() + " 折扣后:" + en.getDiscountedPrice());
    }
}

class Book {
    private String name;
    private Double price;
    private Discount discount;

    public Book(String name, Double price, Discount discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public double getDiscountedPrice() {
        return discount.compute(price);
    }
}

interface Discount {
    double compute(Double price);
}

class ComputerDiscount implements Discount {
    @Override
    public double compute(Double price) {
        return price * 0.7;
    }
}

class EnglishDiscount implements Discount {
    @Override
    public double compute(Double price) {
        return price * 0.6;
    }
}