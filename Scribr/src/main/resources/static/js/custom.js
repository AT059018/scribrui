
var highliteconfig = {'accuracy':'exactly','separateWordSearch':false};

var words = [
	"management report",
	"management report.",
	"tomorrow",
	"tomorrow."
];

function doHighLite($ctx){
	for(var i=0;i<words.length;i++){
		$ctx.mark(words[i] , highliteconfig);
	}
};

var socket = new SockJS('/gs-websocket');
stompClient = Stomp.over(socket);
stompClient.connect({}, function (frame) {
    //setConnected(true);
    console.log('Connected: ' + frame);
    stompClient.subscribe('/topic/sentence', function (sentence) {
    	var response = JSON.parse(sentence.body);
    	
    	var $temp = $(".media-list li:eq(0)").clone();
    	$(".media-body:eq(1) span",$temp).text(response.sentence);
    	if(response.task===true){
    		$(".paperclip",$temp).addClass("glyphicon-paperclip");
    		$(".media-body .media-body span",$temp).addClass("action-font");
    	} else {
    		$(".media-body .media-body span",$temp).addClass("transcript-font");
    	}
    	$("small",$temp).text([response.username,(new Date(response.created)).toLocaleTimeString()].join(" | "));
    	$temp.show();
    	doHighLite($temp);
    	$(".media-list:eq(0)").append($temp);
    	$(".current-chat-area").animate({ scrollTop: $('.current-chat-area').prop("scrollHeight")}, 1000);
    });
});

$(function(){
	doHighLite($("ul.media-list li .media-body .media-body span"));
});
