
    function Refresh() {
        setTimeout(function () {    // <-- Simulate network congestion, remove setTimeout from production!
            var originData = $(".loadmoreWrapper ul").html();
            var el, li, i;
            el = document.querySelector(".loadmoreWrapper ul");
            el.innerHTML = '';
            $('.loadmoreWrapper ul').append(originData);
            wrapper.refresh();/****remember to refresh after  action completed！ ---yourId.refresh(); ----| ****/

        }, 1000);
    }
    function Load() {
        setTimeout(function () {// <-- Simulate network congestion, remove setTimeout from production!
            var el, li, i;
            var originData = $(".loadmoreWrapper ul").html();
            $('.loadmoreWrapper ul').append(originData);
            wrapper.refresh();/****remember to refresh after action completed！！！   ---id.refresh(); --- ****/
        }, 1000);
    }