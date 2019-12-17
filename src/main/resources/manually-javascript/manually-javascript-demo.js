////完全自动化版//
$(document).ready(function () {


    ///////////////////////
    var xunHuanCiShu = 3; //在这里更改想要转移多少条，默认设置了3条。
    ///////////////////////


    var timesRun = 0;
    //每次循环间隔2000毫秒
    var interval = setInterval(function () {
        timesRun += 1;
        if (timesRun == xunHuanCiShu) {
            clearInterval(interval);
        }
        //开始工作
        firstStep();
    }, 5000);

});

//点击“转移标签”按钮,弹出弹出框
function firstStep() {
    //debugger;
    //获取第一个标签数量小于3个的元素
    var zongBiaoQian = $("div.uc-lst-ino").find("div.uc-lst-bar").filter(function () {
        return $(this).find("a.sort-tag").size() < 3
    }).first();
    //获取其兄弟标签
    var brotherTags = zongBiaoQian.siblings();
    //获取其中的“转移标签”按钮
    var zhuanYiBiaoQian = brotherTags.find("a.btn-setup-bar").filter(function (a, b) {
        return $(b).text() == "转移标签";
    }).get(0);
    //点击“转移标签”按钮
    zhuanYiBiaoQian.click()
    setTimeout("secondStep()", 500);
}


function secondStep() {
    //获取现有标签的个数
    var length = $(".my-interest-popup.selectedInterest").size();
    //寻找“育儿”标签
    var yuEr = $(".my-interest-popup.selectedInterest").find('.interest-tab.select_tag').filter(function (a, b) {
        ;
        return $(b).text() == "育儿"
    }).find("a").get(0);
    //如果标签个数小于3个 并且 不存在“育儿”标签
    if (length < 3 && !yuEr) {

        //获取“健康生活”方框
        var jianKangShengHuo = $(".category-field-tab").slice(5).get(0);
        //点击
        jianKangShengHuo.click();

        setTimeout("selectYuErTag()", 500);
    } else if (length < 3 && yuEr) {
        //获取“健康生活”方框
        var jianKangShengHuo = $(".category-field-tab").slice(5).get(0);
        //点击
        jianKangShengHuo.click();
        setTimeout("selectShengHuoTag()", 500);

    }
    //else if(length == 3){
    //$(".my-interest-popup.selectedInterest").find('.interest-tab.select_tag').get(2).remove();
    //setTimeout("submit()", 500);
    //}

}

function selectYuErTag() {
    //获取“育儿”标签
    $(".interest-lst-tag2").get(10).click();

    setTimeout("selectYuErPlus()", 500);
}

function selectShengHuoTag() {
    //获取“生活”标签
    $(".interest-lst-tag2").get(9).click();

    setTimeout("selectShengHuoPlus()", 500);
}

function selectYuErPlus() {
    //获取“育儿标签右边的 ‘+’ ”
    $(".interest-lst-tag").get(10).click();
    setTimeout("submit()", 500);
}

function selectShengHuoPlus() {
    //获取“生活标签右边的 ‘+’ ”
    $(".interest-lst-tag").get(9).click();
    setTimeout("submit()", 500);

}

function selectShengHuoPlusAgain() {
    //获取“生活标签右边的 ‘+’ ”
    $(".interest-lst-tag").get(9).click();
    setTimeout("submit()", 500);
}

function submit() {

    //获取“确定”按钮
    var queDing = $(".popup.popup-w.interest_popup").find("[class^='btn-reply-submit']").filter(function (a, b) {
        return $(b).text() == "确定"
    }).get(0);
    queDing.click()
}
