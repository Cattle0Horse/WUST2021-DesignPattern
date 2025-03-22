package classroom.creational.builder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author : Cattle_Horse
 * @date : 2023/11/28 10:31
 * @description : 建造者模式<br>
 * <p>
 * 某快餐厅主要制作并出售儿童套餐，一般包括主餐（各类比萨）、饮料和玩具，其餐品种类可能不同，但其制作过程相同。
 * 前台服务业（Waiter）调度厨师制作套餐。
 */
public class Client {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        waiter.setBuilder(new AComboBuilder());
        System.out.println(waiter.construct());
        System.out.println("----------- BComboBuilder -----------");
        waiter.setBuilder(new BComboBuilder());
        System.out.println(waiter.construct());
    }
}

@ToString
class Pizza {
    String taste;

    public Pizza(String taste) {
        this.taste = taste;
    }
}

@Getter
@Setter
@ToString
class Combo {
    private Pizza pizza;
    private String drink;
    private String toy;
}

abstract class ComboBuilder {
    protected Combo combo = new Combo();

    public abstract void buildPizza();

    public abstract void buildDrink();

    public abstract void buildToy();

    public Combo getCombo() {
        return combo;
    }
}

class AComboBuilder extends ComboBuilder {
    @Override
    public void buildPizza() {
        combo.setPizza(new Pizza("APizza"));
    }

    @Override
    public void buildDrink() {
        combo.setDrink("ADrink");
    }

    @Override
    public void buildToy() {
        combo.setToy("AToy");
    }
}

class BComboBuilder extends ComboBuilder {
    @Override
    public void buildPizza() {
        combo.setPizza(new Pizza("BPizza"));
    }

    @Override
    public void buildDrink() {
        combo.setDrink("BDrink");
    }

    @Override
    public void buildToy() {
        combo.setToy("BToy");
    }
}

class Waiter {
    private ComboBuilder builder;

    public void setBuilder(ComboBuilder builder) {
        this.builder = builder;
    }

    public Combo construct() {
        builder.buildPizza();
        builder.buildDrink();
        builder.buildToy();
        return builder.getCombo();
    }
}