var str;
var tranids = "";
$(function() {
    var url = location.search;
    if (url.indexOf("?") !== -1) {
        str = decodeURI(url.substr(1).split("=")[1]);
    }
    $.ajax({
        url: "http://localhost:8080/phstore_war_exploded/transaction",
        data: {createTime: str},
        success: function (response) {
            var data = response.extend.transactions;
            var realname = data[0].buyer.realname;
            var phonenum = data[0].buyer.phonenum;
            var address = data[0].buyer.receiveadd;
            $(".realName").text(realname);
            $(".phNum").text(phonenum);
            $(".address").text(address);
            var pay = 0;
            for (i in data) {
                var tranid = data[i].tranid;
                tranids += tranid + ",";
                var pic = data[i].pic;
                var proname = data[i].product.proname;
                var version = data[i].product.version;
                var color = data[i].color;
                var acprice = data[i].acprice;
                var amount = data[i].amount;
                var total = acprice * amount;
                pay += total;
                $(".tranList").append($("<div></div>").addClass("tranPro")
                    .append($("<img>").attr("src", pic).attr("alt", proname))
                    .append($("<p></p>").text(proname+" "+version+" "+color))
                    .append($("<p></p>").text(acprice+"元×"+amount))
                    .append($("<span></span>").text(total+"元"))
                );
            }
            tranids = tranids.substring(0, tranids.length-1);
            $("#cartTotalPrice").text(pay);
        },error: function () {

        }
    });
});
function deleteTran() {
    var tranId = tranids.split(",");
    for (i in tranId) {
        $.ajax({
            url: "http://localhost:8080/phstore_war_exploded/transaction/"+tranId[i],
            data: {},
            type: "DELETE",
            success: function () {

            }, error: function () {

            }
        });
    }
}
function returnCart() {
    deleteTran();
    history.go(-1);
}
function order(){
    if (confirm("确定购买吗？")) {
        var shopcartIds = localStorage.getItem("shopcartIds");
        if (shopcartIds !== "") {
            var shopcartId = shopcartIds.split(",");
            for (i in shopcartId) {
                $.ajax({
                    url: "http://localhost:8080/phstore_war_exploded/shopcart/" + shopcartId[i],
                    data: {},
                    type: "DELETE",
                    success: function () {
                    }, error: function () {
                    }
                });
            }
        }
        location.href="person.html?type=2";
    }
}
function toPerson() {
    deleteTran();
    location.href = "person.html?type=1";
}
function toOrder() {
    deleteTran();
    location.href = "person.html?type=2";
}
function toComment() {
    deleteTran();
    location.href = "person.html?type=3";
}