package com.xun.service;

import com.xun.pojo.Category;

import java.util.List;

public interface CategoryService {

    //添加一个分类
    void add(Category category);

    //查询所有分类
    List<Category> list();

    //根据id查询详细信息
    Category findById(Integer id);

    //更新分类信息
    void update(Category category);

    //删除一个分类
    void delete(Integer id);
}
