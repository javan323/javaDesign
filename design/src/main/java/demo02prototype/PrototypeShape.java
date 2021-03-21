package demo02prototype;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Descrition: 用带原型管理器的原型模式来生成包含“圆”和“正方形”等图形的原型，并计算其面积。
 * @Author Javan
 * @Date 2021.01.03
 * @Version V1.0
 */
interface Shape extends Cloneable {
    public Object clone(); //拷贝

    public void countArea(); //计算面积
}

class Circle implements Shape {

    @Override
    public Object clone() {
        Circle c = null;
        try {
            c = (Circle) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("拷贝圆面积失败！");
        }
        return c;
    }

    @Override
    public void countArea() {
        int r = 0;
        System.out.println("这是一个圆，请输入圆的半径：");
        Scanner input = new Scanner(System.in);
        r = input.nextInt();
        System.out.println("该圆的面积：" + 3.1415926 * r * r + "\n");
    }
}

class Square implements Shape {

    @Override
    public Object clone() {
        Square s = null;
        try {
            s = (Square) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("计算正方形面积失败");
        }
        return s;
    }

    @Override
    public void countArea() {
        int a = 0;
        System.out.println("这是一个正方形，请输入边长:");
        Scanner input = new Scanner(System.in);
        a = input.nextInt();
        System.out.println("该正方形的面积:" + a * a + "\n");
    }
}

class PrototypeManager {
    private HashMap<String, Shape> ht = new HashMap<>();

    public PrototypeManager() {
        ht.put("Circle", new Circle());
        ht.put("Square", new Square());
    }

    public void addShape(String key, Shape obj) {
        ht.put(key, obj);
    }

    public Shape getShape(String key) {
        Shape temp = ht.get(key);
        return (Shape) temp.clone();
    }
}

public class PrototypeShape {
    public static void main(String[] args) {
        PrototypeManager pm = new PrototypeManager();
        Shape obj1 = pm.getShape("Circle");
        obj1.countArea();

        Shape obj2 = pm.getShape("Square");
        obj2.countArea();
    }
}
