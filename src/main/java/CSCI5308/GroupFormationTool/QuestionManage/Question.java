package CSCI5308.GroupFormationTool.QuestionManage;

import java.util.Date;

/**
 * 
 * @author nieruize
 *
 */
public class Question {
	
	private long id;
	private String title;
	private Date created;
	
	public Question()
	{
		setDefaults();
	}
	
	public void setDefaults()
	{
		id = -1;
		title = "";
		created = null;
	}

	public Question(long id, IQuestionPersistence questionDB)
	{
		setDefaults();
		questionDB.loadQuestionByID(id, this);
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
	public boolean delete(IQuestionPersistence questionDB)
	{
		return questionDB.deleteQuestion(id);
	}

	
	
}
