package com.ly.linkedlist;

/**
 * @className: DoubleLinkedListDemo
 * @description: 双向链表案例
 * @author: ly
 * @date: 2021/4/6 21:35
 **/
public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        //测试用例
        HeroNode2 heroNode1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 heroNode2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 heroNode3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 heroNode4 = new HeroNode2(4, "林冲", "豹子头");
        DoubleLinkedList doubleLinkedList=new DoubleLinkedList();
        doubleLinkedList.add(heroNode1);
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.add(heroNode3);
        doubleLinkedList.add(heroNode4);
        doubleLinkedList.printList();
        System.out.println("修改链表");
        HeroNode2 heroNode5 = new HeroNode2(4, "林冲!!~", "豹子头~~~");
        doubleLinkedList.updateNode(heroNode5);
        doubleLinkedList.printList();
        System.out.println("删除链表");
        doubleLinkedList.deleteNode(heroNode3);
        doubleLinkedList.printList();
    }
}

    class  DoubleLinkedList{
        private HeroNode2 headerNode=new HeroNode2(-1,"","");
        public HeroNode2 getHead(){
            return headerNode;
        }

        /**
         * 打印双向链表
         */
        public void printList(){
            if(headerNode.next == null){
                return;
            }
            HeroNode2 temp=headerNode.next;
            while (true){
                if(temp==null){
                    break;
                }
                System.out.println(temp);
                temp=temp.next;
            }
        }

        /**
         * 添加元素
         * @param heroNode
         */
        public void add(HeroNode2 heroNode){
            HeroNode2 temp=headerNode;
            while (temp.next!=null){
                temp=temp.next;
            }
            temp.next=heroNode;
            heroNode.pre=temp;

        }

        /**
         * 修改链表
         * @param heroNode
         */
        public void updateNode(HeroNode2 heroNode){
            HeroNode2 temp=headerNode.next;
            boolean flag=false;
            while (true){
                if(temp == null){
                    break;
                }
                if(temp.no == heroNode.no){
                    flag=true;
                    break;
                }
                temp=temp.next;
            }
            if(flag){
                temp.name= heroNode.name;
                temp.nickName= heroNode.nickName;
            }else{
                System.out.println("要更新的节点不存在!");
            }
        }

        /**
         * 删除节点
         * @param heroNode
         */
        public void deleteNode(HeroNode2 heroNode){
            HeroNode2 deleteNode=headerNode;
            boolean flag=false;
            while (true){
                if(deleteNode ==null){
                    break;
                }
                if(deleteNode.no == heroNode.no){
                    flag=true;
                    break;
               }
                deleteNode=deleteNode.next;
            }
            if(flag){
                if(deleteNode.pre!=null)
                    deleteNode.pre.next=deleteNode.next;
                if(deleteNode.next!=null)
                    deleteNode.next.pre=deleteNode.pre;
            }else{
                System.out.println("要删除的节点不存在!");
            }
        }




    }
    class HeroNode2{
        public int no;
        public String name;
        public String nickName;
        public HeroNode2 next;
        public HeroNode2 pre;

        public HeroNode2(int no,String name,String nickName){
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


