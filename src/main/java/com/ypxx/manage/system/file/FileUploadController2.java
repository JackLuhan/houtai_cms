package com.ypxx.manage.system.file;

import com.ypxx.manage.common.utils.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuwei on 2018/10/10.
 */
@Controller
@MultipartConfig
public class FileUploadController2 {

    @RequestMapping(value = "/upload/img2", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> upload(@RequestParam("file") MultipartFile file){
        String url = null;
        try {
            url = FileUtils.upload("enterprise", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map2 = new HashMap<>();
        if (url == null){
            map.put("msg","上传失败");
            map.put("code",1);
            return map;
        }
        map.put("msg","上传成功");
        map.put("code",0);
        map2.put("src",url);
        map2.put("title",file.getOriginalFilename());
        map.put("data",map2);
        return map;
    }

}
