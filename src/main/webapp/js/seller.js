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
    $.ajax({
        url:"http://localhost:8080/phstore_war_exploded/seller/"+userid,
        data: {
            sellerid: sellerId,
            company: $("#inputCompany").val(),
            userid: userid
        },
        type:"PUT",
        success:function () {
            $(".company").text($("#inputCompany").val());
            cancelMod();
        }, error:function () {
        }
    });
}
function cancelMod() {
    $(".person").css("display", "block");
    $(".modifyPerson").css("display", "none");
    $(".addPerson").css("display", "none");
    $(".Pro").css("display", "none");
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
                for (i in data) {
                    /**
                     *  "color": "全息幻彩蓝*深空灰*全息幻彩紫",
                     "discount": 0,
                     "pic": "https://i8.mifile.cn/a1/pms_1550642240.48638886.jpg-https://i8.mifile.cn/a1/pms_1550642238.19945420.jpg-https://i8.mifile.cn/a1/pms_1550642242.36585125.jpg*https://i1.mifile.cn/f/i/2019/mi9/index/index2.jpg?v=1*https://i1.mifile.cn/f/i/2019/mi9/index/storage.jpg*https://i1.mifile.cn/f/i/2019/mi9/index/play.jpg*https://i1.mifile.cn/f/i/2019/mi9/index/noline.png?v=2*https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/bb4348b89916bd399f63a543d6a63630.mp4*https://i1.mifile.cn/f/i/2019/mi9/index/cameraFunc.png?v=2*https://i1.mifile.cn/f/i/2019/mi9/index/full1.png?v=1*https://i1.mifile.cn/f/i/2019/mi9/index/blue.jpg?v=1*https://i1.mifile.cn/f/i/2019/mi9/index/finger.jpg",
                     "price": "2999",
                     "proId": 1,
                     "proIntro": "骁龙855，索尼4800万超广角微距三摄-全息幻彩全曲面玻璃机身 / 骁龙855旗舰处理器 / 索尼4800万超广角微距三摄 / 20W无线闪充 / 第5代极速屏下指纹解锁-小米9 战斗天使*好看又能打-快！骁龙855 处理器*游戏快 20%，运算快 45%，3 倍 AI 性能*高通骁龙 800 系史上最大升级-模拟使用 18 个月 降低卡顿 35%*游戏显示增强 游戏触控模式-全球首款 20W 无线闪充*提速 37%，充电超级快！-全焦段 AI 三摄*不止多了广角镜头的广阔视野*还有微距拍摄的独特视角-2000 万美颜自拍，前置 AI 背景虚化-6.39"三星 AMOLED 水滴全面屏*90.7% 高屏占比，3.6mm 超窄下巴-硬实力之美*康宁第六代大猩猩玻璃*243mm2 一整块蓝宝石玻璃镜片-第五代屏幕指纹解锁，提速25%*解锁超灵敏，全方位解决解锁难题",
                     "proname": "小米9",
                     "sellerid": 1,
                     "stock": 9999,
                     "version": "全网通版 6GB+128GB"
                     */
                    var color = data[i].color;
                    var discount = data[i].discount;
                    var pic = data[i].pic;
                    var price = data[i].price;
                    var proId = data[i].proId;
                    var proIntro = data[i].proIntro;
                    var proname = data[i].proname;
                    var version = data[i].version;
                    // $(".Pro").append($("<div></div>").addClass("orderList").attr("proid", proid)
                    //     .append($("<img>").attr("src", pic).attr("alt", proname))
                    //     .append($("<p></p>").append($("<a></a>")
                    //         .text(proname + " " + version + " " + color)
                    //         .attr("href", "detail.html?name=" + proname)))
                    //     .append($("<label><label/>").text(acprice + "元×" + amount))
                    //     .append($("<span><span/>").text(createtime))
                    // );
                }
            }
        },error: function () {
        }
    });
}
function toOrder() {
    $(".list ul li a").css("color", "#666666");
    $(".list ul").find("li").eq(2).children().css("color", "#337ab7");
    $(".person").css("display", "none");
    $(".addPerson").css("display", "none");
    $(".modifyPerson").css("display", "none");
    $(".Pro").css("display", "none");
    $(".order").css("display", "block");
    $(".comment").css("display", "none");
    $(".addComment").css("display", "none");
    $(".modifyComment").css("display", "none");
}
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
                    $(".order").append($("<div></div>").addClass("orderList").attr("proid", proid)
                        .append($("<h4>买家收货信息</h4>"))
                        .append($("<p></p>").text("收货人："+realname))
                        .append($("<p></p>").text("电话号码："+phonenum))
                        .append($("<p></p>").text("收货地址："+address))
                        .append($("<br>"))
                        .append($("<img>").attr("src", pic).attr("alt", proname))
                        .append($("<p></p>").append($("<a></a>").text(proname + " " + version + " " + color)))
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
                    if (pros.indexOf(proid) === -1) {
                        pros.push(proid);
                        $(".comment").append($("<div></div>").addClass("orderList comList").attr("buyerid", buyerid)
                            .append($("<img>").attr("src", pic).attr("alt", proname))
                            .append($("<p></p>").append($("<a></a>").text(proname + " " + version + " " + color)))
                            .append($("<label><label/>").text(acprice + "元"))
                        );
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
                            var comminfo = data.comminfo;
                            var commid = data.commid;
                            if (data.apply === "") {
                                $(".comment").find("div").eq(i)
                                    .append($("<a>回复</a>")
                                        .attr("onclick", "addComm(this)")
                                        .attr("proid", pros[i])
                                        .attr("comminfo", comminfo)
                                        .attr("commid", commid)
                                        .attr("class", "btn btn-shop btn-shop1 btn-comm"))
                                    .append($("<br>"))
                                    .append($("<h4>评价详情</h4>"))
                                    .append($("<span></span>").text("买家评价："+comminfo));
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
                                    .append($("<span></span>").text("买家评价："+comminfo))
                                    .append($("<br>"))
                                    .append($("<span></span>").text("卖家回复："+data.apply));
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
function modifyComm(obj) {
    $(".person").css("display", "none");
    $(".addPerson").css("display", "none");
    $(".modifyPerson").css("display", "none");
    $(".Pro").css("display", "none");
    $(".order").css("display", "none");
    $(".comment").css("display", "none");
    $(".addComment").css("display", "none");
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
function cancelComm() {
    $(".person").css("display", "none");
    $(".modifyPerson").css("display", "none");
    $(".addPerson").css("display", "none");
    $(".Pro").css("display", "none");
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