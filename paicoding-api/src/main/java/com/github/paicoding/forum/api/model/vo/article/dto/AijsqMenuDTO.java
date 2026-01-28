package com.github.paicoding.forum.api.model.vo.article.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class AijsqMenuDTO implements Serializable {

    @TableId(type = IdType.AUTO)
    private String id;

    private String parentId;

    private String title;

    private String type;

    private String icon;

    private Integer menuOrder;

    private Integer level;

    private Integer isFolder;

    private Integer isCollapsed;

    private Integer isVisible;

    private Integer createdBy;

    private String createdAt;

    private String updatedAt;
    private List<AijsqMenuDTO> children;

}
