package com.wyh10000.controller.fdfs;

import com.wyh10000.common.result.R;
import com.wyh10000.common.util.FDFSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;

/**
 *@Author feri
 *@Date Created in 2018/9/11 14:54
 */
@RestController
public class FdfsController {

    @Autowired
    private FDFSUtil fdfsUtil;


    private String url="http://10.8.163.50/";
    //上传
    @PostMapping("fileup.do")
    public R fileup(@RequestParam("feri") CommonsMultipartFile multipartFile) throws Exception {
       String filename=multipartFile.getOriginalFilename();
       String sub=filename.substring(filename.lastIndexOf(".")+1);
       String filepath= fdfsUtil.upload_file(multipartFile.getBytes(),sub,null);
       System.out.println("FASTDFS文件上传："+filepath);
       return new R(1001,url+filepath);
    }

}
