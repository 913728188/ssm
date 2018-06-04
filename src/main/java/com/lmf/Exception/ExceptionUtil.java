package com.lmf.Exception;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * com.lmf.Exception
 * <p>
 * root创建于18-6-4
 * TODO:进行描述
 **/
public class ExceptionUtil {
    public static String paramException(){
        Map<String,Object> map = new HashMap<>();
        map.put("errCode","101");
        map.put("msg","参数错误!");
        String json =  JSON.toJSONString(map);
        return json;
    }
}
