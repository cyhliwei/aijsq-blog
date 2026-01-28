package com.github.paicoding.forum.api.model.vo.article;

import lombok.Data;

/**
 * 微信搜索「AI技术圈」，回复 Java
 *
 * @author AI技术圈
 * @date 5/27/23
 */
@Data
public class SearchCategoryReq {
    // 类目名称
    private String category;
    // 分页
    private Long pageNumber;
    private Long pageSize;

}
