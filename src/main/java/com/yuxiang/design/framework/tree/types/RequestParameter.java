package com.yuxiang.design.framework.tree.types;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestParameter {

    private String name;
    private String value;
    private String price;
    private String channel;
}
