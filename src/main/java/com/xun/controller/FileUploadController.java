package com.xun.controller;

import com.xun.pojo.Result;
import com.xun.utils.AliOssUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {
        String originalFilename = file.getOriginalFilename();
        //保证文件的名字是唯一的
        String filename = UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
        //file.transferTo(new File("D:\\Desktop\\test\\" + filename));
        String url = AliOssUtils.upLoadFile(filename,file.getInputStream());
        return Result.success(url);
    }
}
