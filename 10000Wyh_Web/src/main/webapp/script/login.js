$(document).ready(function() {
    $('#loginForm').validate({
        debug:true,
        rules:{
            username: {
                required: true
            },
            password: {
                required: true
            }
        },
        messages:{
            username: {
                required: '请输入用户名'
            },
            password: {
                required: '请输入密码'
            }
        },
        submitHandler:function(form){
            $(form).ajaxSubmit({
                method:$("#loginForm").attr("method"),
                xhrFields: {withCredentials: true},
                data:$("#loginForm").serialize(),
                success:function (obj) {
                    if(obj.code==1001){
                        location.href="index.html";
                    }else{
                        alert("登录失败");
                    }
                }
            });
        }
    });
});


