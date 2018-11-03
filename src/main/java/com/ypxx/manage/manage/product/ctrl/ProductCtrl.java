package com.ypxx.manage.manage.product.ctrl;

import com.ypxx.manage.manage.product.entity.ProductEntity;
import com.ypxx.manage.manage.product.entity.ProductTypeEntity;
import com.ypxx.manage.manage.product.service.ProductService;
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
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("product")
public class ProductCtrl {

    @Autowired
    ProductService productService;

    @Autowired
    TypeService typeService;

    @RequestMapping("/index")
    public String index(Model model, @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        System.out.println("--------------产品主页 pageNum:" + pageNum + "-----pageSize:" + pageSize + "------------");
        Page<ProductEntity> page = productService.getProduct(pageNum, pageSize);

        List<ProductTypeEntity> list = typeService.getAll();
        model.addAttribute("list", list);
        model.addAttribute("page", page);
        model.addAttribute("count", productService.count());
        return "product/product";
    }

    @RequestMapping("/seach")
    public String seach(Model model, @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize, Long typeid, String seachtext) {
        System.out.println("----搜索--typeid:" + typeid + "-----seachtext" + seachtext + "---------");

        Page<ProductEntity> page = productService.seachProduct(pageNum, pageSize, typeid, seachtext);

        List<ProductTypeEntity> list = typeService.getAll();
        model.addAttribute("list", list);
        model.addAttribute("page", page);
        model.addAttribute("count", page.getTotalElements());
        return "product/product";
    }

    @RequestMapping("/add")
    public String add(Model model) {
        System.out.println("--------------产品-------------");
        List<ProductTypeEntity> list = typeService.getAll();
        model.addAttribute("list", list);
        return "product/product_add";
    }

    @RequestMapping("/adddo")
    @ResponseBody
    public Map<String, Object> adddo(String productName, String describes, String picture, Long typeID) {
        System.out.println("----typeID:" + typeID + "----------产品添加do---productName:" + productName + "----- describes:" + describes + "----picture:" + picture);
        Map<String, Object> map = new HashMap<>();

        if (productName != null && describes != null && picture != null && typeID != null && !productName.equals("") && !describes.equals("") && !picture.equals("")) {
            ProductEntity productEntity = new ProductEntity();
            productEntity.setProductName(productName);
            productEntity.setProductTypeID(typeID);
            productEntity.setProductTypeNames(typeService.getOneType(typeID).getTypeName());
            productEntity.setPictures(picture);
            productEntity.setDescribes(describes);
            map.put("status", 1);
            productService.addProduct(productEntity);
            return map;
        }
        map.put("status", 0);

        return map;
    }

    @RequestMapping("/edit")
    public String edit(Model model, Long id) {
        System.out.println("---------修改请求----------------");
        ProductEntity product = productService.getOneProduct(id);

        List<ProductTypeEntity> list = typeService.getAll();
        model.addAttribute("list", list);

        model.addAttribute("product", product);
        return "product/product_modify";
    }

    @RequestMapping("/editdo")
    @ResponseBody
    public Map<String, Object> editdo(Long id, String productName, String describes, String picture, Long typeID) {
        System.out.println("--修改请求-id:" + id + "---productName:" + productName + "--describes" + describes + "---typeID:" + typeID + "---picture:" + picture);

        ProductEntity productEntity = productService.getOneProduct(id);
        productEntity.setId(id);
        productEntity.setProductName(productName);
        productEntity.setProductTypeID(typeID);
        productEntity.setDescribes(describes);
        productEntity.setProductTypeNames(typeService.getOneType(typeID).getTypeName());
        if (picture != null && !picture.equals("")) {
            productEntity.setPictures(picture);
        }
        productService.modifyProduct(productEntity);

        Map<String, Object> map = new HashMap<>();
        map.put("status", 1);
        return map;
    }

    @RequestMapping("/del")
    @ResponseBody
    public Map<String, Object> del(Long id) {

        System.out.println("------del-----");
        productService.deleteProduct(id);
        Map<String, Object> map = new HashMap<>();
        map.put("status", 1);
        return map;
    }
}
