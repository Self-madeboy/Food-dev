package com.life.mapper;

import com.life.my.mapper.MyMapper;
import com.life.pojo.Items;
import com.life.pojo.vo.ItemCommentVO;
import com.life.pojo.vo.SearchItemsVO;
import com.life.pojo.vo.ShopcartVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ItemsMapperCustom extends MyMapper<Items> {
    /**
     * 查询评论
     *
     * @param map
     * @return
     */
    List<ItemCommentVO> queryItemComments(@Param("paramsMap") Map<String, Object> map);

    /**
     * 通过关键字搜索商品
     *
     * @param map
     * @return
     */
    List<SearchItemsVO> searchItems(@Param("paramsMap") Map<String, Object> map);

    /**
     * 通过分类查询商品
     * @param map
     * @return
     */
    List<SearchItemsVO> searchItemsByThirdCat(@Param("paramsMap") Map<String, Object> map);

    /**
     * 查询规格参数
     * @param specIdsList
     * @return
     */
    List<ShopcartVO> queryItemsBySpecIds(@Param("paramsList")List<String> specIdsList);
}