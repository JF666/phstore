var buyerId=localStorage.getItem("buyerId");
var cartTotalNum = 0; // 总数量
var selTotalNum = 0; // 选择数量
var cartTotalPrice = 0; // 合计
var TotalPrice = 0; // 总价
var goods = [];
var record = [];
var record1 = [];
$(function() {
    $(".cartHead .col-check .icon-checkbox").attr("CheckOrNot", "0");
    $("#cartTotalPrice").text(cartTotalPrice);
    $(".btn-sum").attr("disabled", true);
    $.ajax({
        url: "http://localhost:8080/phstore_war_exploded/shopcartBuyer/"+buyerId,
        data: {},
        type: "GET",
        success: function (response) {
            data = response.extend.shopcarts;
            if (data.length === 0){
                $(".table_r").empty();
                $(".table_btn").empty();
                $(".table_r").append($("<h2>您的购物车还是空的！</h2>"))
                    .append($("<a></a>").text("马上去购物").attr("href", "index.html").attr("class", "btn btn-shop"));
            } else {
                $(".cartList").empty();
                for (i in data) {
                    var shopcartId = data[i].shopcartid;
                    var product = data[i].product;
                    if (product === null) {
                        $(".cartList").append($("<div></div>").addClass("shopProList")
                            .append($("<div></div>").addClass("col col-name")
                                .append($("<span></span>").attr("shopcartId", shopcartId).text("该商品已失效！")))
                            .append($("<div></div>").addClass("col col-action")
                                .append($("<a></a>").attr("onclick", "removeDis(this)")
                                    .append($("<span></span>").addClass("glyphicon glyphicon-remove"))
                                )
                            )
                        );
                    } else {
                        var proId = data[i].product.proId;
                        var sellerId = data[i].product.sellerid;
                        var proname = data[i].product.proname;
                        var version = data[i].product.version;
                        var color = data[i].color;
                        var pic = data[i].pic;
                        var price = data[i].acprice;
                        var amount = data[i].amount;
                        cartTotalNum += amount;
                        var total = price*amount;
                        TotalPrice += total;
                        $(".cartList").append($("<div></div>").addClass("shopProList")
                            .append($("<div></div>").addClass("col col-check")
                                .append($("<span></span>").attr("shopcartId", shopcartId)
                                    .attr("sellerId", sellerId)
                                    .addClass("iconfont icon-checkbox")
                                    .attr("onclick", "checkRow(this)").attr("CheckOrNot", "0")))
                            .append($("<div></div>").addClass("col col-img")
                                .append($("<img>").attr("src", pic).attr("alt", proname)))
                            .append($("<div></div>").addClass("col col-name").text(proname + " " + version + " " + color))
                            .append($("<div></div>").addClass("col col-price").text(price + "元"))
                            .append($("<div></div>").addClass("col col-num").attr("proId", proId).attr("color", color)
                                .append($("<span></span>").addClass("glyphicon glyphicon-minus").attr("onclick", "minus(this)"))
                                .append($("<input autocomplete='off'>").addClass("goodsNum").attr("value", amount))
                                .append($("<span></span>").addClass("glyphicon glyphicon-plus").attr("onclick", "plus(this)"))
                            )
                            .append($("<div></div>").addClass("col col-total").text(total + "元"))
                            .append($("<div></div>").addClass("col col-action")
                                .append($("<a></a>").attr("onclick", "remove(this)")
                                    .append($("<span></span>").addClass("glyphicon glyphicon-remove"))
                                )
                            )
                        );
                    }
                }
                $("#cartTotalNum").text(cartTotalNum);
                $(".goodsNum").focus(function () {
                    cartTotalNum -= Number($(this).val());
                    var acp = $(this).parent().prev().text();
                    acp = acp.substring(0,acp.indexOf("元"));
                    TotalPrice -= Number($(this).val())*Number(acp);
                    var CheckOrNot = $(this).parent().parent().children().first().children().attr("CheckOrNot");
                    if (CheckOrNot === "1") {
                        selTotalNum -= Number($(this).val());
                        cartTotalPrice -= Number($(this).val())*Number(acp);
                    }
                });
                $(".goodsNum").blur(function () {
                    var reg =  /^[1-9]\d*$/;
                    var goodsNum = $(this).val();
                    if (!(reg.test(goodsNum))) {
                        alert("只能输入正整数");
                        $(this).val("");
                    } else if (reg.test(goodsNum)) {
                        if (Number(goodsNum)>10) {
                            alert("限购数量为10");
                            $(this).val("");
                        } else{
                            var num = Number($(this).val())
                            cartTotalNum += num;
                            var acp = $(this).parent().prev().text();
                            acp = Number(acp.substring(0,acp.indexOf("元")));
                            TotalPrice += num*acp;
                            $(this).parent().next().text(num*acp+"元");
                            $("#cartTotalNum").text(cartTotalNum);
                            var CheckOrNot = $(this).parent().parent().children().first().children().attr("CheckOrNot");
                            var proId1 = $(this).parent().attr("proId");
                            var color1 = $(this).parent().attr("color");
                            $.ajax({
                                url: "http://localhost:8080/phstore_war_exploded/updateAmount",
                                type: "PUT",
                                data: {
                                    buyerId: buyerId,
                                    proId: proId1,
                                    color: color1,
                                    amount: num
                                },
                                success: function () {
                                }, error: function () {
                                }
                            });
                            if (CheckOrNot === "1") {
                                selTotalNum += num;
                                cartTotalPrice += num*acp;
                                $("#cartTotalPrice").text(cartTotalPrice);
                                $("#selTotalNum").text(selTotalNum);
                                if (record.indexOf(Number(this.parentNode.getAttribute("proId"))) !== -1 && record1.indexOf(this.parentNode.getAttribute("color")) !== -1) {
                                    var index = record.indexOf(Number(this.parentNode.getAttribute("proId")));
                                    goods[index].amount = num;
                                }
                            }
                        }
                    }
                });
            }
        },error: function () {
        }
    })
});
function allCheckOrNot(obj) {
    var list = document.getElementsByClassName("cartList");
    if (obj.getAttribute("CheckOrNot") === "0") {
        $(".btn-sum").attr("disabled", false);
        for (var i = 0; i < list[0].childNodes.length; i++) {
            var shopcartId = Number(list[0].childNodes[i].childNodes[0].childNodes[0].getAttribute("shopcartId"));
            var sellerId = Number(list[0].childNodes[i].childNodes[0].childNodes[0].getAttribute("sellerId"));
            var proId = Number(list[0].childNodes[i].childNodes[4].getAttribute("proId"));
            var amount = Number(list[0].childNodes[i].childNodes[4].childNodes[1].value);
            var mytime = new Date().getTime().toString();
            var price = list[0].childNodes[i].childNodes[3].innerHTML;
            var acprice = Number(price.substring(0,price.indexOf("元")));
            var color = list[0].childNodes[i].childNodes[4].getAttribute("color");
            var pic = list[0].childNodes[i].childNodes[1].childNodes[0].src;
            var good = {
                "shopcartId": shopcartId,
                "buyerId": Number(buyerId),
                "sellerId": sellerId,
                "proId": proId,
                "amount": amount,
                "tranSts": 0,
                "createTime": mytime,
                "acprice": acprice,
                "color": color,
                "pic": pic
            };
            goods.push(good);
            record.push(good.proId);
            record1.push(good.color);
        }
        selTotalNum = cartTotalNum;
        cartTotalPrice = TotalPrice;
        $("#cartTotalPrice").text(cartTotalPrice);
        $(".col-check").children().removeClass("iconfont icon-checkbox").addClass("iconfont icon-duoxuanzhijiao");
        $("#selTotalNum").text(selTotalNum);
        $(".col-check").children().attr("CheckOrNot", "1");
    } else {
        $(".btn-sum").attr("disabled", true);
        goods = [];
        record = [];
        record1 = [];
        selTotalNum = 0;
        cartTotalPrice = 0;
        $("#cartTotalPrice").text(cartTotalPrice);
        $(".col-check").children().removeClass("iconfont icon-duoxuanzhijiao").addClass("iconfont icon-checkbox");
        $("#selTotalNum").text(selTotalNum);
        $(".col-check").children().attr("CheckOrNot", "0");
    }
}
function checkRow(obj) {
    var total = obj.parentNode.parentNode.childNodes[5].innerHTML;
    var acprice = obj.parentNode.parentNode.childNodes[3].innerHTML;
    var mytime = new Date().getTime();
    var good = {
        "shopcartId": Number(obj.getAttribute("shopcartId")),
        "buyerId": Number(buyerId),
        "sellerId": Number(obj.getAttribute("sellerId")),
        "proId": Number(obj.parentNode.parentNode.childNodes[4].getAttribute("proId")),
        "amount": Number(obj.parentNode.parentNode.childNodes[4].childNodes[1].value),
        "tranSts": 0,
        "createTime": mytime.toString(),
        "acprice": Number(acprice.substring(0,acprice.indexOf("元"))),
        "color": obj.parentNode.parentNode.childNodes[4].getAttribute("color"),
        "pic": obj.parentNode.parentNode.childNodes[1].childNodes[0].src
    };
    if (obj.getAttribute("CheckOrNot") === "0") {
        $(".btn-sum").attr("disabled", false);
        goods.push(good);
        record.push(good.proId);
        record1.push(good.color);
        selTotalNum += Number(obj.parentNode.parentNode.childNodes[4].childNodes[1].value);
        cartTotalPrice += Number(total.substring(0,total.indexOf("元")));
        $("#cartTotalPrice").text(cartTotalPrice);
        if (selTotalNum === cartTotalNum) {
            $(".cartHead .col-check").children().attr("CheckOrNot", "1");
            $(".cartHead .col-check").children().removeClass("iconfont icon-checkbox").addClass("iconfont icon-duoxuanzhijiao");;
        }
        obj.setAttribute("class", "iconfont icon-duoxuanzhijiao");
        $("#selTotalNum").text(selTotalNum);
        obj.setAttribute("CheckOrNot", "1");
    } else {
        if (record.indexOf(good.proId) !== -1 && record1.indexOf(good.color) !== -1) {
            var index = record.indexOf(good.proId);
            goods.splice(index, 1);
            record.splice(index, 1);
            record1.splice(index, 1);
        }
        selTotalNum -= Number(obj.parentNode.parentNode.childNodes[4].childNodes[1].value);
        cartTotalPrice -= Number(total.substring(0,total.indexOf("元")));
        $("#cartTotalPrice").text(cartTotalPrice);
        if (selTotalNum < cartTotalNum) {
            $(".cartHead .col-check").children().attr("CheckOrNot", "0");
            $(".cartHead .col-check").children().removeClass("iconfont icon-duoxuanzhijiao").addClass("iconfont icon-checkbox");;
        }
        if (selTotalNum === 0) {
            $(".btn-sum").attr("disabled", true);
        }
        obj.setAttribute("class", "iconfont icon-checkbox");
        $("#selTotalNum").text(selTotalNum);
        obj.setAttribute("CheckOrNot", "0");
    }
}
function remove(obj) {
    var CheckOrNot = $(obj).parent().parent().children().first().children().attr("CheckOrNot");
    var proId = Number($(obj).parent().prev().prev().attr("proid"));
    var color = $(obj).parent().prev().prev().attr("color");
    var total = $(obj).parent().prev().text();
    if (CheckOrNot === "1") {
        console.log(record.indexOf(proId));
        if (record.indexOf(proId) !== -1 && record1.indexOf(color) !== -1) {
            var index = record.indexOf(proId);
            goods.splice(index, 1);
            record.splice(index, 1);
            record1.splice(index, 1);
        }
        cartTotalNum -= Number($(obj).parent().prev().prev().find("input").eq(0).val());
        selTotalNum -= Number($(obj).parent().prev().prev().find("input").eq(0).val());
        cartTotalPrice -= Number(total.substring(0,total.indexOf("元")));
        TotalPrice -= Number(total.substring(0,total.indexOf("元")));
        $("#cartTotalNum").text(cartTotalNum);
        $("#selTotalNum").text(selTotalNum);
        $("#cartTotalPrice").text(cartTotalPrice);
        if (selTotalNum < cartTotalNum) {
            $(".cartHead .col-check").children().attr("CheckOrNot", "0");
            $(".cartHead .col-check").children().removeClass("iconfont icon-duoxuanzhijiao").addClass("iconfont icon-checkbox");;
        }
        if (selTotalNum === 0) {
            $(".btn-sum").attr("disabled", true);
        }
    }
    var shopCartId = Number(obj.parentNode.parentNode.childNodes[0].childNodes[0].getAttribute("shopcartId"));
    $.ajax({
        url: "http://localhost:8080/phstore_war_exploded/shopcart/" + shopCartId,
        data: {},
        type: "DELETE",
        success: function () {
            $(obj).parent().parent().hide(1000, function () {
                $(obj).parent().parent().remove();
            });
            if($(".cartList").children().length === 1){
                $(".table_r").empty();
                $(".table_btn").empty();
                $(".table_r").append($("<h2>您的购物车还是空的！</h2>"))
                    .append($("<a></a>").text("马上去购物").attr("href", "index.html").attr("class", "btn btn-shop"));
            }
        }, error: function () {
        }
    });
}
function removeDis(obj) {
    var shopCartId = Number(obj.parentNode.parentNode.childNodes[0].childNodes[0].getAttribute("shopcartId"));
    $.ajax({
        url: "http://localhost:8080/phstore_war_exploded/shopcart/" + shopCartId,
        data: {},
        type: "DELETE",
        success: function () {
            $(obj).parent().parent().hide(1000, function () {
                $(obj).parent().parent().remove();
            });
            if($(".cartList").children().length === 1){
                $(".table_r").empty();
                $(".table_btn").empty();
                $(".table_r").append($("<h2>您的购物车还是空的！</h2>"))
                    .append($("<a></a>").text("马上去购物").attr("href", "index.html").attr("class", "btn btn-shop"));
            }
        }, error: function () {
        }
    });
}
function minus(obj) {
    var old = Number($(obj).next().val());
    if (old>1) {
        old--;
    } else {
        alert("至少购买1件");
        return;
    }
    cartTotalNum --;
    var price = $(obj).parent().prev().text();
    price = Number(price.substring(0,price.indexOf("元")));
    TotalPrice -= price;
    var CheckOrNot = $(obj).parent().parent().children().first().children().attr("CheckOrNot");
    if (CheckOrNot === "1") {
        selTotalNum--;
        cartTotalPrice -= price;
        $("#cartTotalPrice").text(cartTotalPrice);
        $("#selTotalNum").text(selTotalNum);
        if (record.indexOf(Number(obj.parentNode.getAttribute("proId"))) !== -1 && record1.indexOf(obj.parentNode.getAttribute("color")) !== -1) {
            var index = record.indexOf(Number(obj.parentNode.getAttribute("proId")));
            goods[index].amount--;
        }
    }
    var total = price*old;
    $(obj).next().val(old);
    $(obj).parent().next().text(total+"元");
    $("#cartTotalNum").text(cartTotalNum);
    $.ajax({
        url: "http://localhost:8080/phstore_war_exploded/updateAmount",
        type: "PUT",
        data: {
            buyerId: buyerId,
            proId: obj.parentNode.getAttribute("proId"),
            color: obj.parentNode.getAttribute("color"),
            amount: old
        },
        success: function () {
        }, error: function () {
        }
    });
}
function plus(obj) {
    var old = Number($(obj).prev().val());
    if (old<10) {
        old++;
    } else {
        alert("限制购买数量为10");
        return;
    }
    cartTotalNum ++;
    var price = $(obj).parent().prev().text();
    price = Number(price.substring(0,price.indexOf("元")));
    TotalPrice += price;
    var CheckOrNot = $(obj).parent().parent().children().first().children().attr("CheckOrNot");
    if (CheckOrNot === "1") {
        selTotalNum++;
        cartTotalPrice += price;
        $("#cartTotalPrice").text(cartTotalPrice);
        $("#selTotalNum").text(selTotalNum);
        if (record.indexOf(Number(obj.parentNode.getAttribute("proId"))) !== -1 && record1.indexOf(obj.parentNode.getAttribute("color")) !== -1) {
            var index = record.indexOf(Number(obj.parentNode.getAttribute("proId")));
            goods[index].amount++;
        }
    }
    var total = price*old;
    $(obj).prev().val(old);
    $(obj).parent().next().text(total+"元");
    $("#cartTotalNum").text(cartTotalNum);
    $.ajax({
        url: "http://localhost:8080/phstore_war_exploded/updateAmount",
        type: "PUT",
        data: {
            buyerId: buyerId,
            proId: obj.parentNode.getAttribute("proId"),
            color: obj.parentNode.getAttribute("color"),
            amount: old
        },
        success: function () {
        }, error: function () {
        }
    });
}
function sum() {
    var mytime = new Date().getTime().toString();
    var shopcartIds = "";
    for (i in goods) {
        goods[i].createTime = mytime;
        shopcartIds += goods[i].shopcartId+",";
        $.ajax({
            url: "http://localhost:8080/phstore_war_exploded/transactionInsert",
            type: "POST",
            data: {
                buyerid: goods[i].buyerId,
                sellerid: goods[i].sellerId,
                proid: goods[i].proId,
                amount: goods[i].amount,
                transts: goods[i].tranSts,
                createtime: goods[i].createTime,
                acprice: goods[i].acprice,
                color: goods[i].color,
                pic: goods[i].pic
            },
            success: function () {
            }, error: function () {
            }
        });
    }
    shopcartIds = shopcartIds.substring(0, shopcartIds.length-1);
    localStorage.setItem("shopcartIds", shopcartIds);
    location.href="order.html?mytime="+mytime;
}