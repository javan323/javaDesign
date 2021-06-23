package demo16IteratorPattern;

import java.util.Vector;

/**
 * 迭代器模式（Iterator Pattern）
 * Javan 2021.06.23
 */
public class IteratorPattern {
    public static void main(String[] args) {
        Aggregate agg = new ConcreteAggregate();
        agg.add("张三");
        agg.add("李四");
        agg.add("王五");
        Iterator iterator = agg.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}

//抽象迭代器
interface Iterator {
    public Object next();

    public boolean hasNext();
}

//抽象聚集
interface Aggregate {
    public void add(Object obj);

    public Iterator createIterator();
}

//集体聚集
class ConcreteAggregate implements Aggregate {
    private Vector vector = new Vector();

    @Override
    public void add(Object obj) {
        this.vector.add(obj);
    }

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(this);
    }

    public int size() {
        return vector.size();
    }

    public Object getElement(int index) {
        if (index < vector.size()) {
            return vector.get(index);
        } else {
            return null;
        }
    }
}

//具体迭代器
class ConcreteIterator implements Iterator {
    private ConcreteAggregate agg;
    private int index = 0;
    private int size = 0;

    public ConcreteIterator(ConcreteAggregate agg) {
        this.agg = agg;
        size = agg.size();
        index = 0;
    }

    @Override
    public Object next() {
        if (index < size) {
            return agg.getElement(index++);
        } else {
            return null;
        }
    }

    //    是否有下一个元素，即还没遍历结束
    @Override
    public boolean hasNext() {
        return index < size;
    }
}


