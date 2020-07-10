package com.youyuan.springcloud.sentinel.controller;

import com.sun.org.apache.xerces.internal.impl.dv.InvalidDatatypeFacetException;
import com.youyuan.springcloud.sentinel.bean.NightTrialDetailRecordDto;
import com.youyuan.springcloud.sentinel.bean.NightTrialRecordDto;
import com.youyuan.springcloud.sentinel.enums.NightTrialStepEnum;
import com.youyuan.springcloud.sentinel.service.TestService;
import com.youyuan.springcloud.sentinel.test.Approver;
import com.youyuan.springcloud.sentinel.test.PurcheRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.BufferedOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/6/4 14:10
 */
@RestController
public class TestController {
    private final Approver departmentApprover;
    private final Approver collegeApprover;
    private final Approver viceSchoolMasterApprover;
    private final Approver schoolMasterApprover;
    private final TestService testService;

    public TestController(Approver departmentApprover, Approver collegeApprover, Approver viceSchoolMasterApprover, Approver schoolMasterApprover, TestService testService) {
        this.collegeApprover = collegeApprover;
        this.departmentApprover = departmentApprover;
        this.viceSchoolMasterApprover = viceSchoolMasterApprover;
        this.schoolMasterApprover = schoolMasterApprover;
        this.testService = testService;
    }

    @GetMapping("/test")
    public void test() {
        PurcheRequest purcheRequest = new PurcheRequest("服务器", 1, 29800);

        departmentApprover.setApprover(collegeApprover);
        collegeApprover.setApprover(viceSchoolMasterApprover);
        viceSchoolMasterApprover.setApprover(schoolMasterApprover);
        schoolMasterApprover.setApprover(departmentApprover);

        int num = 0;
        collegeApprover.validate(purcheRequest, num);
    }

    @GetMapping("/test1")
    public void test1(@RequestParam("step") String step) {
        testService.selectStep(step);
    }

    @GetMapping("/txt")
    public void exportLog(HttpServletResponse response) {
        List<NightTrialRecordDto> list = new ArrayList<>();
        List<NightTrialDetailRecordDto> stepDetailDto1 = new ArrayList<>();
        stepDetailDto1.add(new NightTrialDetailRecordDto(1, "订单1123432423423存在逾期占房，系统取消成功", ""));
        stepDetailDto1.add(new NightTrialDetailRecordDto(2, "订单7657767657657存在逾期占房，系统取消成功", ""));
        stepDetailDto1.add(new NightTrialDetailRecordDto(3, "订单9788980868687存在逾期占房，系统取消成功", ""));
        stepDetailDto1.add(new NightTrialDetailRecordDto(4, "订单8778687677767存在逾期占房，系统取消成功", ""));
        stepDetailDto1.add(new NightTrialDetailRecordDto(5, "订单2121318665776存在逾期占房，系统取消成功", ""));
        stepDetailDto1.add(new NightTrialDetailRecordDto(6, "散客预抵未到订单检查通过", ""));

        NightTrialRecordDto recordDto1 = new NightTrialRecordDto();
        recordDto1.setNightTrialStep(NightTrialStepEnum.STEP_1.getCode());
        recordDto1.setNightTrialStepName(NightTrialStepEnum.STEP_1.getDesc());
        recordDto1.setDetailRecordDtos(stepDetailDto1);
        recordDto1.setExitNightTrial(Boolean.TRUE);
        list.add(recordDto1);

        List<NightTrialDetailRecordDto> stepDetailDto2 = new ArrayList<>();
        stepDetailDto2.add(new NightTrialDetailRecordDto(7, "房间8502逾期未离店，请办理退房或续住", ""));
        stepDetailDto2.add(new NightTrialDetailRecordDto(8, "房间1123逾期未离店，请办理退房或续住", ""));
        stepDetailDto2.add(new NightTrialDetailRecordDto(9, "房间7867逾期未离店，请办理退房或续住", ""));
        stepDetailDto2.add(new NightTrialDetailRecordDto(10, "房间8976逾期未离店，请办理退房或续住", ""));
        stepDetailDto2.add(new NightTrialDetailRecordDto(11, "房间8767逾期未离店，请办理退房或续住", ""));
        stepDetailDto2.add(new NightTrialDetailRecordDto(12, "今日预离房间检查通过", ""));

        NightTrialRecordDto recordDto2 = new NightTrialRecordDto();
        recordDto2.setNightTrialStep(NightTrialStepEnum.STEP_2.getCode());
        recordDto2.setNightTrialStepName(NightTrialStepEnum.STEP_2.getDesc());
        recordDto2.setDetailRecordDtos(stepDetailDto2);
        recordDto2.setExitNightTrial(Boolean.TRUE);
        list.add(recordDto2);

        List<NightTrialDetailRecordDto> stepDetailDto3 = new ArrayList<>();
        stepDetailDto3.add(new NightTrialDetailRecordDto(13, "房间7801生成2019/03/04房费150元，账目ID:324234234", "324234234"));
        stepDetailDto3.add(new NightTrialDetailRecordDto(14, "房间7901生成2020/06/08房费170元，账目ID:879988799", "879988799"));
        stepDetailDto3.add(new NightTrialDetailRecordDto(15, "在住房间生成房费完成", ""));

        NightTrialRecordDto recordDto3 = new NightTrialRecordDto();
        recordDto3.setNightTrialStep(NightTrialStepEnum.STEP_3.getCode());
        recordDto3.setNightTrialStepName(NightTrialStepEnum.STEP_3.getDesc());
        recordDto3.setDetailRecordDtos(stepDetailDto3);
        recordDto3.setExitNightTrial(Boolean.TRUE);
        list.add(recordDto3);

        List<NightTrialDetailRecordDto> stepDetailDto4 = new ArrayList<>();
        stepDetailDto4.add(new NightTrialDetailRecordDto(16, "房间8891住净转住脏成功", ""));
        stepDetailDto4.add(new NightTrialDetailRecordDto(17, "房间8899住净转住脏成功", ""));
        stepDetailDto4.add(new NightTrialDetailRecordDto(18, "房态转换完成", ""));

        NightTrialRecordDto recordDto4 = new NightTrialRecordDto();
        recordDto4.setNightTrialStep(NightTrialStepEnum.STEP_4.getCode());
        recordDto4.setNightTrialStepName(NightTrialStepEnum.STEP_4.getDesc());
        recordDto4.setDetailRecordDtos(stepDetailDto4);
        recordDto4.setExitNightTrial(Boolean.TRUE);
        list.add(recordDto4);

        List<NightTrialDetailRecordDto> stepDetailDto5 = new ArrayList<>();
        stepDetailDto5.add(new NightTrialDetailRecordDto(19, "营业日转换为2020/06/10", ""));
        stepDetailDto5.add(new NightTrialDetailRecordDto(20, "夜审完成", ""));

        NightTrialRecordDto recordDto5 = new NightTrialRecordDto();
        recordDto5.setNightTrialStep(NightTrialStepEnum.STEP_5.getCode());
        recordDto5.setNightTrialStepName(NightTrialStepEnum.STEP_5.getDesc());
        recordDto5.setDetailRecordDtos(stepDetailDto5);
        recordDto5.setExitNightTrial(Boolean.TRUE);
        list.add(recordDto5);
        System.out.println("下载内容明细:" + list);

        //拼接字符串
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("获取营业日是").append("2020-06-11").append("\r\n");
        stringBuffer.append("开始执行夜审").append("\r\n\r\n");
        for (NightTrialRecordDto recordDto : list) {
            stringBuffer.append(recordDto.getNightTrialStepName()).append("\r\n");
            for (NightTrialDetailRecordDto detailRecordDto : recordDto.getDetailRecordDtos()) {
                stringBuffer.append(detailRecordDto.getNum()).append(".").append(detailRecordDto.getMsg()).append("\r\n");
            }
            stringBuffer.append("\r\n");
        }
        exportTxt(response, stringBuffer.toString());
    }

    public void exportTxt(HttpServletResponse response, String text) {
        response.setCharacterEncoding("utf-8");
        //设置响应的内容类型
        response.setContentType("text/plain");
        //设置文件的名称和格式
        response.addHeader("Content-Disposition", "attachment;filename="
                + genAttachmentFileName("酒店夜审日志", "默认文件名称")//设置名称格式，没有这个中文名称无法显示
                + ".txt");
        BufferedOutputStream buff = null;
        ServletOutputStream outStr = null;
        try {
            outStr = response.getOutputStream();
            buff = new BufferedOutputStream(outStr);
            buff.write(text.getBytes("UTF-8"));
            buff.flush();
            buff.close();
        } catch (Exception e) {
            //LOGGER.error("导出文件文件出错:{}",e);
        } finally {
            try {
                buff.close();
                outStr.close();
            } catch (Exception e) {
                //LOGGER.error("关闭流对象出错 e:{}",e);
            }
        }
    }

    //防止中文文件名显示出错

    public String genAttachmentFileName(String cnName, String defaultName) {
        try {
            cnName = new String(cnName.getBytes("gb2312"), "ISO8859-1");
        } catch (Exception e) {
            cnName = defaultName;
        }
        return cnName;
    }
}
