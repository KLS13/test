<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>JSP</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="<c:url value="/resources/js/sockjs-0.3.4.js"/>"></script>
<script type="text/javascript">
    $(document).ready(function() {
        $("#sendBtn").click(function() {
        	if( $("#message").val() == "") {
        		alert("1글자 이상을 입력해주세요");
        		return false;
        	}
            sendMessage();
            $("#message").val("");
        });
    });
    var sock;
    sock = new SockJS("<c:url value="/echo"/>");
    sock.onmessage = onMessage;
    sock.onclose = onClose;
    
    function sendMessage() {
        sock.send($("#message").val());
    }
    function onMessage(evt) {

        var data = evt.data;
        $("#data").append(data + "<br/>");
        //sock.close();
    }
    function onClose(evt) {

        $("#data").append("연결 끊김");
    }
</script>
</head>
<body>
	<h1>경제나눔 이야기</h1>
    <input type="text" id="message" />
    <input type="button" id="sendBtn" value="전송" />
    <div id="data"></div>
</body>
</html>
