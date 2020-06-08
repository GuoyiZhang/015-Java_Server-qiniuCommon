package pro.guoyi.qiniu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pro.guoyi.qiniu.model.RefreshUrlRequest;
import pro.guoyi.qiniu.utils.CommonUtil;
import pro.guoyi.qiniu.utils.QiniuUtil;
import pro.guoyi.qiniu.utils.response.Result;

import static pro.guoyi.qiniu.utils.response.ResponseCode.STATUS_SUCCESS;

/**
 * Created by kzyuan on 2017/6/20.
 */
@Controller
@Slf4j
@RequestMapping(value = "/upload")
public class QiniuController {

    @Autowired
    private QiniuUtil qiniuUtil;
    @Autowired
    private CommonUtil commonUtil;

    /**
     * @param multipartFile
     * @return
     */
    @RequestMapping(value = "/qiniuToken")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public Result<Object> qiniuToken() {

        /**
         * 七牛云文件上传 服务 file文件 以及 文件扩展名
         */
        String upToken = qiniuUtil.getUpToken();
        Result<Object> result = Result.wrapSuccessfulResult();
        result.setCode(STATUS_SUCCESS);
        result.setSuccess(true);
        result.setMessage("获取成功");
        result.setData(upToken);
        return result;
    }

    /**
     * @param multipartFile
     * @return
     */
    @RequestMapping(value = "/qiNiuUpload", method = RequestMethod.POST)
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public Result<Object> qiniuUpload(@RequestParam("file") MultipartFile multipartFile, @RequestParam("path") String path) {

        /**
         * MultipartFile 转 file 类型
         */
//        File file = commonUtil.multipartToFile(multipartFile);
        /**
         * 上传文件路径
         */
//        String fileName = path + file.getName();
        String fileName = path + multipartFile.getOriginalFilename();
        /**
         * 七牛云文件上传 服务 file文件 以及 文件扩展名
         */
        return qiniuUtil.uploadFile(multipartFile, fileName);
    }

    /**
     * @param linkList
     * @return
     */
    @RequestMapping(value = "/qiniuRefresh")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public Result<Object> qiniuRefresh(@RequestBody RefreshUrlRequest refreshUrlRequest) {
        return qiniuUtil.refreshUrl(refreshUrlRequest.getLinkList());
    }

}
