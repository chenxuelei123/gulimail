package com.atguigu.gulimall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimall.product.dao.CategoryDao;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWidthTree() {
        //查出所有的数据
        List<CategoryEntity> entities = baseMapper.selectList(null);
        //封装树级数据
        List<CategoryEntity> level1Menus = entities.stream().filter(categoryEntity -> categoryEntity.getParentCid() == 0)
                .map((menu) -> {
                    menu.setChildren(getChildrens(menu, entities));
                    return menu;
                }).sorted(Comparator.comparingInt(menu -> (menu.getSort() != null ? menu.getSort() : 0)))
                .collect(Collectors.toList());
        return level1Menus;
    }

    /*
     * 递归获取子元素
     * */
    private List<CategoryEntity> getChildrens(CategoryEntity menu, List<CategoryEntity> entities) {
        List<CategoryEntity> children = entities.stream().filter(categoryEntity ->
                menu.getCatId() == categoryEntity.getParentCid()
        ).map(categoryEntity -> {
            categoryEntity.setChildren(getChildrens(categoryEntity, entities));
            return categoryEntity;
        }).sorted(Comparator.comparingInt(CategoryEntity -> (CategoryEntity.getSort() != null ? CategoryEntity.getSort() : 0))).collect(Collectors.toList());
        return children;
    }

}