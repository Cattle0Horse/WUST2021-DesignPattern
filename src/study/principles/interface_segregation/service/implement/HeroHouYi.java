package study.principles.interface_segregation.service.implement;

import study.principles.interface_segregation.service.ISkillArchery;
import study.principles.interface_segregation.service.ISkillInvisible;
import study.principles.interface_segregation.service.ISkillSilent;

/**
 * @author : Cattle_Horse
 * @date   : 2023/11/6 16:39
 * @description : 后裔
 **/
public class HeroHouYi implements ISkillArchery, ISkillInvisible, ISkillSilent {

    @Override
    public void doArchery() {
        System.out.println("后裔的灼日之矢");
    }

    @Override
    public void doInvisible() {
        System.out.println("后裔的隐身技能");
    }

    @Override
    public void doSilent() {
        System.out.println("后裔的沉默技能");
    }

}
