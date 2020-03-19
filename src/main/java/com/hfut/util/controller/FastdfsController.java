package com.hfut.util.controller;

import com.hfut.util.component.FastdfsClientUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * Copyright(C),2016-2020,合肥工业大学
 * FileName:FastdfsController
 * Author:  陈志浩
 * Date:    2020/2/3 9:05
 * Description:控制层
 */

@Controller
public class FastdfsController {

    @Resource
    FastdfsClientUtil fastdfsClientUtil;

    /**
     * 获取路径
     *
     * @param multipartFile 文件名
     * @return 文件在FastDFS的路径
     */
    public String getPath(MultipartFile multipartFile) {
        try {
            String upload = fastdfsClientUtil.upload(multipartFile);
            StringBuilder url = new StringBuilder();
            url.append("http://47.100.139.173:8888/");
            url.append(upload);
            System.out.println("=========================");
            return url.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
