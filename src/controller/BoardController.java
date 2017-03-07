package controller;

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import domain.ArticleBean;
import service.BoardService;
import serviceImpl.BoardServiceImpl;
import util.DispatcherServlet;
import util.Pagination;
import util.Separator;

@WebServlet("/board.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Separator.init(request, response);
		ArticleBean bean = new ArticleBean();
		Pagination pg = new Pagination();
		BoardService service = BoardServiceImpl.getInstance();
		List<ArticleBean> list = new ArrayList<>();
		switch(Separator.command.getAction()){
		case "move": 
			DispatcherServlet.send(request, response);
			break;
		case "list":
			System.out.println("==list==");
			pg.setBlockSize(5);
			pg.setRowCount(5);
			pg.setCount(service.count());
			pg.setPageNO(request.getParameter("pageNO"));
			pg.setPageStart();
			pg.setPageEnd();
			pg.setPageCount(0);
			int[] pageArr={pg.getPageStart(),pg.getPageEnd()};  
			list=service.list(pageArr);
			pg.setPageCount();
			pg.setBlockCount();
			pg.setBlockStart();
			pg.setPrevBlock();
			pg.setNextBlock();
			pg.setBlockEnd();
			request.setAttribute("count", pg.getAttribute()[0]);
			System.out.println("count : "+ pg.getAttribute()[0]);
			request.setAttribute("pageCount", pg.getAttribute()[1]);
			System.out.println("pageCount : "+ pg.getAttribute()[1]);
			request.setAttribute("pageNO", pg.getAttribute()[2]);
			System.out.println("pageNO : "+ pg.getAttribute()[2]);
			request.setAttribute("pageStart", pg.getAttribute()[3]);
			System.out.println("pageStart : " + pg.getAttribute()[3]);
			request.setAttribute("pageEnd", pg.getAttribute()[4]);
			System.out.println("pageEnd : "+ pg.getAttribute()[4]);
			request.setAttribute("blockStart", pg.getAttribute()[5]);
			System.out.println("blockStart : " + pg.getAttribute()[5]);
			request.setAttribute("blockEnd", pg.getAttribute()[6]);
			System.out.println("blockEnd : "+ pg.getAttribute()[6]);
			request.setAttribute("prevBlock", pg.getAttribute()[7]);
			System.out.println("prevBlock : "+ pg.getAttribute()[7]);
			request.setAttribute("nextBlock", pg.getAttribute()[8]);
			System.out.println("nextBlock : " + pg.getAttribute()[8]);
			request.setAttribute("list", list);
			System.out.println("list : " + list);			
			break;
		case "detail":
			String seq = request.getParameter("seq");
			bean.setSeq(seq);
			try {
				bean = service.findOne(bean);
				request.setAttribute("article", bean);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			break;
		}
		DispatcherServlet.send(request, response);
	}
}
