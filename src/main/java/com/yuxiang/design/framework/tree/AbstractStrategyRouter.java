package com.yuxiang.design.framework.tree;

import lombok.Getter;
import lombok.Setter;

public abstract class AbstractStrategyRouter<T, D, R> implements StrategyHandler<T, D, R>,StrategyMapper<T, D, R>{
    @Getter
    @Setter
    protected StrategyHandler<T, D, R> defaultStrategyHandler = StrategyHandler.DEFAULT;



    public R router(T requestParameter,D dynamicParameter){
        StrategyHandler<T, D, R> strategyHandler = get(requestParameter, dynamicParameter);

        if (null != strategyHandler){
            return strategyHandler.apply(requestParameter, dynamicParameter);
        }else {
            return defaultStrategyHandler.apply(requestParameter, dynamicParameter);
        }
    }

}
