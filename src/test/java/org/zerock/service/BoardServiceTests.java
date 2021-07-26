package org.zerock.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
	
	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	@Test
	public void testExist() {
		log.info(service + "    <------------------------------------[HERE]!!!!");
		assertNotNull(service);
	}
	
	@Test
	public void testRegister() {
		
		BoardVO board = new BoardVO();
		board.setTitle("new title service");
		board.setContent("new content service");
		board.setWriter("new writer service");
		
		service.register(board);
		
		log.info("New article's number : "+board.getBno()+"    <------------------------------------[HERE]!!!!");
	}
	
	@Test
	public void testGetList() {
		service.getList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testGet() {
		log.info(service.get(11l));
	}
	
	@Test
	public void testDelete() {
		log.info("Remove result : " + service.remove(11l)+"    <------------------------------------[HERE]!!!!");
	}
	
	@Test
	public void testUpdate() {
		
		BoardVO board = service.get(13L);
		
		if(board == null) {
			return;
		}
		
		board.setTitle("update new title");
		log.info("modify result : " + service.modify(board));
	}
	
	
 

}
