package com.yuxiang.design.framework.link;

import com.yuxiang.design.framework.link.chain.BusinessLinkedList;
import com.yuxiang.design.framework.link.handler.ILogicHandler;


/**
 * 链路装配
 * @param <T>
 * @param <D>
 * @param <R>
 */
public class LinkArmory <T,D,R> {


    private BusinessLinkedList<T,D,R> logicLink;






    @SafeVarargs
    public LinkArmory(String linkName, ILogicHandler<T, D, R>... logicHandlers) {
        logicLink = new BusinessLinkedList<>(linkName);//创建链路的名称
        for (ILogicHandler<T, D, R> logicHandler: logicHandlers){
            logicLink.add(logicHandler);//将所有的节点组装起来，尾插法
        }
    }


    public BusinessLinkedList<T, D, R> getLogicLink() {
        return logicLink;
    }

}
