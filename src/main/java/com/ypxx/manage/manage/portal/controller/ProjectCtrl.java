package com.ypxx.manage.manage.portal.controller;

import com.ypxx.manage.manage.product.entity.ProductEntity;
import com.ypxx.manage.manage.product.entity.ProductTypeEntity;
import com.ypxx.manage.manage.product.service.ProductService;
import com.ypxx.manage.manage.product.service.TypeService;
import com.ypxx.manage.manage.product.service.impl.ProductTypeServiceImpl;
import com.ypxx.manage.system.type.entity.TypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "portal/project")
public class ProjectCtrl {

    @Autowired
    ProductService productService;

    @Autowired
    TypeService typeService;

    @RequestMapping("index")
    public String index(Model model) {
        List<ProductTypeEntity> list = typeService.getAll();
        List<ProductEntity> productList = productService.getAll();
        model.addAttribute("typelist", list);
        model.addAttribute("productList", productList);

        return "portal/project";
    }

    @RequestMapping("/select")
    @ResponseBody
    public String select(Model model, Long id) {
        System.out.println("---类型选择---- --id"+id);

        List<ProductTypeEntity> list = typeService.getAll();
        model.addAttribute("typelist", list);

        Page<ProductEntity> page = productService.seachProduct(1, 100, id, null);
        List<ProductEntity> productList = page.getContent();
        model.addAttribute("productList", productList);
        return "1";
    }
}
