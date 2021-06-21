package com.life.service;

import com.life.pojo.Carousel;

import java.util.List;

/**
 * @author jc
 */
public interface CarouselService {
    /**
     * query carousel
     * @param type
     * @return
     */
    List<Carousel> queryAllCarousel(Integer type);
}
