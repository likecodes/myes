/**
 * Created by leo on 2017/7/16.
 */
$.ajax({
    url : "/login/success",
    async : false,
    type : "POST",
    data : {},
    dataType:"json",
    success : function(data) {
        if(data.code!='0'){
            window.location="/html/login.html"
        }
    },
    error:function (data) {
        window.location="/html/login.html"
    }
});
