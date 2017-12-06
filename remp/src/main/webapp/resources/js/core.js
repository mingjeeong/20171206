/*
* ReMP에서 사용될 기본 자바스크립트 태그
 * 작성자 : 김재림
 * 버전 v 1.0
 */

/* 서브메뉴 열기 */
var operationMod = "debug";

function getNavSubMenu(targetElement) {
	var targetId = "#" + $(targetElement).data("module");
	
	if ($(targetId).css("display") == "flex") {
		$(targetId).slideUp('fast');
		return;
	}
	$("#rental").hide(0);	
	$("#asset").hide(0);
	$("#EIS").hide(0);
	$("#member").hide(0);
	$(targetId).slideDown('fast');
}

/*비밀번호변경 확인*/
function checkPw(){
	if($("#newpw").val() != $("#checkpw").val()){
		alert("입력하신 새 비밀번호 불일치");
		return false;
	} else {
		document.changepwform.submit();
	}
}

/*rentalDetail 품목 아이디 가져오기*/
function getItemId(element){
	var itemId = $(element).data("code");
	location.href = "rentaldetail.do?itemId="+itemId;
}

/*rental품목 아이디 가져오기*/
function getId(element){
	var itemId = $(element).data("code");
	location.href = "rental.do?itemId="+itemId;
}

/*결제수단  카드선택*/
function showCard(){
	$("#paymentCard").css("display","block");
	$("#paymentAccount").css("display","none");
	$("#paymentCash").css("display","none");
	$("#paymentCard input").attr("required",true);
	$("#paymentCard select").attr("required",true);
	$("#paymentCash input").attr("required",false);
	$("#paymentCash select").attr("required",false);
	$("#paymentCash select").val('');
	$("#paymentCash input").val('');
}

/*결제수단 계좌이체선택*/
function showAccount(){
	$("#paymentCard").css("display","none");
	$("#paymentAccount").css("display","block");
	$("#paymentCash").css("display","none");
	$("#paymentCash input").attr("required",true);
	$("#paymentCash select").attr("required",true);
	$("#paymentCard input").attr("required",false);
	$("#paymentCard select").attr("required",false);
	$("#paymentCard select").val('');
	$("#paymentCard input").val('');
}

function showCash(){
	$("#paymentCard").css("display","none");
	$("#paymentAccount").css("display","none");
	$("#paymentCash").css("display","block");
	$("#paymentCash input").attr("required",false);
	$("#paymentCash select").attr("required",false);
	$("#paymentCard input").attr("required",false);
	$("#paymentCard select").attr("required",false);
	$("#paymentCard select").val('');
	$("#paymentCard input").val('');
	$("#paymentCash select").val('');
	$("#paymentCash input").val('');
}

/*렌탈 기간 설정*/
function setDate(element){
	var startDate = $(element).val().split("-");
	var year = parseInt(startDate[0])+($('#period').val()/12);
	var month = startDate[1];
	var date = startDate[2];
	$("#end").val(year+'-'+month+'-'+date);
	var today = new Date();
	year = today.getFullYear();
	month = today.getMonth()+1;
	date = today.getDate();
	if(month < 10) {
		month = '0' + month;
	}
	if(date < 10) {
		date = '0' + date;
	}
	$("#start").attr('min', year+'-'+month+'-'+date);
}
/* 점검결과조회 날짜 선택*/
function dateLock(element){
	var startDate = $(element).val().split("-");
	var year = parseInt(startDate[0]);
	var month = parseInt(startDate[1]);
	var date = parseInt(startDate[2]);
	console.log(year);
	console.log(month);
	console.log(date);
	if(month < 10) {
		month = '0' + month;
	}
	if(date < 10) {
		date = '0' + date;
	}
	$("#end").attr('min', year+'-'+month+'-'+date);
}
/* ajax 관련 설정 */
var loading = {
	on: $('<div />', {class: 'loading'}),
}

/* head_detail에서 head 일련번호 세팅하기 */
var headSeq = null;
var selectedHeadSeq = null;

function setHeadSeqRequest(takeElement) {
	var callbackfunction = $(takeElement).data("fn-name");//data-fn-name=?
	headSeq = $(takeElement).data("key");//data-key=?
	debug(headSeq);
	$(takeElement).parents("table")
		.children()
		.children(".table-success")
		.removeClass("table-success");
	$(takeElement).addClass("table-success");
	debug(callbackfunction+"(headSeq)");
	eval(callbackfunction+"(headSeq)");
}

function getHeadSeqRequest(){
	return headSeq;
}

/* 입고요청조회 */
function getInputRequest(key) {
	var takeData = key;
	var requestURL = "getinputrequest.do";
	var sData = JSON.stringify({
		inputState:takeData
	});
	debug(sData);
	debug(requestURL);
	$.ajax({
		type : "POST",
		url : requestURL,
		data : sData,
		dataType : "JSON",
		async: true,
		contentType:'application/json;charset=UTF-8',
		beforeSend: function() {
			$("#content").append(loading.on);
		},
		success : function(rData) {
			var ihtml = "";
			debug(rData.length);
			debug(rData);
			for (var i = 0; i < rData.length; i++) {
				var row = rData[i];
				ihtml += "<tr data-input-id='"+ row.id
					+"' data-item-name='"+ row.name
					+"' data-item-count='"+ row.count
					+"' data-item-state='"+ row.state
					+"' data-item-date='"+ row.date
					+"' data-item-delivery='"+ row.delivery
					+"'>";
				ihtml += "<td>"+row.id+
					"</td><td>"+row.name+
					"</td><td>"+row.count+
					"</td><td>"+row.date+
					"</td><td>"+row.delivery+
					"</td><td><button class='btn btn-primary btn-sm' onclick='inputRequest(this)'>입고</button></td></tr>";
			}
			debug(ihtml);
			$("#inputList").html(ihtml);
			if ($(".table-success").data("flag") == "true") {
				$("table button").attr("disabled", true);
			}
		},
		error : function() {
			alert("검색실패!");
		},
		complete : function() {
			$(".loading").remove();
		}
	});
}
/* 요청입고 등록 */
function inputRequest(takeElement) {
	var requestURL = "setinputstate.do";
	var sData = JSON.stringify({
		id:$(takeElement).parents("tr").data("input-id"),
		state:$(takeElement).parents("tr").data("item-state")
	});
	debug(sData);
	debug(requestURL);
	$.ajax({
		type : "POST",
		url : requestURL,
		data : sData,
		dataType : "JSON",
		async: true,
		contentType:'application/json;charset=UTF-8',
		beforeSend: function() {
			$("#content").append(loading.on);
		},
		success : function(rData) {
			alert(rData.result);
			$(takeElement).attr("disabled", true);
		},
		error : function() {
			alert("입고실패!");
		},
		complete : function() {
			$(".loading").remove();
		}
	});
}

/* 요청 입고 검색 */
function searchInputRequest() {
	var requestURL = "searchinputrequest.do";
	var sData = JSON.stringify({
		state:getHeadSeqRequest(),
		name:$("#searchInput").val()
	});
	debug(sData);
	debug(requestURL);
	$.ajax({
		type : "POST",
		url : requestURL,
		data : sData,
		dataType : "JSON",
		async: true,
		contentType:'application/json;charset=UTF-8',
		beforeSend: function() {
			$("#content").append(loading.on);
		},
		success : function(rData) {
			var ihtml = "";
			debug(rData.length);
			debug(rData);
			for (var i = 0; i < rData.length; i++) {
				var row = rData[i];
				ihtml += "<tr data-input-id='"+ row.id
					+"' data-item-name='"+ row.name
					+"' data-item-count='"+ row.count
					+"' data-item-state='"+ row.state
					+"' data-item-date='"+ row.date
					+"' data-item-delivery='"+ row.delivery
					+"'>";
				ihtml += "<td>"+row.id+
					"</td><td>"+row.name+
					"</td><td>"+row.count+
					"</td><td>"+row.date+
					"</td><td>"+row.delivery+
					"</td><td><button class='btn btn-primary btn-sm' onclick='inputRequest(this)'>입고</button></td></tr>";
			}
			debug(ihtml);
			$("#inputList").html(ihtml);
			if ($(".table-success").data("flag") == "true") {
				$("table button").attr("disabled", true);
			}
		},
		error : function() {
			alert("검색실패!");
		},
		complete : function() {
			$(".loading").remove();
		}
	});
}
/* 입고 자산상태별 조회*/
function getInput(key){
	var takeData = key;
	var requestURL = "getinput.do";
	var sData = JSON.stringify({
		state:takeData
	});
	debug(sData);
	debug(requestURL);
	$.ajax({
		type : "POST",
		url : requestURL,
		data : sData,
		dataType : "JSON",
		async: true,
		contentType:'application/json;charset=UTF-8',
		beforeSend: function() {
			$("#content").append(loading.on);
		},
		success : function(rData) {
			var ihtml = "";
			debug(rData.length);
			debug(rData);
			for (var i = 0; i < rData.length; i++) {
				var row = rData[i];
				
				ihtml += "<tr data-input-id='"+ row.id
					+"' data-item-name='"+ row.name
					+"' data-item-count='"+ row.count
					+"' data-item-state='"+ row.state
					+"' data-item-date='"+ row.date
					+"' data-item-delivery='"+ row.delivery
					+"' data-item-qr='"+ row.qr+"'>";
				ihtml += "<td>"+row.id+
					"</td><td>"+row.name+
					"</td><td>"+row.count+
					"</td><td>"+row.date+
					"</td><td>"+row.delivery+
					"</td><td></td></tr>";
			}
			debug(ihtml);
			$("#inputList").html(ihtml);
			if ($(".table-success").data("flag") == "true") {
				$("table button").attr("disabled", true);
			}
		},
		error : function() {
			alert("검색실패!");
		},
		complete : function() {
			$(".loading").remove();
		}
	});
}
/* 입고 제품명 검색 조회*/
function searchInput(){
	var requestURL = "searchinput.do";
	var sData = JSON.stringify({
		state:getHeadSeqRequest(),
		name:$("#searchInput").val()
	});
	debug(sData);
	debug(requestURL);
	$.ajax({
		type : "POST",
		url : requestURL,
		data : sData,
		dataType : "JSON",
		async: true,
		contentType:'application/json;charset=UTF-8',
		beforeSend: function() {
			$("#content").append(loading.on);
		},
		success : function(rData) {
			var ihtml = "";
			debug(rData.length);
			debug(rData);
			for (var i = 0; i < rData.length; i++) {
				var row = rData[i];
				ihtml += "<tr data-input-id='"+ row.id
					+"' data-item-name='"+ row.name
					+"' data-item-count='"+ row.count
					+"' data-item-state='"+ row.state
					+"' data-item-date='"+ row.date
					+"' data-item-delivery='"+ row.delivery
					+"' data-item-qr='"+ row.qr+"'>";
				ihtml += "<td>"+row.id+
					"</td><td>"+row.name+
					"</td><td>"+row.count+
					"</td><td>"+row.date+
					"</td><td>"+row.delivery+
					"</td><td></td></tr>";
			}
			debug(ihtml);
			$("#inputList").html(ihtml);
		},
		error : function() {
			alert("검색실패!");
		},
		complete : function() {
			$(".loading").remove();
		}
	});
}

/* 점검대기 정보 검색 조회 */
function getRepairList(){
	var requestURL = "getrepairlist.do";
	var sData = JSON.stringify({
		keyword:$("#keyword").val(),
		select:$("#type").val()
	});
	debug(sData);
	debug(requestURL);
	$.ajax({
		type : "POST",
		url : requestURL,
		data : sData,
		dataType : "JSON",
		async: true,
		contentType:'application/json;charset=UTF-8',
		beforeSend: function() {
			$("#content").append(loading.on);
		},
		success : function(rData) {
			var ihtml = "";
			debug(rData.length);
			debug(rData);
			for (var i = 0; i < rData.length; i++) {
				ihtml += "<tr data-fn-name='getrepairform' data-key='"+rData[i].id+"' onclick='setHeadSeqRequest(this)'>";
				ihtml += "<td>"+rData[i].id+"</td><td>"+rData[i].name+"</td>"+"<td>"+rData[i].state+"</td><td>"+rData[i].date+"</td>";
				ihtml += "</tr>";
			}
			debug(ihtml);
			$("#repairList tbody").html(ihtml);
			$('.loading').remove();
		},
		error : function() {
		},
		complete : function() {
			$(".loading").remove();
		}
	});
}
/* 점검내역 폼 가져오기*/
function getrepairform(key){
	var takeData = key;
	var requestURL = "getrepairform.do";
	var sData = JSON.stringify({
		id:takeData
	});
	debug(sData);
	debug(requestURL);
	$.ajax({
		type : "POST",
		url : requestURL,
		data : sData,
		dataType : "JSON",
		async: true,
		contentType:'application/json;charset=UTF-8',
		beforeSend: function() {
			$("#content").append(loading.on);
		},
		success : function(rData) {
			$("#productId").val(rData.productId);
			$("#itemId").val(rData.itemId);
			$("#itemName").val(rData.itemName);
			$("#repairDate").val(rData.todayDate);
		},
		error : function() {
			alert("실패!");
		},
		complete : function() {
			$(".loading").remove();
		}
	});
}

function useParts(){
	document.getElementById("useParts").value += $("#parts").val()+" ";
}

function resetParts(){
	document.getElementById("useParts").value = "";
}

function resetForm(){
	$("#repairContents").val('');
	$("#useParts").val('');
	$("#repairSort").val('');
	$("#parts").val('');
}

/* 점검내역 폼에 부품 가져오기*/
function getPartsList(key){ 
	var takeData = $(key).data('itid');
	var requestURL = "getpartslist.do";
	var sData = JSON.stringify({
		id:takeData
	});
	debug(sData);
	debug(requestURL);
	$.ajax({
		type : "POST",
		url : requestURL,
		data : sData,
		dataType : "JSON",
		async: true,
		contentType:'application/json;charset=UTF-8',
		beforeSend: function() {
			$("#content").append(loading.on);
			$("#parts tbody").remove();
			$('#parts').parents('td').children('div').remove();
			$('#parts').css('display', 'table');
		},
		success : function(rData) {
			debug(rData.length);
			debug(rData);
			if (rData.length > 0) {
				var tbody = $('<tbody />', {});
				for (var i = 0; i < rData.length; i++) {
					var tr = $('<tr />',{});
					$(tr).data('part-id', rData[i].partId);
					$(tr).data('part-name', rData[i].partName);
					$(tr).data('part-count', rData[i].partCount);
					$(tr).append($('<td />', {text: rData[i].partId}));
					$(tr).append($('<td />', {text: rData[i].partName}));
					$(tr).append($('<td />', {text: rData[i].partCount}));
					$(tr).append($('<td />', {}).append(
							$('<input />', {
								name : rData[i].partId,
								type: 'number',
								max: rData[i].partCount,
								min: '0',
								step: '1',
								value:'0',
								class: 'from-control'
							}))
					)
					$(tbody).append(tr);
				}
				$('#parts').append(tbody);
			} else {
				$('#parts').parents('td').append($('<div />', {text: '조회된 결과가 없습니다.', class: 'card border-warning'}))
				$('#parts').css('display', 'none');
			}
		},
		error : function() {
			alert("실패!");
		},
		complete : function() {
			$(".loading").remove();
		}
	});
}

/* 수리내역 등록 */
function addRepairResult() {
	var requestURL = "addrepairresult.do";
	var sData = getUsePartsList("#repairResultForm");
	/*var sData = JSON.stringify({
	//	repairid = $("#productId").val(),
		itname:$("#itemName").val(),
		productid:$("#productId").val(),
		engineerid:$("#engineerId").val(),
		engineername:$("#engineerName").val(),
		repairsort:$("#repairSort").val(),
		//state = $("#productId").val(),
		//repairdate = $("#repairDate").val(),
		repaircontent:$("#repairContents").val(),
		//list:$("#parts input").serializeArray()
		getUsePartsList("#repairForm input")
		
	});*/
	debug(sData);
	debug(requestURL);
	$.ajax({
		type : "POST",
		url : requestURL,
		data : sData,
		dataType : "JSON",
		async: true,
		contentType:'application/json;charset=UTF-8',
		beforeSend: function() {
			$("#content").append(loading.on);
		},
		success : function(rData) {
			alert(rData.result);
		},
		error : function() {
			
			alert("입력 필수입니다.");
		},
		complete : function() {
			$(".loading").remove();
		}
	});
}

function repairFormCheck(){
	if(document.getElementById("repairSort") == null){
		alert('분류미선택');
		return;
	}else if(document.getElementById("repairContents") == null){
		alert('점검내역미입력');
		return;
	}
}
/* 우편번호 */
function getPost() {
   new daum.Postcode({
        oncomplete: function(data) {
            var fullAddr = '';
            var extraAddr = '';

            if (data.userSelectedType === 'R') {
                fullAddr = data.roadAddress;
            } else {
                fullAddr = data.jibunAddress;
            }

            if(data.userSelectedType === 'R'){
                if(data.bname !== '') {
                    extraAddr += data.bname;
                }
                if(data.buildingName !== '') {
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
            }
            $("#tb_post").val(data.zonecode);
            $("#tb_addr").val(fullAddr);
            document.getElementById('tb_addD').focus();
        }
    }).open();
}
/**/
function getUsePartsList(form){
	var jsonstr = "{";
	$.each($(form).serializeArray(), function(index, item){
		if(item.value != 0){
			jsonstr += ""+item.name+":"+item.value+","}
		});
	//jsonstr += "\"\":\"\"}";
	jsonstr += "}";
	return jsonstr;
}

/* 모든 부속품 리스트 가져오기*/
function getAllPartsList(){
	var requestURL = "getallpartslist.do";
	var sData = JSON.stringify({
	});
	debug(sData);
	debug(requestURL);
	$.ajax({
		type : "POST",
		url : requestURL,
		data : sData,
		dataType : "JSON",
		async: true,
		contentType:'application/json;charset=UTF-8',
		beforeSend: function() {
			$("#content").append(loading.on);
		},
		success : function(rData) {
			var ihtml = "";
			debug(rData.length);
			debug(rData);
			for (var i = 0; i < rData.length; i++) {
				var row = rData[i];
				var message = "";
				if(row.partSafety != null && parseInt(row.partTotal) <= parseInt(row.partSafety)){
					message = "부속품 주문요청";
				}
				ihtml += "<tr data-parts-id='"+ row.partId
					+"' data-parts-model='"+ row.partModel
					+"' data-parts-search='"+ row.partSearch
					+"' data-item-id='"+ row.itemId
					+"' data-parts-manufacturer='"+ row.partManufacturer
					+"' data-parts-total='"+ row.partTotal
					+"' data-parts-safety='"+ row.partSafety+"'>";
				ihtml += "<td>"+row.partId+
					"</td><td>"+row.partModel+
					"</td><td>"+row.partSearch+
					"</td><td>"+row.itemId+
					"</td><td>"+row.partManufacturer+
					"</td><td>"+row.partTotal+
					"</td><td>"+row.partSafety+
					"</td><td  style='color: red'>"+message+"</td></tr>";
			}
			debug(ihtml);
			$("#partsList").html(ihtml);
		},
		error : function() {
			alert("부속품가져오기실패!!");
		},
		complete : function() {
			$(".loading").remove();
		}
	});
}
/* 모든 수리결과 리스트 가져오기*/
function getAllRepairResultList(){
	var requestURL = "getallrepairresultlist.do";
	var sData = JSON.stringify({
	});
	debug(sData);
	debug(requestURL);
	$.ajax({
		type : "POST",
		url : requestURL,
		data : sData,
		dataType : "JSON",
		async: true,
		contentType:'application/json;charset=UTF-8',
		beforeSend: function() {
			$("#content").append(loading.on);
		},
		success : function(rData) {
			var ihtml = "";
			debug(rData.length);
			debug(rData);
			for (var i = 0; i < rData.length; i++) {
				var row = rData[i];
				
				ihtml += "<tr data-repair-id='"+ row.repairId
					+"' data-item-name='"+ row.itemName
					+"' data-product-id='"+ row.productId
					+"' data-repair-date='"+ row.repairDate
					+"' data-repair-state='"+ row.repairState
					+"' data-engineer-id='"+ row.engineerId
					+"' data-engineer-name='"+ row.engineerName
					+"' data-repair-sort='"+ row.repairSort
					+"' data-repair-content='"+ row.repairContent
					+"' id='"+ row.engineerId+"'>";
				ihtml += "<td>"+row.repairId+
					"</td><td>"+row.itemName+
					"</td><td>"+row.productId+
					"</td><td>"+row.repairDate+
					"</td><td>"+row.repairState+"</td></tr>";
			}
			debug(ihtml);
			$("#repairResultList").html(ihtml);
		},
		error : function() {
			alert("수리결과초기리스트가져오기 실패!!");
		},
		complete : function() {
			$(".loading").remove();
		}
	});
}
/* 부품 검색*/
function getSearchPartsList(){
	var requestURL = "getsearchpartslist.do";
	var sData = JSON.stringify({
		searchType : $("#searchType").val(),
		searchKeyword : $("#searchParts").val()
	});
	debug(sData);
	debug(requestURL);
	$.ajax({
		type : "POST",
		url : requestURL,
		data : sData,
		dataType : "JSON",
		async: true,
		contentType:'application/json;charset=UTF-8',
		beforeSend: function() {
			$("#content").append(loading.on);
		},
		success : function(rData) {
			var ihtml = "";
			debug(rData.length);
			debug(rData);
			for (var i = 0; i < rData.length; i++) {
				var row = rData[i];
				var message = "";
				if(row.partSafety != null && parseInt(row.partTotal) <= parseInt(row.partSafety)){
					message = "부속품 주문요청";
				}
				ihtml += "<tr data-parts-id='"+ row.partId
					+"' data-parts-model='"+ row.partModel
					+"' data-parts-search='"+ row.partSearch
					+"' data-item-id='"+ row.itemId
					+"' data-parts-manufacturer='"+ row.partManufacturer
					+"' data-parts-total='"+ row.partTotal
					+"' data-parts-safety='"+ row.partSafety+"'>";
				ihtml += "<td>"+row.partId+
					"</td><td>"+row.partModel+
					"</td><td>"+row.partSearch+
					"</td><td>"+row.itemId+
					"</td><td>"+row.partManufacturer+
					"</td><td>"+row.partTotal+
					"</td><td>"+row.partSafety+
					"</td><td  style='color: red'>"+message+"</td></tr>";
			}
			debug(ihtml);
			$("#partsList").html(ihtml);
		},
		error : function() {
			alert("부품 검색 실패!!");
		},
		complete : function() {
			$(".loading").remove();
		}

		
	});
}
/* 점검결과 조회*/
function getRepairResultList(){
	var requestURL = "getrepairresultlist.do";
	var sData = JSON.stringify({
		startDate : $("#start").val(),
		endDate : $("#end").val(),
		repairSort : $("#repairResultSort").val(),
	});
	debug(sData);
	debug(requestURL);
	$.ajax({
		type : "POST",
		url : requestURL,
		data : sData,
		dataType : "JSON",
		async: true,
		contentType:'application/json;charset=UTF-8',
		beforeSend: function() {
			$("#content").append(loading.on);
		},
		success : function(rData) {
			var ihtml = "";
			debug(rData.length);
			debug(rData);
			for (var i = 0; i < rData.length; i++) {
				var row = rData[i];
				
				ihtml += "<tr data-repair-id='"+ row.repairId
					+"' data-item-name='"+ row.itemName
					+"' data-product-id='"+ row.productId
					+"' data-repair-date='"+ row.repairDate
					+"' data-repair-state='"+ row.repairState
					+"' data-engineer-id='"+ row.engineerId
					+"' data-engineer-name='"+ row.engineerName
					+"' data-repair-sort='"+ row.repairSort
					+"' data-repair-content='"+ row.repairContent
					+"' id='"+ row.engineerId
					+"'>";
				ihtml += "<td>"+row.repairId+
					"</td><td>"+row.itemName+
					"</td><td>"+row.productId+
					"</td><td>"+row.repairDate+
					"</td><td>"+row.repairSort+"</td></tr>";
			}
			debug(ihtml);
			$("#repairResultList").html(ihtml);
		},
		error : function() {
			alert("점검결과 조회 실패!!");
		},
		complete : function() {
			$(".loading").remove();
		}
	});
}
/* 로그처리 */
function debug(log) {
	if (operationMod == "debug") {
		console.log("[Debug] Message : " + log);
	}
}