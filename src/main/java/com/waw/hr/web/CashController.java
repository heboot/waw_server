package com.waw.hr.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.waw.hr.CommonValue;
import com.waw.hr.core.MValue;
import com.waw.hr.core.Result;
import com.waw.hr.core.ResultGenerator;
import com.waw.hr.entity.CashLogModel;
import com.waw.hr.entity.RecommendUser;
import com.waw.hr.model.EmployeeModel;
import com.waw.hr.response.CashListResponse;
import com.waw.hr.response.RecommendListResponse;
import com.waw.hr.service.CashService;
import com.waw.hr.service.EmployeeService;
import com.waw.hr.utils.JWTUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static com.waw.hr.core.ResultCode.UNAUTHORIZED;

@RestController
@RequestMapping("/cash")
public class CashController {

    @Resource
    private CashService cashService;

    @Resource
    private EmployeeService employeeService;

    /**
     * 获取提现列表
     *
     * @return
     */
    @PostMapping("/cashList")
    public Result cashList(@RequestParam String token,
                           @RequestParam(defaultValue = "1") Integer sp,
                           @RequestParam(defaultValue = "20") Integer pageSize,
                           @RequestParam(required = false) String cashed) {

        if (!JWTUtil.verify(token, JWTUtil.getUsername(token), CommonValue.SECRET)) {
            return ResultGenerator.genFailResult(MValue.MESSAGE_TOKEN_ERROR, UNAUTHORIZED);
        }
        PageHelper.startPage(sp, pageSize);
        List<CashLogModel> enterprises = cashService.cashList(cashed == null ? 0 : 2);
        PageInfo<CashLogModel> pageInfo = new PageInfo<>(enterprises);
        return ResultGenerator.genSuccessResult(new CashListResponse(sp, pageSize, pageInfo.getPages(), (int) pageInfo.getTotal(), pageInfo.getList()));
    }


    /**
     * 获取推荐列表
     *
     * @return
     */
    @PostMapping("/recommendList")
    public Result recommendList(@RequestParam String token,
                                @RequestParam(defaultValue = "1") Integer sp,
                                @RequestParam(defaultValue = "20") Integer pageSize,
                                @RequestParam(required = false) String cashed) {

        if (!JWTUtil.verify(token, JWTUtil.getUsername(token), CommonValue.SECRET)) {
            return ResultGenerator.genFailResult(MValue.MESSAGE_TOKEN_ERROR, UNAUTHORIZED);
        }
        PageHelper.startPage(sp, pageSize);
        List<RecommendUser> enterprises = cashService.recommendList(cashed == null ? 0 : 1);
        PageInfo<RecommendUser> pageInfo = new PageInfo<>(enterprises);
        return ResultGenerator.genSuccessResult(new RecommendListResponse(sp, pageSize, pageInfo.getPages(), (int) pageInfo.getTotal(), pageInfo.getList()));
    }

    /**
     * 更新用户提现记录 为已打款
     * <p>
     * 扣掉余额 生成明细
     */
    @PostMapping("/updateEmployeeCashLogStatus")
    public Result updateEmployeeCashLogStatus(
            @RequestParam String token,
            @RequestParam String employeeId,
            @RequestParam int money,
            @RequestParam String cashId) {

        if (!JWTUtil.verify(token, JWTUtil.getUsername(token), CommonValue.SECRET)) {
            return ResultGenerator.genFailResult(MValue.MESSAGE_TOKEN_ERROR, UNAUTHORIZED);
        }

        EmployeeModel employeeModel = employeeService.getEmployeeById(employeeId);

        if (StringUtils.isEmpty(employeeModel.getBalance())) {
            return ResultGenerator.genFailResult(MValue.MESSAGE_ROLE_ERROR);
        }

        double balance = Double.parseDouble(employeeModel.getBalance());

        if (money > balance) {
            return ResultGenerator.genFailResult(MValue.MESSAGE_CASH_BALANCE_ERROR);
        }

        int result = cashService.updateEmployeeBalanceByCash(Integer.parseInt(employeeId), String.valueOf(balance - money), Integer.parseInt(cashId));

        if (result == 1) {
            return ResultGenerator.genSuccessResult("更新成功", null);
        }

        return ResultGenerator.genFailResult(MValue.MESSAGE_ROLE_ERROR);
    }


}
