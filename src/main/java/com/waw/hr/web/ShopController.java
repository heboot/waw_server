package com.waw.hr.web;

import com.waw.hr.core.Result;
import com.waw.hr.core.ResultGenerator;
import com.waw.hr.entity.BankModel;
import com.waw.hr.entity.CityEntity;
import com.waw.hr.entity.ShopEntity;
import com.waw.hr.model.ShopListModel;
import com.waw.hr.response.ConfigDataResponse;
import com.waw.hr.response.ShopListResponse;
import com.waw.hr.service.ConfigService;
import com.waw.hr.service.ShopService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
//List 以ID分组 Map<Integer,List<Apple>>
//        Map<Integer, List<Apple>> groupBy = appleList.stream().collect(Collectors.groupingBy(Apple::getId));

//        System.err.println("groupBy:"+groupBy);
//        {1=[Apple{id=1, name='苹果1', money=3.25, num=10}, Apple{id=1, name='苹果2', money=1.35, num=20}], 2=[Apple{id=2, name='香蕉', money=2.89, num=30}], 3=[Apple{id=3, name='荔枝', money=9.99, num=40}]}
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


}
