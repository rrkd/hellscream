$(window).load(function(){

    var $container = $('#content')

// initialize Isotope

    $container.isotope({

        // options...

        resizable: false, // disable normal resizing

        // set columnWidth to a percentage of container width

        masonry: { columnWidth: $container.width() / 2 }

    });

// update columnWidth on window resize

    $(window).smartresize(function(){

        $container.isotope({

            // update columnWidth to a percentage of container width

            masonry: { columnWidth: $container.width() / 2 }

        });

    });

});

jQuery(document).ready(function ($) {
    //MASONRY

        var $container = $('#content');

        $container.imagesLoaded( function(){

            $container.isotope({

                filter: '*',

                animationOptions: {

                    duration: 750,

                    easing: 'linear',

                    queue: false

                }

            });

        });

//FILTER

        $('#filter a.filter-btn').click(function(){

            var selector = $(this).attr('data-filter');

            $container.isotope({

                filter: selector,

                animationOptions: {

                    duration: 750,

                    easing: 'linear',

                    queue: false

                }

            });

            return false;

        });

        $('#filter a.filter-btn').click(function (event) {

            $('a.selected').removeClass('selected');

            var $this = $(this);

            $this.addClass('selected');

            var selector = $this.attr('data-filter');

            $container.isotope({

                filter: selector

            });

            return false;

        });

    });

//ROLL ON HOVER

    $(function() {

        $(".roll").css("opacity","0");

        $(".roll").hover(function () {

                $(this).stop().animate({

                    opacity: .8

                }, "slow");

            },

            function () {

                $(this).stop().animate({

                    opacity: 0

                }, "slow");

            });

});