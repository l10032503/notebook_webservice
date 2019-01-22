var source = $("#pagination-template").html();
var template = Handlebars.compile(source);
Handlebars.registerHelper('add number', function (number) {
    return number + 1;
});
Handlebars.registerHelper('sub number', function (number){
    return number - 1;
});
$("#pagination").html(template);
