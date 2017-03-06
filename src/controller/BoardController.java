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
import util.Separator;

@WebServlet("/board.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Separator.init(request, response);
		ArticleBean bean = new ArticleBean();
		BoardService service = BoardServiceImpl.getInstance();
		List<ArticleBean> list = new ArrayList<>();
		switch(Separator.command.getAction()){
		case "move": 
			DispatcherServlet.send(request, response);
			break;
		case "list":
			try {
				list = service.list();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			String strPageNO = request.getParameter("pageNO");
			System.out.println("화면에서 넘어온 PAGE NO :" + strPageNO);
			int count=list.size();
			int rowCount = 5;
			int block = count/rowCount;
			int pageNO = Integer.parseInt(strPageNO);
			int pageStart=(pageNO-1)+rowCount+1;
			int pageEnd = pageNO*rowCount;
			int blockStart = 1;
			int blockSize = 5;
			int blockEnd = (blockStart-1)+blockSize;
			
			request.setAttribute("count", list.size());
			request.setAttribute("list", list);
			request.setAttribute("pageStart", pageStart);
			request.setAttribute("pageEnd", pageEnd);
			request.setAttribute("block", block);
			request.setAttribute("blockStart", blockStart);
			request.setAttribute("blockEnd", blockEnd);
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
