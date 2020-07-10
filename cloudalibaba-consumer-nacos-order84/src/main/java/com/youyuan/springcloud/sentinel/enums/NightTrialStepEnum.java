package com.youyuan.springcloud.sentinel.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 类名称：NightTrialStepEnum<br>
 * 类描述：夜审步骤枚举 <br>
 *
 * @author 冯亚鹏
 * @version 1.0.0
 * @date 创建时间：2020/4/4 19:15<br>
 */
@Getter
@AllArgsConstructor
public enum NightTrialStepEnum {

    /**
     * 夜审校验步骤01
     */
    VALIDATE_1("validateStep1", "校验营业日是否为空"),

    /**
     * 夜审校验步骤02
     */
    VALIDATE_2("validateStep2", "校验是否存在夜审成功记录"),

    /**
     * 夜审校验步骤03
     */
    VALIDATE_3("validateStep3", "校验是否存在正在执行夜审"),

    /**
     * 夜审校验步骤04
     */
    VALIDATE_4("validateStep4", "校验营业日是否符合夜审规则"),


    /**
     * 夜审步骤01
     */
    STEP_1("nightTrialStep1", "散客预抵未住订单检查"),
    /**
     * 夜审步骤02
     */
    STEP_2("nightTrialStep2", "今日预离房间检查"),
    /**
     * 夜审步骤03
     */
    STEP_3("nightTrialStep3", "在住房间生成房费"),
    /**
     * 夜审步骤04
     */
    STEP_4("nightTrialStep4", "住净客房转住脏"),
    /**
     * 夜审步骤05
     */
    STEP_5("nightTrialStep5", "转换营业日");

    /**
     * 步骤编码
     */
    private String code;
    /**
     * 步骤描述
     */
    private String desc;

    /**
     * 方法名: enums
     * 方法描述: 封装所有步骤 <br>
     *
     * @return {@link List<NightTrialStepEnum>}
     * @date 创建时间: 2020/4/4 19:21 <br>
     * @author 冯亚鹏
     */
    public static List<NightTrialStepEnum> enums() {
        return Stream.of(NightTrialStepEnum.STEP_1, NightTrialStepEnum.STEP_2, NightTrialStepEnum.STEP_3,
                NightTrialStepEnum.STEP_4, NightTrialStepEnum.STEP_5)
                .collect(Collectors.toList());
    }

    /**
     * 方法名: descByCode
     * 方法描述: 根据编码获取步骤描述 <br>
     *
     * @param code 步骤编码
     * @return {@link String}
     * @date 创建时间: 2020/4/4 19:22 <br>
     * @author 冯亚鹏
     */
    public static String descByCode(String code) {
        for (NightTrialStepEnum statusEnum : enums()) {
            if (statusEnum.getCode().equals(code)) {
                return statusEnum.getDesc();
            }
        }
        return null;
    }

}
