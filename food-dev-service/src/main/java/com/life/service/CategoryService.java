package com.life.service;

import com.life.pojo.Category;
import com.life.pojo.vo.CategoryVO;
import com.life.pojo.vo.NewItemsVO;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * @author jc
 */
public interface CategoryService {
    /**
     * query RootLevelCat
     * @return
     */
    List<Category> queryAllRootLevelCat();

    /**
     * getSubCatList
     * @param rootCatId
     * @return
     */
    List<CategoryVO> getSubCatList(Integer rootCatId);

    /**
     * getSixNewItemsLazy
     * @param rootCatId
     * @return
     */
    List<NewItemsVO> getSixNewItemsLazy(Integer rootCatId);
}
