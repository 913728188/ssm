# ssm
my test ssm project
遇到的问题总结:
1:页面请求接口415问题,发送的请求需要修改content-type,项目中使用的是json,所以修改为 contentType:'application/json;charset=UTF-8'
2:参数转化问题, JsonParseException: Unrecognized token '——属性名————': was expecting ('true', 'false' or 'null'),请求参数需要修改成JSON对象