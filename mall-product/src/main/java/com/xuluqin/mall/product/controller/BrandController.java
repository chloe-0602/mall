package com.xuluqin.mall.product.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.xuluqin.mall.product.entity.BrandEntity;
import com.xuluqin.mall.product.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xuluqin.common.utils.PageUtils;
import com.xuluqin.common.utils.R;

import javax.validation.Valid;


/**
 * 品牌
 *
 * @author xuluqin
 * @email 13262816312@163.com
 * @date 2024-04-01 00:31:43
 */
@RestController
@RequestMapping("product/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:brand:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = brandService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{brandId}")
    //@RequiresPermissions("product:brand:info")
    public R info(@PathVariable("brandId") Long brandId){
		BrandEntity brand = brandService.getById(brandId);

        return R.ok().put("brand", brand);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:brand:save")
    public R save(@Valid @RequestBody BrandEntity brand, BindingResult result){
        Map<String, String> map = new HashMap<>();
        if (result.hasErrors()){
            // 1.获取错误信息
            result.getFieldErrors().forEach(item -> {
                // 2.获取错误提示
                String message = item.getDefaultMessage();
                // 3.获取错误的属性的名字
                String field = item.getField();
                // 4.将错误信息封装到map中
                map.put(field, message);
            });
            return R.error(400, "提交的数据不合法").put("data", map);
        }else{
            brandService.save(brand);
        }


        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:brand:update")
    public R update(@RequestBody BrandEntity brand){
		brandService.updateById(brand);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:brand:delete")
    public R delete(@RequestBody Long[] brandIds){
		brandService.removeByIds(Arrays.asList(brandIds));

        return R.ok();
    }

}
