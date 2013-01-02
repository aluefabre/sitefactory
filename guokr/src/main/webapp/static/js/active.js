var activeModule = new function() {

    var contextBase = "/guokr";

    this.decorateActive = function() {
    	var location = window.location.pathname;
    	$('.activable').each(function(index) {
    		if(contextBase + $(this).attr('activetrigger')==location){
        		$(this).toggleClass("active");
    		}
    	});
    };
};