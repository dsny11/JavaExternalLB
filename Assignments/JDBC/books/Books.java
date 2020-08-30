package books;

import java.util.Date;

public class Books {
	
	private String title;
	
	private String isbnCode;
	
	private Author authorUID;
	
	public Books(String title, String isbnCode, Author authorUID) {
		setTitle(title);
		setIsbnCode(isbnCode);
		setAuthorUID(authorUID);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbnCode() {
		return isbnCode;
	}

	public void setIsbnCode(String isbnCode) {
		this.isbnCode = isbnCode;
	}

	public String getAuthorUID() {
		return authorUID.getAuthorUID();
	}

	public void setAuthorUID(Author authorUID) {
		this.authorUID = authorUID;
	}

}

