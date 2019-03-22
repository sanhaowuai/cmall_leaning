package com.mmall.service.impl;

import com.google.common.collect.Lists;
import com.mmall.common.ServerResponse;
import com.mmall.service.IFileService;
import com.mmall.util.FTPUtil;
import com.mmall.vo.ProductDetailVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @BelongsProject: cmall
 * @BelongsPackage: com.mmall.service.impl
 * @Author: 爱迪生
 * @CreateTime: 2018-10-30 14:03
 * @Description: 文件处理实现类
 */
@Service("iFileService")
public class FileServiceImpl implements IFileService {

    private static final Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    public String upload(MultipartFile file,String path){
        //得到上传时的文件名
        String fileName = file.getOriginalFilename();
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".")+1);
        String uploadFileName = UUID.randomUUID().toString()+"."+fileExtensionName;
        logger.info("开始上传文件，上传文件的文件名：{},上传的路径：{}，新文件名：{}",fileName,path,uploadFileName);
        File fileDir = new File(path);
        if(!fileDir.exists()){
            fileDir.setWritable(true);
            //mkdirs()可以建立多级文件夹， mkdir()只会建立一级的文件夹;例如：new File("/tmp/one/two/three").mkdirs();
            fileDir.mkdirs();
        }
        File targetFile = new File(path,uploadFileName);
        try {
            //上传，spring mvc提供MultipartFile,将file移动到targetfile目录下
            file.transferTo(targetFile);
            //将targetFile上传到FTP服务器
            FTPUtil.uploadFile(Lists.newArrayList(targetFile));
            //删除upload文件夹下面的文件
            targetFile.delete();
        } catch (IOException e) {
            logger.error("上传文件异常",e);
            return null;
        }
        return targetFile.getName();
    }

    public static void main(String[] args) {
        String fileName = "abc.jpg";
        System.out.println(fileName.lastIndexOf("."));
        System.out.println(fileName.substring(fileName.lastIndexOf(".")));
    }
}
