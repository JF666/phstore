function log() {
    var username=$("#inputUser");
    var password=$("#inputPassword");
    if(username.val() === "" || password.val() === ""){
        password.css("border-bottom", "1px solid red")
            .parent().removeClass("has-success has-error").addClass("has-error")
            .children().next("span").text("用户名或密码未填");
        username.css("border-bottom", "1px solid red");
    } else {
        clearLogError();
        $.ajax({
            url: "http://localhost:8080/phstore_war_exploded/login",
            type: "GET",
            data: {
                username: username.val(),
                password: password.val()
            },
            success: function (response) {
                if(response.code===100){
                    var id = response.extend.user.id;
                    var authority = response.extend.user.authority;
                    localStorage.setItem("username",response.extend.user.username);
                    if (authority === 1) {
                        $.ajax({
                            url: "http://localhost:8080/phstore_war_exploded/buyerById/"+id,
                            type: "GET",
                            data: {},
                            success: function (response) {
                                if (response.extend.buyer === null) {
                                    localStorage.setItem("buyerId", "");
                                    location.href="person.html?id="+id;
                                } else {
                                    localStorage.setItem("buyerId",response.extend.buyer.buyerid);
                                    location.href="index.html";
                                }
                            }, error: function () {
                            }
                        });
                    } else if (authority === 2) {
                        $.ajax({
                            url: "http://localhost:8080/phstore_war_exploded/sellerByUser/"+id,
                            type: "GET",
                            data: {},
                            success: function (response) {
                                if (response.extend.seller === null) {
                                    localStorage.setItem("sellerId", "");
                                    location.href="seller.html?id="+id;
                                } else {
                                    localStorage.setItem("sellerId",response.extend.seller.sellerid);
                                    location.href="seller.html?id="+id;
                                }
                            }, error: function () {
                            }
                        });
                    } else {
                        location.href="admin.html";
                    }
                }
                else {
                    password.css("border-bottom", "1px solid red").parent().removeClass("has-success has-error").addClass("has-error").children().next("span").text("用户名或密码不正确");
                    username.css("border-bottom", "1px solid red");
                }
            }, error: function () {
                var xmlState = new XMLHttpRequest();
                if (xmlState.readyState !== 4 || xmlState.status !== 200) {
                    password.parent().removeClass("has-success has-error").addClass("has-error").children().next("span").text("用户名不存在");
                    username.css("border-bottom", "1px solid red");
                } else {
                    password.parent().removeClass("has-success has-error").addClass("has-error").children().next("span").text("连接服务器失败");
                }
            }
        });
    }
}
function clearResError() {
    $("#inputUser1").css("border-bottom", "1px solid #ccc")
        .parent().removeClass("has-success has-error").addClass("has-success")
        .children().next("span").text("");
    $("#inputPassword3").css("border-bottom", "1px solid #ccc")
        .parent().removeClass("has-success has-error").addClass("has-success")
        .children().next("span").text("");
    $("#inputPassword4").css("border-bottom", "1px solid #ccc")
        .parent().removeClass("has-success has-error").addClass("has-success")
        .children().next("span").text("");
}
function clearLogError() {
    $("#inputPassword").css("border-bottom", "1px solid #ccc")
        .parent().removeClass("has-success has-error").addClass("has-success")
        .children().next("span").text("");
    $("#inputUser").css("border-bottom", "1px solid #ccc");
}
function toRes(){
    clearLogError();
    $("#inputUser").val("");
    $("#inputPassword").val("");
    $(".login-box").removeClass("test2").addClass("test").css("display", "none");
    $(".res-box").removeClass("test").addClass("test2").css("display", "block");
}
function toLog(){
    clearResError();
    $("#inputUser1").val("");
    $("#inputPassword3").val("");
    $("#inputPassword4").val("");
    $(".login-box").removeClass("test").addClass("test2").css("display", "block");
    $(".res-box").removeClass("test2").addClass("test").css("display", "none");
}
function res() {
    var user=$("#inputUser1");
    var pass=$("#inputPassword3");
    var pass1=$("#inputPassword4");
    if(user.val()===""||pass.val()===""||pass1.val()===""){
        // alert("未填写信息");
        user.css("border-bottom", "1px solid red")
            .parent().removeClass("has-success has-error")
            .children().next("span").text("");
        pass.css("border-bottom", "1px solid red")
            .parent().removeClass("has-success has-error")
            .children().next("span").text("");
        pass1.css("border-bottom", "1px solid red")
            .parent().removeClass("has-success has-error").addClass("has-error")
            .children().next("span").text("请填写信息");
    } else if(pass.val()!==pass1.val()){
        user.css("border-bottom", "1px solid #ccc")
            .parent().removeClass("has-success has-error")
            .children().next("span").text("");
        pass.css("border-bottom", "1px solid #ccc")
            .parent().removeClass("has-success has-error")
            .children().next("span").text("");
        pass1.css("border-bottom", "1px solid red")
            .parent().removeClass("has-success has-error").addClass("has-error")
            .children().next("span").text("两次密码不一致");
    } else {
        clearResError();
        $.ajax({
            url:"http://localhost:8080/phstore_war_exploded/register",
            data: $(".form-horizontal1").serialize()+"&authority=1",
            type:"POST",
            success:function (result) {
                if(result.code===100){
                    location.href = "login.html";
                } else {
                    if (result.extend.errorFields.username !== undefined && result.extend.errorFields.password !== undefined) {
                        user.css("border-bottom", "1px solid red")
                            .parent().removeClass("has-success has-error").addClass("has-error")
                            .children().next("span").text(result.extend.errorFields.username);
                        pass.css("border-bottom", "1px solid red")
                            .parent().removeClass("has-success has-error").addClass("has-error")
                            .children().next("span").text(result.extend.errorFields.password);
                        pass1.css("border-bottom", "1px solid #ccc")
                            .parent().removeClass("has-success has-error")
                            .children().next("span").text("");
                    } else if (result.extend.errorFields.username !== undefined && result.extend.errorFields.password === undefined) {
                        user.css("border-bottom", "1px solid red")
                            .parent().removeClass("has-success has-error").addClass("has-error")
                            .children().next("span").text(result.extend.errorFields.username);
                        pass.css("border-bottom", "1px solid #ccc")
                            .parent().removeClass("has-success has-error")
                            .children().next("span").text("");
                        pass1.css("border-bottom", "1px solid #ccc")
                            .parent().removeClass("has-success has-error")
                            .children().next("span").text("");
                    } else if (result.extend.errorFields.username === undefined && result.extend.errorFields.password !== undefined) {
                        user.css("border-bottom", "1px solid #ccc")
                            .parent().removeClass("has-success has-error")
                            .children().next("span").text("");
                        pass.css("border-bottom", "1px solid red")
                            .parent().removeClass("has-success has-error").addClass("has-error")
                            .children().next("span").text(result.extend.errorFields.password);
                        pass1.css("border-bottom", "1px solid #ccc")
                            .parent().removeClass("has-success has-error")
                            .children().next("span").text("");
                    }
                }
            }, error:function () {
                var xmlState = new XMLHttpRequest();
                if (xmlState.readyState !== 4 || xmlState.status !== 200) {
                    user.css("border-bottom", "1px solid red")
                        .parent().removeClass("has-success has-error").addClass("has-error")
                        .children().next("span").text("用户名已存在");
                    pass.css("border-bottom", "1px solid #ccc")
                        .parent().removeClass("has-success has-error")
                        .children().next("span").text("");
                    pass1.css("border-bottom", "1px solid #ccc")
                        .parent().removeClass("has-success has-error")
                        .children().next("span").text("");
                } else {
                    user.css("border-bottom", "1px solid #ccc")
                        .parent().removeClass("has-success has-error")
                        .children().next("span").text("");
                    pass.css("border-bottom", "1px solid #ccc")
                        .parent().removeClass("has-success has-error")
                        .children().next("span").text("");
                    pass1.css("border-bottom", "1px solid red")
                        .parent().removeClass("has-success has-error").addClass("has-error")
                        .children().next("span").text("连接服务器失败");
                }
            }
        });
    }
}