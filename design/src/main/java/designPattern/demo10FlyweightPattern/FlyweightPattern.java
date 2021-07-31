package designPattern.demo10FlyweightPattern;

import java.util.HashMap;

/**
 * 享元模式
 * Javan 2021.04.04
 */
//客户端角色
public class FlyweightPattern {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();
        Flyweight f01 = factory.getFlyyweight("A");
        Flyweight f02 = factory.getFlyyweight("A");
        Flyweight f03 = factory.getFlyyweight("A");
        Flyweight f11 = factory.getFlyyweight("B");
        Flyweight f12 = factory.getFlyyweight("B");
        f01.operation(new UnsharedConcreteFlyweight("第一次调用A。"));
        f02.operation(new UnsharedConcreteFlyweight("第二次调用A。"));
        f03.operation(new UnsharedConcreteFlyweight("第三次调用A。"));
        f11.operation(new UnsharedConcreteFlyweight("第一次调用B。"));
        f12.operation(new UnsharedConcreteFlyweight("第二次调用B。"));
    }
}

//非享元角色
class UnsharedConcreteFlyweight {
    private String info;

    public UnsharedConcreteFlyweight(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

//抽象享元
interface Flyweight {
    public void operation(UnsharedConcreteFlyweight state);
}

//具体享元
class ConcreteFlyweight implements Flyweight {
    private String key;

    public ConcreteFlyweight(String key) {
        this.key = key;
        System.out.println("具体享元" + key + "被创建！");
    }

    @Override
    public void operation(UnsharedConcreteFlyweight outState) {
        System.out.print("具体享元" + key + "被调用，");
        System.out.println("非享元信息是:" + outState.getInfo());
    }
}

//享元工厂
class FlyweightFactory {
    private HashMap<String, Flyweight> flyweightHashMap = new HashMap<>();

    public Flyweight getFlyyweight(String key) {
        Flyweight flyweight = flyweightHashMap.get(key);
        if (flyweight != null) {
            System.out.println("具体享元" + key + "已经存在，被成功获取！");
        } else {
            flyweight = new ConcreteFlyweight(key);
            flyweightHashMap.put(key, flyweight);
        }
        return flyweight;
    }
}
