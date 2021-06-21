package com.life.mapper;

import com.life.my.mapper.MyMapper;
import com.life.pojo.Carousel;
import com.life.pojo.vo.CategoryVO;
import com.life.pojo.vo.NewItemsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author jc
 */
public interface CarouselMapperCustom extends MyMapper<Carousel> {
    /**
     * getSubCatList
     *
     * @param rootCatId
     * @return
     */
    List<CategoryVO> getSubCatList(Integer rootCatId);

    /**
     * getSixNewItemsLazy
     *
     * @param map
     * @return
     */
    List<NewItemsVO> getSixNewItemsLazy(@Param("paramsMap") Map<String, Object> map);
}