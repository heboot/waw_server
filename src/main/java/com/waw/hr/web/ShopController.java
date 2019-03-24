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
@RequestMapping("app/shop")
public class ShopController {


    @Resource
    private ConfigService configService;

    /**
     * 获取所有企业
     *
     * @return
     */
    @PostMapping("/shopList")
    public Result shopList() {
        List<BankModel> bankModelList = configService.bankList();
        ConfigDataResponse configDataResponse = new ConfigDataResponse();
        configDataResponse.setKfTel("18621242123");
        configDataResponse.setBankList(bankModelList);
        configDataResponse.setVersion("1.0");
        configDataResponse.setRecommendInfo("好友入职，你就得100元推荐费");
        configDataResponse.setRecommendIcon("recommend/icon_recommend.png");
        return ResultGenerator.genSuccessResult(configDataResponse);
    }


}
