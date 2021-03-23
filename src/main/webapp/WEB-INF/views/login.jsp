<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<head lang="en">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!-- Bootstrap styles -->
	<link href="resources/assets/bootstrap/css/login.css" rel="stylesheet">
	<style>
	    .token {
	        display: block;
	        width: 350px;
	        height: 200px;
	        padding-rigth: 40px;
            white-space: pre-line;
	    }
		.modal-window {
			position: fixed;
			background-color: rgba(255, 255, 255, 0.25);
			top: 0;
			right: 0;
			bottom: 0;
			left: 0;
			z-index: 999;
			visibility: hidden;
			opacity: 0;
			pointer-events: none;
			transition: all 0.3s;
		}
		.modal-window.active {
			 visibility: visible;
			 opacity: 1;
			 pointer-events: auto;
		 }
		.modal-window > div, .modal-window > input {
			  width: 400px;
			  position: absolute;
			  top: 50%;
			  left: 50%;
			  transform: translate(-50%, -50%);
			  padding: 2em;
			  background: white;
		  }
		header {
			font-weight: bold;
		}
		.modal-window h1 {
			font-size: 150%;
			margin: 0 0 15px;
		}
		.modal-window .modal-close {
			color: #aaa;
			line-height: 50px;
			font-size: 80%;
			position: absolute;
			right: 0;
			text-align: center;
			top: 0;
			width: 70px;
			text-decoration: none;
		}
		.modal-window input.modal-content {
			border: 1px solid #000;
			width: 350px;
			height: 20px;
			padding:  2px;
			/*display: block;*/
			/*width: 400px;*/
			/*height: 200px;*/
			/*word-wrap: break-word;*/
		}
		.modal-close:hover {
			color: black;
		}
		.modal-content{

			word-wrap: break-word;
		}
		.modal-copy {
			color: #fff;
			background-color: #888;
			border-radius: 3px;
			padding: 2px;
			margin-bottom: 4px;
		}
		.move-swagger {
			width: 100%;
			height: 50px;
			border-radius: 25px;
			background-color: #000;
			color: #fff;
			font-size: 15px;
			margin-top: 18px;
		}
	</style>
</head>
<body>
<script type="text/javascript" src="resources/assets/js/jquery-3.6.0.min.js" defer></script>
<script type="text/javascript" src="resources/assets/js/login.js" defer></script>
<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-pic js-tilt" data-tilt>
					<img src="https://colorlib.com/etc/lf/Login_v1/images/img-01.png" alt="IMG">
				</div>

				<form class="login100-form validate-form" >
					<span class="login100-form-title">
						Member Login
					</span>
					<div class="wrap-input100 validate-input" data-validate = "Valid email is wrong: ex@abc.xyz">
						<input class="input100" type="text" name="email" placeholder="Email">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
					</div>

					<div class="wrap-input100 validate-input" data-validate = "Password is wrong">
						<input class="input100" type="password" name="pass" placeholder="Password">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
					</div>

					<div class="container-login100-form-btn">
						<input type="submit" value="login" class="login100-form-btn">
					</div>

					<div class="text-center p-t-12">
						<span class="txt1">
							Forgot
						</span>
						<a class="txt2" href="#">
							Username / Password?
						</a>
					</div>
					<button class="move-swagger">MOVE TO SWAGGER</button>
					<div id="open-modal" class="modal-window">

					</div>




					<div class="text-center p-t-136">
						<a class="txt2" href="#">
							Create your Account
							<i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
						</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>