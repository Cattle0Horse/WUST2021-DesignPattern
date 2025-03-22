package study.principles.single_responsibility;

import study.principles.single_responsibility.service.IVideoUserService;
import study.principles.single_responsibility.service.implement.VIPVideoUserService;

/**
 * 类的职责要单一，不能将太多的职责放在一个类中。<p>
 * 单一职责原则：拆分<code>if-else</code>，将职责分布给单一实现类，抽取接口<p>
 *
 * @author : Cattle_Horse
 * @date : 2023/11/6 15:05
 * @description : 单一职责原则
 */
public class Client {
    public static void main(String[] args) {
        IVideoUserService service = new VIPVideoUserService();
        service.advertisement();
        service.videoQuality();
    }
}
