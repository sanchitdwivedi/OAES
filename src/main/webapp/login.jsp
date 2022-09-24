<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <title>Insert title here</title>
</head>
<body>
<div align="center">
    <input type="checkbox" name="tandc" id="tandc" value="1" required>Do you accept the terms and conditions?
    <input type="checkbox" name="mic" id="mic" value="2" required>Please provide webcam and microphone access.
    <br>
    <button type="submit" class="btn btn-primary" onclick="javascript:failed();">Submit</button>
<%--    <h5 style="color: darkred">You cannot continue without accepting the terms and conditions of the exam</h5>--%>
</div>
</body>
</html>

<script type="text/javascript">
    function failed(){
        alert("Failed to access webcam and microphone");
    }
</script>