package study.principles.single_responsibility.service.implement;

import study.principles.single_responsibility.service.IVideoUserService;

/**
 * @author : Cattle_Horse
 * @date : 2023/11/6 15:20
 * @description : VIP用户，实现接口，VIP用户的功能
 */
public class VIPVideoUserService implements IVideoUserService {
    @Override
    public void advertisement() {
        System.out.println("VIP用户广告：无广告");
    }

    @Override
    public void videoQuality() {
        System.out.println("VIP用户画质：1080P");
    }
}