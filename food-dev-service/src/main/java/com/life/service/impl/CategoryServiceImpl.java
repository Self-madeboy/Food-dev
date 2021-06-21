package com.life.service.impl;

import com.life.common.exception.Asserts;
import com.life.mapper.CarouselMapperCustom;
import com.life.mapper.CategoryMapper;
import com.life.pojo.Category;
import com.life.pojo.vo.CategoryVO;
import com.life.pojo.vo.NewItemsVO;
import com.life.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jc
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private CarouselMapperCustom categoryMapperCustom;

    @Override
    public List<Category> queryAllRootLevelCat() {
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("type", 1);
        List<Category> categories = categoryMapper.selectByExample(example);
        Asserts.checkTrue(ObjectUtils.isEmpty(categories), "没有一级分类");
        return categories;
    }

    @Override
    public List<CategoryVO> getSubCatList(Integer rootCatId) {
        List<CategoryVO> subCatList = categoryMapperCustom.getSubCatList(rootCatId);
        Asserts.checkTrue(ObjectUtils.isEmpty(subCatList), "没有相关的子类!");
        return subCatList;
    }

    @Override
    public List<NewItemsVO> getSixNewItemsLazy(Integer rootCatId) {
        Map<String, Object> map = new HashMap<>(1);
        map.put("rootCatId", rootCatId);
        List<NewItemsVO> sixNewItemsLazy = categoryMapperCustom.getSixNewItemsLazy(map);
        Asserts.checkTrue(ObjectUtils.isEmpty(sixNewItemsLazy), "没有Items");
        return sixNewItemsLazy;
    }
}
