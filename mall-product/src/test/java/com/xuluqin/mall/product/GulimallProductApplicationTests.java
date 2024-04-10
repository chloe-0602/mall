package com.xuluqin.mall.product;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.xuluqin.mall.product.entity.BrandEntity;
import com.xuluqin.mall.product.entity.CategoryEntity;
import com.xuluqin.mall.product.service.BrandService;
import com.xuluqin.mall.product.service.CategoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * 1、引入oss-starter
 * 2、配置key，endpoint相关信息即可
 * 3、使用OSSClient 进行相关操作
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class GulimallProductApplicationTests {

    @Autowired
    BrandService brandService;

    @Test
    public void testUpload() throws FileNotFoundException {
        String endpoint = "oss-cn-shanghai.aliyuncs.com";
        String accessKeyId = "LTAI5tCHHtRoNLqXqhtt9gkR";
        String accessKeySecret = "QFn672ck3zKEHlraCCUD6g5i6mBorm";
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        InputStream inputStream = new FileInputStream("C:\\Users\\herry\\Desktop\\bug.jpg");
        ossClient.putObject("mall-cherry", "bug.jpg", inputStream);
        ossClient.shutdown();

        System.out.println("上传成功");
    }




    @Autowired
    CategoryService categoryService;



    @Test
    public void contextLoads() {

        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setBrandId(1L);
        brandEntity.setDescript("华为");

//
//        brandEntity.setName("华为");
//        brandService.save(brandEntity);
//        System.out.println("保存成功....");

//        brandService.updateById(brandEntity);
        List<BrandEntity> list = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id", 1L));
        list.forEach(item -> {
            System.out.println(item);
        });


    }

}
