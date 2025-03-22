package classroom.creational.abstract_factory;

/**
 * 抽象工厂模式（Abstract Factory Pattern）定义：<p>
 * 提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。
 *
 * @author : Cattle_Horse
 * @date : 2023/11/6 17:56
 * @description : 抽象工厂模式
 */
public class Client {
    public static void main(String[] args) {
        SkinFactory factory = new SpringSkinFactory();
        Button button = factory.createButton();
        TextField textField = factory.createTextFiled();
        ComboBox comboBox = factory.createComboBox();
        button.display();
        textField.display();
        comboBox.display();
    }
}

interface Button {
    void display();
}

interface TextField {
    void display();
}

interface ComboBox {
    void display();
}

class SpringButton implements Button {
    @Override
    public void display() {
        System.out.println("SpringButton.display");
    }
}

class SummerButton implements Button {
    @Override
    public void display() {
        System.out.println("SummerButton.display");
    }
}

class SpringTextFiled implements TextField {
    @Override
    public void display() {
        System.out.println("SpringTextFiled.display");
    }
}

class SummerTextFiled implements TextField {
    @Override
    public void display() {
        System.out.println("SummerTextFiled.display");
    }
}

class SpringComboBox implements ComboBox {
    @Override
    public void display() {
        System.out.println("SpringComboBox.display");
    }
}

class SummerComboBox implements ComboBox {
    @Override
    public void display() {
        System.out.println("SummerComboBox.display");
    }
}

interface SkinFactory {
    Button createButton();

    TextField createTextFiled();

    ComboBox createComboBox();
}

class SpringSkinFactory implements SkinFactory {
    @Override
    public Button createButton() {
        return new SpringButton();
    }

    @Override
    public TextField createTextFiled() {
        return new SpringTextFiled();
    }

    @Override
    public ComboBox createComboBox() {
        return new SpringComboBox();
    }
}

class SummerSkinFactory implements SkinFactory {
    @Override
    public Button createButton() {
        return new SummerButton();
    }

    @Override
    public TextField createTextFiled() {
        return new SummerTextFiled();
    }

    @Override
    public ComboBox createComboBox() {
        return new SummerComboBox();
    }
}