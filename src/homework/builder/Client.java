package homework.builder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author : Cattle_Horse
 * @date : 2023/11/11 18:16
 * @description :
 */
public class Client {
    public static void main(String[] args) {
        Director director = new Director();
        director.setBuilder(new BenZBuilder());
        System.out.println(director.buildCar());
    }
}

@Getter
@Setter
@ToString
class Car {
    String wheel;
    String oilBox;
    String body;
}

abstract class Builder {
    protected Car car = new Car();

    public abstract void buildWheel();

    public abstract void buildOilBox();

    public abstract void buildBody();

    public Car getCar() {
        return car;
    }
}

class BMWBuilder extends Builder {
    @Override
    public void buildWheel() {
        car.setWheel("BMW Wheel");
    }

    @Override
    public void buildOilBox() {
        car.setOilBox("BMW OilBox");
    }

    @Override
    public void buildBody() {
        car.setBody("BMW Body");
    }
}

class BenZBuilder extends Builder {
    @Override
    public void buildWheel() {
        car.setWheel("Benz Wheel");
    }

    @Override
    public void buildOilBox() {
        car.setOilBox("Benz OilBox");
    }

    @Override
    public void buildBody() {
        car.setBody("Benz Body");
    }
}

class Director {
    private Builder builder;

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public Car buildCar() {
        builder.buildBody();
        builder.buildWheel();
        builder.buildOilBox();
        System.out.println(builder.getClass().getName() + " create car");
        return builder.getCar();
    }
}