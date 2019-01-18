package com.waw.hr.web;

import com.waw.hr.service.EnterpriseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/enterprise")
public class TbEnterpriseController {

    @Resource
    private EnterpriseService enterpriseService;



}
