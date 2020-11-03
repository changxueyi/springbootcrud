package com.cxy.service.Impl;

import com.cxy.service.LogService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

/**
 * @ClassName LogService
 * @Description TODO
 * @Author changxueyi
 * @Date 2020/11/3 16:30
 */
@Service
class LogServiceImpl implements LogService {
    public void logDownload(String name, HttpServletResponse response) throws Exception {
        File file = new File("logs" + File.separator + name);
        if (!file.exists()) {
            throw new Exception(name + "文件不存在");
        }
        response.setContentType("application/force-download");
        response.addHeader("Content-Disposition", "attachment;fileName=" + name);
        byte[] buffer = new byte[1024];
        try (FileInputStream fis = new FileInputStream(file);
             BufferedInputStream bis = new BufferedInputStream(fis)) {

            OutputStream os = response.getOutputStream();

            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
        }
    }
}