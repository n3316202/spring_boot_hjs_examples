package edu.hi.ex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.hi.ex.service.BoardService;
import edu.hi.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/boards")
public class RestBoardController {

	@Autowired
	private BoardService boardService;

	
	@GetMapping("/list")
	public List<BoardVO> list(Model model) {
		
		log.info("list()...");
		return boardService.getList();		
	}
	
	@GetMapping("/{bid}")
	public BoardVO rest_content_view(BoardVO boardVO, ModelAndView mav) {

		log.info("rest_content_view");

		return boardService.get(boardVO.getBid());

	}
	
//	@GetMapping("/list2")
//	public PagingVO list2(Criteria cri,Model model) {
//		log.info("list2...");
//		log.info("Criteria:" + cri);
//		
//		int total = boardService.getTotal();
//		log.info("total:" + total);
//		log.info("boardService.getListWithPaging:" + boardService.getListWithPaging(cri));
//		
//		
//		return new PagingVO(boardService.getListWithPaging(cri),new PageVO(cri,total));
//	}
	

	@PostMapping("/")
	public ResponseEntity<String> write(@RequestBody BoardVO boardVO) {

		log.info("axios write()......");
		log.info("Board:" + boardVO);

		ResponseEntity<String> entity = null;

		try {
			boardService.writeBoard(boardVO);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;

	}

	@PutMapping("/{bid}")
	public ResponseEntity<String> rest_update(@RequestBody BoardVO boardVO) {

		ResponseEntity<String> entity = null;

		log.info("rest_update..");
		try {

			int rn = boardService.modify(boardVO);
			log.info("update 넘어온 숫자:::::" + rn);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
	
	@DeleteMapping("/{bid}")
	public ResponseEntity<String> rest_delete(BoardVO boardVO, Model model) {
		ResponseEntity<String> entity = null;
		log.info("rest_delete..");
		
		try {
				int rn = boardService.remove(boardVO.getBid());
				// 삭제가 성공하면 성공 상태메시지 저장
				log.info("delete 넘어온 숫자:::::" + rn);
				
			entity = new ResponseEntity<String>(String.valueOf(rn), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			// 댓글 삭제가 실패하면 실패 상태메시지 저장
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		// 삭제 처리 HTTP 상태 메시지 리턴
		return entity;

	}
	
}
