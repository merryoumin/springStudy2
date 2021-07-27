package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

	@Override
	public void register(BoardVO board) {
	
		log.info("register : "+ board + "    <------------------------------------[HERE :  register in BoardServiceImpl]");
		mapper.insertSelectKey(board);

	}

	@Override
	public BoardVO get(Long bno) {
		log.info("get :    <------------------------------------[HERE :  get in BoardServiceImpl]");
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("modify : " + board + "    <------------------------------------[HERE : modify in BoardServiceImpl]");
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		log.info("remove :  " + bno + "  <------------------------------------[HERE : remove in BoardServiceImpl]");
		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BoardVO> getList() {
		log.info("getList :    <------------------------------------[HERE : List in BoardServiceImpl]");
		return mapper.getList();
	}

}
