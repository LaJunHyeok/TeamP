<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SAFE SEOUL</title>
<style>
.left {
	left: 50%;
	float: left;
	width: 50%;
}

.right {
	border-left: 1px solid gray;
	height: 100%;
	float: left;
	width: 50%;
}
</style>
</head>
<header>
	<!-- 메뉴 바 -->
	<jsp:include page="../menubar.jsp" flush="false" />

</header>

<body>
	<br>
	<br>
	<br>
	<!-- 메인페이지 (좌측엔 시각화자료, 우측엔 범죄토픽 크롤링데이터 시각화) -->
	<div class="container">
		<div class="left">
			<img src="seoul.png" width="80%" height="80%">
		</div>
		<div class="right">
			<ul class="topic_li">
				<A
					href=https://news.naver.com/main/read.nhn?mode=LSD&mid=sec&sid1=102&oid=353&aid=0000036890>“<b>범죄</b>
					예방 ‘셉테드’ 법적 근거 필요”
				</A>
				<br></br>
				<A
					href=http://www.weeklytoday.com/news/articleView.html?idxno=184079>노원구,
					'일반주택가 <b>범죄</b>제로화' 사업 펼쳐 주요 <b>5대 범죄</b> 뚝↓
				</A>
				<br></br>
				<A
					href=https://news.naver.com/main/read.nhn?mode=LSD&mid=sec&sid1=102&oid=277&aid=0004707573>송파구,
					재난관리 우수 기관 선정…<b>서울시</b> 유일 4연속
				</A>
				<br></br>
				<A
					href=https://news.naver.com/main/read.nhn?mode=LSD&mid=sec&sid1=102&oid=003&aid=0009879202>노원구,
					일반주택가 <b>범죄</b>제로화로 <b>5대 범죄</b> 줄였다
				</A>
				<br></br>
				<A
					href=https://news.naver.com/main/read.nhn?mode=LSD&mid=sec&sid1=102&oid=001&aid=0011424288>검찰,
					역학조사 거부·집회금지 위반 등 '<b>5대 범죄</b>' 선제대응
				</A>
				<br></br>
				<A
					href=https://news.naver.com/main/read.nhn?mode=LSD&mid=sec&sid1=102&oid=081&aid=0003057184>‘공동현관
					도어록’ 주택가 <b>범죄</b> 절반 줄였다
				</A>
				<br></br>
				<A
					href=https://news.naver.com/main/read.nhn?mode=LSD&mid=sec&sid1=102&oid=055&aid=0000775995><b>서울시</b>
					여성 43%, 디지털 성<b>범죄</b> 피해 경험했다</A>
				<br></br>
				<A
					href=https://news.naver.com/main/read.nhn?mode=LSD&mid=sec&sid1=102&oid=001&aid=0011424433>검찰,
					역학조사 거부·집회금지 위반 등 '<b>5대 범죄</b>' 선제대응(종합)
				</A>
				<br></br>
				<A
					href=https://news.naver.com/main/read.nhn?mode=LSD&mid=sec&sid1=102&oid=022&aid=0003428770>가로등
					범위 1㎢ 넓히니 야간<b>범죄</b> 16% ‘뚝’ [밀착취재]
				</A>
				<br></br>
				<A
					href=http://kookbang.dema.mil.kr/newsWeb/20200109/4/BBSMSTR_000000010031/view.do>가로등만
					설치해도 <b>범죄</b> 16%↓
				</A>
				<br></br>
			</ul>
		</div>
	</div>
</body>
<footer>
	<!-- footer -->
	<jsp:include page="../footer.jsp" flush="false" />
</footer>
</html>