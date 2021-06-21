package com.life.pojo.vo;

import com.life.pojo.Items;
import com.life.pojo.ItemsImg;
import com.life.pojo.ItemsParam;
import com.life.pojo.ItemsSpec;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author jc
 */
@Data
@Builder
public class ItemInfoVO {
    private Items item;
    private List<ItemsImg> itemImgList;
    private List<ItemsSpec> itemSpecList;
    private ItemsParam itemParams;
}
