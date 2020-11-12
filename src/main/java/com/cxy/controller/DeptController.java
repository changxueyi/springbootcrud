package com.cxy.controller;

import com.cxy.service.DeptService;
import com.cxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName DeptController
 * @Description TODO
 * @Author changxueyi
 * @Date 2020/11/12 17:41
 */
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping("/user/excel")
    public void excelExport(HttpServletResponse response) throws Exception {
        deptService.excelExport(response);
    }
    @PostMapping("/user/excel")
    public String excelImport(@RequestParam("file") MultipartFile file) throws IOException {
        deptService.excelImport(file);
        return "success";
    }
}