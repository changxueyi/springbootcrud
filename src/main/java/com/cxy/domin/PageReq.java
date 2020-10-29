package com.cxy.domin;

import com.alibaba.druid.util.StringUtils;


/**
 * Created with IntelliJ IDEA.
 * User: fuzhengwei1
 * Date: 15-12-8
 * Time: 下午4:11
 * To change this template use File | Settings | File Templates.
 */
public class PageReq {

    private int pageStart = 0;  //开始 limit 第一个参数
    private int pageEnd = 0;    //结束 limit 第二个参数

    private int page;   //页数
    private int rows;   //行数

    public PageReq() {
    }

    public PageReq(String page, String rows) {
        this.page = StringUtils.isEmpty(page) ? 1 : Integer.parseInt(page);
        this.rows = StringUtils.isEmpty(page) ? 2 : Integer.parseInt(rows);
        if (0 == this.page) {
            this.page = 1;
        }
        this.pageStart = (this.page - 1) * this.rows;
        this.pageEnd = this.rows;
    }

    public void setPage(String page, String rows) {
        this.page = StringUtils.isEmpty(page) ? 1 : Integer.parseInt(page);
        this.rows = StringUtils.isEmpty(page) ? 2 : Integer.parseInt(rows);
        if (0 == this.page) {
            this.page = 1;
        }
        this.pageStart = (this.page - 1) * this.rows;
        this.pageEnd = this.rows;
    }

    public int getPageStart() {
        return pageStart;
    }

    public void setPageStart(int pageStart) {
        this.pageStart = pageStart;
    }

    public int getPageEnd() {
        return pageEnd;
    }

    public void setPageEnd(int pageEnd) {
        this.pageEnd = pageEnd;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PageReq{");
        sb.append("pageStart=").append(pageStart);
        sb.append(", pageEnd=").append(pageEnd);
        sb.append(", page=").append(page);
        sb.append(", rows=").append(rows);
        sb.append('}');
        return sb.toString();
    }
}
