package com.waw.hr.web;

import com.waw.hr.CommonValue;
import com.waw.hr.core.MValue;
import com.waw.hr.core.Result;
import com.waw.hr.core.ResultGenerator;
import com.waw.hr.entity.BankModel;
import com.waw.hr.response.ConfigDataResponse;
import com.waw.hr.service.CommonService;
import com.waw.hr.service.ConfigService;
import com.waw.hr.utils.JWTUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static com.waw.hr.core.ResultCode.UNAUTHORIZED;

@RestController
@RequestMapping("app/common")
public class CommonController {


    @Resource
    private CommonService commonService;

    /**
     * 获取所有企业
     *
     * @return
     */
    @PostMapping("/feedback")
    public Result feedback(@RequestParam String token,
                           @RequestParam String content) {

        if (!JWTUtil.verifyById(token, JWTUtil.getUserId(token), CommonValue.SECRET)) {
            return ResultGenerator.genFailResult(MValue.MESSAGE_TOKEN_ERROR, UNAUTHORIZED);
        }

        int result = commonService.feedback(JWTUtil.getUserId(token), content);

        if (result > 0) {
            return ResultGenerator.genSuccessResult(MValue.MESSAGE_FEEDBACK_SUC);
        }

        return ResultGenerator.genFailResult(MValue.MESSAGE_FOLLOW_FAIL);


    }


}
