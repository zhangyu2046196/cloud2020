package com.youyuan.springcloud.sentinel.test;

/**
 * @author zhangy
 * @version 1.0
 * @description 设计模式—行为型—职责链模式
 * <p>
 * 请求类  对象
 * @date 2019/12/9 11:32
 */
public class PurcheRequest {
    /**
     * 采购商品名字
     */
    private String name;
    /**
     * 采购序号
     */
    private int id;
    /**
     * 金额
     */
    private float price;

    public PurcheRequest(String name, int id, float price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
