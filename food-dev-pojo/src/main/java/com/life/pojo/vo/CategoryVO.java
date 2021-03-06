package com.life.pojo.vo;

import lombok.Data;

import java.util.List;

/**
 * @author jc
 */
@Data
public class CategoryVO {
    private Integer id;
    private String name;
    private String type;
    private Integer fatherId;

    /**
     * 三级分类vo list
     */
    private List<SubCategoryVO> subCatList;
}
