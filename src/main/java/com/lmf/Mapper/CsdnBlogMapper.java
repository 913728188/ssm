package com.lmf.Mapper;

import com.lmf.base.BaseMapper;
import com.lmf.entity.CsdnBlog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * com.lmf.Mapper
 * <p>
 * root创建于18-6-4
 * TODO:进行描述
 **/
@Mapper
public interface CsdnBlogMapper extends BaseMapper<CsdnBlog> {

    List<CsdnBlog> findAll();
}
