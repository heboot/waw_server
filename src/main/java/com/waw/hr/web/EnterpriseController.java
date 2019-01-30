package com.waw.hr.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.waw.hr.core.Result;
import com.waw.hr.core.ResultGenerator;
import com.waw.hr.core.ServiceException;
import com.waw.hr.entity.Enterprise;
import com.waw.hr.response.GetAllEnterpriseResponse;
import com.waw.hr.service.EnterpriseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {

    @Resource
    private EnterpriseService enterpriseService;

    /**
     * 获取所有企业
     *
     * @param page 代表当前页数
     * @param size 代表每页显示多少行
     * @return
     */
    @GetMapping("/getAllEnterprise")
    public Result getAppConfig(@RequestParam(defaultValue = "1") Integer page,
                               @RequestParam(defaultValue = "20") Integer size, Model model) {
        PageHelper.startPage(page, size);
        List<Enterprise> enterprises = enterpriseService.getAllEnterprise();
        PageInfo<Enterprise> pageInfo = new PageInfo<>(enterprises);
        return ResultGenerator.genSuccessResult(new GetAllEnterpriseResponse(page, size, (int) pageInfo.getTotal(), pageInfo.getList()));
    }

    /**
     * 根据模糊查询企业集合
     *
     * @param page 代表当前页数
     * @param size 代表每页显示多少行
     * @return
     */
    @PostMapping("/getEnterpriseByName")
    public Result getEnterpriseByName(@RequestParam(defaultValue = "1") Integer page,
                                      @RequestParam(defaultValue = "20") Integer size, String name) {
        PageHelper.startPage(page, size);
        List<Enterprise> enterprises = enterpriseService.getEnterpriseByName(name);
        PageInfo<Enterprise> pageInfo = new PageInfo<>(enterprises);
        return ResultGenerator.genSuccessResult(new GetAllEnterpriseResponse(page, size, (int) pageInfo.getTotal(), pageInfo.getList()));
    }

    /**
     * 根据企业ID获取企业信息
     *
     * @return
     */
    @PostMapping("/getEnterpriseById")
    public Result getEnterpriseById(@RequestParam(value = "id") Integer id) {
        Enterprise enterprise = enterpriseService.getEnterpriseById(id);
        return ResultGenerator.genSuccessResult(enterprise);
    }

    /**
     * 更新企业信息
     *
     * @return success表示成功   error表示失败
     */
    @PostMapping("/updateEnterprise")
    public Result updateEnterprise(Enterprise enterprise) {
        Integer num = enterpriseService.updateEnterprise(enterprise);
        if (num > 0) {
            return ResultGenerator.genSuccessResult("success");
        } else {
            return ResultGenerator.genFailResult("error");
        }
    }

    /**
     * 添加企业信息
     *
     * @return success表示成功   error表示失败
     */
    @PostMapping("/addEnterprise")
    public Result addEnterprise(Enterprise enterprise) {
        Integer num = enterpriseService.addEnterprise(enterprise);
        if (num > 0) {
            return ResultGenerator.genSuccessResult("success");
        } else {
            return ResultGenerator.genFailResult("error");
        }
    }

    /**
     * 删除企业信息
     *
     * @return success表示成功   error表示失败
     */
    @PostMapping("/removeEnterprise")
    public Result removeEnterprise(Integer id) {
        Integer num = enterpriseService.removeEnterprise(id);
        if (num > 0) {
            return ResultGenerator.genSuccessResult("success");
        } else {
            return ResultGenerator.genFailResult("error");
        }
    }

    @PostMapping("updateEnterpriseSubsidy")
    public Result updateEnterpriseSubsidy(@RequestParam() Integer id, @RequestParam(required = false) Integer subsidy_money, @RequestParam(required = false) String subsidy_info) {
        if (enterpriseService.getEnterpriseById(id) != null) {
            Integer num = enterpriseService.updateEnterpriseSubsidy(id, subsidy_money, subsidy_info);
            if (num != null && num > 0) {
                return ResultGenerator.genSuccessResult();
            } else {
                throw new ServiceException("更新失败，请联系管理员");
            }
        } else {
            throw new ServiceException("更新失败2，请联系管理员");
        }
    }


}
