package com.xuluqin.mall.thirdparty;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest
class GulimallThirdPartyApplicationTests {

    @Test
    void contextLoads() {


    }
//
//    @Autowired
//    OSSClient ossClient;

    @Test
    public void testUpload() throws FileNotFoundException {
        String endpoint = "oss-cn-shanghai.aliyuncs.com";
        String accessKeyId = "";
        String accessKeySecret = "";
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        InputStream inputStream = new FileInputStream("C:\\Users\\herry\\Desktop\\bug.jpg");
        ossClient.putObject("mall-cherry", "2.jpg", inputStream);
        ossClient.shutdown();

        System.out.println("上传成功");
    }
}
