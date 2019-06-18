 $(function () {
        $("ul li").hover(function(){
            $(this).addClass('hs');
            $(this).prevAll().addClass('hs');
        },function(){
            $(this).removeClass('hs');
            $(this).prevAll().removeClass('hs');
        })

        $("ul li").click(function () {
            $(this).addClass('cs');
            $(this).prevAll().addClass('cs');
            $(this).nextAll().removeClass('cs');
        })
    })