/**
 * Created by leo on 2017/7/12.
 */
$(function () {
    function menuGen(permissionMatrix) {
        //格式化数据，建立多叉树
        if(!permissionMatrix)return;
        var menuHtml=""
        $.each(permissionMatrix,function(index,menuItem){
            console.log("menuItem"+menuItem+index);
            if($.isEmptyObject(menuItem.parentId)&&menuItem.permType==1){
                //填充UI节点
                console.log("parentId"+menuItem.description+""+index+menuItem);

                menuHtml=menuHtml+'<li>' +
                    '<a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>' +menuItem.description+'<span class="fa arrow"></span></a>'
                    +'<ul class="nav nav-second-level">'
                $.each(permissionMatrix,
                    function(childIndex,menuChildItem){
                        if(menuChildItem.parentId==menuItem.permId &&menuChildItem.permType==1){
                            //填充child节点
                            console.log("menuItemC"+menuChildItem.description);
                            menuHtml=menuHtml+'<li><a href="'+menuChildItem.resouce+'">'+menuChildItem.description+'</a> </li>'
                        }
                    })
                menuHtml=menuHtml+'</ul></li>'
            }

        })
        console.log("html"+menuHtml);
        $("#side-menu").empty();
        $("#side-menu").append(menuHtml);
    }
    $.ajax({
            type: "GET",
            url: "/aut/mng/user/permsions",
            data: {username: $("#username").val(), content: $("#content").val()},
            dataType: "json",
            success: function (response) {
                console.log(response)
                if(response.retcode=='0000'){
                    menuGen(response.data)
                }
            }
        }
    )

})