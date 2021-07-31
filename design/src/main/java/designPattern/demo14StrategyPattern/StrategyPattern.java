package designPattern.demo14StrategyPattern;

/**
 * 策略模式
 * Javan 2021.05.16
 */
public class StrategyPattern {
    public static void main(String[] args) {
        Context c = new Context();
        Strategy s = new ConcreteStragy();
        c.setStrategy(s);
        c.strategyInterface();
    }
}

//抽象策略角色
interface Strategy {
    public void strategyInterface(); //策略方法
}

//具体策略角色
class ConcreteStragy implements Strategy {
    @Override
    public void strategyInterface() {
        System.out.println("具体的策略方法被访问！");
    }
}

//环境角色
class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void strategyInterface() {
        strategy.strategyInterface();
    }
}
