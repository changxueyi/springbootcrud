package com.cxy.service.Elasticsearch;

import com.cxy.domin.BlogModel;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


/**
 * @ClassName BlogRepository
 * @Description TODO
 * @Author changxueyi
 * @Date 2020/11/20 17:54
 */
public interface BlogRepository extends ElasticsearchRepository<BlogModel, String> {
}