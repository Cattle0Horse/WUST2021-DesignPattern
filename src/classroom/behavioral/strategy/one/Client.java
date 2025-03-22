package classroom.behavioral.strategy.one;

/**
 * @author : Cattle_Horse
 * @date : 2023/11/3 15:25
 * @description : 策略模式课堂练习
 */
public class Client {
    public static void main(String[] args) {
        MovieTicket mt = new MovieTicket();
        double originalPrice = 60.0;
        double currentPrice;
        mt.setPrice(originalPrice);
        System.out.println("originalPrice = " + originalPrice);
        System.out.println("---------------------");

        Discount discount = new ChildrenDiscount();
        mt.setDiscount(discount);
        currentPrice = mt.getPrice();
        System.out.println("currentPrice = " + currentPrice);
    }
}

interface Discount {
    /**
     * 计算票价
     *
     * @param price 折扣前票价
     * @return 折扣后票价
     */
    double calculate(double price);
}

class MovieTicket {
    double price;
    Discount discount;

    public double getPrice() {
        if (discount == null) {
            return price;
        }
        return discount.calculate(price);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}

class StudentDiscount implements Discount {
    @Override
    public double calculate(double price) {
        System.out.println("学生票");
        return price * 0.8;
    }
}

class VIPDiscount implements Discount {
    @Override
    public double calculate(double price) {
        System.out.println("VIP票");
        return price * 0.5;
    }
}

class ChildrenDiscount implements Discount {
    @Override
    public double calculate(double price) {
        System.out.println("儿童票");
        return price - 10;
    }
}