package com.cxy.service.Impl;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.cxy.common.poi.ExcelListener;
import com.cxy.dao.DeptMapper;
import com.cxy.domin.Dept;
import com.cxy.service.DeptService;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

/**
 * @ClassName DeptServiceImpl
 * @Description TODO
 * @Author changxueyi
 * @Date 2020/11/12 17:43
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public void excelExport(HttpServletResponse response) throws IOException {
        List<Dept> list = deptMapper.queryAllDept();
        String fileName = "用户名单";
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + new String( fileName.getBytes("gb2312"), "ISO8859-1" ) + ".xls");
        ServletOutputStream out = response.getOutputStream();
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLS,true);
        Sheet sheet = new Sheet(1,0,Dept.class);
        //设置自适应宽度
        sheet.setAutoWidth(Boolean.TRUE);
        sheet.setSheetName("用户名单");
        writer.write(list,sheet);
        writer.finish();
        out.flush();
        response.getOutputStream().close();
        out.close();
    }

    @Override
    public void excelImport(MultipartFile file) throws IOException {
        if(!file.getOriginalFilename().equals("用户名单.xls") && !file.getOriginalFilename().equals("用户名单.xlsx") ){
            return;
        }
        InputStream inputStream = new BufferedInputStream(file.getInputStream());
        //实例化实现了AnalysisEventListener接口的类
        ExcelListener excelListener = new ExcelListener(deptMapper);
        ExcelReader reader = new ExcelReader(inputStream,null,excelListener);
        //读取信息
        reader.read(new Sheet(1,1,Dept.class));
    }
}