package design.demo07AdapterPattern;


/**
 * 适配器模式（Adapter）
 * Javan 2021.03.14
 */
public class AdpaterPatternTest {
    public static void main(String[] args) {
        System.out.println("适配器模式测试：");
        Target target = new Adapter();
        target.request();
    }
}

//目标角色
interface Target {
    public void request();
}

//源角色
class Adaptee {
    public void specificRequest() {
        System.out.println("适配器中的业务代码被调用");
    }
}

// 适配器角色
class Adapter extends Adaptee implements Target {

    @Override
    public void request() {
        specificRequest();
    }
}


