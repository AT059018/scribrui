
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
    	$(".media-list:eq(0)").append($temp);
    	$temp.show();
    	$(".current-chat-area").animate({ scrollTop: $('.current-chat-area').prop("scrollHeight")}, 1000);
    });
});
