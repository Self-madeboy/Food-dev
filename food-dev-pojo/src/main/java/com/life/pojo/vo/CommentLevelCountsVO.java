package com.life.pojo.vo;

import lombok.Builder;
import lombok.Data;

/**
 * @author jc
 */
@Data
@Builder
public class CommentLevelCountsVO {
    public Integer totalCounts;
    public Integer goodCounts;
    public Integer normalCounts;
    public Integer badCounts;
}
