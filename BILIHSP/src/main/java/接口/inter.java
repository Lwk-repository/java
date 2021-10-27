package 接口;

/**
 * 抽象类实现接口，可以不实现接口方法
 * 接口的修饰符只能是public和默认
 */
public interface inter {
    // 接口的属性默认用 public static final 修饰
    String doctor = "1";

    // 抽象方法 abstract省略
    void dog();

    // jdk8以后接口可以有实现方法，必须default修饰
    default void cry(){
        System.out.println("1");
    }

    // 也可以有静态方法
    static void car(){
        System.out.println(2);
    }
}
class AB{String doctor = "aa";}
class DD extends AB implements inter{

    @Override
    public void dog() {
        System.out.println(inter.doctor);
        System.out.println(super.doctor);
    }

    public static void main(String[] args) {
        new DD().dog();
    }
}
