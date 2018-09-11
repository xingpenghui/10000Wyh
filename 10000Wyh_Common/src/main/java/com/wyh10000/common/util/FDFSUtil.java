package com.wyh10000.common.util;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;

/**
 *@Author feri
 *@Date Created in 2018/9/11 14:49
 */
public class FDFSUtil {
    private TrackerClient trackerClient;
    private TrackerServer trackerServer;
    private StorageClient1 storageClient;
    private StorageServer storageServer;

    public FDFSUtil(String conf) throws Exception {
        if (conf.startsWith("classpath")) {//如果配置文件是 classpath 开头的,则代表是在类路径中,去掉 classpath: 然后拼接类路径
            conf=conf.replace("classpath:", getClass().getResource("/").getPath());
            System.out.println(getClass().getResource("/").getPath());
            System.out.println(conf);
        }
        ClientGlobal.init(conf);//加载路径
        trackerClient=new TrackerClient();
        trackerServer=trackerClient.getConnection();
        storageClient=new StorageClient1(trackerServer, storageServer);
    }
    /**
     上传文件,参数是文件的路径,后缀名和元数据
     */
    public String  upload_file(String fileName,String ext_name,NameValuePair[] pairs) throws Exception {
        return storageClient.upload_file1(fileName, ext_name, pairs);
    }

    public String upload_file(String fileName)  throws Exception{
        return upload_file(fileName, null, null);
    }


    public String upload_file(String fileName,String ext_name)  throws Exception{
        return upload_file(fileName, ext_name, null);
    }

    public String upload_file(String fileName,NameValuePair[] pairs)  throws Exception{
        return upload_file(fileName, null, pairs);
    }
    /**
     上传二进制数据,需要将文件先转换为二进制
     */
    public String upload_file(byte[]source,String ext_name,NameValuePair[] pairs) throws Exception{
        return storageClient.upload_file1(source, ext_name, pairs);
    }
}
