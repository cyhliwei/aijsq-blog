package com.github.paicoding.forum.service.article.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.paicoding.forum.api.model.vo.article.dto.AijsqMenuDTO;
import com.github.paicoding.forum.service.article.repository.entity.AijsqMenu;


import java.util.List;

/**
 * 菜单项表 服务接口
 */
public interface AijsqMenuService extends IService<AijsqMenu> {
    /**
     * 查询菜单项表分页列表
     */
    IPage<AijsqMenu> selectPage(AijsqMenu aijsqMenu);

    /**
     * 查询菜单项表列表
     */
    List<AijsqMenu> selectList(AijsqMenu aijsqMenu);

    /**
     * 新增菜单项表
     */
    boolean insert(AijsqMenu aijsqMenu);

    /**
     * 修改菜单项表
     */
    boolean update(AijsqMenu aijsqMenu);

    /**
     * 批量删除菜单项表
     */
    boolean deleteByIds(List<String> ids);

    List<AijsqMenuDTO> getMenuTree(AijsqMenu aijsqMenu);
}