<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>only_test</title>
</head>
<body>
	<input type="button" value="test" onclick="test()" />
</body>
<script type="text/javascript" src="jquery-3.1.0.min.js"></script>
<script type="text/javascript">
	function test() {
		$.ajax({
			url:'../TestMaven/shiyang/testSpring.json',
			type:'post',
			datatype:'json',
			asyn:false,
			success:function(map){
				var str = map.str;
				alert(str);
			},
		    error:function(map){
		    	console.log("失败！")
		    }
		})
	}
</script>
</html>