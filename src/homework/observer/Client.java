package homework.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client {
    public static void main(String[] args) {
        Product p = new Product("小米手机", 5999.99);
        p.addObserver(Product.NAME, o -> System.out.println("改名了"));
        p.addObserver(Product.PRICE, o -> System.out.println("变价了"));
        p.setName("小米12 Ultra");
        p.setPrice(49999.99);
    }
}

class Product {
    public static final String NAME = "Name";
    public static final String PRICE = "Price";

    private String name;
    private Double price;
    private Map<String, List<Observer>> observerMap = new HashMap<>(2) {{
        put(NAME, new ArrayList<>());
        put(PRICE, new ArrayList<>());
    }};

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
        notifyObserver(NAME);
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObserver(PRICE);
    }

    void notifyObserver(String key) {
        List<Observer> observers = observerMap.getOrDefault(key, null);
        if (observers == null) {
            return;
        }
        for (Observer observer : observers) {
            observer.response(this);
        }
    }

    public void addObserver(String key, Observer observer) {
        List<Observer> observers = observerMap.getOrDefault(key, null);
        if (observers == null) {
            throw new NullPointerException();
        }
        observers.add(observer);
    }

    public boolean deleteObserver(String key, Observer observer) {
        List<Observer> observers = observerMap.getOrDefault(key, null);
        if (observers == null) {
            throw new NullPointerException();
        }
        return observers.remove(observer);
    }
}

interface Observer {
    void response(Object o);
}

