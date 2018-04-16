<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>


<style>


Basic input element using psuedo classes
*/

html {
  font-family: 'Lora', sans-serif;
  width: 100%;
}

body {
	background-image:url('data:image/jpeg;base64,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');
	background-repeat: no-repeat;
   background-size:100%;
   
  margin: 5% auto 0 auto;
  width: 90%;
  max-width: 1125px;
}

h1 {
  font-size: 28px;
  margin-bottom: 2.5%;
}

input,
span,
label,
textarea {
  font-family: 'Ubuntu', sans-serif;
  display: block;
  margin: 10px;
  padding: 5px;
  border: none;
  font-size: 22px;
}


input:focus {
  outline: 0;
}
/* Question */

input.question,
textarea.question {
  font-size: 48px;
  font-weight: 300;
  border-radius: 2px;
  margin: 0;
  border: none;
  width: 80%;
  background: rgba(0, 0, 0, 0);
  transition: padding-top 0.2s ease, margin-top 0.2s ease;
  overflow-x: hidden; /* Hack to make "rows" attribute apply in Firefox. */
}
/* Underline and Placeholder */

input.question + label,
textarea.question + label {
  display: block;
  position: relative;
  white-space: nowrap;
  padding: 0;
  margin: 0;
  width: 10%;
  border-top: 1px solid red;
  -webkit-transition: width 0.4s ease;
  transition: width 0.4s ease;
  height: 0px;
}

input.question:focus + label,
textarea.question:focus + label {
  width: 80%;
}

input.question:focus,
input.question:valid {
  padding-top: 35px;
}

textarea.question:valid,
textarea.question:focus {
  margin-top: 35px;
}

input.question:focus + label > span,
input.question:valid + label > span {
  top: -100px;
  font-size: 22px;
  color: #333;
}

textarea.question:focus + label > span,
textarea.question:valid + label > span {
  top: -150px;
  font-size: 22px;
  color: #333;
}

input.question:valid + label,
textarea.question:valid + label {
  border-color: green;
}

input.question:invalid,
textarea.question:invalid {
  box-shadow: none;
}

input.question + label > span,
textarea.question + label > span {
  font-weight: 300;
  margin: 0;
  position: absolute;
  color: #8F8F8F;
  font-size: 48px;
  top: -66px;
  left: 0px;
  z-index: -1;
  -webkit-transition: top 0.2s ease, font-size 0.2s ease, color 0.2s ease;
  transition: top 0.2s ease, font-size 0.2s ease, color 0.2s ease;
}

input[type="submit"] {
  -webkit-transition: opacity 0.2s ease, background 0.2s ease;
  transition: opacity 0.2s ease, background 0.2s ease;
  display: block;
  opacity: 0;
  margin: 10px 0 0 0;
  padding: 10px;
  cursor: pointer;
}

input[type="submit"]:hover {
  background: #EEE;
}

input[type="submit"]:active {
  background: #999;
}

input.question:valid ~ input[type="submit"], textarea.question:valid ~ input[type="submit"] {
  -webkit-animation: appear 1s forwards;
  animation: appear 1s forwards;
}

input.question:invalid ~ input[type="submit"], textarea.question:invalid ~ input[type="submit"] {
  display: none;
}

@-webkit-keyframes appear {
  100% {
    opacity: 1;
  }
}

@keyframes appear {
  100% {
    opacity: 1;
  }
}

</style>
<h2>${message}</h2>
<h1>Login</h1>
<form method="post" action='login.htm'>
  <input type="text" name="email" class="question" id="nme" required autocomplete="off" />
  <label for="nme"><span>Enter your email</span></label><br><br><br>
  <input type="password" name="password" class="question" id="msg" required autocomplete="off"/>
  <label for="msg"><span>Enter your password</span></label>
  <input type="submit" value="Submit!" />
</form>
<br><br>
<%request.setAttribute("heading", "Registration Page"); %>
<a href="Register.html">Click here to register</a>
