package 模板设计模式;

public class AA extends ABS{
    @Override
    public void job() {
        int num = 0;
        for (int i = 0; i < 80000; i++) {
            num += i;
        }
    }
}
