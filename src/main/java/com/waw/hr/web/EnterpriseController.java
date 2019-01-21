package com.waw.hr.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.waw.hr.core.Result;
import com.waw.hr.core.ResultGenerator;
import com.waw.hr.entity.Enterprise;
import com.waw.hr.response.GetAllEnterpriseResponse;
import com.waw.hr.service.EnterpriseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {

    @Resource
    private EnterpriseService enterpriseService;

    /**
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


}
