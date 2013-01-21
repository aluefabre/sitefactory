var questionModule = new function() {
    this.registerEvents = function() {
    	$( "#addtag" ).on( "autocompleteselect", function( event, ui ) {
    		var newtag = ui.item.value;
    		var oldtags = $("#tags").val();
    		var oldtagarray=oldtags.split(" "); 
    		for(x in oldtagarray){
    			if(newtag===oldtagarray[x]){
    				return;
    			}
    		}
    		$("#tags").val(oldtags + " " + newtag);
    		$("#tags").after('<span>'+newtag+'  </span>');
    	} );
    };
};
$(document).ready(
	function() {
		questionModule.registerEvents();
	}
);