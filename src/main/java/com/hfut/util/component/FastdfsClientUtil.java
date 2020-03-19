package com.hfut.util.component;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * Copyright(C),2016-2020,合肥工业大学
 * FileName:FastdfsClientUtil
 * Author:  陈志浩
 * Date:    2020/2/3 9:04
 * Description:通过fastdfs获取图片路径
 */

@Component
    public class FastdfsClientUtil {

    @Resource
    private FastFileStorageClient storageClient;

    /**
     * 上传文件
     *
     * @param multipartFile 文件名
     * @return 文件在FastDFS中的路径
     * @throws Exception 异常
     */
    public String upload(MultipartFile multipartFile) throws Exception {
        // 文件名
        String originalFilename = Objects.requireNonNull(multipartFile.getOriginalFilename()).substring(
                multipartFile.getOriginalFilename().lastIndexOf(".") + 1);
        StorePath storePath = this.storageClient.uploadImageAndCrtThumbImage(multipartFile.getInputStream(),
                multipartFile.getSize(), originalFilename, null);
        // 文件在FastDFS中的路径
        return storePath.getFullPath();
    }
}
