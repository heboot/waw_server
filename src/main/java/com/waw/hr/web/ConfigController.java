package com.waw.hr.web;

import com.waw.hr.core.Result;
import com.waw.hr.core.ResultGenerator;
import com.waw.hr.entity.BankModel;
import com.waw.hr.response.ConfigDataResponse;
import com.waw.hr.service.ConfigService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("app/config")
public class ConfigController {


    @Resource
    private ConfigService configService;

    /**
     * 获取所有企业
     *
     * @return
     */
    @PostMapping("/appConfig")
    public Result getAppConfig() {
        List<BankModel> bankModelList = configService.bankList();
        ConfigDataResponse configDataResponse = new ConfigDataResponse();
        configDataResponse.setKfTel("18621242123");
        configDataResponse.setBankList(bankModelList);
        configDataResponse.setVersion("1.0");
        configDataResponse.setCashTip("入职奖励以当天报价为准。\n 入职满足打卡条件后方可提现");
        configDataResponse.setRecommendInfo("好友入职，你就得100元推荐费");
        configDataResponse.setRecommendIcon("recommend/icon_recommend.png");
        return ResultGenerator.genSuccessResult(configDataResponse);
    }


}
