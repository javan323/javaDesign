package designPattern.demo12BridgePattern;

/**
 * 桥接模式
 * Javan 2021.04.18
 */
public class BridgePattern {
    public static void main(String[] args) {
        Implementor imple = new ConcreteImplementor();
        Abstraction abs = new RefinedAbstraction(imple);
        abs.operation();
    }
}

//实现化角色
interface Implementor {
    public void OperationImpl();
}

//具体实现化角色
class ConcreteImplementor implements Implementor {

    @Override
    public void OperationImpl() {
        System.out.println("具体实现化(Concrete Implementor)角色被访问");
    }
}

//抽象化角色
abstract class Abstraction {
    protected Implementor implementor;

    protected Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    public abstract void operation();
}

//扩展抽象角色
class RefinedAbstraction extends Abstraction {

    protected RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    @Override
    public void operation() {
        System.out.println("扩展抽象化（Refined Abstraction）角色被访问");
        implementor.OperationImpl();
    }
}
