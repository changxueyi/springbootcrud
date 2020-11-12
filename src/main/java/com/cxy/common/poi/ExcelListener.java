package com.cxy.common.poi;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.cxy.dao.DeptMapper;
import com.cxy.domin.Dept;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ExcelListener
 * @Description TODO
 * @Author changxueyi
 * @Date 2020/11/12 17:57
 */
@Controller
public class ExcelListener extends AnalysisEventListener<Dept> {
    private List<Dept> datas = new ArrayList<>();
    private static final int BATCH_COUNT = 3000;
    private DeptMapper deptMapper;

    public ExcelListener(DeptMapper deptMapper){
        this.deptMapper = deptMapper;
    }

    @Override
    public void invoke(Dept dept, AnalysisContext analysisContext) {
        //数据存储到datas，供批量处理，或后续自己业务逻辑处理。
        datas.add(dept);
        //达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if(datas.size() >= BATCH_COUNT){
            saveData();
            // 存储完成清理datas
            datas.clear();
        }
    }

    private void saveData() {
        for(Dept dept : datas){
            deptMapper.addDept(dept);
        }
    }

    public List<Dept> getDatas() {
        return datas;
    }

    public void setDatas(List<Dept> datas) {
        this.datas = datas;
    }

    /**
     * 所有数据解析完成了 都会来调用
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();//确保所有数据都能入库
    }

   /* @Override
    public void invoke(Dept dept, AnalysisContext analysisContext) {

    }*/
}