package com.cxy.domin;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @ClassName Dept
 * @Description TODO
 * @Author changxueyi
 * @Date 2020/11/12 17:00
 */
public class Dept extends BaseRowModel {
    @ExcelProperty(value = "deptNo", index = 0)
    private Integer deptNo;
    @ExcelProperty(value = "部门名", index = 1)
    private String deptName;
    @ExcelProperty(value = "localtion", index = 2)
    private String localtion;

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getLocaltion() {
        return localtion;
    }

    public void setLocaltion(String localtion) {
        this.localtion = localtion;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptNo=" + deptNo +
                ", deptName='" + deptName + '\'' +
                ", localtion='" + localtion + '\'' +
                '}';
    }
}