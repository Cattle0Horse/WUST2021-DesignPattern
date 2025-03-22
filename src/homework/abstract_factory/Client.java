package homework.abstract_factory;

/**
 * @author : Cattle_Horse
 * @date : 2023/11/11 17:54
 * @description :
 */
public class Client {
    public static void main(String[] args) {
        IFactory factory = new KFCFactory();
        Hamburg hamburg = factory.buildHamburg();
        hamburg.steam();
        Cola cola = factory.buildCola();
        cola.bubble();
    }
}

abstract class Hamburg {
    public abstract void steam();
}

class McDonaldsHamburg extends Hamburg {
    @Override
    public void steam() {
        System.out.println("McDonalds Hamburg steam");
    }
}

class KFCHamburg extends Hamburg {
    @Override
    public void steam() {
        System.out.println("KFC Hamburg steam");
    }
}

abstract class Cola {
    public abstract void bubble();
}

class McDonaldsCola extends Cola {
    @Override
    public void bubble() {
        System.out.println("McDonalds Cola bubble");
    }
}

class KFCCola extends Cola {
    @Override
    public void bubble() {
        System.out.println("KFC Cola bubble");
    }
}

interface IFactory {
    Hamburg buildHamburg();

    Cola buildCola();
}

class McDonaldsFactory implements IFactory {
    @Override
    public Hamburg buildHamburg() {
        System.out.println("McDonalds create McDonalds Hamburg");
        return new McDonaldsHamburg();
    }

    @Override
    public Cola buildCola() {
        System.out.println("McDonalds create McDonalds Cola");
        return new McDonaldsCola();
    }
}

class KFCFactory implements IFactory {
    @Override
    public Hamburg buildHamburg() {
        System.out.println("KFC create KFC Hamburg");
        return new KFCHamburg();
    }

    @Override
    public Cola buildCola() {
        System.out.println("KFC create KFC Cola");
        return new KFCCola();
    }
}