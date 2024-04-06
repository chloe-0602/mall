package com.xuluqin.mall.product.service.impl;

import com.xuluqin.mall.product.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuluqin.common.utils.PageUtils;
import com.xuluqin.common.utils.Query;

import com.xuluqin.mall.product.dao.CategoryDao;
import com.xuluqin.mall.product.entity.CategoryEntity;


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

    /**
     * 查询出所有的分类，并按照树形结构进行展示
     * @return
     */
    @Override
    public List<CategoryEntity> listWithTree() {
//        1.查询所有分类
        List<CategoryEntity> entities = baseMapper.selectList(null);
//        2. 封装成树形结构
//        2.1 找到所有的一级分类
        List<CategoryEntity> level1Menus = entities.stream().filter(categoryEntity ->
             categoryEntity.getParentCid() == 0)
                .map((menu)->{
                    menu.setChildren(getChildrens(menu,entities));
                    return menu;
                })
                .sorted((menu1, menu2) ->{
                    return ((menu1.getSort() == null? 0 : menu1.getSort()) - (menu2.getSort() == null? 0 : menu2.getSort()));
                })
                .collect(Collectors.toList());

        return level1Menus;


    }

    /**
     *递归查找所有菜单的子菜单
     * @param root
     * @param all
     * @return
     */
    private List<CategoryEntity> getChildrens(CategoryEntity root, List<CategoryEntity> all){

        List<CategoryEntity> children = all.stream()
                .filter(categoryEntity -> categoryEntity.getParentCid().equals(root.getCatId()))
                .map(categoryEntity -> {

                    // find the children
                    categoryEntity.setChildren(getChildrens(categoryEntity, all));
                    return categoryEntity;
                })
                .sorted((menu1, menu2) -> {

                    // sort
                    return ((menu1.getSort() == null? 0 : menu1.getSort()) - (menu2.getSort() == null? 0 : menu2.getSort()));
                }).collect(Collectors.toList());

        return children;
    }

}