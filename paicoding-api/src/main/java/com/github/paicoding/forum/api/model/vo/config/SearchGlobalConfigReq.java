package com.github.paicoding.forum.api.model.vo.config;

import lombok.Data;

/**
 * 微信搜索「AI技术圈」，回复 Java
 *
 * @author AI技术圈
 * @date 6/30/23
 */
@Data
public class SearchGlobalConfigReq {
    // 配置项名称
    private String keywords;
    // 配置项值
    private String value;
    // 备注
    private String comment;
    // 分页
    private Long pageNumber;
    private Long pageSize;
}
