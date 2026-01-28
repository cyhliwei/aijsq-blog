package com.github.paicoding.forum.api.model.vo.article.dto;

import lombok.Data;

/**
 * 微信搜索「AI技术圈」，回复 Java
 *
 * @author AI技术圈
 * @date 12/8/23
 */
@Data
public class ColumnArticleFlipDTO {
    String prevHref;
    Boolean prevShow;
    String nextHref;
    Boolean nextShow;
}
