package com.lmf.service.impl;

import com.lmf.Mapper.CsdnBlogMapper;
import com.lmf.base.BaseMapper;
import com.lmf.base.BaseServiceImpl;
import com.lmf.entity.CsdnBlog;
import com.lmf.service.CsdnBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * com.lmf.service.impl
 * <p>
 * root创建于18-6-4
 * TODO:进行描述
 **/
public class CsdnBlogServiceImpl  extends BaseServiceImpl<CsdnBlog,Long> implements CsdnBlogService {

    @Autowired
    private CsdnBlogMapper csdnBlogMapper;


    @Override
    @Autowired
    public void setBaseMapper(@Qualifier("csdnBlogMapper") BaseMapper<CsdnBlog> baseMapper) {
        this.baseMapper = baseMapper;

    }

    public  void setMapper(CsdnBlogMapper csdnBlogMapper){
        csdnBlogMapper = this.csdnBlogMapper;
    }
}
