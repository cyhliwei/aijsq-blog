package com.github.paicoding.forum.service.article.repository.params;

import lombok.Data;

/**
 * 微信搜索「AI技术圈」，回复 Java
 *
 * @author AI技术圈
 * @date 5/30/23
 */
@Data
public class ColumnArticleParams {
    // 教程 ID
    private Long columnId;
    // 文章 ID
    private Long articleId;
    // section
    private Integer section;
}
