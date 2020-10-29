package com.cxy.common.enums;

/**
 * @ClassName ResponseStatus.java
 * @Description 接口状态
 * @Author liufenglei
 * @Date 2018/9/14 10:27
 * @Version 1.0
 **/
public enum ResponseStatus {

    // 成功
    SUCCESS("S0001","成功"),
    // 成功，结果为空
    SUCCESS_RESULT_IS_NULL("S0002","结果为空"),

    // 失败，系统异常，业务验证不通过
    FAIL_COMMOM("F0000","请求有误"),
    FAIL("F0001","未知错误"),
    FAIL_DATA_ALREADY_EXIST("F0002", "数据已经存在"),
    FAIL_DATA_NOT_EXIST("F0003","数据不存在"),
    FAIL_NOT_LOGIN("F0004","未登录"),

    // 参数错误
    PE_PARAM_CAN_NOT_BE_NULL("PE000","参数对象不能为空"),
    PE_ID_CAN_NOT_BE_NULL("PE001","参数id(ids)不能为空，且应为大于0的整数"),
    PE_CATEGORYCODE_CAN_NOT_BE_NULL("PE002","参数categoryCode不能为空"),
    PE_CATEGORYNAME_CAN_NOT_BE_NULL("PE003","参数categoryName不能为空"),
    PE_CATEGORYTYPE_CAN_NOT_BE_NULL("PE004", "参数categoryType不能为空"),
    PE_CATEGORYLEVEL_CAN_NOT_BE_ZERO("PE005","参数categoryLevel不能为空"),
    PE_PARENTCATEGORYCODE_CAN_NOT_BE_ZERO("PE006","参数parentCategoryCode不能为空"),
    PE_SALEACTIVITYNAME_CAN_NOT_BE_NULL("PE007","参数saleActivityName不能为空"),
    PE_SALEACTIVITYID_CAN_NOT_BE_NULL("PE008","参数saleActivityId不能为空"),
    PE_SALETYPE_CAN_NOT_BE_NULL("PE009", "参数saleType不能为空"),
    PE_PAGESIZE_CAN_NOT_BE_NULL("PE0010","参数pageSize应大于0"),
    PE_PAGENUM_CAN_NOT_BE_NULL("PE0011","参数pageNum应大于0"),
    PE_STARTDATE_CAN_NOT_BE_NULL("PE0012","参数startTime不能为空"),
    PE_ENDDATE_NOT_EXISTS("PE0013", "参数endTime不能为空"),
    PE_CATEGORYCODE_NOT_EXISTS("PE0014", "参数categoryCode（parentCategoryCode）错误，未查到数据"),
    PE_INFO_CAN_NOT_BE_NULL("PE0015","参数info不能为空"),
    PE_PIN_CAN_NOT_BE_NULL("PE0016","参数pin不能为空"),
    PE_SALEID_CAN_NOT_BE_NULL("PE0016","参数saleId不能为空"),
    PE_ORDERID_CAN_NOT_BE_NULL("PE0016","参数orderId（orderIds）不能为空");

    /**
     * 编码
     */
    public String code;
    /**
     * 信息
     */
    public String msg;

    ResponseStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}