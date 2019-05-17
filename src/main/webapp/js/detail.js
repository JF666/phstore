var user=localStorage.getItem("username");
var buyerId=localStorage.getItem("buyerId");
var str,price,proPicUrl,proId,color,proColor,selPic,sellerId;
var colors = [];
var pics = [];
var proIds = [];
var prices = [];
var discounts = [];
$(function(){
    var url = location.search;
    if (url.indexOf("?") !== -1) {
        str = decodeURI(url.substr(1).split("=")[1]);
    }
    $.ajax({
        url: "http://localhost:8080/phstore_war_exploded/probyname/"+str,
        type: "GET",
        data: {},
        success: function (response) {
            var data = response.extend.product;
            var intro = data[0].proIntro.split("-");
            var pic = data[0].pic.split("*");
            sellerId = data[0].sellerid;
            proId = data[0].proId;
            proPicUrl = pic[0].split("-");
            for (i in data) {
                colors.push(data[i].color);
                pics.push(data[i].pic);
                proIds.push(data[i].proId);
                prices.push(data[i].price);
                discounts.push(data[i].discount);
            }
            var img = document.createElement("img");
            var h1 = document.createElement("h1");
            var p1 = document.createElement("p");
            var p2 = document.createElement("p");
            var span1 = document.createElement("span");
            var span2 = document.createElement("span");
            var del = document.createElement("del");
            var btn1 = document.createElement("button");
            var btn2 = document.createElement("button");
            img.src = proPicUrl[0];
            selPic = proPicUrl[0];
            img.setAttribute("class", "proPicUrl");
            $(".pic").append(img);
            h1.innerHTML = data[0].proname;
            p1.innerHTML = intro[1];
            p2.setAttribute("class","price1");
            if (data[0].discount>0){
                span1.innerHTML = data[0].price-data[0].discount+"元";
                span1.setAttribute("class","num1");
                span2.innerHTML = data[0].price+"元";
                span2.setAttribute("class","num2");
                p2.append(span1);
                del.append(span2);
                p2.append(del);
            }
            else {
                span1.innerHTML = data[0].price+"元";
                span1.setAttribute("class","num1");
                p2.append(span1);
            }
            price = data[0].price-data[0].discount;
            btn1.setAttribute("class","btn btn-add");
            btn1.onclick = function () {addPro();};
            btn1.innerHTML = "加入购物车";
            btn2.setAttribute("class","btn btn-danger btn-buy");
            btn2.onclick = function () {buyPro();};
            btn2.innerHTML = "立即购买";
            $(".buy").append(h1).append(p1).append(p2).append(
                $("<h2></h2>").text("选择版本")
            ).append($("<ul></ul>").addClass("verList"));
            for (i in data) {
                $(".verList").append($("<li></li>")
                    .append($("<a></a>").attr("onclick", "changeVer(this)").attr("verId", i)
                        .append($("<span></span>").addClass("verName").text(data[i].version))
                        .append($("<span></span>").addClass("verPrice").text(data[i].price-data[i].discount+"元"))
                    )
                );
            }
            $(".verList").find("li").eq(0).css("border-color", "#337ab7")
                .children().find("span").eq(0).css("color", "#337ab7")
                .next().css("color", "#757575");
            $(".buy").append(
                $("<h2></h2>").text("选择颜色")
            ).append($("<ul></ul>").addClass("colList"));
            proColor = data[0].color.split("*");
            color = proColor[0];
            for (i in proColor) {
                $(".colList").append($("<li></li>")
                    .append($("<a></a>").attr("onclick", "changeCol(this)").attr("colId", i)
                        .append($("<span></span>").addClass("colName").text(proColor[i]))
                    )
                );
            }
            $(".colList").find("li").eq(0).css("border-color", "#337ab7")
                .children().find("span").eq(0).css("color", "#337ab7");
            $(".buy").append(btn1).append(btn2);
            var intro1 = data[0].proIntro.split("-").slice(2);
            var pic1 = data[0].pic.split("*").slice(1);
            for(i in intro1) {
                var div = $("<div></div>").addClass("intro1");
                var h2 = $("<h2></h2>");
                if (intro1[i].indexOf("*") > -1) {
                    var intro2 = intro1[i].split("*");
                    for (j in intro2) {
                        h2.append(intro2[j]).append($("<br>"));
                    }
                } else {
                    h2.text(intro1[i]);
                }
                var picVid;
                if (pic1[i].indexOf("mp4") > -1) {
                    picVid = $("<video></video>").attr("src", pic1[i])
                        .attr("preload", "auto")
                        .attr("autoplay", "")
                        .attr("loop", "")
                        .attr("muted", "");
                } else {
                    picVid = $("<img>").attr("src", pic1[i]);
                }
                $(".intro_1").append(div
                    .append(h2)
                    .append(picVid)
                );
            }
        }, error: function () {

        }
    });
});
function addPro() {
    if(user){
        $.ajax({
            url: "http://localhost:8080/phstore_war_exploded/proCount",
            type: "GET",
            data: {
                buyerId: buyerId,
                proId: proId,
                color: color
            },
            success: function (response) {
                if (response.extend.proNum === null) {
                    $.ajax({
                        url: "http://localhost:8080/phstore_war_exploded/shopcartInsert",
                        type: "POST",
                        data: {
                            buyerid: buyerId,
                            proid: proId,
                            acprice: price,
                            amount: 1,
                            color: color,
                            pic: selPic
                        },
                        success: function () {
                            localStorage.setItem("selCol", color);
                            location.href="add.html?id="+proId;
                        }, error: function () {
                        }
                    });
                } else {
                    var amount = response.extend.proNum;
                    amount++;
                    $.ajax({
                        url: "http://localhost:8080/phstore_war_exploded/updateAmount",
                        type: "PUT",
                        data: {
                            buyerId: buyerId,
                            proId: proId,
                            color: color,
                            amount: amount
                        },
                        success: function () {
                            localStorage.setItem("selCol", color);
                            location.href="add.html?id="+proId;
                        }, error: function () {
                        }
                    });
                }

            }, error: function () {
            }
        });
    }
    else {
        window.location.href="login.html";
    }
}
function buyPro() {
    if(user){
        var mytime = new Date().getTime().toString();
        var good = {
            "buyerid": Number(buyerId),
            "sellerid": sellerId,
            "proid": proId,
            "amount": 1,
            "transts": 0,
            "createtime": mytime,
            "acprice": price,
            "color": color,
            "pic": selPic
        };
        $.ajax({
            url: "http://localhost:8080/phstore_war_exploded/transactionInsert",
            type: "POST",
            data: good,
            success: function () {
                localStorage.setItem("shopcartIds", "");
                location.href="order.html?mytime="+mytime;
            }, error: function () {
            }
        });
    }
    else {
        window.location.href="login.html";
    }
}
function changeVer(obj) {
    $(".verList li").css("border-color", "#e0e0e0");
    $(".verName").css("color", "#333");
    $(".verPrice").css("color", "#b0b0b0");
    obj.parentNode.style.borderColor = "#337ab7";
    obj.firstChild.style.color = "#337ab7";
    obj.lastChild.style.color = "#757575";
    price = obj.childNodes[1].innerHTML;
    price = parseInt(price.substring(0,price.indexOf("元")));
    $(".num1").text(price+"元");
    $(".num2").text(price + discounts[obj.getAttribute("verId")]+"元");
    $(".colList").empty();
    proColor = colors[obj.getAttribute("verId")].split("*");
    color = proColor[0];
    for (i in proColor) {
        $(".colList").append($("<li></li>")
            .append($("<a></a>").attr("onclick", "changeCol(this)").attr("colId", i)
                .append($("<span></span>").addClass("colName").text(proColor[i]))
            )
        );
    }
    $(".colList").find("li").eq(0).css("border-color", "#337ab7")
        .children().find("span").eq(0).css("color", "#337ab7");
    var pic = pics[obj.getAttribute("verId")].split("*");
    proPicUrl = pic[0].split("-");
    $(".proPicUrl").attr("src", proPicUrl[0]);
    selPic = proPicUrl[0];
    proId = proIds[obj.getAttribute("verId")];
}
function changeCol(obj) {
    $(".colList li").css("border-color", "#e0e0e0");
    $(".colName").css("color", "#333");
    obj.parentNode.style.borderColor = "#337ab7";
    obj.firstChild.style.color = "#337ab7";
    $(".proPicUrl").attr("src", proPicUrl[obj.getAttribute("colId")]);
    selPic = proPicUrl[obj.getAttribute("colId")];
    color = proColor[obj.getAttribute("colId")];
}