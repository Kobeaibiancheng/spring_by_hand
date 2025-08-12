package com.yuxiang.design.framework.link.chain;

/**
 * 功能链路
 * @param <E>
 */
public class LinkedList <E> implements ILink<E>{

    /**
     * 责任链名称
     */
    private final String name;

    transient int size = 0;
    transient Node<E> first;
    transient Node<E> last;

    public LinkedList(String name) {
        this.name = name;
    }


    /**
     * 这是一个双向链表
     * 在链表的头部插入新节点
     * @param e
     */
    public void linkFirst(E e) {
        final Node<E> f = first;//先将原先的头节点保存
        final Node<E> newNode = new Node<>(e,null,f);
        first = newNode;//新插入进来的作为头节点
        if(null == f){//如果原先的头节点为空，表示此链表还是空
            last = newNode;//所以尾节点也是新插入的节点
        }else {//如果原先头节点不是空，那么原先的头节点的前驱指向新的头节点
            f.prev = newNode;
        }
        size++;
    }


    /**
     * 尾插
     * @param e
     */
    public void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(e,l,null);
        last = newNode;
        if(l == null){
            //说明是第一次插入
            first = newNode;
        }else{
            l.next = newNode;
        }
        size++;
    }




    @Override
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    @Override
    public boolean addFirst(E e) {
        linkFirst(e);
        return true;
    }

    @Override
    public boolean addLast(E e) {
        linkLast(e);
        return true;
    }



    @Override
    public boolean remove(Object o) {
        //删除的是Node的属性E item等于o的节点
        if (null == o) {
            for(Node<E> x = first; x != null; x = x.next){
                if(x.item == null){
                    unLink(x);
                    return true;
                }
            }
        }else{
            for(Node<E> x = first; x != null; x = x.next){
                if (o.equals(x.item)){
                    unLink(x);
                    return true;
                }
            }
        }
        return false;
    }

    private E unLink(Node<E> x) {
        final E element = x.item;

        final Node<E> prev = x.prev;
        final Node<E> next = x.next;
        //当前节点的前驱为null
        if(prev == null){
            first = next;
        }else{
            prev.next = next;
            x.prev = null;
        }
        //当前节点的后继为null
        if(next == null){
            last = prev;
        }else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;


    }

    @Override
    public E get(int index) {
        return node(index).item;
    }

    Node<E> node(int index) {
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++){
                x = x.next;
            }
            return x;
        }else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    @Override
    public void printLinkList() {
        if (size != 0){
            Node<E> x = first;
            System.out.print("头节点为："+ first+"尾节点为："+ last+"整体为：");
            for (int i = 0; i < size; i++){
                System.out.print(x.item+" ");
                x  = x.next;
            }
        }else {
            System.out.println("链表为空");
        }

    }

    public String getName() {
        return name;
    }


    protected static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
