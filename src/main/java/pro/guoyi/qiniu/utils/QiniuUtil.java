package pro.guoyi.qiniu.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import pro.guoyi.qiniu.utils.request.RestClientUtils;
import pro.guoyi.qiniu.utils.response.Result;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import static pro.guoyi.qiniu.utils.response.ResponseCode.STATUS_ERROR;
import static pro.guoyi.qiniu.utils.response.ResponseCode.STATUS_SUCCESS;

/**
 * 七牛云 手写工具类
 * Created by kzyuan on 2017/6/20.
 */
@Component
public class QiniuUtil {

    @Value("${bucket}")
    private String bucketName;
    @Value("${accessKey}")
    private String accessKey;
    @Value("${secretKey}")
    private String secretKey;


    @Value("${domain}")
    private String domain;

    /**
     * 获取普通上传凭证
     *
     * @return
     */
    public String getUpToken() {
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucketName);
        System.out.println(upToken);
        return upToken;
    }

    /**
     * 获取覆盖上传凭证
     *
     * @return
     */
    public String getReUpToken(String fileKey) {
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucketName, fileKey);
        System.out.println(upToken);
        return upToken;
    }

    //通过文件路径上传文件
    public ExecuteResult<String> uploadFile(String localFile) {
        ExecuteResult<String> executeResult = new ExecuteResult<String>();

        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.region0());
        //其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //生成上传凭证，然后准备上传
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = null;
        String upToken = getUpToken();
        try {
            Response response = uploadManager.put(localFile, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
        return executeResult;
    }

    //通过File上传
    public ExecuteResult<String> uploadFile(File file, String key) {
        ExecuteResult<String> executeResult = new ExecuteResult<String>();

        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.region0());
        //其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //生成上传凭证，然后准备上传
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String upToken = getUpToken();
        try {
            Response response = uploadManager.put(file.getAbsolutePath(), key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
            executeResult.setSuccessMessage("上传成功!");
            executeResult.setResult(getDownloadFileUrl(putRet.key));
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            executeResult.addErrorMessage("上传失败");
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
        return executeResult;
    }

    /**
     * 从 inputstream 中写入七牛
     *
     * @param key  文件名
     * @param file 文件
     * @return
     */
    public Result<Object> uploadFile(MultipartFile file, String key) {
        Result<Object> result = Result.wrapSuccessfulResult();
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.huanan());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        try {
            ByteArrayInputStream byteInputStream = new ByteArrayInputStream(file.getBytes());
            String upToken = getUpToken();
            try {
                Response response = uploadManager.put(byteInputStream, key, upToken, null, null);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                System.out.println(putRet.key);
                System.out.println(putRet.hash);
                result.setCode(STATUS_SUCCESS);
                result.setSuccess(true);
                result.setMessage("上传成功");
                HashMap<String, Object> map = new HashMap<>();
                map.put("url", getDownloadFileUrl(putRet.key));
                map.put("hash", putRet.hash);
                map.put("key", putRet.key);
                result.setData(map);
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                result.setCode(STATUS_ERROR);
                result.setSuccess(false);
                result.setMessage("上传失败：" + r.error);
                result.setData(r);
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
        } catch (UnsupportedEncodingException ex) {
            //ignore
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    //获得下载地址
    public String getDownloadFileUrl(String fileName) {
        String finalUrl = String.format("%s%s", domain, fileName);
        System.out.println(finalUrl);
        return finalUrl;
    }

    //删除文件
    public void deleteFile(String filename) {
        int aaa = 1;

    }

    public Result<Object> refreshUrl(String[] urlList) {
//        RestClientUtils.postJson()
        return null;
    }
}