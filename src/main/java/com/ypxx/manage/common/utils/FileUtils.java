package com.ypxx.manage.common.utils;

import com.google.gson.Gson;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by xuwei on 2018/10/10.
 */
public class FileUtils {

    private static String bucket = "ypsc";
    private static String domainOfBucket = "http://pbdwj52zy.bkt.clouddn.com";

    private static Configuration cfg = new Configuration(Zone.zone0());

    public static String upload(String key, MultipartFile file) throws IOException {
        UploadManager uploadManager = getUploadManager();
        Auth auth = getAuth();
        String upToken = auth.uploadToken(bucket);

        Response response = uploadManager.put(file.getBytes(), key + UUID.randomUUID().toString().replaceAll("-", ""), upToken);
        DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
        return domainOfBucket + "/" + putRet.key;
    }

    private static UploadManager getUploadManager() {
        return new UploadManager(cfg);
    }

    static Auth getAuth() {
        String accessKey = "2xgaX0CJVTUJp7T0EKiomLFFkPIRVNymuQDSvYaj";
        String secretKey = "VWq8oIbr-VG9FFk-KJoYJTieISGiPmu-WVtWZ6sg";
        return Auth.create(accessKey, secretKey);
    }
}
