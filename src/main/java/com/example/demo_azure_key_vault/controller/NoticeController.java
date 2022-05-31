package com.example.demo_azure_key_vault.controller;


//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;

import com.example.demo_azure_key_vault.domain.Notice;
import com.example.demo_azure_key_vault.rtn.CommonResponse;
import com.example.demo_azure_key_vault.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 公告Controller
 * Created by wmm on 2019/4/24.
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    @GetMapping("/sqlSersver")
    public String get() {
        Notice byId = noticeService.findById("1");
        System.out.println(byId);
        return byId.toString();
    }


    @PostMapping("/list")
//    @RequiresPermissions("notice:view")//权限管理;
    public CommonResponse list(HashMap map, String nameParam, @RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        try {
//            JSONObject jsonObject = (JSONObject) JSON.toJSON(noticeService.findList(nameParam, page - 1, pageSize));
//            System.out.println("结果=====" + jsonObject);
//            map.put("datas", jsonObject);
            map.put("nameParam", nameParam);
            map.put("goodsList", "goodsService.findAll()");
            map.put("code", 1);
            map.put("msg", "成功");
        } catch (Exception e) {
            map.put("code", 0);
            map.put("msg", "失败");
            e.printStackTrace();
        }


        return CommonResponse.ok(map);

    }

//    @RequestMapping("toEdit")
//    @ResponseBody
//    public Map toEdit(String id) {
//        Map map = new HashMap();
//        try {
//            map.put("bean", noticeService.findById(id));
//            map.put("code", 1);
//            map.put("msg", "成功");
//        } catch (Exception e) {
//            map.put("code", 0);
//            map.put("msg", "失败");
//            e.printStackTrace();
//        }
//        return map;
//    }
//
//    @RequestMapping("edit")
//    @ResponseBody
////    @RequiresPermissions("notice:edit")//权限管理;
//    public Map editMenu(Notice bean) {
//        Map map = new HashMap();
//        try {
//            return noticeService.edit(bean);
//        } catch (Exception e) {
//            map.put("code", 0);
//            map.put("msg", "失败");
//            e.printStackTrace();
//            return map;
//        }
//    }
//
//    @RequestMapping("deleteById")
//    @ResponseBody
////    @RequiresPermissions("notice:delete")//权限管理;
//    public Map deleteById(String id) {
//        return noticeService.deleteById(id);
//    }
//
//    @RequestMapping("listCount")
//    @ResponseBody
//    public Map listCount() {
//        Map map = new HashMap();
//        try {
//            map.put("count", noticeService.listCount());
//            map.put("code", 1);
//            map.put("msg", "成功");
//        } catch (Exception e) {
//            map.put("code", 0);
//            map.put("msg", "失败");
//            e.printStackTrace();
//        }
//        return map;
//    }
}
