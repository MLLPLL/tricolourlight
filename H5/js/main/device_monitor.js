$(function () {

    alert(1);
    $.ajax({
        contentType: "application/json;charset=utf-8",
        url: "http://localhost:8888/server/api/v1/triColourLight/allLightInfo",
        type: "GET",
        cache: false,
        //async: false,
        dataType: "json",
        data: JSON.stringify({
            "pageNumber": 1,
            "pageSize": 10
        }),
        success: function (data) {
            alert(data);
        },
        error: function (error) {
            alert("error" + error);
            return false;
        }

    });

})

    