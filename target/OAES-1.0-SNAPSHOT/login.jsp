<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 9/24/2022
  Time: 9:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<HTML>
<HEAD>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <TITLE>Submitting Radio Buttons</TITLE>
</HEAD>

<BODY>
<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
<H1>Login</H1>
<FORM ACTION="login" METHOD="post">
    <input type="radio" onclick="javascript:yesnoCheck();" name="yesno" id="userIDCheck" value="1"  required>Login by User ID
    <input type="radio" onclick="javascript:yesnoCheck();" name="yesno" id="emailCheck" value="2" checked required> Login by Email
    <div id="ifYes" style="display:block">
        <div class="form-group">
            <label for="email">Email:</label> <input type="text"
                                                         class="form-control" id="email" placeholder="Email"
                                                         name="email">
        </div>
    </div>
    <div id="ifNo" style="display: none">
        <div class="form-group">
            <label for="userID">User ID:</label> <input type="text"
                                                         class="form-control" id="userID" placeholder="User ID"
                                                         name="userID">
        </div>
    </div>
    <div class="form-group" id="pass">
        <label for="password">Password:</label> <input type="password"
                                                       class="form-control" id="password" placeholder="Password"
                                                       name="password" required>
    </div>
    <br>
    <button type="submit" class="btn btn-primary">Submit</button>
<%--    <br>--%>
<%--    <h5 style="color: darkred">${msg}</h5>--%>
</FORM>
</div>
</BODY>
</HTML>

<script>
    function yesnoCheck() {
        if (document.getElementById('userIDCheck').checked) {
            document.getElementById('ifYes').style.display = 'none';
            document.getElementById('ifNo').style.display = 'block';
        }
        else{
            document.getElementById('ifYes').style.display = 'block';
            document.getElementById('ifNo').style.display = 'none';
        }
        // document.getElementById('pass').style.display = 'block';
    }
</script>
