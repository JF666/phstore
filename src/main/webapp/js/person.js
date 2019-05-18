var str,nickname,phonenum,realname,receiveadd,userid;
var buyerId = localStorage.getItem("buyerId");
$(function () {
    var url = location.search;
    if (url.indexOf("?") !== -1) {
        str = decodeURI(url.substr(1).split("=")[1]);
    }
    if (buyerId === "") {
        addPer();
    } else {
        getPerson();
        getOrder();
        getComment();
        if (str === "1") {
            toPerson();
        } else if (str === "2") {
            toOrder();
        } else if (str === "3") {
            toComment();
        }
    }
});
function toPerson() {
    $(".list ul li a").css("color", "#666666");
    $(".list ul").children().first().children().css("color", "#337ab7");
    $(".person").css("display", "block");
    $(".modifyPerson").css("display", "none");
    $(".addPerson").css("display", "none");
    $(".order").css("display", "none");
    $(".comment").css("display", "none");
    $(".addComment").css("display", "none");
    getPerson();
}
function getPerson() {
    $.ajax({
        url: "http://localhost:8080/phstore_war_exploded/buyer/"+buyerId,
        data: {},
        type: "GET",
        success: function (response) {
            var data = response.extend.buyer;
            userid = data.userid;
            nickname = data.nickname;
            phonenum = data.phonenum;
            realname = data.realname;
            receiveadd = data.receiveadd;
            $(".nickname").text(nickname);
            $(".phonenum").text(phonenum);
            $(".realname").text(realname);
            $(".receiveadd").text(receiveadd);
        },error: function () {
        }
    });
}
function modifyPer() {
    $(".modifyPerson").css("display", "block");
    $(".addPerson").css("display", "none");
    disClick();
    $("#inputnick").val($(".nickname").text());
    $("#inputphone").val($(".phonenum").text());
    $("#inputname").val($(".realname").text());
    $("#inputadd").val($(".receiveadd").text());
}
function saveMod() {
    $.ajax({
        url:"http://localhost:8080/phstore_war_exploded/buyer/"+userid,
        data: {
            buyerid: buyerId,
            userid: userid,
            nickname: $("#inputnick").val(),
            balance: "9999",
            receiveadd: $("#inputadd").val(),
            phonenum: $("#inputphone").val(),
            realname: $("#inputname").val()
        },
        type:"PUT",
        success:function () {
            $(".nickname").text($("#inputnick").val());
            $(".phonenum").text($("#inputphone").val());
            $(".realname").text($("#inputname").val());
            $(".receiveadd").text($("#inputadd").val());
            cancelMod();
        }, error:function () {
        }
    });
}
function cancelMod() {
    $(".person").css("display", "block");
    $(".modifyPerson").css("display", "none");
    $(".addPerson").css("display", "none");
    $(".order").css("display", "none");
    $(".comment").css("display", "none");
    $(".addComment").css("display", "none");
    $(".list ul").children().first().children().attr("onclick", "toPerson()");
    $(".list ul").find("li").eq(1).children().attr("onclick", "toOrder()");
    $(".list ul").children().last().children().attr("onclick", "toComment()");
    $(".user-menu").find("li").eq(0).children().attr("onclick", "toPerson()");
    $(".user-menu").find("li").eq(1).children().attr("onclick", "toOrder()");
    $(".user-menu").find("li").eq(2).children().attr("onclick", "toComment()");
    $(".user-menu").find("li").eq(3).children().attr("onclick", "quit();return false;");
    $(".logo a").attr("href", "index.html");
    $(".topbar-cart a").attr("onclick", "cart();return false;");
}
function addPer() {
    $(".addPerson").css("display", "block");
    $(".modifyPerson").css("display", "none");
    disClick();
}
function saveAdd() {
    if ($("#innick").val() === "" || $("#inadd").val() === "" || $("#inphone").val() === "" ||$("#inname").val() === "") {
        alert("请填写完整信息");
    } else {
        $.ajax({
            url: "http://localhost:8080/phstore_war_exploded/buyerInsert",
            data: {
                userid: Number(str),
                nickname: $("#innick").val(),
                balance: "9999",
                receiveadd: $("#inadd").val(),
                phonenum: $("#inphone").val(),
                realname: $("#inname").val()
            },
            type: "POST",
            success: function () {
                $(".nickname").text($("#innick").val());
                $(".phonenum").text($("#inphone").val());
                $(".realname").text($("#inname").val());
                $(".receiveadd").text($("#inadd").val());
                userid = Number(str);
                $.ajax({
                    url: "http://localhost:8080/phstore_war_exploded/buyerById/"+userid,
                    data: {},
                    type: "GET",
                    success: function (response) {
                        var data = response.extend.buyer;
                        buyerId = data.buyerid;
                        localStorage.setItem("buyerId", buyerId);
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
    $("#innick").val("");
    $("#inname").val("");
    $("#inphone").val("");
    $("#inadd").val("");
}
function disClick() {
    $(".person").css("display", "none");
    $(".order").css("display", "none");
    $(".comment").css("display", "none");
    $(".addComment").css("display", "none");
    $(".list ul li a").removeAttr("onclick");
    $(".user-menu li a").removeAttr("onclick");
    $(".logo a").removeAttr("href");
    $(".topbar-cart a").removeAttr("onclick");
}
function toOrder() {
    $(".list ul li a").css("color", "#666666");
    $(".list ul").find("li").eq(1).children().css("color", "#337ab7");
    $(".person").css("display", "none");
    $(".addPerson").css("display", "none");
    $(".modifyPerson").css("display", "none");
    $(".order").css("display", "block");
    $(".comment").css("display", "none");
    $(".addComment").css("display", "none");
}
function getOrder() {
    $.ajax({
        url: "http://localhost:8080/phstore_war_exploded/tranByBuyer",
        data: {
            buyerid: buyerId
        },
        type: "GET",
        success: function (response) {
            var data = response.extend.transactions;
            if (data.length === 0){
                $(".order").empty();
                $(".order").append($("<div></div>").addClass("emptyOrder")
                    .append($("<h2>尚未购买商品！</h2>"))
                    .append($("<a></a>").text("马上去购物").attr("href", "index.html").attr("class", "btn btn-shop btn-shop1")));
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
                    $(".order").append($("<div></div>").addClass("orderList").attr("proid", proid)
                        .append($("<img>").attr("src", pic).attr("alt", proname))
                        .append($("<p></p>").append($("<a></a>")
                            .text(proname + " " + version + " " + color)
                            .attr("href", "detail.html?name=" + proname)))
                        .append($("<label><label/>").text(acprice + "元×" + amount))
                        .append($("<span><span/>").text(createtime))
                    );
                }
            }
        },error: function () {
        }
    });
}
function getComment() {
    $.ajax({
        url: "http://localhost:8080/phstore_war_exploded/tranByBuyer",
        data: {
            buyerid: buyerId
        },
        type: "GET",
        success: function (response) {
            var data = response.extend.transactions;
            if (data.length === 0){
                $(".comment").empty();
                $(".comment").append($("<div></div>").addClass("emptyOrder")
                    .append($("<h2>尚未购买商品！</h2>"))
                    .append($("<a></a>").text("马上去购物").attr("href", "index.html").attr("class", "btn btn-shop btn-shop1")));
            } else {
                var pros = [];
                for (i in data) {
                    var acprice = data[i].acprice;
                    var color = data[i].color;
                    var pic = data[i].pic;
                    var proid = data[i].product.proId;
                    var sellerid = data[i].sellerid;
                    var proname = data[i].product.proname;
                    var version = data[i].product.version;
                    if (pros.indexOf(proid) === -1) {
                        pros.push(proid);
                        $(".comment").append($("<div></div>").addClass("orderList comList").attr("sellerid", sellerid)
                            .append($("<img>").attr("src", pic).attr("alt", proname))
                            .append($("<p></p>").append($("<a></a>")
                                .text(proname + " " + version + " " + color)
                                .attr("href", "detail.html?name=" + proname)))
                            .append($("<label><label/>").text(acprice + "元"))
                        );
                    }
                }
                for (i in pros) {
                    $.ajax({
                        url: "http://localhost:8080/phstore_war_exploded/commentByBuyerId",
                        data: {
                            proid: pros[i],
                            buyerid: buyerId
                        },
                        type: "GET",
                        async: false,
                        success: function (response) {
                            var data = response.extend.comment;
                            if (data === null) {
                                $(".comment").find("div").eq(i).append($("<a>评价</a>")
                                    .attr("onclick", "addComm(this)")
                                    .attr("proid", pros[i])
                                    .attr("class", "btn btn-shop btn-shop1 btn-comm"));
                            } else {
                                if (data.apply === "") {
                                    $(".comment").find("div").eq(i)
                                        .append($("<br>"))
                                        .append($("<h4>评价详情</h4>"))
                                        .append($("<span></span>").text("买家评价："+data.comminfo));
                                } else {
                                    $(".comment").find("div").eq(i)
                                        .append($("<br>"))
                                        .append($("<h4>评价详情</h4>"))
                                        .append($("<span></span>").text("买家评价："+data.comminfo))
                                        .append($("<br>"))
                                        .append($("<span></span>").text("卖家回复："+data.apply));
                                }
                            }
                        }, error: function () {
                        }
                    });
                }
            }
            $("#commentContent").focus(function () {
                if ($("#commentContent").val() === "外形如何，品质如何，好用吗，写点您真实的使用感受吧") {
                    $("#commentContent").val("");
                }
            });
            $("#commentContent").blur(function () {
                if ($("#commentContent").val() === "") {
                    $("#commentContent").val("外形如何，品质如何，好用吗，写点您真实的使用感受吧");
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
    $(".order").css("display", "none");
    $(".comment").css("display", "block");
    $(".addComment").css("display", "none");
}
function addComm(obj) {
    $(".person").css("display", "none");
    $(".addPerson").css("display", "none");
    $(".modifyPerson").css("display", "none");
    $(".order").css("display", "none");
    $(".comment").css("display", "none");
    $(".addComment").css("display", "block");
    $(".list ul li a").removeAttr("onclick");
    $(".user-menu li a").removeAttr("onclick");
    $(".logo a").removeAttr("href");
    $(".topbar-cart a").removeAttr("onclick");
    var proid = $(obj).attr("proid");
    var sellerid = $(obj).parent().attr("sellerid");
    var pic = $(obj).parent().children().first().attr("src");
    var proname = $(obj).parent().children().first().attr("alt");
    var name = $(obj).prev().prev().children().text();
    var acprice = $(obj).prev().text();
    $(".commentPro").empty();
    $(".commentPro").append($("<div></div>").addClass("addComm")
        .attr("proid", proid).attr("sellerid", sellerid)
        .append($("<img>").attr("src", pic).attr("alt", proname))
        .append($("<p></p>").text(name))
        .append($("<span><span/>").text(acprice))
    );
}
function saveComm(obj) {
    var commInfo = $(obj).parent().prev().val();
    var proid = $(obj).parent().parent().prev().children().attr("proid");
    var sellerid = $(obj).parent().parent().prev().children().attr("sellerid");
    $.ajax({
        url: "http://localhost:8080/phstore_war_exploded/commentInsert",
        data: {
            buyerid: buyerId,
            sellerid: sellerid,
            comminfo: commInfo,
            apply: "",
            commsts: 0,
            proid: proid
        },
        type: "POST",
        success: function () {
            $(".comment").empty();
            $(".comment").append($("<h1>评价晒单</h1>"));
            getComment();
            cancelComm();
        }, error: function () {
        }
    });
}
function cancelComm() {
    $(".person").css("display", "none");
    $(".modifyPerson").css("display", "none");
    $(".addPerson").css("display", "none");
    $(".order").css("display", "none");
    $(".comment").css("display", "block");
    $(".addComment").css("display", "none");
    $(".list ul").children().first().children().attr("onclick", "toPerson()");
    $(".list ul").find("li").eq(1).children().attr("onclick", "toOrder()");
    $(".list ul").children().last().children().attr("onclick", "toComment()");
    $(".user-menu").find("li").eq(0).children().attr("onclick", "toPerson()");
    $(".user-menu").find("li").eq(1).children().attr("onclick", "toOrder()");
    $(".user-menu").find("li").eq(2).children().attr("onclick", "toComment()");
    $(".user-menu").find("li").eq(3).children().attr("onclick", "quit();return false;");
    $(".logo a").attr("href", "index.html");
    $(".topbar-cart a").attr("onclick", "cart();return false;");
}