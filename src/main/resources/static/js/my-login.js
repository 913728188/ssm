$(function() {
	$("input[type='password'][data-eye]").each(function(i) {
		var $this = $(this);

		$this.wrap($("<div/>", {
			style: 'position:relative'
		}));
		$this.css({
			paddingRight: 60
		});
		$this.after($("<div/>", {
			html: 'Show',
			class: 'btn btn-primary btn-sm',
			id: 'passeye-toggle-'+i,
			style: 'position:absolute;right:10px;top:50%;transform:translate(0,-50%);-webkit-transform:translate(0,-50%);-o-transform:translate(0,-50%);padding: 2px 7px;font-size:12px;cursor:pointer;'
		}));
		$this.after($("<input/>", {
			type: 'hidden',
			id: 'passeye-' + i
		}));
		$this.on("keyup paste", function() {
			$("#passeye-"+i).val($(this).val());
		});
		$("#passeye-toggle-"+i).on("click", function() {
			if($this.hasClass("show")) {
				$this.attr('type', 'password');
				$this.removeClass("show");
				$(this).removeClass("btn-outline-primary");
			}else{
				$this.attr('type', 'text');
				$this.val($("#passeye-"+i).val());				
				$this.addClass("show");
				$(this).addClass("btn-outline-primary");
			}
		});
	});


	$(".submit").on("click",function(){
	    var data = getFormData("#form");
	    ajaxFn({url:"/signup",data:data},function(result){
	      if(result.code ==200 ){
            location.href = "/login";
          }

	    })
	}),

	$(".login_submit").on("click",function(){

	    var data = getFormData("#login_form");
	    console.log(data);
	    ajaxFn({url:"/login",data:data},function(result){
	      alert(result.msg);
          if(result.code ==200 ){
           sessionStorage.setItem("user", result.data.id);
            location.href = "/index?user_id="+result.data.id;
          }
	    })
	})
});