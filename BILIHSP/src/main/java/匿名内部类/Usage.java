package 匿名内部类;

/**
 * 匿名内部类使用场景
 */
public class Usage {
    public static void main(String[] args) {
        Usage usage = new Usage();
//        匿名内部类当作参数传入，否则需要创建类继承接口（属于硬编码，非常生硬）
        usage.test(new Li() {
            @Override
            public void eat() {
                System.out.println("haha");
            }
        });
    }
    void test(Li li){
        li.eat();
    }
}
interface Li{
    void eat();
}
