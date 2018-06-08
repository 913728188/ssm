package com.lmf.entity;

/**
 * com.lmf.entity
 * <p>
 * root创建于18-6-5
 * TODO:进行描述
 **/

    import com.alibaba.fastjson.JSONObject;

    public class Url {
        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getRefer() {
            return refer;
        }

        public void setRefer(String refer) {
            this.refer = refer;
        }

        private String url;
        private String refer;
        private String writer;

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        private String source;

        public String getWriter() {
            return writer;
        }

        public void setWriter(String writer) {
            this.writer = writer;
        }

        @Override
        public String toString() {
            return JSONObject.toJSONString(this);
        }
    }

