<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script type="text/javascript" src="/js/board.js"></script>
	<script type="text/javascript">
/* 	$.ajax({
		url : '서비스 주소'
			, data : '서비스 처리에 필요한 인자값'
			, type : 'HTTP방식' (POST/GET 등)
			, dataType : 'return 받을 데이터 타입' (json, text 등)
			, success : function('결과값'){
			// 서비스 성공 시 처리 할 내용
			}, error : function('결과값'){
			// 서비스 실패 시 처리 할 내용
			}
		}); 
*/

		function listCallback(result){
			
			var htmls="";
			
        	$("#list-table").html("");	

			$("<tr>" , {
				html : "<td>" + "번호" + "</td>"+  // 컬럼명들
						"<td>" + "이름" + "</td>"+
						"<td>" + "제목" + "</td>"+
						"<td>" + "날짜" + "</td>"+				
						"<td>" + "히트" + "</td>"
			}).appendTo("#list-table") // 이것을 테이블에 붙임

			if(result.length < 1){
				htmls.push("등록된 댓글이 없습니다.");
			} else {

                    $(result).each(function(){			                    			                    
	                    htmls += '<tr>';
	                    htmls += '<td>'+ this.bid + '</td>';
	                    htmls += '<td>'+ this.bname + '</td>';
	                    htmls += '<td>'
	         			for(var i=0; i < this.bindent; i++) { //for 문은 시작하는 숫자와 종료되는 숫자를 적고 증가되는 값을 적어요. i++ 은 1씩 증가 i+2 는 2씩 증가^^
	         				htmls += '-'	
	        			}
	                    htmls += '<a href="${pageContext.request.contextPath}/content_view?bid=' + this.bid + '">' + this.btitle + '</a></td>';
		                htmls += '<td>'+ this.bdate + '</td>'; 
	                    htmls += '<td>'+ this.bhit + '</td>';
	                    htmls += '<td>'+ '<input id=' + this.bid + " type='button' class='btn_delete' value='삭제'>" + '</td>';
	                    htmls += '</tr>';			                    		                   
                	});	//each end

                	htmls+='<tr>';
                	htmls+='<td colspan="5"> <a href="${pageContext.request.contextPath}/write_view">글작성</a> </td>';		                	
                	htmls+='</tr>';
                	
			}

			$("#list-table").append(htmls);
			
        }		
	</script>
	
	<script>
		$(document).ready(function(){
			boardService.list(listCallback);
		});
	</script>
	
	<script>
		
		$(document).ready(function(){
			
			let 
			
			$(document).on("click","#list-table .btn_delete",function(){
				console.log($(this).attr("id"));
				
				
				//boardService.del($(this).attr("id"));
				//$(this).parent().parent().remove();	
				
				//위의 코드든 아래 코드든 상관이 없음
				boardService.del($(this).attr("id"),function(){
					$(this).parent().parent().remove();	
				});		
				
				
			});

		});
	</script>

</head>
<body>
	<table id="list-table" width="500" cellpadding="0" cellspacing="0" border="1">
	</table>
</body>
</html>