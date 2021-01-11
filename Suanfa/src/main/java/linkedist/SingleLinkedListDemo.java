package linkedist;

/**
 * 单链表
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        // 创建节点
        HeroNode hero1 = new HeroNode(324,"宋江", "及时雨");
        HeroNode hero2 = new HeroNode(22,"卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(34321,"吴用", "智多星");
        HeroNode hero4 = new HeroNode(443,"豹子头", "林冲");
        HeroNode hero5 = new HeroNode(4243,"ff", "aa");
        SingleLinkedList sl = new SingleLinkedList();
        sl.add2(hero1);
        sl.add2(hero4);
        sl.add2(hero3);
        sl.add2(hero2);
        sl.add2(hero5);

        HeroNode neww = new HeroNode(443,"狗头", "内瑟斯");
        sl.update(neww);

        sl.list();
    }
}

// 定义SingleLinkedList 管理人物
class SingleLinkedList{
    // 先初始化一个头节点，头节点不要动
    private HeroNode head = new HeroNode(0,"","");

    // 1.找到当前链表的最后节点
    // 2.将最后这个节点的next 指向新的节点
    public void add(HeroNode heroNode){
        // head节点不能动，需要一个辅助变量
        HeroNode temp = head;
        // 遍历链表，找到最后
        while(true){
            // 找到链表的最后
            if(temp.next == null){
                break;
            }
            // 没找到，将temp后移
            temp = temp.next;
        }
        // 当退出while循环时，temp就指向了链表的最后
        // 将最后这节点的next 指向新的节点
        temp.next = heroNode;
    }//无序

    public void add2(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;
        while(true){
            if(temp.next == null){
                // 节点的子节点为空，直接加后面
                break;
            }else if(temp.next.no > heroNode.no){
                // 节点的子节点大于当前，加中间
                break;
            }else if(temp.next.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            System.out.printf("节点已存在%d\n", heroNode.no);
        }else{
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }// 有序

    public void update(HeroNode heroNode){
        if(null == head){
            System.out.println("节点为空");
            return;
        }
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if(null == head.next){
                break;
            }else if(temp.no == heroNode.no){
                flag = true;    // 找到
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        }else {
            System.out.println("劳斯莱斯-魅有");
        }
    }// 修改节点

    public void list(){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        // 头节点不能动，辅助变量
        HeroNode temp = head.next;
        while(true){
            // 判断是否到链表最后
            if(temp == null){
                break;
            }
            System.out.println(temp);
            // 输出上一个，把下一个赋给temp继续输出
            temp = temp.next;
        }
    }
}

// 定义HeroNode, 每个HeroNode对象就是一个
class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;   // 指向下一个节点

    // 构造器
    public HeroNode(int no, String name, String nickName){
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
