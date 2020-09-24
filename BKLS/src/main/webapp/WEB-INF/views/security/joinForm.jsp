<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<header>
<!-- 메뉴 바 -->
<jsp:include page="../menubar.jsp" flush="false" />

</header>

<body>

	<!--  회원가입창 -->

		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-8 order-md-1">

					<br> <br>
					<p style="text-align: center">
						<font size="6" color="#5bc0de">회원 가입</font>
						
					<form th:action="@{/joinOk}" method="post" class="needs-validation" novalidate>
						<div class="row"></div>
						
						<div class="mb-3">
							<label for="name">이름</label> <input type="text"
								class="form-control" name="name" placeholder="필수 입력 값" value=""
								required>
							<div class="invalid-feedback">Valid first name is required.
							</div>
						</div>

						<div class="mb-3">
							<label for="username">회원 아이디</label>
							<div class="input-group">
								<div class="input-group-prepend">
									<!-- <span class="input-group-text">@</span> -->
								</div>
								<input type="text" class="form-control" name="id"
									placeholder="필수 입력 값" required>
								<div class="invalid-feedback" style="width: 100%;">Your
									username is required.</div>
							</div>
						</div>

						<div class="mb-3">
							<label for="pw">비밀번호</label> <input type="password"
								class="form-control" name="pw" placeholder="필수 입력 값" value=""
								required>
							<div class="invalid-feedback">Valid first name is required.
							</div>
						</div>

						<div class="mb-3">
							<label for="pw_check">비밀번호 확인</label> <input type="password"
								class="form-control" name="pw_check" placeholder="필수 입력 값"
								value="" required>
							<div class="invalid-feedback">Valid first name is required.
							</div>
						</div>

						<div class="mb-3">
							<label for="eMail">이메일 <span class="text-muted">(필수
									입력 값)</span></label> <input type="email" class="form-control" name="eMail"
								placeholder="safe@seoul.com">
							<div class="invalid-feedback">Please enter a valid email
								address for shipping updates.</div>
						</div>

						<div class="mb-3">
							<label for="address">주소</label> <input type="text"
								class="form-control" name="address" placeholder="선택 사항" required>
							<input type="text" class="form-control" name="address"
								placeholder="선택 사항" required>
							<div class="invalid-feedback">Please enter your shipping
								address.</div>
						</div>

						<hr class="mb-4">

						<!-- <hr class="mb-4">  -->
						<button class="btn btn-info btn-lg btn-block" type="submit"
							>가입 완료하기</button>
						<button class="btn btn-info btn-lg btn-block" type="button"
							onclick="history.go(-1)">돌아가기</button>
					</form>
				</div>
			</div>
		</div>
</body>
<footer>
    <!-- footer -->
    <jsp:include page="../footer.jsp" flush="false" />
</footer>
</html>