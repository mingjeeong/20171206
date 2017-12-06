<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>
<form method="post" action="rentalpayment.do">
<div align="center" style="margin-left: 20%; margin-right: 20%">
	<!-- 상품정보 -->
	<div>
		<div align="center" class="left-w20" style="font-size: 20px; "  >상품정보</div>
		<div class="left-w80">
			<table class="table frame">
			<thead>
				<tr>
					<th>상품정보</th>
					<th>사용기간</th>
					<th>상품금액</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><img src="resources/images/${dto.getImage()}" width="120px">${dto.getCode()}&nbsp;${dto.getName()}
						<input type="hidden" id="itemId" name="itemId" value="${dto.getId()}">
						<input type="hidden" id="itemName" name="itemName" value="${dto.getName()}">
						<input type="hidden" id="itemCode" name="itemCode" value="${dto.getCode()}"></td>
					<td>${dto.getPeriod()}개월<input type="hidden" id="period" name="period" value="${dto.getPeriod()}"></td>
					<td>매월 ${price}원<input type="hidden" id="price" name="price" value="${dto.getPrice()}"></td>
				</tr>
			</tbody>
		</table>
		</div>
	</div>
	<!-- 기간설정 -->
	<div>
		<div class="left-w20" style="font-size: 20px;" >기간설정</div>
		<div class="left-w80">
			<div class="left-w10">시작일</div><div class="left-w30"><input type="date" class="form-control" id="start" name="start" title="시작일" onclick="setDate(this)" onchange="setDate(this)" required></div>
			<div class="left-w10">종료일</div><div class="left-w30"><input type="date" class="form-control" id="end" name="end" title="종료일" readonly></div>
		</div>
	</div>
	<!-- 배송지정보 -->
	<div>
		<div class="left-w20" style="font-size: 20px;" >배송지정보</div>
		<div class="left-w80">
		<table class="table frame">
		<tr>
			<th>받는 분 </th>
			<td><div class="left-w20"><input type="text" id="recipient" title="수취인" class="form-control" required></div></td>
		</tr>
		<tr>
			<th>연락처</th>
			<td>
				<div class="item_wrapper">
				<div class="left-w20">
					<select name="sb_mobile1" class="form-control" required>
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="016">016</option>
						<option value="017">017</option>
						<option value="018">018</option>
						<option value="019">019</option>
						<option value="019">02</option>
						<option value="019">031</option>
						<option value="019">032</option>
						<option value="019">033</option>
						<option value="019">041</option>
						<option value="019">042</option>
						<option value="019">043</option>
						<option value="019">044</option>
						<option value="019">051</option>
						<option value="019">052</option>
						<option value="019">053</option>
						<option value="019">054</option>
						<option value="019">055</option>
						<option value="019">061</option>
						<option value="019">062</option>
						<option value="019">063</option>
						<option value="019">064</option>
						<option value="019">070</option>
						<option value="019">080</option>
						<option value="019">0130</option>
						<option value="019">0303</option>
						<option value="019">0502</option>
						<option value="019">0503</option>
						<option value="019">0504</option>
					</select>
				</div>
				<div class="left space"> - </div>
				<div class="left-w20">
					<input type="text" class="form-control" name="mobile2" id="mobile2" title="연락처 중간" pattern="^\d{3,4}$" maxlength="4" required>
				</div><div class="left space"> - </div>
				<div class="left-w20">
					<input type="text" class="form-control" name="mobile3" id="mobile3" title="연락처 마지막" pattern="^\d{4}$" maxlength="4" required>
				</div>
				</div>
			</td>
		</tr>
		  
		<tr>
			<th>주소</th>
			<td>  
				<div class="left"><input id="tb_post" name="tb_post" type="number" class="form-control" title="우편번호" onclick="getPost()" readonly required></div>
				<div class="left"><input class="btn btn-success" type="button" value="우편번호" onclick="getPost()"><br></div>
				<input  id="tb_addr" name="tb_addr" type="text" class="form-control" title="주소" onclick="getPost()" readonly required>
				<input  id="tb_addD" name="tb_addD" type="text" class="form-control" title="상세주소" onfocus="getAddressCheck()" required>
			</td>
		</tr>
	</table>
		</div>
	</div>
	<!-- 결제수단 -->
	<div>
		<div class="left-w20" style="font-size: 20px;" >결제수단</div>
		<div class="left-w80">
			<div class="left-w30">
				<input type="radio" name="rb_payment" id="rb_payment" onclick="showCard()" value="card" required>신용카드/체크카드 결제
			</div>
			<div class="left-w30">
				<input type="radio" name="rb_payment" id="rb_payment" onclick="showAccount()" value="account" required>계좌이체
			</div>
			<!--  <div class="left-w30">
				<input type="radio" name="rb_payment" id="rb_payment" onclick="showCash()" value="cash" required>현금결제
			</div>
			-->
			<br>
			<div id="paymentCard" class="sb_payment ">
				<div class="left-w10">카드종류</div> 
				<div class="left-w30">
					<select name="sb_card" id="sb_card" class="form-control" >
						<option value="">카드를 선택해주세요</option>
						<option value="현대카드">현대카드</option>
						<option value="KB국민카드">KB국민카드</option>
						<option value="신한카드">신한카드</option>
						<option value="삼성카드">삼성카드</option>
						<option value="롯데카드">롯데카드</option>
						<option value="우리카드">우리카드</option>
						<option value="하나카드">하나카드</option>
						<option value="비씨카드">비씨카드</option>
						<option value="NH농협카드">NH농협카드</option>
						<option value="씨티카드">씨티카드</option>
						<option value="카카오뱅크">카카오뱅크</option>
					</select>
				</div>
				<div class="left-w30">
					<input class="form-control" type="text" name="cardNum" title="카드번호" id="cardNum" placeholder="'-'없이 카드번호 입력" pattern="^\d{16}$" maxlength="16">
				</div>
			</div>
			<div class="sb_payment" id="paymentAccount">
				<div class="left-w10">은행종류</div>
				<div class="left-w30">
					<select name="sb_bank" id="sb_bank" class="form-control" >
						<option value="">은행을 선택해주세요</option>
						<option value="농협">농협</option>
						<option value="우리은행">우리은행</option>
						<option value="신한은행">신한은행</option>
						<option value="국민은행">국민은행</option>
						<option value="하나은행">하나은행</option>
						<option value="외환은행">외환은행</option>
						<option value="씨티은행">씨티은행</option>
						<option value="기업은행">기업은행</option>
						<option value="우체국">우체국</option>
						<option value="부산은행">부산은행</option>
						<option value="SC은행">SC은행</option>
					</select>
				</div>
				<div class="left-w30">
					<input type="text" class="form-control" name="accountNum" title="계좌번호" id="accountNum" placeholder="'-'없이 계좌번호 입력">
				</div>
			</div>
		</div>
	</div>
	<input type="submit" class="btn btn-primary btn-sm" value="결제하기" > 
</div>
</form>