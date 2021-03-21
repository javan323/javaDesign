package demo01singleton;

/**
 * @Descrition: 饿汉式单例:该模式的特点是类一旦加载就创建一个
 * 单例，保证在调用 getInstance 方法之前单例已经存在了。
 * @Author Javan
 * @Date 2020.12.31
 * @Version V1.0
 */
public class HungrySingleton {
    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}
