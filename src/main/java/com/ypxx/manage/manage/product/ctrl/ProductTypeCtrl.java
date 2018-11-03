package com.ypxx.manage.manage.product.ctrl;

import com.ypxx.manage.manage.product.entity.ProductTypeEntity;
import com.ypxx.manage.manage.product.service.TypeService;
import com.ypxx.manage.manage.product.service.impl.ProductTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("type")
public class ProductTypeCtrl {
    @Autowired
    TypeService typeService;


    @RequestMapping("/index")
    public String index(Model model, @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        System.out.println("--------------类别主页 pageNum:" + pageNum + "-----pageSize:" + pageSize + "------------");
        Page<ProductTypeEntity> page = typeService.getType(pageNum, pageSize);
        model.addAttribute("count", typeService.count());
        model.addAttribute("page", page);
        return "product/type";
    }

    @RequestMapping("/add")
    public String add() {
        return "product/type_add";
    }

    @RequestMapping("/adddo")
    @ResponseBody
    public Map<String, Object> adddo(String typename, Integer typeweight) {
        System.out.println("--------------添加类别----------------");
        Map<String, Object> map = new HashMap<>();

        if (typename != null && typeweight != null && !typename.trim().equals("")) {
            System.out.println("-------------" + typename + "---" + typeweight + "-------------------");
            ProductTypeEntity type = new ProductTypeEntity();
            type.setTypeName(typename);
            type.setTypeWeight(typeweight);
            typeService.addType(type);
            map.put("status", 1);
            return map;
        }
        map.put("status", 0);
        return map;
    }

    @RequestMapping("/modify")
    public String modify(Model model, Long id) {
        System.out.println("-------------修改类别" + id + "-------------------");
        ProductTypeEntity productTypeEntity = typeService.getOneType(id);
        model.addAttribute("productTypeEntity", productTypeEntity);
        return "product/type_modify";
    }

    @RequestMapping("/modifydo")
    @ResponseBody
    public Map<String, String> modifydo(Model model, Long id, String typename, Integer typeweight) {
        System.out.println("-------------修改类别do" + id + " " + typename + " " + typeweight + "-------------------");
        Map<String, String> map = new HashMap<>();
        if (id != null && typename != null && typeweight != null && !typename.equals("")) {
            ProductTypeEntity productTypeEntity = typeService.getOneType(id);
            productTypeEntity.setTypeName(typename);
            productTypeEntity.setTypeWeight(typeweight);
            typeService.addType(productTypeEntity);
            map.put("status", "1");
            return map;
        }
        map.put("status", "0");
        return map;
    }

    @RequestMapping("/del")
    @ResponseBody
    public Map<String, Object> del(Long id) {
        System.out.println("------------删除类别" + id + "---------------");
        Map<String, Object> map = new HashMap<>();

        if (id != null) {
            typeService.deleteType(id);
            map.put("status", 1);
            System.out.println("删除成功");
            return map;
        }
        System.out.println("删除失败");

        map.put("status", 1);
        return map;
    }
}
