package study.principles.interface_segregation.service.implement;

import study.principles.interface_segregation.service.ISkillInvisible;
import study.principles.interface_segregation.service.ISkillSilent;
import study.principles.interface_segregation.service.ISkillVertigo;

/**
 * @author : Cattle_Horse
 * @date   : 2023/11/6 16:39
 * @description :廉颇
 **/
public class HeroLianPo implements ISkillInvisible, ISkillSilent, ISkillVertigo {

    @Override
    public void doInvisible() {
        System.out.println("廉颇的隐身技能");
    }

    @Override
    public void doSilent() {
        System.out.println("廉颇的沉默技能");
    }

    @Override
    public void doVertigo() {
        System.out.println("廉颇的眩晕技能");
    }

}
