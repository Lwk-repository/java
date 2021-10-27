package 局部内部类;

public class LocalInnerClass {
    public static void main(String[] args) {
        Outer2 outer2 = new Outer2();
        outer2.m1();
    }
}
class Outer2{
    private int a = 10;
    static int b = 10;
    public void m1(){
//        局部内部类是定义在外部类的局部位置，通常在方法，本质仍然是个类
//        不能添加访问修饰符，但可以用final
//        作用域：仅仅在定义他的方法或代码块中
        class Inner02{
            int a = 1;
//            可以直接访问外部类所有成员,包括私有的
//            如果外部类和局部类成员重名，遵循就近原则
//            如何访问外部成员 外部类名.this.属性名，哪个对象调用了m1，Outer2.this就指哪个对象
            public void f1(){
                System.out.println(Outer2.this.a);
            }
        }
        Inner02 inner02 = new Inner02();
        inner02.f1();
    }
}

