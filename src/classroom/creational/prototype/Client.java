package classroom.creational.prototype;

/**
 * 原型模式（Prototype Pattern）定义：<p>
 * 采用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。原型模式允许一个对象再创建另外一个可定制的对象，无需知道任何创建的细节。<p>
 * <li>浅拷贝：除基元类型外，复制地址</li>
 * <li>深拷贝：复制值，新建内存</li>
 * 可通过实现克隆接口{@link java.lang.Cloneable}或序列化接口{@link java.io.Serializable}完成深拷贝
 *
 * @author : Cattle_Horse
 * @date : 2023/11/8 11:13
 * @description : 原型模式
 * @see java.lang.Cloneable
 * @see java.io.Serializable
 */
public class Client {
    public static void main(String[] args) {
        Email oldEmail = new Email();
        oldEmail.setAttachment(new Attachment("附件1"));
        oldEmail.setName("哈哈");
        oldEmail.setContent("Hello World!");
        oldEmail.setDate("2023/11/8 11:39");

        Email shallowCopyEmail1 = oldEmail.shallowCopy();
        System.out.println("浅拷贝");
        System.out.println("Email是否是同一地址\t\t" + (oldEmail == shallowCopyEmail1));
        System.out.println("Attachment是否是同一地址\t" + (oldEmail.getAttachment() == shallowCopyEmail1.getAttachment()));
        System.out.println("------------------------------");

        Email deepCopyEmail2 = oldEmail.deepCopy();
        System.out.println("深拷贝");
        System.out.println("Email是否是同一地址\t\t" + (oldEmail == deepCopyEmail2));
        System.out.println("Attachment是否是同一地址\t" + (oldEmail.getAttachment() == deepCopyEmail2.getAttachment()));
    }
}

class Attachment implements Cloneable {
    private final String name;

    public Attachment(String name) {
        this.name = name;
    }

    public void download() {
        System.out.println("下载 {" + name + "} 附件");
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Email implements Cloneable {
    private Attachment attachment;
    private String name;
    private String date;
    private String content;

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // @Override
    // public Email clone() {
    //     try {
    //         return (Email) super.clone();
    //     } catch (CloneNotSupportedException e) {
    //         System.out.println("Email类不支持复制");
    //         return null;
    //     }
    // }

    public Email shallowCopy() {
        try {
            return (Email) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Email类不支持复制");
            return null;
        }
    }

    public Email deepCopy() {
        Email email = null;
        try {
            email = (Email) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        try {
            email.attachment = (Attachment) attachment.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return email;
    }
}