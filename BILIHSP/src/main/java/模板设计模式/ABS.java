package 模板设计模式;

public abstract class ABS {
    public abstract void job();

    /**
     * 计算时差方法
     */
    public void timeLag(){
        long start = System.currentTimeMillis();
        job();
        long end = System.currentTimeMillis();
        System.out.println("时差：" + (end - start));
    }
}
