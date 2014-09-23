jQuery(document).ready(function ($) {
    $('.merchant-rank').raty();
    $('.merchant-rank').each(function () {
        $(this).raty('score', $(this).attr("data-rank"));
    });
    $('.flexslider').flexslider({

        pauseOnHover:false,

        slideshow:true, //Boolean: Animate slider automatically

        slideshowSpeed:4000, //Integer: Set the speed of the slideshow cycling, in milliseconds

        animationSpeed:1300,

        animation:"slide", //String: Select your animation type, "fade" or "slide"

        easing:"swing", //{NEW} String: Determines the easing method used in jQuery transitions. jQuery easing plugin is supported!

        direction:"horizontal",

        controlNav:true, //Boolean: Create navigation for paging control of each clide? Note: Leave true for manualControls usage

        directionNav:true

    });

    $('#recent-projects').carouFredSel({

        responsive:true,

        width:'100%',

        auto:true,

        circular:true,

        infinite:false,

        prev:{

            button:"#car_prev",

            key:"left"

        },

        next:{

            button:"#car_next",

            key:"right"

        },

        swipe:{

            onMouse:true,

            onTouch:true

        },

        scroll:1500,

        items:{

            visible:{

                min:4,

                max:4

            }

        }

    });

    $("img.imgOpa").hover(function () {

            $(this).stop().animate({opacity:"0.6"}, 'slow');

        },

        function () {

            $(this).stop().animate({opacity:"1.0"}, 'slow');

        });

});
