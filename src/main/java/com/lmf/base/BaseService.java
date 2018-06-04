package com.lmf.base;

/**
 * com.lmf.base
 * <p>
 * root创建于18-6-4
 * TODO:进行描述
 **/
public interface BaseService<T,PK> {

    boolean update(T u);

    T findById(PK id);
}
