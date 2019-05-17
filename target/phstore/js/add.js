var str;
$(function() {
    var url = location.search;
    if (url.indexOf("?") !== -1) {
        str = decodeURI(url.substr(1).split("=")[1]);
    }
    $.ajax({
        url: "http://localhost:8080/phstore_war_exploded/probyId/"+str,
        type: "GET",
        data: {},
        success: function (response) {
            var data = response.extend.product
            var span = document.createElement("span");
            span.setAttribute("class","name");
            var color = localStorage.getItem("selCol");
            span.innerHTML = data.proname+"\t"+data.version+"\t"+ color;
            $(".hero").append(span);
        },error: function () {

        }
    })
});