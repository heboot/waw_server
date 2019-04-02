package com.waw.hr.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.waw.hr.CommonValue;
import com.waw.hr.core.MValue;
import com.waw.hr.core.Result;
import com.waw.hr.core.ResultGenerator;
import com.waw.hr.entity.BankModel;
import com.waw.hr.entity.CityEntity;
import com.waw.hr.entity.Enterprise;
import com.waw.hr.entity.ShopEntity;
import com.waw.hr.model.ShopListModel;
import com.waw.hr.response.ConfigDataResponse;
import com.waw.hr.response.GetShopListResponse;
import com.waw.hr.response.ShopListResponse;
import com.waw.hr.service.ConfigService;
import com.waw.hr.service.ShopService;
import com.waw.hr.utils.JWTUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.waw.hr.core.ResultCode.UNAUTHORIZED;

@RestController
@RequestMapping(value = {"/shop", "app/shop"})
public class ShopController {


    @Resource
    private ShopService shopService;

    /**
     * 获取所有企业
     *
     * @return
     */
    @PostMapping("/shopList")
    public Result shopList() {
        List<ShopEntity> shopEntities = shopService.shopList();

        List<CityEntity> cityEntities = shopService.cityList();

        ShopListResponse shopListResponse = new ShopListResponse();

        List<ShopListModel> shopListModels = new ArrayList<>();

        for (CityEntity cityEntity : cityEntities) {
            ShopListModel shopListModel = new ShopListModel();
            shopListModel.setTitle(cityEntity.getTitle());
            shopListModel.setId(cityEntity.getId());
            shopListModels.add(shopListModel);
        }

        for (ShopListModel shopListModel : shopListModels) {
            for (ShopEntity shopEntity : shopEntities) {
                if (shopEntity.getCityId() == shopListModel.getId()) {
                    if (shopListModel.getList() == null) {
                        shopListModel.setList(new ArrayList<>());
                    }
                    shopListModel.getList().add(shopEntity);
                }
            }
        }


        List<ShopListModel> resultList = new ArrayList<>();

        for (ShopListModel shopListModel : shopListModels) {
            if (shopListModel.getList() != null && shopListModel.getList().size() > 0) {
                resultList.add(shopListModel);
            }
        }

        shopListResponse.setList(resultList);

        return ResultGenerator.genSuccessResult(shopListResponse);

    }

    /**
     * 获取所有门店 后端使用
     *
     * @return
     */
    @PostMapping("/getShopList")
    public Result getShopList(@RequestParam(defaultValue = "1") Integer page,
                              @RequestParam(defaultValue = "20") Integer size) {
        List<ShopEntity> shopEntities = shopService.shopList();

        PageHelper.startPage(page, size);
        PageInfo<ShopEntity> pageInfo = new PageInfo<>(shopEntities);

        return ResultGenerator.genSuccessResult(new GetShopListResponse(page, size, pageInfo.getPages(), (int) pageInfo.getTotal(), shopEntities));

    }

    @PostMapping("/addShop")
    public Result addShop(@RequestParam String token,
                          @RequestParam String name,
                          @RequestParam String address,
                          @RequestParam String location,
                          @RequestParam String workTime,
                          @RequestParam int type,
                          @RequestParam String cityId) {

        if (!JWTUtil.verify(token, JWTUtil.getUsername(token), CommonValue.SECRET)) {
            return ResultGenerator.genFailResult(MValue.MESSAGE_TOKEN_ERROR, UNAUTHORIZED);
        }

        int result = shopService.addShop(name, address, location.split(",")[1], location.split(",")[0], null, workTime, type, cityId);

        if (result > 0) {
            return ResultGenerator.genSuccessResult(MValue.MESSAGE_CREATE_SUC);
        }

        return ResultGenerator.genFailResult(MValue.MESSAGE_CREATE_FAIL);

    }


}
