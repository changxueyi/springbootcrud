package com.cxy.service;

import javax.servlet.http.HttpServletResponse;

public interface LogService {
    public void logDownload(String name, HttpServletResponse response) throws Exception;
}
