package study.principles.dependency_inversion.dependency;

/**
 * @author : Cattle_Horse
 * @date : 2023/11/6 16:48
 * @description : 使用依赖+抽象 实现 依赖倒置原则
 */
public class Client {
    public static void main(String[] args) {
        new Person().receive(new Email());
        new Person().receive(new Weixin());
    }
}

interface IReceiveMessage {
    /**
     * 获取信息
     *
     * @return 信息
     */
    String getInformation();
}

class Person {
    /**
     * 传递抽象类型参数，通过依赖+抽象实现依赖倒置原则
     *
     * @param iReceiveMessage 抽象信息类
     */
    public void receive(IReceiveMessage iReceiveMessage) {
        System.out.println(iReceiveMessage.getInformation());
    }
}

class Email implements IReceiveMessage {
    @Override
    public String getInformation() {
        return "电子邮件信息";
    }
}

class Weixin implements IReceiveMessage {
    @Override
    public String getInformation() {
        return "微信信息";
    }
}