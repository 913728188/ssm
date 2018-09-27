package com.lmf.service.impl;

import com.lmf.Mapper.CsdnBlogMapper;
import com.lmf.Mapper.MsgMapper;
import com.lmf.base.BaseMapper;
import com.lmf.base.BaseServiceImpl;
import com.lmf.entity.CsdnBlog;
import com.lmf.entity.Msg;
import com.lmf.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("msgService")
public class MsgServiceImpl extends BaseServiceImpl<Msg,Long> implements MsgService{

    @Autowired
    private  MsgMapper msgMapper;

    private  MsgService msgService;

    public MsgService getMsgService() {
        return msgService;
    }

    public void setMsgService(MsgService msgService) {
        this.msgService = msgService;
    }
    @Override
    @Autowired
    public void setBaseMapper(@Qualifier("msgMapper") BaseMapper<Msg> baseMapper) {
        this.baseMapper = baseMapper;

    }

    public  void setMapper(MsgMapper msgMapper){
        msgMapper = this.msgMapper;
    }

    public  Msg add(Msg msg){
        int count = msgMapper.insert(msg);
        return msg;
    }

}
