package com.cxy.controller.Es;

import com.alibaba.druid.util.StringUtils;
import com.cxy.common.enums.RpcStatus;
import com.cxy.common.res.Result;
import com.cxy.domin.BlogModel;
import com.cxy.service.Elasticsearch.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * @ClassName BlogController
 * @Description TODO
 * @Author changxueyi
 * @Date 2020/11/20 17:55
 */
@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogRepository blogRepository;

    /**
     * 添加
     */
    @PostMapping("/add")
    public Result add(@RequestBody BlogModel blogModel) {
        blogRepository.save(blogModel);
        return new Result(RpcStatus.SUCCESS.code, RpcStatus.SUCCESS.msg);
    }

    @GetMapping("/get/{id}")
    public ResultEs getById(@PathVariable String id) {
        if (StringUtils.isEmpty(id)) {
            return ResultEs.error();
        }
        Optional<BlogModel> blogModelOptional = blogRepository.findById(id);
        if (blogModelOptional.isPresent()) {
            BlogModel blogModel = blogModelOptional.get();
            return ResultEs.success(blogModel);
        }
        return ResultEs.error();
    }

    @GetMapping("/get")
    public ResultEs getAll() {
        Iterable<BlogModel> iterable = blogRepository.findAll();
        List<BlogModel> list = new ArrayList<>();
        iterable.forEach(list::add);
        return ResultEs.success(list);
    }


}