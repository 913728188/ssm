package com.lmf.Mapper;

import com.lmf.base.BaseMapper;
import com.lmf.entity.CsdnBlog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    @Select("select * from csdnblog where id = ${id}")
    CsdnBlog findById(@Param("id") Long id);


    @Update("update csdnblog set content='${csdblog.content}' where id=${csdblog.id}")
    int updatebyEmit(@Param("csdblog") CsdnBlog csdnBlog);
}
