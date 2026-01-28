package com.github.paicoding.forum.api.model.vo.user;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 微信搜索「AI技术圈」，回复 Java
 *
 * @author AI技术圈
 * @date 6/29/23
 */
@Data
public class ZsxqUserBatchOperateReq implements Serializable {
    // ids
    private List<Long> ids;
    // 状态
    private Integer status;
}
