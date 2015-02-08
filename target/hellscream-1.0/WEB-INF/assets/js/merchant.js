jQuery(document).ready(function ($) {
    $('.merchant-rank').raty();
    $('.merchant-rank').each(function(){
        $(this).raty('score', $(this).attr("data-rank"));
    });
});