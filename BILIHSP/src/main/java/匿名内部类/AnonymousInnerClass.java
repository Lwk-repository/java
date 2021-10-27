package 匿名内部类;

public class AnonymousInnerClass {
    public static void main(String[] args) {
        Outer04 outer04 = new Outer04();
        outer04.method2();
        outer04.method();
    }
}

class Outer04 {
    public void method() {
        /*基于接口的匿名内部类
        * 匿名内部类，不创建对象就可实现接口
        * 编译类型 A
        * 运行类型 匿名内部类
        * 底层原理：系统分配一个类，只能用一次
        *   他的名字 本类名$1 Outer04$1 多个匿名内部类，后面的数字会递增，递增规则是方法定义顺序
        *   class Outer04$1 implement A {
        *       @Override
        *       public void cry(){
        *           System.out.println("xxxx");
        *       }
        *   }
        * JDK在底层创建匿名内部类 Outer04$1, 立即就创建了 Outer04$1实例，并且把地址返回给 a
        * 抽象类实现匿名内部类，类似接口实现匿名内部类*/
        A a = new A() {
            @Override
            public void cry() {
                System.out.println("hahaha");
            }
        };
        a.cry();
        System.out.println("运行类型：" + a.getClass());
    }

    public void method2(){
        /*基于类的匿名内部类
        * 分析
        * 1.father 编译类型 Father
        * 2.father 运行类型 Outer04$2
        * class Outer04$2 extends Father {
        *   @Override
            public void test() {
                System.out.println("匿名内部类重写了test方法");
            }
        * }*/
        Father father = new Father("aa"){
            @Override
            public void test() {
                System.out.println("匿名内部类重写了test方法");
            }
        };
        father.test();
        System.out.println(father.getClass());
    }
}

interface A {
    void cry();
}

class Father {
    public Father(String name) {
        super();
        System.out.println(name);
    }
    public void test() {

    }
}
