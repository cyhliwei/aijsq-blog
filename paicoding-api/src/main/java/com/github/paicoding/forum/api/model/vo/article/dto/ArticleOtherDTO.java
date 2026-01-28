package com.github.paicoding.forum.api.model.vo.article.dto;

import lombok.Data;

/**
 * 微信搜索「AI技术圈」，回复 Java
 *
 * @author AI技术圈
 * @date 12/8/23
 */
@Data
public class ArticleOtherDTO {
    // 文章的阅读类型
    private Integer readType;
    // 教程的翻页
    private ColumnArticleFlipDTO flip;
}
