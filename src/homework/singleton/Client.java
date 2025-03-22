package homework.singleton;

/**
 * @author : Cattle_Horse
 * @date : 2023/11/11 15:57
 * @description : 单例模式作业
 **/
public class Client {
    /**
     * Test singleton {@link AppConfig}
     */
    public static void main(String[] args) {
        AppConfig config1 = AppConfig.getInstance();
        AppConfig config2 = AppConfig.getInstance();
        System.out.println("Before the change: config1.getParameter() = " + config1.getParameter());
        config2.setParameter("change parameter");
        System.out.println("After the change : config1.getParameter() = " + config1.getParameter());
        System.out.println("Are config1 and config2 the same instance?  " + (config1 == config2 ? "Yes" : "No"));
    }
}

class AppConfig {
    private static int count = 0;
    private static volatile AppConfig instance = null;

    private AppConfig() {
        ++count;
        System.out.printf("Create an AppConfig instance, this is the %dth instance\n", count);
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            synchronized (AppConfig.class) {
                if (instance == null) {
                    instance = new AppConfig();
                }
            }
        }
        return instance;
    }

    /**
     * Suppose this is the content of a configuration file
     */
    private String parameter = "default config";

    public synchronized String getParameter() {
        return parameter;
    }

    public synchronized void setParameter(String content) {
        parameter = content;
    }
}
