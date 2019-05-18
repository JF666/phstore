var user=localStorage.getItem("username");
$(function () {
    if (user!=null){
        $(".user").css("display", "block");
        $("#J_userInfo").css("display", "none");
        $(".name").text(user);
        $(".user").hover(function () {
            $(".user-menu").css("display", "block");
            $(".user-name").css("background", "#fff")
                .css("color", "#000");
        },function () {
            $(".user-name").css("background", "#333")
                .css("color", "#b0b0b0");
            $(".user-menu").css("display", "none");
        });
    }
    getPerson();
    getPro();
    getOrder();
    getComment();
});
// 用户管理页面
function toPerson() {
    $(".list ul li a").css("color", "#666666");
    $(".list ul").children().first().children().css("color", "#337ab7");
    $(".person").css("display", "block");
    $(".modifyPerson").css("display", "none");
    $(".addPerson").css("display", "none");
    $(".Pro").css("display", "none");
    $(".addPro").css("display", "none");
    $(".modifyPro").css("display", "none");
    $(".order").css("display", "none");
    $(".modifyOrder").css("display", "none");
    $(".comment").css("display", "none");

    $(".modifyComment").css("display", "none");
    getPerson();
}
// 获取用户信息
function getPerson() {
    $.ajax({
        url: "http://localhost:8080/phstore_war_exploded/users",
        data: {},
        type: "GET",
        success: function (response) {
            var data = response.extend.users;
            if (data.length === 1){
                $(".person").empty();
                $(".person").append($("<div></div>").addClass("emptyOrder")
                    .append($("<h2>系统无买家或卖家用户！</h2>"))
                    .append($("<a></a>").text("马上去添加").attr("onclick", "addPer()").attr("class", "btn btn-shop btn-shop1"))
                );
            } else {
                for (i in data) {
                    var userid = data[i].id;
                    var username = data[i].username;
                    var password = data[i].password;
                    var authority = data[i].authority;
                    if (authority === 1) {
                        $(".person").append($("<div></div>").addClass("PerList").attr("userid", userid)
                            .append($("<h4>买家信息</h4>"))
                            .append($("<label>用户名：</label>").append($("<p></p>").text(username)))
                            .append($("<label>密码：</label>").append($("<p></p>").text(password)))
                            .append($("<label>用户类型：</label>").append($("<p></p>").text("买家")))
                            .append($("<a>修改</a>")
                                .attr("onclick", "modifyPer(this)")
                                .attr("userid", userid)
                                .attr("class", "btn btn-shop btn-shop1 btn-Pro"))
                            .append($("<a>删除</a>")
                                .attr("onclick", "deletePer(this)")
                                .attr("userid", userid)
                                .attr("class", "btn btn-danger btn-shop1 btn-Pro"))
                        );
                    } else if (authority === 2) {
                        $(".person").append($("<div></div>").addClass("PerList").attr("userid", userid)
                            .append($("<h4>卖家信息</h4>"))
                            .append($("<label>用户名：</label>").append($("<p></p>").text(username)))
                            .append($("<label>密码：</label>").append($("<p></p>").text(password)))
                            .append($("<label>用户类型：</label>").append($("<p></p>").text("卖家")))
                            .append($("<a>修改</a>")
                                .attr("onclick", "modifyPer(this)")
                                .attr("userid", userid)
                                .attr("class", "btn btn-shop btn-shop1 btn-Pro"))
                            .append($("<a>删除</a>")
                                .attr("onclick", "deletePer(this)")
                                .attr("userid", userid)
                                .attr("class", "btn btn-danger btn-shop1 btn-Pro"))
                        );
                    }
                }
            }
        },error: function () {
        }
    });
}
// 删除用户功能
function deletePer(obj) {
    var userid = $(obj).attr("userid");
    $.ajax({
        url: "http://localhost:8080/phstore_war_exploded/user/" + userid,
        data: {},
        type: "DELETE",
        success: function () {
            $(obj).parent().hide(1000, function () {
                $(obj).parent().remove();
            });
            if($(".person").children().length === 1){
                $(".person").empty();
                $(".person").append($("<div></div>").addClass("emptyOrder")
                    .append($("<h2>系统无买家或卖家用户！</h2>"))
                    .append($("<a></a>").text("马上去添加").attr("onclick", "addPer()").attr("class", "btn btn-shop btn-shop1"))
                );
            }
        }, error: function () {

        }
    });
}
// 修改用户页面
function modifyPer(obj) {
    $(".modifyPerson").css("display", "block");
    $(".addPerson").css("display", "none");
    disClick();
    var userid = $(obj).attr("userid");
    $(".modifyPerson").attr("userid", userid);
    $("#inputUsername").val($(obj).prev().prev().prev().children().text());
    $("#inputPassword").val($(obj).prev().prev().children().text());
    $("#inputAuth").val($(obj).prev().children().text());
}
// 保存修改用户
function saveMod() {
    if ($("#inputPassword").val() === "" || $("#inputUsername").val() === "" || $("#inputAuth").val() === "") {
        alert("请填写完整信息");
    } else {
        var userid = $(".modifyPerson").attr("userid");
        $.ajax({
            url: "http://localhost:8080/phstore_war_exploded/user/" + userid,
            data: {
                username: $("#inputUsername").val(),
                password: $("#inputPassword").val(),
                authority: $("#inputAuth").val()
            },
            type: "PUT",
            success: function () {
                $(".PerList[userid='" + userid + "']").find("label").eq(0).children().text($("#inputUsername").val());
                $(".PerList[userid='" + userid + "']").find("label").eq(1).children().text($("#inputPassword").val());
                $(".PerList[userid='" + userid + "']").find("label").eq(2).children().text($("#inputAuth").val());
                $(".modifyPerson").removeAttr("userid");
                cancelMod();
            }, error: function () {
            }
        });
    }
}
// 取消修改用户
function cancelMod() {
    $(".person").css("display", "block");
    $(".modifyPerson").css("display", "none");
    $(".addPerson").css("display", "none");
    $(".Pro").css("display", "none");
    $(".addPro").css("display", "none");
    $(".modifyPro").css("display", "none");
    $(".order").css("display", "none");
    $(".modifyOrder").css("display", "none");
    $(".comment").css("display", "none");
    $(".modifyComment").css("display", "none");
    $(".list ul").find("li").eq(0).children().attr("onclick", "toPerson()");
    $(".list ul").find("li").eq(1).children().attr("onclick", "toPro()");
    $(".list ul").find("li").eq(2).children().attr("onclick", "toOrder()");
    $(".list ul").find("li").eq(3).attr("onclick", "toComment()");
    $(".user-menu").find("li").eq(0).children().attr("onclick", "toPerson()");
    $(".user-menu").find("li").eq(1).children().attr("onclick", "toPro()");
    $(".user-menu").find("li").eq(2).children().attr("onclick", "toOrder()");
    $(".user-menu").find("li").eq(3).children().attr("onclick", "toComment()");
    $(".user-menu").find("li").eq(4).children().attr("onclick", "quit();return false;");
}
// 添加用户页面
function addPer() {
    $(".addPerson").css("display", "block");
    $(".modifyPerson").css("display", "none");
    disClick();
}
// 保存添加用户信息
function saveAdd() {
    if ($("#inPassword").val() === "" || $("#inUsername").val() === "" || $("#inAuth").val() === "") {
        alert("请填写完整信息");
    } else {
        $.ajax({
            url: "http://localhost:8080/phstore_war_exploded/userInsert",
            data: {
                username: $("#inUsername").val(),
                password: $("#inPassword").val(),
                authority: $("#inAuth").val()
            },
            type: "POST",
            success: function () {
                cancelMod();
                getPerson();
            }, error: function () {
            }
        });
    }
}
// 重置添加用户信息，清空输入框
function resetAdd() {
    $("#inUsername").val("");
    $("#inPassword").val("");
    $("#inAuth").val("");
}
// 修改添加用户共用，禁用a标签，隐藏其他页面
function disClick() {
    $(".person").css("display", "none");
    $(".Pro").css("display", "none");
    $(".addPro").css("display", "none");
    $(".modifyPro").css("display", "none");
    $(".order").css("display", "none");
    $(".modifyOrder").css("display", "none");
    $(".comment").css("display", "none");
    $(".modifyComment").css("display", "none");
    $(".list ul li a").removeAttr("onclick");
    $(".user-menu li a").removeAttr("onclick");
}
// 商品管理页面
function toPro() {
    $(".list ul li a").css("color", "#666666");
    $(".list ul").find("li").eq(1).children().css("color", "#337ab7");
    $(".person").css("display", "none");
    $(".modifyPerson").css("display", "none");
    $(".addPerson").css("display", "none");
    $(".Pro").css("display", "block");
    $(".addPro").css("display", "none");
    $(".modifyPro").css("display", "none");
    $(".order").css("display", "none");
    $(".modifyOrder").css("display", "none");
    $(".comment").css("display", "none");
    $(".modifyComment").css("display", "none");
    getPro();
}
// 获取商品信息
function getPro() {
    $.ajax({
        url: "http://localhost:8080/phstore_war_exploded/product/"+sellerId,
        data: {},
        type: "GET",
        success: function (response) {
            var data = response.extend.products;
            if (data.length === 0){
                $(".Pro").empty();
                $(".Pro").append($("<div></div>").addClass("emptyOrder")
                    .append($("<h2>尚未添加商品！</h2>"))
                    .append($("<a></a>").text("马上去添加").attr("onclick", "addPro()").attr("class", "btn btn-shop btn-shop1"))
                );
            } else {
                $(".proList").empty();
                for (i in data) {
                    var color = data[i].color;
                    var discount = data[i].discount;
                    var pic = data[i].pic;
                    var price = data[i].price;
                    var proId = data[i].proId;
                    var proIntro = data[i].proIntro;
                    var proname = data[i].proname;
                    var version = data[i].version;
                    $(".proList").append($("<div></div>").addClass("orderList ProList").attr("proId", proId)
                        .append($("<span><span/>").text("商品名称：")
                            .append($("<p></p>").text(proname)))
                        .append($("<span><span/>").text("商品价格：")
                            .append($("<p></p>").text(price)))
                        .append($("<span><span/>").text("商品折扣：")
                            .append($("<p></p>").text(discount)))
                        .append($("<span><span/>").text("商品版本：")
                            .append($("<p></p>").text(version)))
                        .append($("<span><span/>").text("商品介绍：")
                            .append($("<p></p>").text(proIntro)))
                        .append($("<span><span/>").text("商品图片：")
                            .append($("<p></p>").text(pic)))
                        .append($("<span><span/>").text("商品颜色：")
                            .append($("<p></p>").text(color)))
                        .append($("<a>修改</a>")
                            .attr("onclick", "modifyPro(this)")
                            .attr("proId", proId)
                            .attr("class", "btn btn-shop btn-shop1 btn-Pro"))
                        .append($("<a>删除</a>")
                            .attr("onclick", "deletePro(this)")
                            .attr("proId", proId)
                            .attr("class", "btn btn-danger btn-shop1 btn-Pro"))
                    );
                }
            }
        },error: function () {
        }
    });
}
// 添加商品页面
function addPro() {
    $(".person").css("display", "none");
    $(".addPerson").css("display", "none");
    $(".modifyPerson").css("display", "none");
    $(".Pro").css("display", "none");
    $(".addPro").css("display", "block");
    $(".modifyPro").css("display", "none");
    $(".order").css("display", "none");
    $(".modifyOrder").css("display", "none");
    $(".comment").css("display", "none");

    $(".modifyComment").css("display", "none");
    $(".list ul li a").removeAttr("onclick");
    $(".user-menu li a").removeAttr("onclick");
}
// 修改商品页面
function modifyPro(obj) {
    $(".person").css("display", "none");
    $(".addPerson").css("display", "none");
    $(".modifyPerson").css("display", "none");
    $(".Pro").css("display", "none");
    $(".addPro").css("display", "none");
    $(".modifyPro").css("display", "block");
    $(".order").css("display", "none");
    $(".comment").css("display", "none");

    $(".modifyComment").css("display", "none");
    $(".list ul li a").removeAttr("onclick");
    $(".user-menu li a").removeAttr("onclick");
    var proId = $(obj).attr("proId");
    $(".modifyPro").attr("proId", proId);
    $("#inputProname").val($(".ProList[proId='"+proId+"']").find("span").eq(0).children().text());
    $("#inputPrice").val($(".ProList[proId='"+proId+"']").find("span").eq(1).children().text());
    $("#inputDiscount").val($(".ProList[proId='"+proId+"']").find("span").eq(2).children().text());
    $("#inputVersion").val($(".ProList[proId='"+proId+"']").find("span").eq(3).children().text());
    $("#inputIntro").val($(".ProList[proId='"+proId+"']").find("span").eq(4).children().text());
    $("#inputPicture").val($(".ProList[proId='"+proId+"']").find("span").eq(5).children().text());
    $("#inputColor").val($(".ProList[proId='"+proId+"']").find("span").eq(6).children().text());
}
// 删除商品功能
function deletePro(obj) {
    var proId = $(obj).attr("proId");
    $.ajax({
        url: "http://localhost:8080/phstore_war_exploded/product/" + proId,
        data: {},
        type: "DELETE",
        success: function () {
            $(".ProList[proId='"+proId+"']").hide(1000, function () {
                $(".ProList[proId='"+proId+"']").remove();
            });
            if($(".proList").children().length === 0){
                $(".Pro").empty();
                $(".Pro").append($("<div></div>").addClass("emptyOrder")
                    .append($("<h2>尚未添加商品！</h2>"))
                    .append($("<a></a>").text("马上去添加").attr("onclick", "addPro()").attr("class", "btn btn-shop btn-shop1"))
                );
            }
        }, error: function () {

        }
    });
}
// 保存添加商品信息
function saveAddPro() {
    if ($("#inColor").val() === "" || $("#inDiscount").val() === "" || $("#inPicture").val() === "" ||
        $("#inPrice").val() === "" || $("#inIntro").val() === "" || $("#inProname").val() === "" || $("#inVersion").val() === "") {
        alert("请填写完整信息");
    } else {
        $.ajax({
            url: "http://localhost:8080/phstore_war_exploded/productInsert",
            data: {
                color: $("#inColor").val(),
                discount: $("#inDiscount").val(),
                pic: $("#inPicture").val(),
                price: $("#inPrice").val(),
                proIntro: $("#inIntro").val(),
                proname: $("#inProname").val(),
                sellerid: sellerId,
                stock: 9999,
                version: $("#inVersion").val()
            },
            type: "POST",
            success: function () {
                $("#inColor").val("");
                $("#inDiscount").val("");
                $("#inPicture").val("");
                $("#inPrice").val("");
                $("#inIntro").val("");
                $("#inProname").val("");
                $("#inVersion").val("");
                cancelPro();
                getPro();
            }, error: function () {

            }
        });
    }
}
// 取消添加或修改商品
function cancelPro() {
    $(".person").css("display", "none");
    $(".modifyPerson").css("display", "none");
    $(".addPerson").css("display", "none");
    $(".Pro").css("display", "block");
    $(".addPro").css("display", "none");
    $(".modifyPro").css("display", "none");
    $(".order").css("display", "none");
    $(".comment").css("display", "none");
    $(".modifyComment").css("display", "none");
    $(".list ul").children().first().children().attr("onclick", "toPerson()");
    $(".list ul").find("li").eq(1).children().attr("onclick", "toPro()");
    $(".list ul").find("li").eq(2).children().attr("onclick", "toOrder()");
    $(".list ul").children().last().children().attr("onclick", "toComment()");
    $(".user-menu").find("li").eq(0).children().attr("onclick", "toPerson()");
    $(".user-menu").find("li").eq(1).children().attr("onclick", "toPro()");
    $(".user-menu").find("li").eq(2).children().attr("onclick", "toOrder()");
    $(".user-menu").find("li").eq(3).children().attr("onclick", "toComment()");
    $(".user-menu").find("li").eq(4).children().attr("onclick", "quit();return false;");
}
// 保存修改商品信息
function saveModPro() {
    var proId = $(".modifyPro").attr("proId");
    if ($("#inputColor").val() === "" || $("#inputDiscount").val() === "" || $("#inputPicture").val() === "" ||
        $("#inputPrice").val() === "" || $("#inputIntro").val() === "" || $("#inputProname").val() === "" || $("#inputVersion").val() === "") {
        alert("请填写完整信息");
    } else {
        $.ajax({
            url: "http://localhost:8080/phstore_war_exploded/product/" + proId,
            data: {
                color: $("#inputColor").val(),
                discount: $("#inputDiscount").val(),
                pic: $("#inputPicture").val(),
                price: $("#inputPrice").val(),
                proId: proId,
                proIntro: $("#inputIntro").val(),
                proname: $("#inputProname").val(),
                sellerid: sellerId,
                stock: 9999,
                version: $("#inputVersion").val()
            },
            type: "PUT",
            success: function () {
                $(".ProList[proId='" + proId + "']").find("span").eq(0).children().text($("#inputProname").val());
                $(".ProList[proId='" + proId + "']").find("span").eq(1).children().text($("#inputPrice").val());
                $(".ProList[proId='" + proId + "']").find("span").eq(2).children().text($("#inputDiscount").val());
                $(".ProList[proId='" + proId + "']").find("span").eq(3).children().text($("#inputVersion").val());
                $(".ProList[proId='" + proId + "']").find("span").eq(4).children().text($("#inputIntro").val());
                $(".ProList[proId='" + proId + "']").find("span").eq(5).children().text($("#inputPicture").val());
                $(".ProList[proId='" + proId + "']").find("span").eq(6).children().text($("#inputColor").val());
                $(".modifyPro").removeAttr("proId");
                cancelPro();
            }, error: function () {
            }
        });
    }
}
// 订单管理页面
function toOrder() {
    $(".list ul li a").css("color", "#666666");
    $(".list ul").find("li").eq(2).children().css("color", "#337ab7");
    $(".person").css("display", "none");
    $(".addPerson").css("display", "none");
    $(".modifyPerson").css("display", "none");
    $(".Pro").css("display", "none");
    $(".addPro").css("display", "none");
    $(".modifyPro").css("display", "none");
    $(".order").css("display", "block");
    $(".comment").css("display", "none");

    $(".modifyComment").css("display", "none");
}
// 获取订单信息
function getOrder() {
    $.ajax({
        url: "http://localhost:8080/phstore_war_exploded/tranBySeller",
        data: {
            sellerid: sellerId
        },
        type: "GET",
        success: function (response) {
            var data = response.extend.transactions;
            if (data.length === 0){
                $(".order").empty();
                $(".order").append($("<div></div>").addClass("emptyOrder")
                    .append($("<h2>尚未售出商品！</h2>"))
                );
            } else {
                for (i in data) {
                    var acprice = data[i].acprice;
                    var amount = data[i].amount;
                    var color = data[i].color;
                    var createtime = new Date(parseInt(data[i].createtime)).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
                    var pic = data[i].pic;
                    var proid = data[i].proid;
                    var proname = data[i].product.proname;
                    var version = data[i].product.version;
                    var realname = data[i].buyer.realname;
                    var phonenum = data[i].buyer.phonenum;
                    var address = data[i].buyer.receiveadd;
                    if (proid === null) {
                        $(".order").append($("<div></div>").addClass("orderList").attr("proid", proid)
                            .append($("<h4>买家收货信息</h4>"))
                            .append($("<p></p>").text("收货人："+realname))
                            .append($("<p></p>").text("电话号码："+phonenum))
                            .append($("<p></p>").text("收货地址："+address))
                            .append($("<br>"))
                            .append($("<h4>订单商品信息</h4>"))
                            .append($("<br>"))
                            .append($("<h4>该商品已失效！</h4>"))
                        );
                    } else {
                        $(".order").append($("<div></div>").addClass("orderList").attr("proid", proid)
                            .append($("<h4>买家收货信息</h4>"))
                            .append($("<p></p>").text("收货人：" + realname))
                            .append($("<p></p>").text("电话号码：" + phonenum))
                            .append($("<p></p>").text("收货地址：" + address))
                            .append($("<br>"))
                            .append($("<h4>订单商品信息</h4>"))
                            .append($("<br>"))
                            .append($("<img>").attr("src", pic).attr("alt", proname))
                            .append($("<p></p>").text(proname + " " + version + " " + color))
                            .append($("<label><label/>").text(acprice + "元×" + amount))
                            .append($("<span><span/>").text(createtime))
                        );
                    }
                }
            }
        },error: function () {
        }
    });
}
// 评价信息管理
function toComment() {
    $(".list ul li a").css("color", "#666666");
    $(".list ul").children().last().children().css("color", "#337ab7");
    $(".person").css("display", "none");
    $(".addPerson").css("display", "none");
    $(".modifyPerson").css("display", "none");
    $(".Pro").css("display", "none");
    $(".addPro").css("display", "none");
    $(".modifyPro").css("display", "none");
    $(".order").css("display", "none");
    $(".modifyOrder").css("display", "none");
    $(".comment").css("display", "block");

    $(".modifyComment").css("display", "none");
}
// 获取评价信息
function getComment() {
    $.ajax({
        url: "http://localhost:8080/phstore_war_exploded/tranBySeller",
        data: {
            sellerid: sellerId
        },
        type: "GET",
        success: function (response) {
            var data = response.extend.transactions;
            if (data.length === 0){
                $(".comment").empty();
                $(".comment").append($("<div></div>").addClass("emptyOrder")
                    .append($("<h2>尚未售出商品！</h2>"))
                );
            } else {
                var pros = [];
                for (i in data) {
                    var acprice = data[i].acprice;
                    var color = data[i].color;
                    var pic = data[i].pic;
                    var proid = data[i].product.proId;
                    var buyerid = data[i].buyer.buyerid;
                    var proname = data[i].product.proname;
                    var version = data[i].product.version;
                    if (proid === null) {
                        $(".comment").append($("<div></div>").addClass("orderList comList")
                            .append($("<h4>该商品已失效！</h4>"))
                        );
                    } else {
                        if (pros.indexOf(proid) === -1) {
                            pros.push(proid);
                            $(".comment").append($("<div></div>").addClass("orderList comList").attr("buyerid", buyerid)
                                .append($("<img>").attr("src", pic).attr("alt", proname))
                                .append($("<p></p>").append($("<a></a>").text(proname + " " + version + " " + color)))
                                .append($("<label><label/>").text(acprice + "元"))
                            );
                        }
                    }
                }
                for (i in pros) {
                    $.ajax({
                        url: "http://localhost:8080/phstore_war_exploded/commentBySellerId",
                        data: {
                            sellerid: sellerId,
                            proid: pros[i]
                        },
                        type: "GET",
                        async: false,
                        success: function (response) {
                            var data = response.extend.comment;
                            if (data === null) {
                                $(".comment").find("div").eq(i)
                                    .append($("<p>买家尚未评价！</p>"));
                            } else {
                                var comminfo = data.comminfo;
                                var commid = data.commid;
                                if (data.apply === "") {
                                    $(".comment").find("div").eq(i)
                                        .append($("<a>修改</a>")
                                            .attr("onclick", "modifyComm(this)")
                                            .attr("proid", pros[i])
                                            .attr("comminfo", comminfo)
                                            .attr("commid", commid)
                                            .attr("class", "btn btn-shop btn-shop1 btn-comm"))
                                        .append($("<br>"))
                                        .append($("<h4>评价详情</h4>"))
                                        .append($("<span></span>").text("买家评价：" + comminfo));
                                } else {
                                    $(".comment").find("div").eq(i)
                                        .append($("<a>修改</a>")
                                            .attr("onclick", "modifyComm(this)")
                                            .attr("proid", pros[i])
                                            .attr("comminfo", comminfo)
                                            .attr("commid", commid)
                                            .attr("class", "btn btn-shop btn-shop1 btn-comm"))
                                        .append($("<br>"))
                                        .append($("<h4>评价详情</h4>"))
                                        .append($("<span></span>").text("买家评价：" + comminfo))
                                        .append($("<br>"))
                                        .append($("<span></span>").text("卖家回复：" + data.apply));
                                }
                            }
                        }, error: function () {
                        }
                    });
                }
            }
            $("#commentContent").focus(function () {
                if ($("#commentContent").val() === "写点感谢客户的话吧") {
                    $("#commentContent").val("");
                }
            });
            $("#commentContent").blur(function () {
                if ($("#commentContent").val() === "") {
                    $("#commentContent").val("写点感谢客户的话吧");
                }
            });
            $("#commentContent1").focus(function () {
                if ($("#commentContent1").val() === "写点感谢客户的话吧") {
                    $("#commentContent1").val("");
                }
            });
            $("#commentContent1").blur(function () {
                if ($("#commentContent1").val() === "") {
                    $("#commentContent1").val("写点感谢客户的话吧");
                }
            });
        }, error: function () {
        }
    });
}
// 修改评价页面
function modifyComm(obj) {
    $(".person").css("display", "none");
    $(".addPerson").css("display", "none");
    $(".modifyPerson").css("display", "none");
    $(".Pro").css("display", "none");
    $(".addPro").css("display", "none");
    $(".modifyPro").css("display", "none");
    $(".order").css("display", "none");
    $(".modifyOrder").css("display", "none");
    $(".comment").css("display", "none");

    $(".modifyComment").css("display", "block");
    $(".list ul li a").removeAttr("onclick");
    $(".user-menu li a").removeAttr("onclick");
    var proid = $(obj).attr("proid");
    var comminfo = $(obj).attr("comminfo");
    var commid = $(obj).attr("commid");
    var buyerid = $(obj).parent().attr("buyerid");
    var pic = $(obj).parent().children().first().attr("src");
    var proname = $(obj).parent().children().first().attr("alt");
    var name = $(obj).prev().prev().children().text();
    var acprice = $(obj).prev().text();
    $(".commentPro").empty();
    $(".commentPro").append($("<div></div>").addClass("addComm")
        .attr("proid", proid).attr("buyerid", buyerid).attr("comminfo", comminfo).attr("commid", commid)
        .append($("<img>").attr("src", pic).attr("alt", proname))
        .append($("<p></p>").text(name))
        .append($("<span><span/>").text(acprice))
    );
}
// 保存修改评价信息
function saveComm(obj) {
    var apply = $(obj).parent().prev().val();
    var proid = $(obj).parent().parent().prev().children().attr("proid");
    var buyerid = $(obj).parent().parent().prev().children().attr("buyerid");
    var commInfo = $(obj).parent().parent().prev().children().attr("comminfo");
    var commid = $(obj).parent().parent().prev().children().attr("commid");
    $.ajax({
        url: "http://localhost:8080/phstore_war_exploded/comment/"+commid,
        data: {
            buyerid: buyerid,
            sellerid: sellerId,
            comminfo: commInfo,
            apply: apply,
            commsts: 0,
            proid: proid
        },
        type: "PUT",
        success: function () {
            $(".comment").empty();
            $(".comment").append($("<h1>评价晒单</h1>"));
            getComment();
            cancelComm();
        }, error: function () {
        }
    });
}
// 取消修改评价
function cancelComm() {
    $(".person").css("display", "none");
    $(".modifyPerson").css("display", "none");
    $(".addPerson").css("display", "none");
    $(".Pro").css("display", "none");
    $(".addPro").css("display", "none");
    $(".modifyPro").css("display", "none");
    $(".order").css("display", "none");
    $(".modifyOrder").css("display", "none");
    $(".comment").css("display", "block");

    $(".modifyComment").css("display", "none");
    $(".list ul").children().first().children().attr("onclick", "toPerson()");
    $(".list ul").find("li").eq(1).children().attr("onclick", "toPro()");
    $(".list ul").find("li").eq(2).children().attr("onclick", "toOrder()");
    $(".list ul").children().last().children().attr("onclick", "toComment()");
    $(".user-menu").find("li").eq(0).children().attr("onclick", "toPerson()");
    $(".user-menu").find("li").eq(1).children().attr("onclick", "toPro()");
    $(".user-menu").find("li").eq(2).children().attr("onclick", "toOrder()");
    $(".user-menu").find("li").eq(3).children().attr("onclick", "toComment()");
    $(".user-menu").find("li").eq(4).children().attr("onclick", "quit();return false;");
}
// 登出
function quit() {
    window.location.href = "login.html";
    localStorage.removeItem("username");
}