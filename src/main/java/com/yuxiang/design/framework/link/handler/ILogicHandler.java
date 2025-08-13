package com.yuxiang.design.framework.link.handler;


/**
 * 逻辑处理器
 * @param <T>
 * @param <D>
 * @param <R>
 */
public interface ILogicHandler<T, D, R> {

    default R next(T requestParameter, D dynamicContext){
        return null;
    }


    public R apply(T requestParameter, D dynamicContext);

}
