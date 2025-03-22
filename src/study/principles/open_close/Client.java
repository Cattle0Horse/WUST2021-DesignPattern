package study.principles.open_close;

import study.principles.open_close.service.ICalculateAreaService;
import study.principles.open_close.service.implement.CalculateAreaExtService;

/**
 * 开闭原则：软件实体对扩展是开放的，但对修改是关闭的，即在不修改一个软件实体的基础上去扩展其功能。<p>
 *
 * @author : Cattle_Horse
 * @date : 2023/11/6 15:27
 * @description : 开闭原则
 */
public class Client {
    public static void main(String[] args) {
        ICalculateAreaService service = new CalculateAreaExtService();
        System.out.println(service.circular(1));
    }
}
