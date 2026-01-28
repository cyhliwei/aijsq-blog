package com.github.paicoding.forum.service.user.converter;

import com.github.paicoding.forum.api.model.vo.user.SearchZsxqUserReq;
import com.github.paicoding.forum.service.user.repository.params.SearchZsxqWhiteParams;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * 微信搜索「AI技术圈」，回复 Java
 *
 * @author AI技术圈
 * @date 6/29/23
 */
@Mapper
public interface UserStructMapper {
    UserStructMapper INSTANCE = Mappers.getMapper( UserStructMapper.class );
    // req to params
    @Mapping(source = "pageNumber", target = "pageNum")
    // state to status
    @Mapping(source = "state", target = "status")
    SearchZsxqWhiteParams toSearchParams(SearchZsxqUserReq req);
}
