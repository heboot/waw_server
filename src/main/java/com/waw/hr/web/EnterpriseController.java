package com.waw.hr.web;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.waw.hr.core.Result;
import com.waw.hr.core.ResultGenerator;
import com.waw.hr.entity.Enterprise;
import com.waw.hr.response.GetAllEnterpriseResponse;
import com.waw.hr.service.EnterpriseService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {

    @Resource
    private EnterpriseService enterpriseService;

    /**
     * 获取所有企业
     * @param page 代表当前页数
     * @param size 代表每页显示多少行
     * @return
     */
    @PostMapping("/getAllEnterprise")
    public Result getAppConfig(@RequestParam(defaultValue = "1") Integer page,
                               @RequestParam(defaultValue = "20") Integer size) {
        PageHelper.startPage(page, size);
        List<Enterprise> enterprises = enterpriseService.getAllEnterprise();
        PageInfo<Enterprise> pageInfo = new PageInfo<>(enterprises);
        return ResultGenerator.genSuccessResult(new GetAllEnterpriseResponse(page, size, (int) pageInfo.getTotal(), pageInfo.getList()));
    }

    /**
     * 根据模糊查询企业集合
     * @param page 代表当前页数
     * @param size 代表每页显示多少行
     * @return
     */
    @PostMapping("/getEnterpriseByName")
    public Result getEnterpriseByName(@RequestParam(defaultValue = "1") Integer page,
                               @RequestParam(defaultValue = "20") Integer size,String name) {
        PageHelper.startPage(page, size);
        List<Enterprise> enterprises = enterpriseService.getEnterpriseByName(name);
        PageInfo<Enterprise> pageInfo = new PageInfo<>(enterprises);
        return ResultGenerator.genSuccessResult(new GetAllEnterpriseResponse(page, size, (int) pageInfo.getTotal(), pageInfo.getList()));
    }

    /**
     * 根据企业ID获取企业信息
     * @return
     */
    @PostMapping("/getEnterpriseById")
    public Result getEnterpriseById(@RequestParam(value = "id") Integer id) {
        Enterprise enterprise = enterpriseService.getEnterpriseById(id);
        return ResultGenerator.genSuccessResult(enterprise);
    }

    /**
     * 更新企业信息
     * @return  success表示成功   error表示失败
     */
    @PostMapping("/updateEnterprise")
    public Object updateEnterprise(Enterprise enterprise, Map map) {
       Integer num = enterpriseService.updateEnterprise(enterprise);
       if(num>0){
           map.put("result","success");
       }else{
           map.put("result","error");
       }
       return JSONArray.toJSON(map);
    }

    /**
     * 添加企业信息
     * @return  success表示成功   error表示失败
     */
    @PostMapping("/addEnterprise")
    public Object addEnterprise(Enterprise enterprise, Map map) {
        Integer num = enterpriseService.addEnterprise(enterprise);
        if(num>0){
            map.put("result","success");
        }else{
            map.put("result","error");
        }
        return JSONArray.toJSON(map);
    }

    /**
     * 删除企业信息
     * @return  success表示成功   error表示失败
     */
    @PostMapping("/removeEnterprise")
    public Object removeEnterprise(Integer id, Map map) {
        Integer num = enterpriseService.removeEnterprise(id);
        if(num>0){
            map.put("result","success");
        }else{
            map.put("result","error");
        }
        return JSONArray.toJSON(map);
    }




}
