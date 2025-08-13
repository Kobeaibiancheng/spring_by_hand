package com.yuxiang.design.framework.link.chain;

import com.yuxiang.design.framework.link.handler.ILogicHandler;


/**
 * 业务链路
 * @param <T>
 * @param <D>
 * @param <R>
 */
public class BusinessLinkedList<T, D, R> extends LinkedList<ILogicHandler<T, D, R>> implements ILogicHandler<T,D,R> {


    public BusinessLinkedList(String name) {
        super(name);
    }



    @Override
    public R apply(T requestParameter, D dynamicContext) {
        Node<ILogicHandler<T, D, R>> current = super.first;
        do {
            ILogicHandler<T, D, R> item = current.item;
            R apply = item.apply(requestParameter, dynamicContext);
            if (null != apply) return apply;

            current = current.next;
        } while (null != current);
        return null;
    }
}
