package com.youyuan.delayqueue.exception;

/**
 * 类名称：ExceptionCode <br>
 * 类描述： 统一异常码接口定义 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/11/11 17:31<br>
 */
public interface ExceptionCode {

    /**
    * 方法名: getCode <br>
    * 方法描述: 获取异常编码 <br>
    *
    * @return {@link int 返回异常码}
    * @date 创建时间: 2020/11/11 17:32 <br>
    * @author zhangyu
    */
    int getCode();

    /**
    * 方法名: getInfo <br>
    * 方法描述: 获取异常信息 <br>
    *
    * @return {@link String 返回异常信息 }
    * @date 创建时间: 2020/11/11 17:32 <br>
    * @author zhangyu
    */
    String getInfo();
}
