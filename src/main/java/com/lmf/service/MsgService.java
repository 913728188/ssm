package com.lmf.service;

import com.lmf.base.BaseService;
import com.lmf.entity.Msg;

public interface MsgService extends BaseService<Msg,Long> {
    Msg add(Msg msg);
}
