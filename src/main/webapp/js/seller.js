var str,company,userid;
var sellerId = localStorage.getItem("sellerId");
var user=localStorage.getItem("username");
$(function () {
    var url = location.search;
    if (url.indexOf("?") !== -1) {
        str = decodeURI(url.substr(1).split("=")[1]);
    }
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
    if (sellerId === "") {
        addPer();
    } else {
        getPerson();
        getPro();
        getOrder();
        getComment();
    }
});
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
    $(".comment").css("display", "none");
    $(".addComment").css("display", "none");
    $(".modifyComment").css("display", "none");
    getPerson();
}
function getPerson() {
    $.ajax({
        url: "http://localhost:8080/phstore_war_exploded/seller/"+sellerId,
        data: {},
        type: "GET",
        success: function (response) {
            var data = response.extend.seller;
            userid = data.userid;
            company = data.company;
            $(".company").text(company);
        },error: function () {
        }
    });
}
function modifyPer() {
    $(".modifyPerson").css("display", "block");
    $(".addPerson").css("display", "none");
    disClick();
    $("#inputCompany").val($(".company").text());
}
function saveMod() {
    if ($("#inputCompany").val() === "") {
        alert("请填写完整信息");
    } else {
        $.ajax({
            url: "http://localhost:8080/phstore_war_exploded/seller/" + userid,
            data: {
                sellerid: sellerId,
                company: $("#inputCompany").val(),
                userid: userid
            },
            type: "PUT",
            success: function () {
                $(".company").text($("#inputCompany").val());
                cancelMod();
            }, error: function () {
            }
        });
    }
}
function cancelMod() {
    $(".person").css("display", "block");
    $(".modifyPerson").css("display", "none");
    $(".addPerson").css("display", "none");
    $(".Pro").css("display", "none");
    $(".addPro").css("display", "none");
    $(".modifyPro").css("display", "none");
    $(".order").css("display", "none");
    $(".comment").css("display", "none");
    $(".addComment").css("display", "none");
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
function addPer() {
    $(".addPerson").css("display", "block");
    $(".modifyPerson").css("display", "none");
    disClick();
}
function saveAdd() {
    if ($("#inCompany").val() === "") {
        alert("请填写完整信息");
    } else {
        $.ajax({
            url: "http://localhost:8080/phstore_war_exploded/sellerInsert",
            data: {
                company: $("#inCompany").val(),
                userid: Number(str)
            },
            type: "POST",
            success: function () {
                $(".company").text($("#inCompany").val());
                userid = Number(str);
                $.ajax({
                    url: "http://localhost:8080/phstore_war_exploded/sellerByUser/"+userid,
                    data: {},
                    type: "GET",
                    success: function (response) {
                        var data = response.extend.seller;
                        sellerId = data.sellerid;
                        localStorage.setItem("sellerId", sellerId);
                        cancelMod();
                    }, error: function () {
                    }
                });
            }, error: function () {
            }
        });
    }
}
function resetAdd() {
    $("#inCompany").val("");
}
function disClick() {
    $(".person").css("display", "none");
    $(".Pro").css("display", "none");
    $(".addPro").css("display", "none");
    $(".modifyPro").css("display", "none");
    $(".order").css("display", "none");
    $(".comment").css("display", "none");
    $(".addComment").css("display", "none");
    $(".modifyComment").css("display", "none");
    $(".list ul li a").removeAttr("onclick");
    $(".user-menu li a").removeAttr("onclick");
}
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
    $(".comment").css("display", "none");
    $(".addComment").css("display", "none");
    $(".modifyComment").css("display", "none");
    getPro();
}
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
                    $(".proList").append($("<div></div>").addClass("ProList").attr("proId", proId)
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
function addPro() {
    $(".person").css("display", "none");
    $(".addPerson").css("display", "none");
    $(".modifyPerson").css("display", "none");
    $(".Pro").css("display", "none");
    $(".addPro").css("display", "block");
    $(".modifyPro").css("display", "none");
    $(".order").css("display", "none");
    $(".comment").css("display", "none");
    $(".addComment").css("display", "none");
    $(".modifyComment").css("display", "none");
    $(".list ul li a").removeAttr("onclick");
    $(".user-menu li a").removeAttr("onclick");
}
function modifyPro(obj) {
    $(".person").css("display", "none");
    $(".addPerson").css("display", "none");
    $(".modifyPerson").css("display", "none");
    $(".Pro").css("display", "none");
    $(".addPro").css("display", "none");
    $(".modifyPro").css("display", "block");
    $(".order").css("display", "none");
    $(".comment").css("display", "none");
    $(".addComment").css("display", "none");
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
            getOrder();
            getComment();
        }, error: function () {

        }
    });
}
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
function cancelPro() {
    $(".person").css("display", "none");
    $(".modifyPerson").css("display", "none");
    $(".addPerson").css("display", "none");
    $(".Pro").css("display", "block");
    $(".addPro").css("display", "none");
    $(".modifyPro").css("display", "none");
    $(".order").css("display", "none");
    $(".comment").css("display", "none");
    $(".addComment").css("display", "none");
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
    $(".addComment").css("display", "none");
    $(".modifyComment").css("display", "none");
}
function getOrder() {
    $(".order").empty();
    $(".order").append($("<h1>订单信息</h1>"));
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
                    var tranid = data[i].tranid;
                    var acprice = data[i].acprice;
                    var amount = data[i].amount;
                    var color = data[i].color;
                    var createtime = new Date(parseInt(data[i].createtime)).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
                    var pic = data[i].pic;
                    var proid = data[i].product.proId;
                    var proname = data[i].product.proname;
                    var version = data[i].product.version;
                    var realname = data[i].buyer.realname;
                    var phonenum = data[i].buyer.phonenum;
                    var address = data[i].buyer.receiveadd;
                    if (proid === null) {
                        $(".order").append($("<div></div>").addClass("orderList")
                            .append($("<h4>买家收货信息</h4>"))
                            .append($("<p></p>").text("收货人："+realname))
                            .append($("<p></p>").text("电话号码："+phonenum))
                            .append($("<p></p>").text("收货地址："+address))
                            .append($("<br>"))
                            .append($("<h4>订单商品信息</h4>"))
                            .append($("<br>"))
                            .append($("<h3>该商品已失效！</h3>"))
                            .append($("<a>删除</a>")
                                .attr("onclick", "deleteOrder(this)")
                                .attr("tranid", tranid)
                                .attr("class", "btn btn-danger btn-shop1 btn-comm"))
                        );
                    } else {
                        $(".order").append($("<div></div>").addClass("orderList").attr("proid", proid)
                            .append($("<h4>买家收货信息</h4>"))
                            .append($("<p></p>").text("收货人："+realname))
                            .append($("<p></p>").text("电话号码："+phonenum))
                            .append($("<p></p>").text("收货地址："+address))
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
function deleteOrder(obj) {
    var tranid = $(obj).attr("tranid");
    $.ajax({
        url: "http://localhost:8080/phstore_war_exploded/transaction/" + tranid,
        data: {},
        type: "DELETE",
        success: function () {
            $(obj).parent().hide(1000, function () {
                $(obj).parent().remove();
            });
            if($(".order").children().length === 1){
                $(".order").empty();
                $(".order").append($("<div></div>").addClass("emptyOrder")
                    .append($("<h2>尚未售出商品！</h2>"))
                );
            }
        }, error: function () {

        }
    });
}
function getComment() {
    $(".comment").empty();
    $(".comment").append($("<h1>评价信息</h1>"));
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
                        $(".comment").append($("<div></div>").addClass("comList")
                            .append($("<h3>该商品已失效！</h3>"))
                        );
                    } else {
                        if (pros.indexOf(proid) === -1) {
                            pros.push(proid);
                            $(".comment").append($("<div></div>").addClass("comList")
                                .attr("buyerid", buyerid).attr("proid", proid)
                                .append($("<img>").attr("src", pic).attr("alt", proname))
                                .append($("<p></p>").text(proname + " " + version + " " + color))
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
                                $(".comList[proid='" + pros[i] + "']")
                                    .append($("<p>买家尚未评价！</p>"));
                            } else {
                                var comminfo = data.comminfo;
                                var commid = data.commid;
                                var apply = data.apply;
                                if (data.apply === "") {
                                    $(".comList[proid='" + pros[i] + "']")
                                        .append($("<a>回复</a>")
                                            .attr("onclick", "addComm(this)")
                                            .attr("proid", pros[i])
                                            .attr("comminfo", comminfo)
                                            .attr("commid", commid)
                                            .attr("class", "btn btn-shop btn-shop1 btn-comm"))
                                        .append($("<br>"))
                                        .append($("<h4>评价详情</h4>"))
                                        .append($("<span></span>").text("买家评价：" + comminfo));
                                } else {
                                    $(".comList[proid='" + pros[i] + "']")
                                        .append($("<br>"))
                                        .append($("<h4>评价详情</h4>"))
                                        .append($("<span></span>").text("买家评价：" + comminfo))
                                        .append($("<br>"))
                                        .append($("<span></span>").text("卖家回复：" + data.apply))
                                        .append($("<a>修改回复</a>")
                                            .attr("onclick", "modifyComm(this)")
                                            .attr("proid", pros[i])
                                            .attr("comminfo", comminfo)
                                            .attr("commid", commid)
                                            .attr("apply", apply)
                                            .attr("class", "btn btn-shop btn-shop1 btn-Pro"))
                                        .append($("<a>删除回复</a>")
                                            .attr("onclick", "deleteApply(this)")
                                            .attr("proid", pros[i])
                                            .attr("comminfo", comminfo)
                                            .attr("commid", commid)
                                            .attr("class", "btn btn-danger btn-shop1 btn-Pro"));
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
    $(".comment").css("display", "block");
    $(".addComment").css("display", "none");
    $(".modifyComment").css("display", "none");
}
function addComm(obj) {
    $(".person").css("display", "none");
    $(".addPerson").css("display", "none");
    $(".modifyPerson").css("display", "none");
    $(".Pro").css("display", "none");
    $(".addPro").css("display", "none");
    $(".modifyPro").css("display", "none");
    $(".order").css("display", "none");
    $(".comment").css("display", "none");
    $(".addComment").css("display", "block");
    $(".modifyComment").css("display", "none");
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
function deleteApply(obj) {
    var proid = $(obj).attr("proid");
    var buyerid = $(obj).parent().attr("buyerid");
    var commInfo = $(obj).attr("comminfo");
    var commid = $(obj).attr("commid");
    $.ajax({
        url: "http://localhost:8080/phstore_war_exploded/comment/"+commid,
        data: {
            buyerid: buyerid,
            sellerid: sellerId,
            comminfo: commInfo,
            apply: "",
            commsts: 0,
            proid: proid
        },
        type: "PUT",
        success: function () {
            getComment();
            cancelComm();
        }, error: function () {
        }
    });
}
function modifyComm(obj) {
    $(".person").css("display", "none");
    $(".addPerson").css("display", "none");
    $(".modifyPerson").css("display", "none");
    $(".Pro").css("display", "none");
    $(".addPro").css("display", "none");
    $(".modifyPro").css("display", "none");
    $(".order").css("display", "none");
    $(".comment").css("display", "none");
    $(".addComment").css("display", "none");
    $(".modifyComment").css("display", "block");
    $(".list ul li a").removeAttr("onclick");
    $(".user-menu li a").removeAttr("onclick");
    var proid = $(obj).attr("proid");
    var comminfo = $(obj).attr("comminfo");
    var commid = $(obj).attr("commid");
    var apply = $(obj).attr("apply");
    var buyerid = $(obj).parent().attr("buyerid");
    var pic = $(obj).parent().children().first().attr("src");
    var proname = $(obj).parent().children().first().attr("alt");
    var name = $(obj).parent().children().first().next().text();
    var acprice = $(obj).parent().children().first().next().next().text();
    $(".commentPro").empty();
    $(".commentPro").append($("<div></div>").addClass("addComm")
        .attr("proid", proid).attr("buyerid", buyerid)
        .attr("comminfo", comminfo).attr("commid", commid).attr("apply", apply)
        .append($("<img>").attr("src", pic).attr("alt", proname))
        .append($("<p></p>").text(name))
        .append($("<span><span/>").text(acprice))
    );
    if (apply === "") {
        $("#commentContent1").val("写点感谢客户的话吧");
    } else {
        $("#commentContent1").val(apply);
    }
}
function savemodifyComm(obj) {
    var proid = $(obj).parent().parent().prev().children().attr("proid");
    var buyerid = $(obj).parent().parent().prev().children().attr("buyerid");
    var commid = $(obj).parent().parent().prev().children().attr("commid");
    var sellerid = $(obj).parent().parent().prev().children().attr("sellerid");
    var comminfo = $(obj).parent().parent().prev().children().attr("comminfo");
    if ($("#commentContent1").val() === "" ||
        $("#commentContent1").val() === "写点感谢客户的话吧") {
        alert("请填写完整信息");
    } else {
        $.ajax({
            url: "http://localhost:8080/phstore_war_exploded/comment/" + commid,
            data: {
                buyerid: buyerid,
                sellerid: sellerid,
                comminfo: comminfo,
                apply: $("#commentContent1").val(),
                commsts: 0,
                proid: proid
            },
            type: "PUT",
            success: function () {
                getComment();
                cancelComm();
            }, error: function () {
            }
        });
    }
}
function saveComm(obj) {
    var apply = $(obj).parent().prev().val();
    var proid = $(obj).parent().parent().prev().children().attr("proid");
    var buyerid = $(obj).parent().parent().prev().children().attr("buyerid");
    var commInfo = $(obj).parent().parent().prev().children().attr("comminfo");
    var commid = $(obj).parent().parent().prev().children().attr("commid");
    if ($("#commentContent").val() === "" ||
        $("#commentContent").val() === "外形如何，品质如何，好用吗，写点您真实的使用感受吧") {
        alert("请填写完整信息");
    } else {
        $.ajax({
            url: "http://localhost:8080/phstore_war_exploded/comment/" + commid,
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
                getComment();
                cancelComm();
            }, error: function () {
            }
        });
    }
}
function cancelComm() {
    $(".person").css("display", "none");
    $(".modifyPerson").css("display", "none");
    $(".addPerson").css("display", "none");
    $(".Pro").css("display", "none");
    $(".addPro").css("display", "none");
    $(".modifyPro").css("display", "none");
    $(".order").css("display", "none");
    $(".comment").css("display", "block");
    $(".addComment").css("display", "none");
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
function quit() {
    window.location.href = "login.html";
    localStorage.removeItem("username");
    localStorage.removeItem("sellerId");
}