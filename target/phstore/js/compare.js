$(function () {
    var compName = localStorage.getItem("compName");
    var names = compName.split(",");
    //battery
    var capacity = [];
    var charinter = [];
    var charpower = [];
    //cpuinfo
    var cpufqu = [];
    var cpuname = [];
    var cputech = [];
    //frontcamera
    var fcname = [];
    var fcpixel = [];
    //operatingsys
    var osname = [];
    var osversion = [];
    //ramrom
    var ram = [];
    var rom = [];
    //rearcamera
    var rcname = [];
    var rcpixel = [];
    //recognition
    var facerec = [];
    var frontfingerrec = [];
    var rearfingerrec = [];
    var scrfingerrec = [];
    var sidefingerrec = [];
    //screen
    var resolution = [];
    var screenname = [];
    var screenocc = [];
    var screenshape = [];
    var screensize = [];
    //size
    var length = [];
    var width = [];
    var thickness = [];
    var weight = [];
    var pic = [];
    for (i in names) {
        $.ajax({
            url: "http://localhost:8080/phstore_war_exploded/probyname/" + names[i],
            type: "GET",
            async: false,
            data: {},
            success: function (response) {
                var proPic = response.extend.product[0].pic.split("*");
                pic.push(proPic[0]);
                $.ajax({
                    url: "http://localhost:8080/phstore_war_exploded/parameter/" + response.extend.product[0].proId,
                    type: "GET",
                    async: false,
                    data: {},
                    success: function (response) {
                        var data = response.extend.parameter;
                        capacity.push(data[0].battery.capacity);
                        charinter.push(data[0].battery.charinter);
                        charpower.push(data[0].battery.charpower);
                        cpufqu.push(data[0].cpuinfo.cpufqu);
                        cpuname.push(data[0].cpuinfo.cpuname);
                        cputech.push(data[0].cpuinfo.cputech);
                        fcname.push(data[0].frontcamera.fcname);
                        fcpixel.push(data[0].frontcamera.fcpixel);
                        osname.push(data[0].operatingsys.osname);
                        osversion.push(data[0].operatingsys.osversion);
                        ram.push(data[0].ramrom.ram);
                        rom.push(data[0].ramrom.rom);
                        rcname.push(data[0].rearcamera.rcname);
                        rcpixel.push(data[0].rearcamera.rcpixel);
                        facerec.push(data[0].recognition.facerec);
                        frontfingerrec.push(data[0].recognition.frontfingerrec);
                        rearfingerrec.push(data[0].recognition.rearfingerrec);
                        scrfingerrec.push(data[0].recognition.scrfingerrec);
                        sidefingerrec.push(data[0].recognition.sidefingerrec);
                        resolution.push(data[0].screen.resolution);
                        screenname.push(data[0].screen.screenname);
                        if (data[0].screen.screenocc === null) {
                            screenocc.push("null");
                        } else {
                            screenocc.push(data[0].screen.screenocc);
                        }
                        screenshape.push(data[0].screen.screenshape);
                        screensize.push(data[0].screen.screensize);
                        length.push(data[0].size.length);
                        width.push(data[0].size.width);
                        thickness.push(data[0].size.thickness);
                        weight.push(data[0].size.weight);
                    }, error: function () {
                    }
                });
            }, error: function () {
            }
        });
    }
    var tr0 = $("<tr></tr>").append($("<td>商品</td>"));
    var col1 = $("<tr></tr>").append($("<td>充电与电池</td>").attr("colspan", "5"));
    var tr1 = $("<tr></tr>").append($("<td>电池容量</td>"));
    var tr2 = $("<tr></tr>").append($("<td>充电接口</td>"));
    var tr3 = $("<tr></tr>").append($("<td>充电功率</td>"));
    var col2 = $("<tr></tr>").append($("<td>处理器</td>").attr("colspan", "5"));
    var tr4 = $("<tr></tr>").append($("<td>CPU型号</td>"));
    var tr5 = $("<tr></tr>").append($("<td>CPU主频</td>"));
    var tr6 = $("<tr></tr>").append($("<td>CPU制程</td>"));
    var col3 = $("<tr></tr>").append($("<td>前置摄像头</td>").attr("colspan", "5"));
    var tr7 = $("<tr></tr>").append($("<td>前置摄像头型号</td>"));
    var tr8 = $("<tr></tr>").append($("<td>前置摄像头像素</td>"));
    var col4 = $("<tr></tr>").append($("<td>操作系统</td>").attr("colspan", "5"));
    var tr9 = $("<tr></tr>").append($("<td>系统版本</td>"));
    var col5 = $("<tr></tr>").append($("<td>内存与容量</td>").attr("colspan", "5"));
    var tr11 = $("<tr></tr>").append($("<td>运行内存</td>"));
    var tr12 = $("<tr></tr>").append($("<td>机身存储</td>"));
    var col6 = $("<tr></tr>").append($("<td>后置摄像头</td>").attr("colspan", "5"));
    var tr13 = $("<tr></tr>").append($("<td>后置摄像头型号</td>"));
    var tr14 = $("<tr></tr>").append($("<td>后置摄像头像素</td>"));
    var col7 = $("<tr></tr>").append($("<td>解锁方式</td>").attr("colspan", "5"));
    var tr15 = $("<tr></tr>").append($("<td>面部识别</td>"));
    var tr16 = $("<tr></tr>").append($("<td>前置指纹识别</td>"));
    var tr17 = $("<tr></tr>").append($("<td>后置指纹识别</td>"));
    var tr18 = $("<tr></tr>").append($("<td>屏幕指纹识别</td>"));
    var tr19 = $("<tr></tr>").append($("<td>侧边指纹识别</td>"));
    var col8 = $("<tr></tr>").append($("<td>屏幕</td>").attr("colspan", "5"));
    var tr20 = $("<tr></tr>").append($("<td>屏幕名称</td>"));
    var tr21 = $("<tr></tr>").append($("<td>像素</td>"));
    var tr22 = $("<tr></tr>").append($("<td>屏占比</td>"));
    var tr23 = $("<tr></tr>").append($("<td>屏幕形状</td>"));
    var tr24 = $("<tr></tr>").append($("<td>尺寸</td>"));
    var col9 = $("<tr></tr>").append($("<td>外观尺寸</td>").attr("colspan", "5"));
    var tr25 = $("<tr></tr>").append($("<td>高度</td>"));
    var tr26 = $("<tr></tr>").append($("<td>宽度</td>"));
    var tr27 = $("<tr></tr>").append($("<td>厚度</td>"));
    var tr28 = $("<tr></tr>").append($("<td>重量</td>"));
    for (var j = 0; j < 4; j++) {
        if (capacity[j] !== undefined) {
            var pic1 = pic[j].split("-");
            tr0.append($("<td></td>")
                .append($("<a></a>").attr("href", "detail.html?name="+names[j])
                    .attr("alt", names[j])
                    .attr("title", "前往购买")
                    .append($("<img>").attr("src", pic1[0]))
                    .append($("<p></p>").text(names[j]))
                )
            );
            tr1.append($("<td></td>").text(capacity[j]));
            tr2.append($("<td></td>").text(charinter[j]));
            tr3.append($("<td></td>").text(charpower[j]));
            tr4.append($("<td></td>").text(cpuname[j]));
            tr5.append($("<td></td>").text(cpufqu[j]));
            tr6.append($("<td></td>").text(cputech[j]));
            tr7.append($("<td></td>").text(fcname[j]));
            tr8.append($("<td></td>").text(fcpixel[j]));
            tr9.append($("<td></td>").text(osname[j]+osversion[j]));
            tr11.append($("<td></td>").text(ram[j]));
            tr12.append($("<td></td>").text(rom[j]));
            tr13.append($("<td></td>").text(rcname[j]));
            tr14.append($("<td></td>").text(rcpixel[j]));
            if (facerec[j] === 0) {
                tr15.append($("<td></td>").text("不支持"));
            } else {
                tr15.append($("<td></td>").text("支持"));
            }
            if (frontfingerrec[j] === 0) {
                tr16.append($("<td></td>").text("不支持"));
            } else {
                tr16.append($("<td></td>").text("支持"));
            }
            if (rearfingerrec[j] === 0) {
                tr17.append($("<td></td>").text("不支持"));
            } else {
                tr17.append($("<td></td>").text("支持"));
            }
            if (scrfingerrec[j] === 0) {
                tr18.append($("<td></td>").text("不支持"));
            } else {
                tr18.append($("<td></td>").text("支持"));
            }
            if (sidefingerrec[j] === 0) {
                tr19.append($("<td></td>").text("不支持"));
            } else {
                tr19.append($("<td></td>").text("支持"));
            }
            tr20.append($("<td></td>").text(screenname[j]));
            tr21.append($("<td></td>").text(resolution[j]));
            if (screenocc[j] === "null") {
                tr22.append($("<td></td>"));
            } else {
                tr22.append($("<td></td>").text(screenocc[j]));
            }
            tr23.append($("<td></td>").text(screenshape[j]));
            tr24.append($("<td></td>").text(screensize[j]));
            tr25.append($("<td></td>").text(length[j]));
            tr26.append($("<td></td>").text(width[j]));
            tr27.append($("<td></td>").text(thickness[j]));
            tr28.append($("<td></td>").text(weight[j]));
        } else {
            tr0.append($("<td></td>"));
            tr1.append($("<td></td>"));
            tr2.append($("<td></td>"));
            tr3.append($("<td></td>"));
            tr4.append($("<td></td>"));
            tr5.append($("<td></td>"));
            tr6.append($("<td></td>"));
            tr7.append($("<td></td>"));
            tr8.append($("<td></td>"));
            tr9.append($("<td></td>"));
            tr11.append($("<td></td>"));
            tr12.append($("<td></td>"));
            tr13.append($("<td></td>"));
            tr14.append($("<td></td>"));
            tr15.append($("<td></td>"));
            tr16.append($("<td></td>"));
            tr17.append($("<td></td>"));
            tr18.append($("<td></td>"));
            tr19.append($("<td></td>"));
            tr20.append($("<td></td>"));
            tr21.append($("<td></td>"));
            tr22.append($("<td></td>"));
            tr23.append($("<td></td>"));
            tr24.append($("<td></td>"));
            tr25.append($("<td></td>"));
            tr26.append($("<td></td>"));
            tr27.append($("<td></td>"));
            tr28.append($("<td></td>"));
        }
    }
    $(".compBody").append(tr0)
        .append(col1)
        .append(tr1)
        .append(tr2)
        .append(tr3)
        .append(col2)
        .append(tr4)
        .append(tr5)
        .append(tr6)
        .append(col3)
        .append(tr7)
        .append(tr8)
        .append(col4)
        .append(tr9)
        .append(col5)
        .append(tr11)
        .append(tr12)
        .append(col6)
        .append(tr13)
        .append(tr14)
        .append(col7)
        .append(tr15)
        .append(tr16)
        .append(tr17)
        .append(tr18)
        .append(tr19)
        .append(col8)
        .append(tr20)
        .append(tr21)
        .append(tr22)
        .append(tr23)
        .append(tr24)
        .append(col9)
        .append(tr25)
        .append(tr26)
        .append(tr27)
        .append(tr28);
});