package com.hfut.util;

import com.hfut.util.controller.FastdfsController;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import org.apache.http.entity.ContentType;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;

@SpringBootTest
class UtilApplicationTests {

    @Resource
    FastdfsController fastdfsController;

    @Test
    void contextLoads() throws Exception {
        String path = "F:\\wechat_devtool\\demo5\\image\\search";
        String fullPath = path + ".png";
        File file = new File(fullPath);
        FileInputStream fileInputStream = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile(file.getName(), file.getName(),
                ContentType.APPLICATION_OCTET_STREAM.toString(), fileInputStream);      // 将File转化为MultipartFile文件
        System.out.println(fastdfsController.getPath(multipartFile));

    }
}
