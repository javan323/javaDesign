package designPattern.demo18StatePattern;

/**
 * 状态模式（State Pattern）
 * Javan 2021.06.28
 */
public class StatePattern {
    public static void main(String[] args) {
        Conext conext = new Conext(); //创建环境
        conext.Handle(); //处理请求
        conext.Handle();
        conext.Handle();
        conext.Handle();
    }
}

//环境类
class Conext {
    private State state;

    // 设置新状态
    public Conext() {
        this.state = new ConcreteStateA();
    }

    //    读取状态
    public State getState() {
        return state;
    }

    //    设置新状态
    public void setState(State state) {
        this.state = state;
    }

    public void Handle() {
        state.Handle(this);
    }
}

//抽象状态类
abstract class State {
    public abstract void Handle(Conext conext);
}

//具体状态A类
class ConcreteStateA extends State {
    @Override
    public void Handle(Conext conext) {
        System.out.println("当前状态是A.");
        conext.setState(new ConcreteStateB());
    }
}

//具体状态B类
class ConcreteStateB extends State {

    @Override
    public void Handle(Conext conext) {
        System.out.println("当前状态是B.");
        conext.setState(new ConcreteStateA());
    }
}

