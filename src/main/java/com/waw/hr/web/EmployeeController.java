package com.waw.hr.web;

import com.waw.hr.core.Result;
import com.waw.hr.service.EmployeeService;
import com.waw.hr.service.EmployeeSignLogService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/emplpyee")
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    @Resource
    private EmployeeSignLogService employeeSignLogService;

    @PostMapping("/doEmployeeLogin")
    public Result doEmployeeLogin(@RequestParam String mobile,
                                  @RequestParam String code) {
        return employeeService.doLogin(mobile, code);
    }

}
