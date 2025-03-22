package study.principles.dependency_inversion.polymerization;

/**
 * @author : Cattle_Horse
 * @date : 2023/11/6 16:53
 * @description : 使用聚合+抽象 实现 依赖倒置原则
 */
public class Client {
    public static void main(String[] args) {
        Person person = new Person();
        person.setMessage(new Email());
        person.receive();
        System.out.println("----------------");
        person.setMessage(new Weixin());
        person.receive();
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
    private IReceiveMessage message;

    /**
     * 通过聚合+抽象 实现 依赖倒置原则
     *
     * @param message 抽象信息类
     */
    public void setMessage(IReceiveMessage message) {
        this.message = message;
    }

    public void receive() {
        System.out.println(message.getInformation());
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