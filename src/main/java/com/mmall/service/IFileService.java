package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @BelongsProject: cmall
 * @BelongsPackage: com.mmall.service
 * @Author: 爱迪生
 * @CreateTime: 2018-10-30 14:02
 * @Description: 文件处理
 */
public interface IFileService {

    String upload(MultipartFile file, String path);
}
