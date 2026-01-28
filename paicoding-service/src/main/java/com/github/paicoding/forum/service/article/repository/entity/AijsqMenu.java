package com.github.paicoding.forum.service.article.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@TableName("aijsq_menu")
@ApiModel(value = "菜单项表对象")
public class AijsqMenu implements Serializable {

    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "菜单ID（可自定义，如：1, 2, 16-1）")
    private String id;

    @ApiModelProperty(value = "父菜单ID")
    private String parentId;

    @ApiModelProperty(value = "菜单标题")
    private String title;

    @ApiModelProperty(value = "菜单类型")
    private String type;

    @ApiModelProperty(value = "图标类名")
    private String icon;

    @ApiModelProperty(value = "菜单顺序")
    private Integer menuOrder;

    @ApiModelProperty(value = "菜单层级（1：一级，2：二级，3：三级）")
    private Integer level;

    @ApiModelProperty(value = "是否是文件夹（0：否，1：是）")
    private Integer isFolder;

    @ApiModelProperty(value = "是否默认折叠（0：否，1：是）")
    private Integer isCollapsed;

    @ApiModelProperty(value = "是否可见（0：否，1：是）")
    private Integer isVisible;

    @ApiModelProperty(value = "创建者ID")
    private Integer createdBy;

    @ApiModelProperty(value = "创建时间")
    private String createdAt;

    @ApiModelProperty(value = "更新时间")
    private String updatedAt;

    @TableField(exist = false)
    private List<AijsqMenu> children;
}