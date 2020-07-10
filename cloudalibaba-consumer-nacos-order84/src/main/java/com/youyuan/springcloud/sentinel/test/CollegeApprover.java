package com.youyuan.springcloud.sentinel.test;

import org.springframework.stereotype.Service;

/**
 * @author zhangy
 * @version 1.0
 * @description 设计模式—行为型—职责链模式
 * <p>
 * 院长
 * @date 2019/12/9 11:40
 */
@Service
public class CollegeApprover extends Approver {

    private final Approver viceSchoolMasterApprover;
    /**
     * 审批开始金额
     */
    private float startPrice = 5000;
    /**
     * 审批结束金额
     */
    private float endPrice = 10000;

    public CollegeApprover(Approver viceSchoolMasterApprover) {
        this.viceSchoolMasterApprover = viceSchoolMasterApprover;
        this.setApprover(viceSchoolMasterApprover);
    }

    @Override
    public void processRequest(PurcheRequest purcheRequest, Integer num) {
        System.out.println("院长 num:" + num++);
        if (purcheRequest.getPrice() > startPrice && purcheRequest.getPrice() <= endPrice) {
            System.out.println("执行采购步骤为 " + purcheRequest.getId() + " 执行人：" + getName());
        } else {
            this.getApprover().processRequest(purcheRequest, num);
        }
    }
}
