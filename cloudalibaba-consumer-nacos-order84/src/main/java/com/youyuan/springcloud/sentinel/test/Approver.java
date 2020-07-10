package com.youyuan.springcloud.sentinel.test;

import org.springframework.scheduling.annotation.Async;

/**
 * @author zhangy
 * @version 1.0
 * @description 设计模式—行为型—职责链模式
 * <p>
 * 处理者抽象类
 * @date 2019/12/9 11:30
 */
public abstract class Approver {
    /**
     * 名字
     */
    private String name;
    /**
     * 下一个处理者
     */
    private Approver approver;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Approver getApprover() {
        return approver;
    }

    public void setApprover(Approver approver) {
        this.approver = approver;
    }

    /**
     * 处理方法
     *
     * @param purcheRequest 处理请求对象
     */
    public abstract void processRequest(PurcheRequest purcheRequest, Integer num);

    @Async
    public void validate(PurcheRequest purcheRequest, Integer num) {
        System.out.println("校验");
        processRequest(purcheRequest, num);
    }
}
