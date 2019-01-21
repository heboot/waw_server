package com.waw.hr.web;

import com.waw.hr.core.Result;
import com.waw.hr.core.ResultGenerator;
import com.waw.hr.entity.Enterprise;
import com.waw.hr.service.EnterpriseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {

    @Resource
    private EnterpriseService enterpriseService;

    @PostMapping("/getAllEnterprise")
    public Result getAppConfig() {
        List<Enterprise> enterprises = enterpriseService.getAllEnterprise();
        return ResultGenerator.genSuccessResult(enterprises);
    }


}
