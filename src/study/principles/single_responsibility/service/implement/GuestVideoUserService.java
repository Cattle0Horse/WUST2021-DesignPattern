package study.principles.single_responsibility.service.implement;

import study.principles.single_responsibility.service.IVideoUserService;

/**
 * @author : Cattle_Horse
 * @date : 2023/11/6 15:19
 * @description : 访客用户，实现接口，访客的功能
 */
public class GuestVideoUserService implements IVideoUserService {
    @Override
    public void advertisement() {
        System.out.println("访客广告：有广告");
    }

    @Override
    public void videoQuality() {
        System.out.println("访客画质：480P");
    }
}
