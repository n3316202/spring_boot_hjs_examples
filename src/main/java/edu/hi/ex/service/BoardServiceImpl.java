package edu.hi.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.hi.ex.mapper.BoardMapper;
import edu.hi.ex.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
@NoArgsConstructor
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper;

	@Override
	public List<BoardVO> getList() {

		log.info("getList..........");
		return mapper.getList();
	}

	@Override
	public BoardVO get(int bno) {

		log.info("get..........");
		return mapper.read(bno);
	}

	@Override
	public void writeBoard(BoardVO boardVO) {

		mapper.insertBoard(boardVO);
	}

	@Override
	public void writeReply(BoardVO boardVO) {
		mapper.updateShape(boardVO);
		mapper.insertReply(boardVO);

	}

	@Override
	public int remove(int bId) {
		log.info("remove..........");
		return mapper.delete(bId);
	}

	@Override
	public int modify(BoardVO board) {
		log.info("service modify");
		return mapper.updateBoard(board);
	}

//	@Override
//	public List<BoardVO> getListWithPaging(Criteria cri) {
//		// TODO Auto-generated method stub
//		log.info("getListWithPaging()......");
//		return mapper.getListWithPaging(cri);
//	}
//
//	// 페이징 처리 함수
//	@Override
//	public int getTotal() {
//		log.info("service:getTotal()..");
//		return mapper.getTotalCount();
//	}
}
