package com.waw.hr.web;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.waw.hr.CommonValue;
import com.waw.hr.core.*;
import com.waw.hr.entity.AdminUser;
import com.waw.hr.entity.Enterprise;
import com.waw.hr.response.GetAllEnterpriseListResponse;
import com.waw.hr.response.PreSearchListResponse;
import com.waw.hr.service.AdminUserService;
import com.waw.hr.service.EnterpriseService;
import com.waw.hr.utils.JWTUtil;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static com.waw.hr.core.ResultCode.UNAUTHORIZED;

@RestController
@RequestMapping(value = {"/enterprise", "app/enterprise"})
public class EnterpriseController {

    @Resource
    private EnterpriseService enterpriseService;

    @Resource
    private AdminUserService adminUserService;


    /**
     * 获取所有企业
     *
     * @return
     */
    @PostMapping("/getEnterpriseList")
    public Result getAppConfig(@RequestParam(defaultValue = "1") Integer sp,
                               @RequestParam(defaultValue = "20") Integer pageSize, Model model) {
        PageHelper.startPage(sp, pageSize);
        List<Enterprise> enterprises = enterpriseService.getAllEnterprise();
        PageInfo<Enterprise> pageInfo = new PageInfo<>(enterprises);
        return ResultGenerator.genSuccessResult(new GetAllEnterpriseListResponse(sp, pageSize, (int) pageInfo.getTotal(), pageInfo.getList()));
    }


    @PostMapping("/preSearch")
    public Result preSearch() {
        List<String> hotTags = new ArrayList<>();
        hotTags.add("临时工");
        hotTags.add("上海");
        hotTags.add("暑假工");
        hotTags.add("寒假工");

        List<String> enterprises = new ArrayList<>();
        enterprises.add("富士康");
        enterprises.add("昌硕");
        enterprises.add("东山精密");

        return ResultGenerator.genSuccessResult(new PreSearchListResponse(hotTags, enterprises));
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
        return ResultGenerator.genSuccessResult(new GetAllEnterpriseListResponse(page, size, (int) pageInfo.getTotal(), pageInfo.getList()));
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
    public Result updateEnterprise(@RequestParam String token, @RequestParam String enterprise) {
        if (!JWTUtil.verify(token, JWTUtil.getUsername(token), CommonValue.SECRET)) {
            return ResultGenerator.genFailResult(MValue.MESSAGE_TOKEN_ERROR, UNAUTHORIZED);
        }

        Enterprise enterpriseData = JSON.parseObject(enterprise, Enterprise.class);

        AdminUser adminUser = adminUserService.getAdminUserByName(JWTUtil.getUsername(token));

        if (adminUser != null && adminUser.getRole() == ROLE.ROLE_ADMIN) {
            Integer num = enterpriseService.updateEnterprise(enterpriseData);
            if (num > 0) {
                return ResultGenerator.genSuccessResult("success");
            } else {
                return ResultGenerator.genFailResult("error");
            }
        } else {
            return ResultGenerator.genFailResult(MValue.MESSAGE_TOKEN_ERROR, UNAUTHORIZED);
        }
    }

    /**
     * 添加企业信息
     *
     * @return success表示成功   error表示失败
     */
    @PostMapping("/addEnterprise")
    public Result addEnterprise(@RequestParam String token, @RequestParam String enterprise) {
        if (!JWTUtil.verify(token, JWTUtil.getUsername(token), CommonValue.SECRET)) {
            return ResultGenerator.genFailResult(MValue.MESSAGE_TOKEN_ERROR, UNAUTHORIZED);
        }

        AdminUser adminUser = adminUserService.getAdminUserByName(JWTUtil.getUsername(token));

        Enterprise addEnterprise = JSON.parseObject(enterprise, Enterprise.class);

        if (adminUser != null && adminUser.getRole() == ROLE.ROLE_ADMIN) {
            Integer num = enterpriseService.addEnterprise(addEnterprise);
            if (num > 0) {
                return ResultGenerator.genSuccessResult(MValue.MESSAGE_CREATE_SUC);
            } else {
                return ResultGenerator.genFailResult(MValue.MESSAGE_CREATE_FAIL);
            }
        } else {
            return ResultGenerator.genFailResult(MValue.MESSAGE_TOKEN_ERROR, UNAUTHORIZED);
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
