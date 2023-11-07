package com.xun.service;

import com.xun.pojo.Article;
import com.xun.pojo.Category;
import com.xun.pojo.PageBean;

public interface ArticleService {
    void add(Article article);

    //条件分页列表
    PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state);

    //查询详情
    Article detail(Integer id);

    //更行信息
    void update(Article article);

    void delete(Integer id);
}
