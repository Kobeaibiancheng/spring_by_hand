package com.yuxiang.design.framework.tree;


/**
 * 策略处理器，用来处理业务
 * @param <T>
 * @param <D>
 * @param <R>
 */
public interface StrategyHandler <T,D,R>{

    /**
     * 当调用这个 StrategyHandler 的抽象方法时（apply方法），无论传入的参数是类型 T 还是 D，最终都返回 null。
     */
    StrategyHandler DEFAULT = (T, D) -> null;//函数时接口，只有一个抽象方法

    R apply(T requestParameter, D dynamicParameter);
}
