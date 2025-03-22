package study.principles.law_of_demeter;

import java.util.Map;

/**
 * 借助中间类降低耦合
 * <ol>
 *      迪米特法则：
 *     <li>不要和“陌生人”说话。</li>
 *     <li>只与你的直接朋友通信。</li>
 *     <li>每一个软件单位对其他的单位都只有最少的知识，而且局限于那些与本单位密切相关的软件单位。</li>
 * </ol>
 *
 * @author : Cattle_Horse
 * @date : 2023/11/6 16:19
 * @description : 迪米特法则（也称最少知识原则）
 */
public class Client {
    public static void main(String[] args) {
        Principal principal = new Principal();
        Map<String, Object> map = principal.queryClazzInfo("3年1班");
        System.out.println(map.toString());
    }
}
