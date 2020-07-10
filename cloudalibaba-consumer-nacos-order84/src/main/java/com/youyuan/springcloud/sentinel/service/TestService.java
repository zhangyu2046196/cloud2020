package com.youyuan.springcloud.sentinel.service;

import com.youyuan.springcloud.sentinel.test.Approver;
import com.youyuan.springcloud.sentinel.test.PurcheRequest;
import org.springframework.stereotype.Service;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/6/4 15:54
 */
@Service
public class TestService {

    private final Approver departmentApprover;
    private final Approver collegeApprover;
    private final Approver viceSchoolMasterApprover;
    private final Approver schoolMasterApprover;

    public TestService(Approver departmentApprover, Approver collegeApprover, Approver viceSchoolMasterApprover, Approver schoolMasterApprover) {
        this.collegeApprover = collegeApprover;
        this.departmentApprover = departmentApprover;
        this.viceSchoolMasterApprover = viceSchoolMasterApprover;
        this.schoolMasterApprover = schoolMasterApprover;
    }

    public void selectStep(String step) {
        PurcheRequest purcheRequest = new PurcheRequest("服务器", 1, 39800);

//        departmentApprover.setApprover(collegeApprover);
//        collegeApprover.setApprover(viceSchoolMasterApprover);
//        viceSchoolMasterApprover.setApprover(schoolMasterApprover);

        int num = 1;

        switch (step) {
            case "collegeApprover":
                collegeApprover.validate(purcheRequest, num);
                break;
            case "viceSchoolMasterApprover":
                viceSchoolMasterApprover.validate(purcheRequest, num);
                break;

            case "schoolMasterApprover":
                schoolMasterApprover.validate(purcheRequest, num);
                break;
            case "departmentApprover":
                departmentApprover.validate(purcheRequest, num);
                break;
            default:
                System.out.println("没有符合的参数");
        }
    }

}
