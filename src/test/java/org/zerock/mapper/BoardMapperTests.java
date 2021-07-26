package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
		@Setter(onMethod_ = @Autowired)
		private BoardMapper mapper;
		
		@Test
		public void testGetList(){
			mapper.getList().forEach(board -> log.info(board+"    <------------------------------------[HERE]!!!!"));
		}
		
		@Test
		public void testInsert(){
			BoardVO board = new BoardVO();
			board.setTitle("new title");
			board.setContent("new content");
			board.setWriter("newbie");
			
			mapper.insert(board);
			log.info(board+"    <------------------------------------[HERE]!!!!");
		}
		
		@Test
		public void testInsertKey(){
			BoardVO board = new BoardVO();
			board.setTitle("new title select key");
			board.setContent("new content select key");
			board.setWriter("newbie select key");
			
			mapper.insertSelectKey(board);
			log.info(board+"    <------------------------------------[HERE]!!!!");
		}
		
		@Test
		public void testRead(){
			BoardVO board = mapper.read(4L);
			log.info(board+"    <------------------------------------[HERE]!!!!");
		}
		
		@Test
		public void testDelet(){
			log.info("Delet count : " + mapper.delete(10L)+"    <------------------------------------[HERE]!!!!");
		}
		
		@Test
		public void testUpdate(){
			BoardVO board = new BoardVO();
			board.setBno(11L);
			board.setTitle("update title ");
			board.setContent("update content ");
			board.setWriter("update writer");
//			int count = mapper.update(board);
//			log.info("Update count : " + count +"   <------------------------------------[HERE]!!!!");
			log.info("Update count : " + mapper.update(board) + "    <------------------------------------[HERE]!!!!");
			
		}
		
}
