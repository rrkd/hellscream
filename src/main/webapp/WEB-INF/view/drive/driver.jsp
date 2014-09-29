<div>
    <a id="testQuoteEmail" href="">test quote email</a>
</div>
<script type="text/javascript">
    jQuery(document).ready(function ($) {
        $('#testQuoteEmail').click(function(){
            $.ajax({
                type:"POST",
                url:"/ws/email/quote",
                data:generateQuote(),
                contentType:'application/json',
                success:function (data) {
                    if (data.status == 'OK') alert('Quote has been added');
                    else alert('Failed adding quote: ' + data.status + ', ' + data.errorMessage);
                }
            });
        });
    });
    function generateQuote() {
        var quote = {
            toAddressList:['rrkd.platform@gmail.com'],
            quoteURL:'http://fit-territory-708.appspot.com/home',
            quote: {
                categoryList:['Wattle GROVE','Sydney'],
                title:"Test quote",
                description:"This is the test quote."
            }
        };
        return JSON.stringify(quote);
    }
</script>