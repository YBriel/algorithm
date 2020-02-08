package linkedlist;

import java.util.concurrent.TimeUnit;

/**
 * @Author： yuzq
 * @Description: 单链表
 * @Date: 2019/12/31   15:28
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
        HeroNode headNode = new HeroNode(1, "张三", "哈哈哈");
        HeroNode headNode1 = new HeroNode(2, "李四", "111");
        HeroNode headNode2 = new HeroNode(3, "王五", "333");
        HeroNode headNode3 = new HeroNode(4, "赵六", "666");
        linkedList.add(headNode);
        linkedList.add(headNode1);
        linkedList.add(headNode2);
        linkedList.add(headNode3);
        linkedList.list();
        System.out.println("开始反转单链表");
        //System.out.println(linkedList.getHeadNode()); //获取头结点
        linkedList.reverseList(linkedList.getHeadNode());
        linkedList.list();
    }

}

class SingleLinkedList {

    private HeroNode headNode = new HeroNode(0, "", "");

    /**
     * 添加链表 根据辅助变量的next判断
     *
     * @param node 头结点
     */
    public void add(HeroNode node) {
        HeroNode temp = headNode;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public HeroNode getHeadNode() {
        if (this.headNode.next == null) {
            System.out.println("链表为空，无头部");
        }
        return this.headNode;
    }

    /**
     * 遍历链表
     */
/*    public void list(){
        if(headNode.next==null){
            System.out.println("链表为空！");
        }
        HeroNode temp=headNode.next;
        while (temp != null) {
            System.out.println(temp);
            temp=temp.next;
        }
    }*/
    public void list() {
        //判断链表是否为空
        if (headNode.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点，不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = headNode.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp后移， 一定小心
            temp = temp.next;
        }
    }

    /**
     * 单链表反转
     *
     * @param node 需要反转的链表头结点
     */
    public void reverseList(HeroNode node) {
        if (headNode.next == null || node.next.next == null) {
            System.out.println("链表为空或不需要反转！");
        }
        HeroNode cur = node.next;
        HeroNode next = null;
        HeroNode reversHead = new HeroNode(0, "", "");
        //遍历原来的链表
        while (cur != null) {
            next = cur.next;  //暂时保存当前节点的下一个节点
            cur.next = reversHead.next;  //第一个节点放入最后指向null
            reversHead.next = cur;
            cur = next;           //让cur后移
        }
        node.next = reversHead.next;

    }
}

class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", next=" + next +
                '}';
    }
}
