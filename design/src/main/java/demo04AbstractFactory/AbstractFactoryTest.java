package demo04AbstractFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * 抽象工厂模式
 * Javan 2021.01.25
 */
public class AbstractFactoryTest {

    public static void main(String[] args) {
        try {
            ProductA a;
            ProductB b;
            AbstractFactory af;
            af = (AbstractFactory) ReadXML1.getObject();
            a = af.factoryA();
            a.show();
            b = af.factoryB();
            b.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

//抽象工厂：提供了产品的生成方法
interface AbstractFactory {
    public ProductA factoryA();

    public ProductB factoryB();
}

//抽象产品：提供了产品的接口
interface ProductA {
    public void show();
}

//抽象产品：提供了产品的接口
interface ProductB {
    public void show();
}

//具体产品A1：实现抽象产品中的抽象方法
class ProductA1 implements ProductA {
    @Override
    public void show() {
        System.out.println("具体产品A1显示...");
    }
}

//具体产品A2：实现抽象产品中的抽象方法
class ProductA2 implements ProductA {
    @Override
    public void show() {
        System.out.println("具体产品A2显示...");
    }
}


//具体产品B1：实现抽象产品中的抽象方法
class ProductB1 implements ProductB {
    @Override
    public void show() {
        System.out.println("具体产品B1显示...");
    }
}

//具体产品B2：实现抽象产品中的抽象方法
class ProductB2 implements ProductB {
    @Override
    public void show() {
        System.out.println("具体产品B2显示...");
    }
}

//具体工厂1：实现了产品的生成方法
class ConcreteFactory1 implements AbstractFactory {

    @Override
    public ProductA factoryA() {
        System.out.println("具体工厂1生成-->具体产品A1...");
        return new ProductA1();
    }

    @Override
    public ProductB factoryB() {
        System.out.println("具体工厂1生成-->具体产品B1...");
        return new ProductB1();
    }
}

//具体工厂2：实现了产品的生成方法
class ConcreteFactory2 implements AbstractFactory {

    @Override
    public ProductA factoryA() {
        System.out.println("具体工厂2生成-->具体产品A2...");
        return new ProductA2();
    }

    @Override
    public ProductB factoryB() {
        System.out.println("具体工厂2生成-->具体产品B2...");
        return new ProductB2();
    }
}

class ReadXML1 {
    //该方法用于从XML配置文件中提取具体类类名，并返回一个实例对象
    public static Object getObject() {
        try {
            //创建文档对象
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc;
            doc = builder.parse(new File("D:\\work\\workspace\\effectiveJava\\Chapter 5\\src\\main\\resources\\config2.xml"));
            //获取包含类名的文本节点
            NodeList nl = doc.getElementsByTagName("className");
            Node classNode = nl.item(0).getFirstChild();
            String cName = classNode.getNodeValue();
            //System.out.println("新类名："+cName);
            //通过类名生成实例对象并将其返回
            Class<?> c = Class.forName(cName);
            Object obj = c.newInstance();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
