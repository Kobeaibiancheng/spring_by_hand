package com.yuxiang.design.framework.tree;

/**
 * 策略映射器，用来映射其他处理器
 * @param <T>
 * @param <D>
 * @param <R>
 */
public interface StrategyMapper <T,D,R>{

    StrategyHandler<T,D,R> get(T requestParameter,D dynamicParameter);
}
