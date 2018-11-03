/**
*
* themesflatSearch(); 
* FlatClient();
* parallax();
* tabs();
* woocommerceTabs();
* flatCounter();
* flatOwl();
* testimonialSlider();
* VideoPopup();
* flatIsotope();
* progressBar();
* detectViewport();
* projectGallary(); 
* flatSpacer();
* flatPaddingAuto();
* flatMarginAuto();
* flatEqualizeHeight();
* goTop();
* flatGallery();
* googleMap();
* accordionToggle();
* responsiveMenu();
* removePreloader();
* headerFixed();
* flatRetinaLogo();
* 
*/

;(function($) {
    "use strict";

    //导航菜单切换
    var responsiveMenu = function() {
        var menuType = 'desktop';

        $(window).on('load resize', function() {
            var currMenuType = 'desktop';

            if ( matchMedia( 'only screen and (max-width: 991px)' ).matches ) {
                currMenuType = 'mobile';
            }

            if ( currMenuType !== menuType ) {
                menuType = currMenuType;

                if ( currMenuType === 'mobile' ) {
                    var $mobileMenu = $('#mainnav').attr('id', 'mainnav-mobi').hide();
                    var hasChildMenu = $('#mainnav-mobi').find('li:has(ul)');

                    $('#header .container-header ').after($mobileMenu);
                    hasChildMenu.children('ul').hide();
                    hasChildMenu.children('a').after('<span class="btn-submenu"></span>');
                    $('.btn-menu').removeClass('active');
                } else {
                    var $desktopMenu = $('#mainnav-mobi').attr('id', 'mainnav').removeAttr('style');

                    $desktopMenu.find('.submenu').removeAttr('style');
                    $('#header .container-header ').find('.nav-wrap').append($desktopMenu);
                    $('.btn-submenu').remove();
                }
            }
        });

        $('.mobile-button').on('click', function() {         
            $('#mainnav-mobi').slideToggle(300);
            $(this).toggleClass('active');
        });

        $(document).on('click', '#mainnav-mobi li .btn-submenu', function(e) {
            $(this).toggleClass('active').next('ul').slideToggle(300);
            e.stopImmediatePropagation()
        });
    };

    //头部固定
    var headerFixed = function() {
        var nav = $('#header');
        $(window).on('load', function(){
            var header = $('#header');           
            var offsetTop = $('#header').offset().top;
            var headerHeight = $('#header').height();             

            $(window).on('load scroll', function(){
                if ( $(window).scrollTop() > offsetTop  ) {
                    $('#header').addClass('fixed-header');
                } else {
                    $('#header').removeClass('fixed-header');
                }
            });
        });
    };

   
    var flatRetinaLogo = function() {
        var retina = window.devicePixelRatio > 1 ? true : false;
        var $logo = $('#logo img');
        var $logo_retina = $logo.data('retina');

        var $logo_ft = $('#logo-ft img');
        var $logo_retina_ft = $logo_ft.data('retina');

        if ( retina && $logo_retina ) {
            $logo.attr({
                src: $logo.data('retina'),
                width: $logo.data('width'),
                height: $logo.data('height')
            });
        } 

        if ( retina && $logo_retina_ft ) {
            $logo_ft.attr({
                src: $logo_ft.data('retina'),
                width: $logo_ft.data('width'),
                height: $logo_ft.data('height')
            });
        }
    };

    //点击自动切换
    var accordionToggle = function() {
        var speed = {duration: 400};
        $('.toggle-content').hide();
        $('.accordion-toggle .toggle-title.active').siblings('.toggle-content').show();
        $('.accordion').find('.toggle-title').on('click', function() {
            $(this).toggleClass('active');
            $(this).next().slideToggle(speed);
            $(".toggle-content").not($(this).next()).slideUp(speed);
            if ($(this).is('.active')) {
                $(this).closest('.accordion').find('.toggle-title.active').toggleClass('active')
                $(this).toggleClass('active');
            };
        });
    };

    var flatIsotope = function() {         
        if ( $().isotope ) {           
            var $container = $('.isotope-project');
            $container.imagesLoaded(function(){
                $container.isotope({
                    itemSelector: '.imagebox',
                    transitionDuration: '1s',
                    layoutMode: 'fitRows'
                });
            });

            $('.portfolio-filter li').on('click',function() {                           
                var selector = $(this).find("a").attr('data-filter');
                $('.portfolio-filter li').removeClass('active');
                $(this).addClass('active');
                $container.isotope({ filter: selector });
                return false;
            });
        };
    };



    var projectGallary = function() {         
        if ( $().isotope ) {           
            var $container = $('.flat-projects .flat-imagebox');
            $container.imagesLoaded(function(){
                $container.isotope({
                    itemSelector: '.imagebox',
                    transitionDuration: '1s'
                });
            });           
        };
    };
    var flatOwl = function() {
        if ( $().owlCarousel ) {
            $('.themesflat-carousel-box').each(function(){
                var
                $this = $(this),
                auto = $this.data("auto"),
                item = $this.data("column"),
                item2 = $this.data("column2"),
                item3 = $this.data("column3"),
                gap = Number($this.data("gap")),
                dots = $this.data("dots"),
                nav = $this.data("nav");

                $this.find('.owl-carousel').owlCarousel({
                    margin: gap,
                    loop:true,
                    dots:dots,
                    nav: nav,
                    navigation : true,
                    pagination: true,
                    autoplay: auto,
                    autoplayTimeout: 5000,
                    responsive: {
                        0:{
                            items:item3
                        },
                        765:{
                            items:item2
                        },
                        1000:{
                            items:item
                        }
                    }
                });
            });
            $('.flat-testimonial-carousel').each(function(){
                var
                $this = $(this),
                auto = $this.data("auto"),
                item = $this.data("column"),
                item2 = $this.data("column2"),
                item3 = $this.data("column3"),
                gap = Number($this.data("gap")),
                dots = $this.data('dots'),
                nav = $this.data('nav');

                $this.find('.owl-carousel').owlCarousel({
                    margin: gap,
                    loop:false,
                    dots:dots,
                    nav: nav,
                    navigation : true,
                    pagination: true,
                    autoplay: auto,
                    autoplayTimeout: 5000,
                    navText:['&#x23;','&#x24;'],
                    responsive: {
                        0:{
                            items:item3
                        },
                        600:{
                            items:item2
                        },
                        1000:{
                            items:item
                        }
                    }
                });
            });
        }
    };


    var tabService = function() {
        $('.flat-tabs').each(function() {
            $('.tab-content-service').css({'opacity':'0'});
            $('.tab-content-service').first().css({'opacity':'1'});;
            $('.iconbox-service-header').on('click', function(e) {
                $('.tab-content-service').css({'opacity':'0'});;
                var id = $(this).data("id");
                $(id).css({'opacity':'1'}).fadeIn('slow');
                e.preventDefault();
            });
        });
    };  
    //返回顶部
    var goTop =  function() {
        $(window).scroll(function() {
            if ( $(this).scrollTop() > 300 ) {
                $('#scroll-top').addClass('show');
            } else {
                $('#scroll-top').removeClass('show');
            }
        });

        $('#scroll-top').on('click', function() {
            $('html, body').animate({ scrollTop: 0 }, 1000 , 'easeInOutExpo' );
            return false;
        });
    };

// Dom Ready
    $(function() {
        flatRetinaLogo();
        responsiveMenu();
        headerFixed();
        accordionToggle();
        flatIsotope();
        flatOwl();
        projectGallary();
        goTop();
        $( window ).load(function() {
            tabService();
        });
        
    });
})(jQuery);