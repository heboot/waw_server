package com.waw.hr.utils;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.Date;

@Service
public class BarcodeUtil2 {

    @Autowired
    UploadUtils uploadUtils;

    /**
     * 编码
     *
     * @param contents
     * @param width
     * @param height
     * @param imgPath
     */
    public void encode(String contents, int width, int height, String imgPath, String key) {
        int codeWidth = 3 + // start guard
                (7 * 6) + // left bars
                5 + // middle guard
                (7 * 6) + // right bars
                3; // end guard
        codeWidth = Math.max(codeWidth, width);
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(contents,
                    BarcodeFormat.CODE_128, codeWidth, height, null);
            File file = new File(imgPath);
            if (!file.exists()) {
                file.mkdirs();
            }
            MatrixToImageWriter
                    .writeToFile(bitMatrix, "png", file);


            if (uploadUtils == null) {
                uploadUtils = new UploadUtils();
            }
            uploadUtils.uploadFile(file, key);

            System.out.println("写文件 " + file
                    .exists());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getUserBarCode(String uid, String editorId, String shopId, String enterpriseId) {
        //AA 城市名字  01 店铺编号  991厂商编号
        String result = "";
        if (!StringUtils.isEmpty(editorId)) {
            result = result + editorId;
        } else {
            result = result + "AA";
        }
        if (!StringUtils.isEmpty(shopId)) {
            result = result + shopId;
        } else {
            result = result + "01";
        }
        if (!StringUtils.isEmpty(uid)) {
            result = result + uid;
        } else {
            result = result + "id";
        }
        if (!StringUtils.isEmpty(enterpriseId)) {
            result = result + enterpriseId;
        } else {
            result = result + "000";
        }
        result = result + DateUtil.date2Str(new Date(), DateUtil.FORMAT_YMD);
        return result;
    }

    public void executeBarcode(String path, String content) {

        // 益达无糖口香糖的条形码
        int width = 105, height = 50;
        BarcodeUtil2 handler = new BarcodeUtil2();
        handler.encode(content, width, height, path, path);

    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        String imgPath = "8888" + System.currentTimeMillis() + ".png";
        // 益达无糖口香糖的条形码
        String contents = "AA019920190203";

        int width = 105, height = 50;
        BarcodeUtil2 handler = new BarcodeUtil2();
        handler.encode(contents, width, height, imgPath, "");

        System.out.println("Michael ,you have finished zxing EAN13 encode.");
    }
}
