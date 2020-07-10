//package com.youyuan.springcloud.sentinel.test;
//
///**
// * @author zhangy
// * @version 1.0
// * @description
// * @date 2019/12/9 11:44
// */
//public class Client {
//
//    public static void main(String[] args) {
//        PurcheRequest purcheRequest = new PurcheRequest("服务器", 1, 29800);
//
//        DepartmentApprover departmentApprover = new DepartmentApprover("系主任");
//
//        CollegeApprover collegeApprover = new CollegeApprover("院长");
//
//        ViceSchoolMasterApprover viceSchoolMasterApprover = new ViceSchoolMasterApprover("副校长");
//
//        SchoolMasterApprover schoolMasterApprover = new SchoolMasterApprover("校长");
//
//        departmentApprover.setApprover(collegeApprover);
//        collegeApprover.setApprover(viceSchoolMasterApprover);
//        viceSchoolMasterApprover.setApprover(schoolMasterApprover);
//        schoolMasterApprover.setApprover(departmentApprover);
//
//        departmentApprover.processRequest(purcheRequest);
//    }
//
//}
