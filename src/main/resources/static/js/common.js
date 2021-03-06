//ajax post
function ajaxFn(option,successFn,errorFn){
    var dataType = option.dataType || "JSON";
    $.ajax({
        type:"post",
        url:option.url,
        dataType:dataType,
        data:option.data,
        contentType:'application/json;charset=UTF-8',
        success:function(result){
              if(typeof successFn === "function"){
                successFn(result)
              }
        },
        error:function(err,status,detail){
            if(typeof errorFn === "function"){
                errorFn(err,status,detail);
            }
        }
    })
}

    function getFormData(selector){
        var data = $(selector).serializeArray();
        var object_ = {};
        for(var i of data){
          object_[i.name] = i.value;
        }
        object_ = JSON.stringify(object_);
        return object_;
    }
