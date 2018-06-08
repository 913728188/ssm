package com.lmf.service.impl;

import com.lmf.Mapper.CsdnBlogMapper;
import com.lmf.base.BaseMapper;
import com.lmf.base.BaseServiceImpl;
import com.lmf.entity.CsdnBlog;
import com.lmf.service.CsdnBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * com.lmf.service.impl
 * <p>
 * root创建于18-6-4
 * TODO:进行描述
 **/
@Service("CsdnBlogService")
public class CsdnBlogServiceImpl  extends BaseServiceImpl<CsdnBlog,Long> implements CsdnBlogService {

    @Autowired
    private CsdnBlogMapper csdnBlogMapper;

    private  CsdnBlogService csdnBlogService;

    public CsdnBlogService getCsdnBlogService() {
        return csdnBlogService;
    }

    public void setCsdnBlogService(CsdnBlogService csdnBlogService) {
        this.csdnBlogService = csdnBlogService;
    }

    @Override
    @Autowired
    public void setBaseMapper(@Qualifier("csdnBlogMapper") BaseMapper<CsdnBlog> baseMapper) {
        this.baseMapper = baseMapper;

    }

    public  void setMapper(CsdnBlogMapper csdnBlogMapper){
        csdnBlogMapper = this.csdnBlogMapper;
    }

    /**
     *  findById
     * @param id
     * @return
     */
    public CsdnBlog findById(Long id){
        return csdnBlogMapper.findById(id);
    }

    public boolean update(CsdnBlog entity) {
        int result = csdnBlogMapper.updatebyEmit(entity);
        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }

}
