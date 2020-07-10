package com.youyuan.springcloud.sentinel.test;

import org.springframework.stereotype.Service;

/**
 * @author zhangy
 * @version 1.0
 * @description 设计模式—行为型—职责链模式
 * <p>
 * 系主任
 * @date 2019/12/9 11:34
 */
@Service
public class DepartmentApprover extends Approver {

    private final Approver collegeApprover;
    /**
     * 审批开始金额
     */
    private float startPrice = 0;
    /**
     * 审批结束金额
     */
    private float endPrice = 5000;

    public DepartmentApprover(Approver collegeApprover) {
        this.collegeApprover = collegeApprover;
        this.setApprover(collegeApprover);
    }

    @Override
    public void processRequest(PurcheRequest purcheRequest, Integer num) {
        System.out.println("系主任 num:" + num++);
        if (purcheRequest.getPrice() > startPrice && purcheRequest.getPrice() <= endPrice) {
            System.out.println("执行采购步骤为 " + purcheRequest.getId() + " 执行人：" + getName());
        } else {
            this.getApprover().processRequest(purcheRequest, num);
        }
    }
}
