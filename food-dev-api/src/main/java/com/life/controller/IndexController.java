package com.life.controller;

import com.life.common.api.Result;
import com.life.common.enums.YesOrNo;
import com.life.common.exception.Asserts;
import com.life.pojo.Carousel;
import com.life.pojo.Category;
import com.life.pojo.vo.CategoryVO;
import com.life.pojo.vo.NewItemsVO;
import com.life.service.CarouselService;
import com.life.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jc
 */
@Api(value = "首页", tags = {"首页展示的相关接口"})
@RestController
@RequestMapping("index")
public class IndexController {
    @Autowired
    private CarouselService carouselService;
    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "获取首页轮播图列表", notes = "获取首页轮播图列表", httpMethod = "GET")
    @GetMapping("/carousel")
    public Result carousel() {
        List<Carousel> list = carouselService.queryAllCarousel(YesOrNo.YES.type);

        return Result.success(list);
    }

    @ApiOperation(value = "获取商品分类(一级分类)", notes = "获取商品分类(一级分类)", httpMethod = "GET")
    @GetMapping("/cats")
    public Result cats() {
        List<Category> list = categoryService.queryAllRootLevelCat();
        return Result.success(list);
    }

    @ApiOperation(value = "获取商品子分类", notes = "获取商品子分类", httpMethod = "GET")
    @GetMapping("/subCat/{rootCatId}")
    public Result subCat(@PathVariable Integer rootCatId) {
        Asserts.checkTrue(ObjectUtils.isEmpty(rootCatId), "没有rootCatId");
        List<CategoryVO> list = categoryService.getSubCatList(rootCatId);
        return Result.success(list);
    }
    @ApiOperation(value = "查询每个一级分类下的最新6条商品数据", notes = "查询每个一级分类下的最新6条商品数据", httpMethod = "GET")
    @GetMapping("/sixNewItems/{rootCatId}")
    public Result sixNewItems(@PathVariable Integer rootCatId){
        Asserts.checkTrue(ObjectUtils.isEmpty(rootCatId),"分类不存在");
        List<NewItemsVO> list = categoryService.getSixNewItemsLazy(rootCatId);
        return Result.success(list);
    }
}
