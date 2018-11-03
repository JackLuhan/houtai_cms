package com.ypxx.manage.system.file;

import com.ypxx.manage.common.utils.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuwei on 2018/10/10.
 */
@Controller
@MultipartConfig
public class FileUploadController {

    @RequestMapping(value = "/upload/img", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> upload(@RequestParam("file") MultipartFile file){
        String url = null;
        try {
            url = FileUtils.upload("enterprise", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, Object> map = new HashMap<>();
        map.put("url",url);
        return map;
    }

}
