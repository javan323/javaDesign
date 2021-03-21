package design.demo01singleton;

/**
 * @Descrition: 懒汉式单例:该模式的特点是类加载时没有生成单例，
 * 只有当第一次调用 getlnstance 方法时才去创建这个单例
 * @Author Javan
 * @Date 2020.12.31
 * @Version V1.0
 */
public class LazySingleton {
    /**
     * 保证 instance 在所有线程中同步
     */
    private static volatile LazySingleton instance = null;

    private LazySingleton() {
    }    //private 避免类在外部被实例化

    public static synchronized LazySingleton getInstance() {
        //getInstance 方法前加同步
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
