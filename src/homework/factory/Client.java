package homework.factory;

/**
 * @author : Cattle_Horse
 * @date : 2023/11/11 17:16
 * @description : 工厂模式作业
 */
public class Client {
    public static void main(String[] args) {
        IFactory factory = new LenovoFactory();
        ILaptop laptop = factory.build();
        System.out.println(laptop.info());
    }
}

interface ILaptop {
    String info();
}

interface IFactory {
    ILaptop build();
}

class LenovoLaptop implements ILaptop {
    @Override
    public String info() {
        return "Lenovo Laptop";
    }
}

class LenovoFactory implements IFactory {
    @Override
    public ILaptop build() {
        System.out.println("Lenovo Factory create Lenovo Laptop");
        return new LenovoLaptop();
    }
}

class HPLaptop implements ILaptop {
    @Override
    public String info() {
        return "HP Laptop";
    }
}

class HPFactory implements IFactory {
    @Override
    public ILaptop build() {
        System.out.println("HP Factory create HP Laptop");
        return new HPLaptop();
    }
}

class AcerLaptop implements ILaptop {
    @Override
    public String info() {
        return "Acer Laptop";
    }
}

class AcerFactory implements IFactory {
    @Override
    public ILaptop build() {
        System.out.println("Acer Factory create Acer Laptop");
        return new AcerLaptop();
    }
}

class DellLaptop implements ILaptop {
    @Override
    public String info() {
        return "Dell Laptop";
    }
}

class DellFactory implements IFactory {
    @Override
    public ILaptop build() {
        System.out.println("Dell Factory create Dell Laptop");
        return new DellLaptop();
    }
}