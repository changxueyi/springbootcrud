package com.cxy.dao;

import com.cxy.domin.Dept;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @ClassName DeptMapper
 * @Description TODO
 * @Author changxueyi
 * @Date 2020/11/12 17:43
 */

public interface DeptMapper {
    List<Dept> queryAllDept();
    void addDept(Dept dept);
}