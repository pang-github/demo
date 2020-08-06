package com.sweet.core.model.system;

import lombok.Data;

import java.util.List;

@Data
public class Routers {
    private String path;
    //
    private String component;
    //重定向地址，在面包屑中点击会重定向去的地址
    private String redirect;
    //当设置 true 的时候该路由不会在侧边栏出现
    private String hidden;
    // 设定路由的名字，一定要填写
    private String name;
    private List<Children> children;
}
