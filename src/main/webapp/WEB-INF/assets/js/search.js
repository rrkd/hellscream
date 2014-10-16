jQuery(document).ready(function ($) {
    $('#search').submit(function(e) {
        e.preventDefault();
    });
    $('#searchBtn').click(function () {
        var keyword = $('#keyWord_text').val().split(" ").join("-");
        window.location.href = "/search?q=" + keyword + "&local=";
        return false;
    });
    $('#keyWord_text').keydown(function(event) {
        if (event.keyCode == 13) {
            var keyword = $('#keyWord_text').val().split(" ").join("-");
            window.location.href = "/search?q=" + keyword + "&local=";
            return false;
        }
    });
});