package 枚举;

/**
 * @Author 李文凯
 * 2021/10/26 15:01
 */
public class Enum{
    public static void main(String[] args) {
        Enum2 enum2 = Enum2.SPRING;
        System.out.println(enum2.toString());
    }
}

enum Enum2 {
    /*private static final Enum2 SPRING = new Enum2("floor", 1);
    private static final Enum2 SUMMER = new Enum2("door", 2);*/

    /*使用enum实现枚举
    * 1. 使用关键字enum 代替class
    * 2. 将上面的声明变为 SPRING("floor", 1) 常量名(实参列表) 与原来意思一样，被简化了
    * 3. 如有多个常量用 ，分割，最后一个带分号
    * 4. 要求常量对象写在类的最前面，否则报错，语法规定
    * 5. 枚举的构造器默认是private
    * 6. 如果使用无参构造器 可以省略括号*/

    SPRING("floor", 1), SUMMER("door", 2), WHAT;

    private String name;
    private int age;

    Enum2(){

    }
    Enum2(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Enum2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
