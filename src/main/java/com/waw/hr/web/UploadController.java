package com.waw.hr.web;

import com.qiniu.util.Auth;
import com.waw.hr.CommonValue;
import com.waw.hr.core.MValue;
import com.waw.hr.core.QiniuKey;
import com.waw.hr.core.Result;
import com.waw.hr.core.ResultGenerator;
import com.waw.hr.utils.JWTUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

import static com.waw.hr.core.ResultCode.UNAUTHORIZED;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @PostMapping("/uploadImage")
    public Result uploadImage(MultipartFile img) {
        if (img.isEmpty()) {
            return ResultGenerator.genFailResult("meiyou");
        }
        String fileName = img.getOriginalFilename();
        String filePath = "/resources/static/img/";
        File dest = new File(filePath + fileName);
        try {
            img.transferTo(dest);
            return ResultGenerator.genSuccessResult();
        } catch (IOException e) {
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }

    @PostMapping("/getUploadEnterpriseImageToken")
    public Result getUploadToken(@RequestParam String token) {
        if (!JWTUtil.verify(token, JWTUtil.getUsername(token), CommonValue.SECRET)) {
            return ResultGenerator.genFailResult(MValue.MESSAGE_TOKEN_ERROR, UNAUTHORIZED);
        }
        Auth auth = Auth.create(QiniuKey.AK, QiniuKey.SK);
        String upToken = auth.uploadToken(QiniuKey.BUCKET_ENTERPRISE_IMAGE);
        return ResultGenerator.genSuccessResult(upToken);
    }
}
