package com.cxy.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName DeptService
 * @Description TODO
 * @Author changxueyi
 * @Date 2020/11/12 17:42
 */
public interface DeptService {
    void excelExport(HttpServletResponse response) throws Exception;

    void excelImport(MultipartFile file) throws IOException;
}