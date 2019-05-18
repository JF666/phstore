var user=localStorage.getItem("username");
var compName = [];
$(function () {
    $(".search-text").focus(function () {
        $(".search-text").css("border-color", "#337ab7").css("box-shadow", "none");
        $(".glyphicon-search").css("border-color", "#337ab7");
    });
    $(".search-text").blur(function () {
        $(".search-text").css("border-color", "#e0e0e0");
        $(".glyphicon-search").css("border-color", "#e0e0e0");
    });
    $(".search-text").bind("keypress",function(event){
        if(event.keyCode === 13){
            var key = $(".search-text").val();
            location.href = "search.html?key="+key;
            return false;
        }
    });
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
    // 左侧厂商列表
    $.ajax({
        url: "http://localhost:8080/phstore_war_exploded/sellers",
        type: "GET",
        data: {},
        success: function (response) {
            var data = response.extend.sellers;
            for (i in data) {
                var li = $("<li></li>")
                    .append($("<div></div>").addClass("tx").attr("onmouseover","over(this)").attr("sellerId", data[i].sellerid).text(data[i].company)
                        .append($("<span></span>").addClass("glyphicon glyphicon-chevron-right")))
                    .append($("<div></div>").addClass("pop")
                    );
                $("#coList").append(li);
            }
        }, error: function () {
        }
    })
    //全部
    toPn(1);
})
function toPn(n) {
    $(".products1").empty();
    $(".page").empty();
    var pronames = "";
    var acprices = "";
    $.ajax({
        url: "http://localhost:8080/phstore_war_exploded/getAcPrice",
        type: "GET",
        data: {},
        async: false,
        success: function (response) {
            var data = response.extend.products;
            for (i in data) {
                acprices += parseInt(data[i].acprice)+"-";
                pronames += data[i].proName+"-";
            }
            acprices = acprices.substring(0, acprices.length-1);
            pronames = pronames.substring(0, pronames.length-1);
        }, error: function () {
        }
    });
    $.ajax({
        url: "http://localhost:8080/phstore_war_exploded/getByName",
        type: "GET",
        data: {
            pn: n,
            pronames: pronames
        },
        success: function (response) {
            var data = response.extend.pageInfo.list;
            var isFp = response.extend.pageInfo.isFirstPage;
            var isLp = response.extend.pageInfo.isLastPage;
            var ul = document.createElement("ul");
            var acprice = acprices.split("-");
            for (i in data) {
                var li, a, div, img, h4, span1, span2, span3, p, del, br;
                li = document.createElement("li");
                a = document.createElement("a");
                div = document.createElement("div");
                img = document.createElement("img");
                h4 = document.createElement("h4");
                span1 = document.createElement("span");
                span2 = document.createElement("span");
                span3 = document.createElement("span");
                p = document.createElement("p");
                del = document.createElement("del");
                br = document.createElement("br");
                img.alt = data[i].proname;
                var pic = data[i].pic.split("*");
                var picSrc = pic[0].split("-");
                img.src = picSrc[0];
                img.width = 160;
                h4.innerHTML = data[i].proname;
                var intro = data[i].proIntro.split("-");
                span1.innerHTML = intro[0];
                div.setAttribute("class", "dis_info");
                a.href = "detail.html?name=" + data[i].proname;
                div.append(img);
                div.append(h4);
                div.append(span1);
                div.append(br);
                if (data[i].discount > 0) {
                    span2.innerHTML = acprice[i] + "元起" + "&nbsp;";
                    span2.setAttribute("class", "num_n");
                    span3.innerHTML = Number(acprice[i])+data[i].discount + "元起";
                    div.append(span2);
                    del.append(span3);
                    div.append(del);
                } else {
                    span3.innerHTML = acprice[i] + "元起";
                    span3.setAttribute("class", "num_n");
                    div.append(span3);
                }
                a.append(div);
                li.append(a);
                var butComp = document.createElement("button");
                butComp.setAttribute("class", "btn btn-primary btn-comp");
                butComp.setAttribute("proname", data[i].proname);
                butComp.onclick = function (){addComp(this);};
                var spanComp = document.createElement("span");
                spanComp.setAttribute("class", "glyphicon glyphicon-plus gly-plus");
                spanComp.innerHTML = "加入对比";
                butComp.append(spanComp);
                li.append(butComp);
                ul.append(li);
            }
            $(".products1").append(ul);
            var li1=document.createElement("li");
            var li2=document.createElement("li");
            var btn1=document.createElement("button");
            var btn2=document.createElement("button");
            var span1=document.createElement("span");
            var span2=document.createElement("span");
            span1.setAttribute("class","glyphicon glyphicon-chevron-left");
            span2.setAttribute("class","glyphicon glyphicon-chevron-right");
            btn1.setAttribute("class","btn");
            btn1.onclick = function (){toPn(n-1);};
            btn2.setAttribute("class","btn");
            btn2.onclick = function (){toPn(n+1);};
            btn1.append(span1);
            btn2.append(span2);
            li1.append(btn1);
            li2.append(btn2);
            $(".page").append(li1).append(li2);
            if (isFp===true){
                btn1.setAttribute("disabled","disabled");
            }
            if (isLp===true){
                btn2.setAttribute("disabled","disabled");
            }
        }, error: function () {
        }
    });
}
function quit() {
    $(".user").empty();
    var li1 = document.createElement("li");
    var a1 = document.createElement("a");
    a1.href="login.html";
    a1.innerHTML = "登录";
    li1.append(a1);
    $(".user").append(li1);
    window.location.href = "index.html";
    localStorage.removeItem("username");
}
function over(obj) {
    $.ajax({
        url: "http://localhost:8080/phstore_war_exploded/product/"+obj.getAttribute("sellerId"),
        data: {},
        success: function (response) {
            var data = response.extend.products;
            $(".pop").empty();
            var dataList = [];
            for (i in data) {
                if (dataList.indexOf(data[i].proname) === -1) {
                    dataList.push(data[i].proname);
                    var p, a, img, br;
                    p = document.createElement("p");
                    a = document.createElement("a");
                    img = document.createElement("img");
                    br = document.createElement("br");
                    var pic = data[i].pic.split("*");
                    var proPic = pic[0].split("-");
                    img.src = proPic[0];
                    img.alt = data[i].proname;
                    a.href = "detail.html?name=" + data[i].proname;
                    a.append(img);
                    a.append(br);
                    a.append(data[i].proname);
                    p.append(a);
                    $(".pop").append(p);
                }
            }
        }, error: function () {
        }
    })
}
function cart(){
    if(user !== null){
        location.href="shopcart.html";
    } else {
        window.location.href="login.html";
    }
}
function addComp(obj) {
    $(".compare-box").css("display", "block");
    var num = $("#CompareNum").text();
    if (num < 4) {
        num++;
        $("#CompareNum").text(num);
        $(obj).attr("disabled", true);
        var href = $(obj).prev().attr("href");
        var src = $(obj).prev().children().children().first().attr("src");
        var name = $(obj).attr("proname");
        compName.push(name);
        $(".compare-box-list").append($("<li></li>")
            .append($("<span></span>").addClass("glyphicon glyphicon-remove item-del").attr("onclick", "removeItem(this)"))
            .append($("<a></a>").attr("href", href).attr("target", "_blank")
                .append($("<img>").attr("src", src))
                .append($("<span></span>").text(name))
            )
        );
    } else {
        alert("最多可以选择4件商品");
    }
}
function removeItem(obj) {
    $(obj).parent().remove();
    var name = $(obj).next().children().last().text();
    compName.splice(compName.indexOf(name),1);
    $(".products1 ul li button[proname='"+name+"']").attr("disabled", false);
    var num = $("#CompareNum").text();
    num--;
    $("#CompareNum").text(num);
    if (num === 0) {
        $(".compare-box").css("display", "none");
        compName = [];
    }
}
function emptyItem() {
    $(".compare-box-list").empty();
    $("#CompareNum").text(0);
    $(".btn-comp").attr("disabled", false);
    compName = [];
    $(".compare-box").css("display", "none");
}
function toComp() {
    localStorage.setItem("compName", compName);
    location.href = "compare.html";
}
function search() {
    var key = $(".search-text").val();
    location.href = "search.html?key="+key;
}