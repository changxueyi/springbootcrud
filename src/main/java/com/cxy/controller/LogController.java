package com.cxy.controller;

import com.cxy.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName LogController
 * @Description TODO
 * @Author changxueyi
 * @Date 2020/11/3 16:38
 */
@RestController
@Scope("prototype")
@RequestMapping("/log")
public class LogController {
    @Autowired
    private LogService logService;

    /**
     * 下载日志接口
     */
    @GetMapping(value = "/download/{name}")
    public void logDownload(@PathVariable String name, HttpServletResponse response) throws Exception {
        logService.logDownload(name, response);
    }
}
