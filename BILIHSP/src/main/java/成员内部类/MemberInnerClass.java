package 成员内部类;

public class MemberInnerClass {
    public static void main(String[] args) {
        Outer8 outer8 = new Outer8();
        outer8.out();
    }
}

class Outer8{
    protected class Inner8 {
        public void say(){
            System.out.println("hahaha");
        }
    }

    public void out(){
        Inner8 inner8 = new Inner8();
        inner8.say();
    }
}