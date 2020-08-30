package books;

public class Author {
	
	private String authorUID;
	private String authorName;
	private String authorEmail;	
	
	public String getAuthorUID() {
		return authorUID;
	}

	public void setAuthorUID(String authorUID) {
		this.authorUID = authorUID;
	}

	public String getAuthorEmail() {
		return authorEmail;
	}

	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}

	public Author(String authorUID) {
		setAuthorUID(authorUID);
	}
	
	public Author(String authorName, String authorUID, String authorEmail) {
		setAuthorName(authorName);
		setAuthorUID(authorUID);		
		setAuthorEmail(authorEmail);
		
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
}

