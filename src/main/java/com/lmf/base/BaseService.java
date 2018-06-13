package com.lmf.base;

import java.util.ArrayList;
import java.util.List;

/**
 * com.lmf.base
 * <p>
 * root创建于18-6-4
 * TODO:进行描述
 **/
public interface BaseService<T,PK> {

    boolean update(T u);

    boolean save(T u);

    T findById(Long id);

    List<T> findAll();
}
