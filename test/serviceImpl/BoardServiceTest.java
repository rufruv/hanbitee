package serviceImpl;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

import domain.ArticleBean;

public class BoardServiceTest {
	BoardServiceImpl service = BoardServiceImpl.getInstance();
	@Test @Ignore
	public void testAdd() throws Exception {
		ArticleBean bean = new ArticleBean();
		bean.setSeq("11");
		bean.setId("kim");
		bean.setTitle("11");
		bean.setContents("11");
		bean.setRegdate("2017-02-14");
		bean.setReadCount("777");
		assertTrue(service.add(bean)==1);
	}

	@Test @Ignore
	public void testFindOne() throws Exception{
		ArticleBean bean = new ArticleBean();
		bean.setSeq("1");
		assertTrue(service.findOne(bean).getId().equals("hong"));
	}

	@Test @Ignore
	public void testFindSome() throws Exception{
		String[] arr = new String[2];
		arr[0] = "title";
		arr[1]= "1st 제목";
		List<ArticleBean> list = new ArrayList<>();
		list=service.findSome(arr);
		assertTrue(list.get(0).getId().equals("hong"));
	}

	@Test @Ignore
	public void testList() throws Exception{
		List<ArticleBean> list = new ArrayList<>();
		/*list=service.list();*/
		assertTrue(list.get(0).getTitle().equals("1st 제목"));
	}

	@Test 
	public void testUpdate() throws Exception{
		ArticleBean bean = new ArticleBean();
		bean.setId("leelee");
		bean.setTitle("10th 제목");
		bean.setContents("제목-10-내용-10");
		bean.setRegdate("2015-02-15");
		bean.setReadCount("888");
		bean.setSeq("10");
		assertTrue(service.update(bean)==1);
	}

	@Test @Ignore
	public void testDelete() throws Exception{
		ArticleBean bean = new ArticleBean();
		bean.setSeq("12");
		assertTrue(service.delete(bean)==1);
	}

}
