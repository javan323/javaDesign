package designPattern.demo19MementoPattern;

/**
 * 备忘录模式（Memento Pattern）
 * Javan 2021.06.29
 */
public class MementoPattern {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();
        originator.setState("S0");
        System.out.println("初始状态：" + originator.getState());
        caretaker.setMemento(originator.createMemento());//保存状态
        originator.setState("S1");
        System.out.println("新的状态：" + originator.getState());
        originator.restoreMemento(caretaker.getMemento()); //恢复状态
        System.out.println("恢复状态：" + originator.getState());
    }
}

//备忘录
class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

//发起人
class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento createMemento() {
        return new Memento(state);
    }

    public void restoreMemento(Memento m) {
        this.setState(m.getState());
    }
}

//管理者
class Caretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}