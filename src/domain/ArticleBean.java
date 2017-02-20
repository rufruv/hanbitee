package domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data public class ArticleBean {
	@Getter @Setter
	private String seq, id, title, contents, regdate, readCount;

	
	@Override
	public String toString() {
		return String.format("[ %s | %s | %s | %s | %s ]",seq, id, title, regdate, "0");
	}
}
