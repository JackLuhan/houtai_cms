package com.ypxx.manage.manage.manager.controller;

import com.ypxx.manage.common.utils.DateUtils;
import com.ypxx.manage.common.utils.UrlUtils;
import com.ypxx.manage.system.permission.entity.PermissionEntity;
import com.ypxx.manage.system.permission.service.IPermissionService;
import com.ypxx.manage.system.role.entity.RoleEntity;
import com.ypxx.manage.system.role.service.IRoleService;
import com.ypxx.manage.system.type.entity.TypeEntity;
import com.ypxx.manage.system.type.service.ITypeService;
import com.ypxx.manage.system.user.entity.UserEntity;
import com.ypxx.manage.system.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by xuwei on 2018/10/6.
 */
@Controller
@RequestMapping(value = "manager")
public class ManagerController {

    private final IUserService userService;
    private final IRoleService roleService;
    private final IPermissionService permissionService;
    private final ITypeService typeService;

    @Autowired
    public ManagerController(IUserService userService, IRoleService roleService, IPermissionService permissionService, ITypeService typeService) {
        this.userService = userService;
        this.roleService = roleService;
        this.permissionService = permissionService;
        this.typeService = typeService;
    }


    @GetMapping(value = "list")
    public String list(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize, Model model, String name, String start, String end) {
        Date startTime = DateUtils.strToDate(start);
        Date endTime = DateUtils.strToDate(end);
        Page<UserEntity> page = userService.page(pageNum, pageSize, name, startTime, endTime);
        model.addAttribute("name", name);
        model.addAttribute("page", page);
        return "admin/user_list";
    }

    @GetMapping(value = "add")
    public String add(Model model) {
        List<RoleEntity> roles = roleService.list();
        model.addAttribute("roles", roles);
        return "admin/user_add";
    }

    @PostMapping(value = "del")
    @ResponseBody
    public Map<String, Object> del(@RequestParam(value = "ids[]", required = false) Long[] ids) {
        Map<String, Object> map = new HashMap<>();
        for (Long id : ids) {
            UserEntity user = userService.delete(id);
            if (user == null) {
                map.put("state", 0);
                return map;
            }
        }
        map.put("state", 1);
        return map;
    }

    @PostMapping(value = "delete")
    @ResponseBody
    public Map<String, Object> delete(Long id) {
        Map<String, Object> map = new HashMap<>();
        UserEntity user = userService.delete(id);
        if (user != null) map.put("state", 1);
        return map;
    }

    @GetMapping(value = "edit")
    public String edit(Model model, Long id) {
        UserEntity user = userService.findById(id);
        model.addAttribute("user", user);
        List<RoleEntity> roles = roleService.list();
        model.addAttribute("roles", roles);
        return "admin/user_edit";
    }

    @PostMapping(value = "user/edit")
    @ResponseBody
    public Map<String, Object> userEdit(UserEntity user, Long roleId) {
        Map<String, Object> map = new HashMap<>();
        UserEntity userEntity = userService.update(user, roleId);
        if (userEntity != null) map.put("state", 1);
        return map;
    }

    @PostMapping(value = "user/add")
    @ResponseBody
    public Map<String, Object> userAdd(UserEntity user, Long roleId) {
        Map<String, Object> map = new HashMap<>();
        UserEntity userEntity = userService.addUser(user, roleId);
        if (userEntity != null) map.put("state", 1);
        return map;
    }

    @GetMapping(value = "role/list")
    public String roleList(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize, Model model, String name, String start, String end) {
        Date startTime = DateUtils.strToDate(start);
        Date endTime = DateUtils.strToDate(end);
        Page<RoleEntity> page = roleService.roleList(pageNum, pageSize, name, startTime, endTime);
        model.addAttribute("name", name);
        model.addAttribute("page", page);
        return "admin/role_list";
    }

    @GetMapping(value = "role/add")
    public String roleAdd(Model model) {
        List<TypeEntity> types = typeService.list();
        model.addAttribute("types", types);
        return "admin/role_add";
    }

    @PostMapping(value = "role/add")
    @ResponseBody
    public Map<String, Object> roleAdd(String name, @RequestParam(value = "typeId[]", required = false) Long[] typeId, @RequestParam(value = "permId[]", required = false) Long[] permId, String desc) {
        Map<String, Object> map = new HashMap<>();
        RoleEntity role = roleService.add(name, typeId, permId, desc);
        if (role != null) map.put("state", 1);
        return map;
    }

    @GetMapping(value = "role/to/edit")
    public String roleEdit(Model model, Long id) {
        RoleEntity role = roleService.findRoleById(id);
        model.addAttribute("role", role);
        List<TypeEntity> types = typeService.list();
        model.addAttribute("types", types);
        return "admin/role_edit";
    }

    @PostMapping(value = "role/edit/edit")
    @ResponseBody
    public Map<String, Object> roleToEdit(Long id,String name, @RequestParam(value = "typeId[]", required = false) Long[] typeId, @RequestParam(value = "permId[]", required = false) Long[] permId, String desc) {
        Map<String, Object> map = new HashMap<>();
        RoleEntity role = roleService.update(id,name, typeId, permId, desc);
        if (role != null) map.put("state", 1);
        return map;
    }

    @PostMapping(value = "role/del")
    @ResponseBody
    public Map<String, Object> roleDel(@RequestParam(value = "ids[]", required = false) Long[] ids) {
        Map<String, Object> map = new HashMap<>();
        for (Long id : ids) {
            RoleEntity role = roleService.delete(id);
            if (role == null) {
                map.put("state", 0);
                return map;
            }
        }
        map.put("state", 1);
        return map;
    }

    @PostMapping(value = "role/delete")
    @ResponseBody
    public Map<String, Object> roleDelete(Long id) {
        Map<String, Object> map = new HashMap<>();
        RoleEntity role = roleService.delete(id);
        if (role != null) map.put("state", 1);
        return map;
    }



    @GetMapping(value = "permission/type/list")
    public String permissionTypeList(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize, Model model) {
        Page<TypeEntity> page = typeService.page(pageNum, pageSize);
        model.addAttribute("page", page);
        return "admin/type_list";
    }

    @PostMapping(value = "permission/type/add")
    @ResponseBody
    public Map<String, Object> permissionTypeAdd(String name) {
        Map<String, Object> map = new HashMap<>();
        TypeEntity type = typeService.add(name);
        if (type != null) map.put("state", 1);
        return map;
    }

    @PostMapping(value = "permission/type/delete")
    @ResponseBody
    public Map<String, Object> permissionTypeDelete(Long id) {
        Map<String, Object> map = new HashMap<>();
        TypeEntity type = typeService.delete(id);
        if (type != null) map.put("state", 1);
        return map;
    }

    @PostMapping(value = "permission/type/del/all")
    @ResponseBody
    public Map<String, Object> permissionTypeDelAll(@RequestParam(value = "ids[]", required = false) Long[] ids) {
        Map<String, Object> map = new HashMap<>();
        for (Long id : ids) {
            TypeEntity type = typeService.delete(id);
            if (type == null) {
                map.put("state", 0);
                return map;
            }
        }
        map.put("state", 1);
        return map;
    }

    @GetMapping(value = "permission/type/edit")
    public String permissionTypeEdit(Model model, Long id) {
        TypeEntity type = typeService.findOne(id);
        model.addAttribute("type", type);
        return "admin/type_edit";
    }

    @PostMapping(value = "permission/type/type/edit")
    @ResponseBody
    public Map<String, Object> permissionTypeTypeEdit(TypeEntity type) {
        Map<String, Object> map = new HashMap<>();
        TypeEntity typeEntity = typeService.edit(type);
        if (typeEntity != null) map.put("state", 1);
        return map;
    }

    @GetMapping(value = "permission/list")
    public String permissionList(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize, Model model) {
        Page<PermissionEntity> page = permissionService.permissionList(pageNum, pageSize);
        List<TypeEntity> types = typeService.list();
        Set<String> urls = UrlUtils.getAllUrl();
        model.addAttribute("types", types);
        model.addAttribute("urls", urls);
        model.addAttribute("page", page);
        return "admin/permission_list";
    }

    @PostMapping(value = "permission/add")
    @ResponseBody
    public Map<String, Object> permissionAdd(Long typeId, String url, String name) {
        Map<String, Object> map = new HashMap<>();
        PermissionEntity permission = permissionService.add(typeId, url, name);
        if (permission != null) map.put("state", 1);
        return map;
    }

    @PostMapping(value = "permission/del")
    @ResponseBody
    public Map<String, Object> perDel(Long id) {
        Map<String, Object> map = new HashMap<>();
        PermissionEntity permission = permissionService.del(id);
        if (permission != null) map.put("state", 1);
        return map;
    }
    @PostMapping(value = "permission/del/all")
    @ResponseBody
    public Map<String, Object> perDelAll(@RequestParam(value = "ids[]", required = false) Long[] ids) {
        Map<String, Object> map = new HashMap<>();
        for (Long id : ids) {
            PermissionEntity permission = permissionService.del(id);
            if (permission == null) {
                map.put("state", 0);
                return map;
            }
        }
        map.put("state", 1);
        return map;
    }


    @GetMapping(value = "permission/edit")
    public String permissionEdit(Model model, Long id) {
        PermissionEntity permission = permissionService.findById(id);
        List<TypeEntity> types = typeService.list();
        Set<String> urls = UrlUtils.getAllUrl();
        model.addAttribute("types", types);
        model.addAttribute("urls", urls);
        model.addAttribute("permission", permission);
        return "admin/permission_edit";
    }

    @PostMapping(value = "permission/edit/edit")
    @ResponseBody
    public Map<String, Object> permissionEditEdit(PermissionEntity permission,Long typeId) {
        Map<String, Object> map = new HashMap<>();
        PermissionEntity permissionEntity = permissionService.edit(permission,typeId);
        if (permissionEntity != null) map.put("state", 1);
        return map;
    }








}
