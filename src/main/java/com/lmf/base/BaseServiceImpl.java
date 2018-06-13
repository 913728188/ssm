package com.lmf.base;

import java.util.List;

/**
 * com.lmf.base
 * <p>
 * root创建于18-6-4
 * TODO:进行描述
 **/
public abstract class BaseServiceImpl<T,PK> implements BaseService<T,PK> {

    protected BaseMapper<T> baseMapper;
    protected Class objClz;
    public abstract void setBaseMapper(BaseMapper<T> baseMapper);

    /**
     * 修改
     * @param entity
     * @return
     */
    @Override
    public boolean update(T entity) {
        int result = baseMapper.updateByPrimaryKeySelective(entity);
        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 添加
     * @param entity
     * @return
     */
    @Override
    public boolean save(T entity) {
        int result = baseMapper.insert(entity);
        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }



    //@Override
    public T findById(Long id) {
        return baseMapper.selectByPrimaryKey(id);
    }


    /**
     * 查询全部
     * @return
     */
    public List<T> findAll() {
        return baseMapper.selectAll();
    }
}
