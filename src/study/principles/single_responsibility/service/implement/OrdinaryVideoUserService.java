package study.principles.single_responsibility.service.implement;

import study.principles.single_responsibility.service.IVideoUserService;

/**
 * @author : Cattle_Horse
 * @date : 2023/11/6 15:19
 * @description : 普通用户，实现接口，普通用户的功能
 */
public class OrdinaryVideoUserService implements IVideoUserService {
    @Override
    public void advertisement() {
        System.out.println("普通用户广告：有广告");
    }

    @Override
    public void videoQuality() {
        System.out.println("普通用户画质：720P");
    }
}
