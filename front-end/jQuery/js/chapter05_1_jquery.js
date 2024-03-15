$().ready(function () {
    
    $(".package-button-area").on("click", function() {
        var package = $(this).closest(".package");
        var amount = $(this).closest(".package").data("price");
        var currency = $(this).closest(".package").data("currency");

        var price = $("<p>From " + currency + amount + "</p>");
        price.on("click", function() {
            var text = $(this).text();
            alert(text);
        });
        
        package.append(price);
        $(this).closest(".package-button-area").remove();
    });

});