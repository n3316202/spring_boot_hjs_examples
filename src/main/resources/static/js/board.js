/*
 * boardService 
 * 모듈 구성하기
 * 	
 * 모듈 패턴은 쉽게 말해서 Java의 클래스처럼 JavaScript를 이용해서 메서드를 가지는 객체를 구성한다. 
 * 모듈 패턴은 JavaScript의 즉시 실행함수와 '{}'를 이용해서 객체를 구성한다. 
 *  
 * 
 * */

console.log("board Module...");

let boardService = (function() {
	
	function list(callback){
		
			$.ajax({
		    type : "GET",
		    url : "/boards/list/",
		    success: function (result) {       
			    console.log(result);
			    if(callback){
			    	callback(result);
			    }
		        
		    },
		    error: function (e) {
		        console.log(e);
		    }
		}); 
		
	}//function boardList(){
	
 	function get(id){
		
		$.ajax({
		    type : "GET",
		    url : "/boards/" + id,
		    success: function (result) {       
			    console.log(result);			
	
		    },
		    error: function (e) {
		        console.log(e);
		    }
		}); 
	
 	}
 	
	function add(board){
		
		$.ajax({
		
			type : "POST",
			url : "/boards/",
			cache : false,
			contentType:'application/json; charset=utf-8',
			data: JSON.stringify(board), 
			success: function (result) {       
				if(result == "SUCCESS"){
					console.log(result);  
				}					        
			},
			error: function (e) {
			        console.log(e);
			    }
			}); //	   $.ajax({
	 }
 	
 	function del(id, callback){
		
		$.ajax({
		    type : "DELETE",
		    url : "/boards/" + id,
		    success: function (result) {       
			    console.log(result);
			    if(callback){
			    	callback();
			    }			
	
		    },
		    error: function (e) {
		        console.log(e);
		    }
		});
	}
	
	return {list : list,
			get : get,
			add : add,
			del : del
			};
	
})();
