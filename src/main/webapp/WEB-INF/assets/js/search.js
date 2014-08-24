jQuery(document).ready(function ($) {
    $('#searchBtn').click(function () {
        window.location.href = "search?q=" + $('#keyWord_text').val().split(" ").join("-");
        return false;
    });
    $('.keyWord_text').keydown(function(event) {
        if (event.keyCode == 13) {
            window.location.href = "search?q=" + $('#keyWord_text').val().split(" ").join("-");
            return false;
        }
    });
});