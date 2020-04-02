<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>회원가입: validate 플러그인을 사용하여 유효성 검사</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <style type="text/css">
        #registerForm label.error { margin-left: 10px; color:red; }
    </style>  
   <script src="http://code.jquery.com/jquery-1.3.2.min.js" ></script>
   <!-- jQuery.validate 플러그인 삽입 -->
   <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.0/jquery.validate.min.js" ></script>
   <script type="text/javascript">
                   
      $(document).ready(function () {          
    	  
        $('#registerForm').validate({
            rules: {
                txtID:{required:true, minlength:3, remote:"Validate"},
                txtPassword: "required",
                txtPasswordConfirm: {required:true, equalTo:'#txtPassword'},               
                txtName: {required:true},
                txtEmail: {required:true, email:true},
                txtAge: {required:true, range:[1,100]} // 1~100범위
            },
            messages: {
                txtID: {
                     required:"아이디를 입력하시오.",
                     minlength: jQuery.format("아이디는 {0}자 이상 입력해주세요!"),
                     remote : jQuery.format("입력하신 {0}는 이미존재하는 아이디입니다. ")
                },
                txtPassword:"암호를 입력하시오.",
                txtPasswordConfirm: {
                    required: "암호확인를 입력하시오.",
                    equalTo:"암호를 다시 확인하세요" },
                txtName: {required:"이름을 입력하시오."},
                txtEmail: {
                    required:"이메일을 입력하시오.",
                    email:"올바른 이메일을 입력하시오."},
                txtAge: {range: "나이는 1~100"}
            },
            submitHandler: function (frm){
                frm.submit();   //유효성 검사를 통과시 전송
            },
            success: function(e){
            }
           
        });
      }); //end ready()
 
    </script>
</head>
<body>
<form id="registerForm" method="post" action="#">
    <!-- 반드시 입력이 필요한 항목은 class="required" 속성 입력 -->
    아이디 : <input type="text" id="txtID" name="txtID" /> <br />
    암호 : <input type="password" id="txtPassword" name="txtPassword" /> <br />
    암호확인 : <input type="password" id="txtPasswordConfirm" name="txtPasswordConfirm" /> <br />
    이름 : <input type="text" id="txtName" name="txtName" /> <br />
    이메일 : <input type="text" id="txtEmail" name="txtEmail" /> <br />
    나이 : <input type="text" id="txtAge" name="txtAge" value="0" /><br />
    <input type="submit" value="전송" />
</form>
</body>
</html>

