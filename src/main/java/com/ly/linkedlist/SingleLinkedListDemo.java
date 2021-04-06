package com.ly.linkedlist;

import java.util.Stack;

/**
 * @className: SingleLinkedList
 * @description: TODO 类描述
 * @author: ly
 * @date: 2021/3/31 15:10
 **/
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4= new HeroNode(4, "林冲", "豹子头");
        SingleLinkedList singleLinkedList=new SingleLinkedList();
        singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode4);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode3);
        singleLinkedList.printfList();
        System.out.println("顺序插入");
        SingleLinkedList singleLinkedList2=new SingleLinkedList();
        singleLinkedList2.addByOrder(heroNode1);
        singleLinkedList2.addByOrder(heroNode4);
        singleLinkedList2.addByOrder(heroNode2);
        singleLinkedList2.addByOrder(heroNode3);
        singleLinkedList2.printfList();
        System.out.println("更新节点信息");
        HeroNode heroNode5 = new HeroNode(2, "卢俊义大将军", "玉麒麟~~~");
        HeroNode heroNode6 = new HeroNode(1, "宋江", "及时雨");
        singleLinkedList2.update(heroNode5);
        singleLinkedList2.printfList();
        System.out.println("删除节点");
        singleLinkedList2.deleteNode(heroNode6);
        singleLinkedList2.printfList();
        System.out.println("获取倒数第k个节点");
        HeroNode lastIndexNode = singleLinkedList2.getLastIndexNode(3);
        System.out.println(lastIndexNode);
        System.out.println("链表的反转:");
        SingleLinkedList singleLinkedList3=new SingleLinkedList();
        singleLinkedList3.addByOrder(heroNode1);
        singleLinkedList3.addByOrder(heroNode4);
        singleLinkedList3.addByOrder(heroNode2);
        singleLinkedList3.addByOrder(heroNode3);
        System.out.println("倒叙打印链表");
        singleLinkedList3.printLinkListReverse();
//        singleLinkedList3.reverseLinkedList();
//        singleLinkedList3.printfList();


    }
}
    class HeroNode{
        public int no;
        public String name;
        public String nickName;
        public HeroNode next;

        public HeroNode(int no,String name,String nickName){
            this.no=no;
            this.name=name;
            this.nickName=nickName;
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

 class  SingleLinkedList{

    /**
     * 头节点
     */
    private HeroNode head=new HeroNode(0,"","");

    /**
     * 添加元素
     * @param node
     */
    public void add(HeroNode node){
        //知道最后一个元素
        //将最后一个元素指针指向当前添加的元素
        HeroNode temp=head;
        while (true){
            if(temp.next == null){
                break;
            }
            temp=temp.next;
        }
        temp.next=node;
    }

     /**
      * 按照英雄编号顺序加入
      * @param heroNode
      */
    public void addByOrder(HeroNode heroNode){
      HeroNode temp=head;
      //表示是否有重复编号
      boolean flag=false;
      while (true){
          if(temp.next == null){
              break;
          }
          if(temp.next.no >heroNode.no){
              //说明找到插入位置了
              break;
          }else if(temp.next.no == heroNode.no){
              //说明相等
              flag=true;
              break;
          }
          temp=temp.next;
      }
      //添加元素到指定位置
        if(flag){
            System.out.printf("当前节点存在no=%d",temp.no);
        }else{
            heroNode.next=temp.next;
            temp.next=heroNode;
        }

    }

     /**
      * 更新节点信息
      * @param newHeroNode
      * @return
      */
    public HeroNode update(HeroNode newHeroNode){
        HeroNode temp=head.next;
        //当前节点是否存在
        boolean flag=false;
        while (true){
            if(temp == null){
                break;
            }
            if(temp.no == newHeroNode.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        HeroNode curNode=temp;
        if(!flag){
            System.out.println("当前要更新节点不存在");
            return null;
        }else{
            temp.name=newHeroNode.name;
            temp.nickName= newHeroNode.nickName;
        }
        return curNode;
    }

     /**
      * 删除节点
      * @param node
      * @return
      */
    public HeroNode deleteNode(HeroNode node){
        HeroNode temp=head;
        //被删除元素是否存在
        boolean flag=false;
        while (true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no == node.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        HeroNode currentNode=temp;
        if(!flag){
          throw new RuntimeException("节点不存在");
        }else{
            HeroNode delNode=currentNode.next;
            temp.next=delNode.next;
            delNode.next=null;
        }
        return currentNode;
    }


     /**
      * 获取链表有效长度
      * @return
      */
    public int getLength(){
        int length=0;
        if(head.next==null){
            return 0;
        }
        HeroNode currNode=head.next;
        while (currNode!=null){
            length++;
            currNode=currNode.next;
        }
        return length;
    }

     /**
      * 求链表中倒数第k个节点信息
      * @param lastIndex
      * @return
      */
    public HeroNode getLastIndexNode(int lastIndex){
        int len=getLength();
        int index=len-lastIndex;
        HeroNode temp=head.next;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp;
    }

    /**
     * 打印链表信息
     */
    public void printfList(){
        if(head.next == null){
            System.out.println("链表为空...");
            return;
        }
        HeroNode heroNode=head.next;
        while (true){
            if(heroNode==null){
                break;
            }
            System.out.println(heroNode);
            heroNode=heroNode.next;
        }

    }


     /**
      * 链表的反转
      * 思路:
      */
    public void reverseLinkedList(){
        //为空节点 或者只有一个节点
        if(head.next==null || head.next.next==null){
            return;
        }
        //当前节点
        HeroNode cur=head.next;
        //下一个节点
        HeroNode next=null;
        //反转头节点
        HeroNode reverseHead=new HeroNode(0,"","");
        while (cur!=null){
            //先保存当前节点的下一个节点
            next=cur.next;
            //当前节点指向反转头节点的
            cur.next=reverseHead.next;
            reverseHead.next=cur;
            cur=next;
        }
        head.next=reverseHead.next;
    }

     /**
      * 逆序打印链表（通过栈的方式实现）
      */
    public void printLinkListReverse(){
        HeroNode node=head;
        if(node.next==null){
            return;
        }
        Stack<HeroNode> stack=new Stack<>();
        node=head.next;
        while (node !=null){
            stack.push(node);
            node=node.next;
        }

        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }
}
