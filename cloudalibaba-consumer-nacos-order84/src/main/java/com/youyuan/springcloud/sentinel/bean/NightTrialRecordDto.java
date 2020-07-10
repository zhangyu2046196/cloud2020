package com.youyuan.springcloud.sentinel.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 类名称：NightTrialRecordDto <br>
 * 类描述：socket推送夜审步骤标题信息 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/6/6 16:02<br>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NightTrialRecordDto implements Serializable {

    private static final long serialVersionUID = 1925906520790338215L;

    /**
     * 步骤结果  true退出夜审(校验失败、步骤夜审失败、完成夜审)  false继续夜审(校验成功、步骤夜审成功)
     */
    private Boolean exitNightTrial;
    /**
     * 夜审步骤编码
     */
    private String nightTrialStep;
    /**
     * 夜审步骤编码描述
     */
    private String nightTrialStepName;
    /**
     * 夜审步骤详情列表
     */
    private List<NightTrialDetailRecordDto> detailRecordDtos;
}
