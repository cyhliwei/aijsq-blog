package com.github.paicoding.forum.web.front.article.view;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.github.paicoding.forum.api.model.context.ReqInfoContext;
import com.github.paicoding.forum.api.model.enums.ArticleReadTypeEnum;
import com.github.paicoding.forum.api.model.enums.column.ColumnArticleReadEnum;
import com.github.paicoding.forum.api.model.vo.PageParam;
import com.github.paicoding.forum.api.model.vo.ResVo;
import com.github.paicoding.forum.api.model.vo.article.dto.*;
import com.github.paicoding.forum.api.model.vo.comment.dto.TopCommentDTO;
import com.github.paicoding.forum.core.util.MarkdownConverter;
import com.github.paicoding.forum.core.util.SpringUtil;
import com.github.paicoding.forum.service.article.repository.entity.AijsqMenu;
import com.github.paicoding.forum.service.article.repository.entity.ColumnArticleDO;
import com.github.paicoding.forum.service.article.service.AijsqMenuService;
import com.github.paicoding.forum.service.article.service.ArticlePayService;
import com.github.paicoding.forum.service.article.service.ArticleReadService;
import com.github.paicoding.forum.service.article.service.ColumnService;
import com.github.paicoding.forum.service.comment.service.CommentReadService;
import com.github.paicoding.forum.service.sidebar.service.SidebarService;
import com.github.paicoding.forum.web.config.GlobalViewConfig;
import com.github.paicoding.forum.web.global.SeoInjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 菜单项表 控制器
 */
@Controller
@RequestMapping("/sys/aijsqMenu")
@RequiredArgsConstructor
@Api(tags = "菜单项表管理")
public class AijsqMenuController {
    @Autowired
    private AijsqMenuService aijsqMenuService;
    @Autowired
    private ColumnService columnService;
    @Autowired
    private ArticleReadService articleReadService;

    @Autowired
    private CommentReadService commentReadService;

    @Autowired
    private SidebarService sidebarService;

    @Resource
    private GlobalViewConfig globalViewConfig;
    @Autowired
    private ArticlePayService articlePayService;
    /**
     * 专栏的文章阅读界面
     *
     * @param model
     * @return
     */
    @GetMapping(path = "{type}/{menuId}")
    public String articles(@PathVariable("type") String type, @PathVariable("menuId") String menuId, Model model) {
        if (StringUtils.isEmpty(type)) type = "0";
        AijsqMenu aijsqMenu = new AijsqMenu();
        aijsqMenu.setType(type);
        // 查询专栏菜单
        List<AijsqMenuDTO> menuTrees = aijsqMenuService.getMenuTree(aijsqMenu);

        // 文章信息
        ArticleDTO articleDTO = articleReadService.queryArticleListByMenuId(menuId, ReqInfoContext.getReqInfo().getUserId());
        // 返回html格式的文档内容
        articleDTO.setContent(MarkdownConverter.markdownToHtml(articleDTO.getContent()));
        // 评论信息
        List<TopCommentDTO> comments = commentReadService.getArticleComments(articleDTO.getArticleId(), PageParam.newPageInstance());

        // 热门评论
        TopCommentDTO hotComment = commentReadService.queryHotComment(articleDTO.getArticleId());

        List<TopCommentDTO> highlightComment = commentReadService.queryHighlightComments(articleDTO.getArticleId());
        ArticleOtherDTO other = new ArticleOtherDTO();
        ColumnArticlesDTO vo = new ColumnArticlesDTO();
        vo.setArticle(articleDTO);
        vo.setComments(comments);
        vo.setHotComment(hotComment);
        vo.setHighlightComments(highlightComment);
        vo.setMenus(menuTrees);
        vo.setActiveMenuId(menuId);
        // 把是文章翻页的参数封装到这里
        // prev 的 href 和 是否显示的 flag
        ColumnArticleFlipDTO flip = new ColumnArticleFlipDTO();
        flip.setPrevHref("/sys/aijsqMenu/" + type + "/" + menuId);
        flip.setPrevShow(true);
        // next 的 href 和 是否显示的 flag
        flip.setNextShow(true);
        other.setFlip(flip);

        // 放入 model 中
        vo.setOther(other);
        // 打赏用户列表
        if (Objects.equals(articleDTO.getReadType(), ArticleReadTypeEnum.PAY_READ.getType())) {
            vo.setPayUsers(articlePayService.queryPayUsers(articleDTO.getArticleId()));
        } else {
            vo.setPayUsers(Collections.emptyList());
        }
        model.addAttribute("vo", vo);

        SpringUtil.getBean(SeoInjectService.class).initArticleSeo(vo, articleDTO.getArticleId());
        return "views/article-menu-type/index";
    }
    @GetMapping(path = "/check/{type}/{menuId}")
    @ResponseBody
    public ResVo<Boolean> check(@PathVariable("type") String type, @PathVariable("menuId") String menuId, Model model) {
        return ResVo.ok(articleReadService.queryArticleByMenuId(menuId));
    }
    @GetMapping("/tree")
    @ApiOperation(value = "获取菜单树列表")
    public ResVo<List<AijsqMenuDTO>> getMenuTree(AijsqMenu aijsqMenu) {
        return ResVo.ok(aijsqMenuService.getMenuTree(aijsqMenu));
    }

    @GetMapping("/list")
    @ApiOperation(value = "获取菜单项表列表")
    public ResVo<IPage<AijsqMenu>> list(AijsqMenu aijsqMenu) {
        return ResVo.ok(aijsqMenuService.selectPage(aijsqMenu));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "获取菜单项表详情")
    public ResVo<AijsqMenu> getInfo(@PathVariable("id") String id) {
        return ResVo.ok(aijsqMenuService.getById(id));
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加菜单项表")
    public ResVo<Object> add(@RequestBody AijsqMenu aijsqMenu) {
        return ResVo.ok(aijsqMenuService.insert(aijsqMenu));
    }

    @PutMapping("/update")
    @ApiOperation(value = "修改菜单项表")
    public ResVo<Object> edit(@RequestBody AijsqMenu aijsqMenu) {
        return ResVo.ok(aijsqMenuService.update(aijsqMenu));
    }

    @DeleteMapping("/delete/{ids}")
    @ApiOperation(value = "删除菜单项表")
    public ResVo<Object> remove(@PathVariable List<String> ids) {
        return ResVo.ok(aijsqMenuService.deleteByIds(ids));
    }
}