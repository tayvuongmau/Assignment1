<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/common/login/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/common/login/font-awesome.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/common/login/login.css" />

<style>
	.colorErr {
		color: red;
	}
</style>
</head>
<body>

	<div class="container-fluid">
		<div class="row no-gutter">
			<!-- The image half -->
			<div class="col-md-6 d-none d-md-flex bg-image"></div>


			<!-- The content half -->
			<div class="col-md-6 bg-light">
				<div class="login d-flex align-items-center py-5">

					<!-- Demo content-->
					<div class="container">
						<div class="row">
							<div class="col-lg-10 col-xl-7 mx-auto">
								<h3 class="display-4">
									<b>Đăng ký tài khoản</b>
								</h3>
								<br />
								<form action="SignIn" method="post">
									<table>
									<tr class="form-group mb-3" >
										<td><input style="width: 200%" id="inputUser" type="text" placeholder="Tên đăng nhập" name="newname" value="${newname}" class="form-control rounded-pill border-0 shadow-sm px-4">
										<div class="colorErr">${newnameErr}</div>
										<p/></td>
									</tr>
									<tr class="form-group mb-3">
										<td><input style="width: 200%" id="inputPassword" type="password" placeholder="Mật khẩu" name="newpassword" value="${newpassword}" class="form-control rounded-pill border-0 shadow-sm px-4 text-primary">
										<div class="colorErr">${newpasswordErr}</div>
										<p/></td>
									</tr>
									<tr class="form-group mb-3">
										<td><input style="width: 200%" id="inputEmail" type="email" placeholder="E-mail" name="newmail" value="${newmail}" class="form-control rounded-pill border-0 shadow-sm px-4">
										<div class="colorErr">${newmailErr}</div>
										<p/></td>
									</tr>
									<tr class="form-group mb-3">
										<td><input style="width: 200%" id="inputBirthday" type="date" placeholder="Ngày sinh" name="newbirthday" value='<fmt:formatDate value="${newbirthday}" pattern="yyyy-MM-dd"/>' class="form-control rounded-pill border-0 shadow-sm px-4">
										<div class="colorErr">${newbirthdayErr}</div>
										<p/></td>
									</tr>
									<tr class="form-group mb-3">
										<td><input style="width: 200%" id="inputTelephone" type="tel" placeholder="Số điện thoại" name="newtel" value="${newtel}" class="form-control rounded-pill border-0 shadow-sm px-4">
										<div class="colorErr">${newtelErr}</div>
										<p/></td>
									</tr>
									<tr>
										<td><button type="submit" class="btn btn-primary btn-block text-uppercase mb-2 rounded-pill shadow-sm">Đăng ký</button></td>
										<td><button style="width: 400%" type="reset" class="btn btn-primary btn-block text-uppercase mb-2 rounded-pill shadow-sm">Xoá</button></td>
									</tr>
									</table>
									<div class="text-center d-flex justify-content-between mt-4"> <a href="/PRJ321x-Assignment1/home.jsp" class="font-italic text-muted">					
												<i>Trở lại trang chủ</i>						
										</a>
									</div>
								</form>
							</div>
						</div>
					</div>
					<!-- End -->

				</div>
			</div>
			</div>
			</div>
			<!-- End -->
			

			<script type="text/javascript"
				src="${pageContext.request.contextPath}/common/login/bootstrap.bundle.min.js"></script>
			<script type="text/javascript"
				src="${pageContext.request.contextPath}/common/login/jquery-3.3.1.slim.min.js"></script>
</body>
</html>