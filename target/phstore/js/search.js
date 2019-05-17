$(function () {
    var url = location.search;
    if (url.indexOf("?") !== -1) {
        var str = decodeURI(url.substr(1).split("=")[1]);
    }
    $(".searchResult").empty();
    $.ajax({
        url: "http://localhost:8080/phstore_war_exploded/FuzzyQuery",
        type: "GET",
        data: {
            key: str
        },
        success: function (response) {
            var data = response.extend.pageInfo.list;
            if (data.length === 0) {
                $(".searchResult").append($("<h2></h2>")
                    .append("抱歉，没有搜索到与 “")
                    .append($("<p></p>").text(str))
                    .append("” 相关的商品")
                );
            }
            var ul = document.createElement("ul");
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
                img.src = data[i].pic;
                img.width = 160;
                h4.innerHTML = data[i].proname;
                span1.innerHTML = data[i].intro;
                div.setAttribute("class", "dis_info");
                a.href = "detail.html?name=" + data[i].proname;
                div.append(img);
                div.append(h4);
                div.append(span1);
                div.append(br);
                if (data[i].discount > 0) {
                    span2.innerHTML = data[i].minprice - data[i].discount + "元起" + "&nbsp;";
                    span2.setAttribute("class", "num_n");
                    span3.innerHTML = data[i].minprice + "元起";
                    div.append(span2);
                    del.append(span3);
                    div.append(del);
                } else {
                    span3.innerHTML = data[i].minprice + "元起";
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
            $(".searchResult").append(ul);
        }, error: function () {
        }
    });
});