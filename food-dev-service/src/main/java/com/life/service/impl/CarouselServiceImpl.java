package com.life.service.impl;

import com.life.common.exception.Asserts;
import com.life.mapper.CarouselMapper;
import com.life.pojo.Carousel;
import com.life.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author jc
 */
@Service
public class CarouselServiceImpl implements CarouselService {
    @Autowired
    private CarouselMapper carouselMapper;

    @Override
    public List<Carousel> queryAllCarousel(Integer type) {
        Asserts.checkTrue(ObjectUtils.isEmpty(type), "请输入要查询的类型!");
        Example example = new Example(Carousel.class);
        example.orderBy("sort").desc();
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isShow", type);
        List<Carousel> carousels = carouselMapper.selectByExample(example);
        Asserts.checkTrue(ObjectUtils.isEmpty(carousels), "没有找到可以展示的轮播图");
        return carousels;
    }
}
