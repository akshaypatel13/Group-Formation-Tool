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
	private String description;
	private String type;
	private Date created;
	
	public Question()
	{
		setDefaults();
	}
	
	public void setDefaults()
	{
		id = -1;
		title = "";
		description = "";
		type = "";
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
	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

//	Need implement by Akashy
//	public boolean createQuestion(IQuestionPersistence questionDB)
//	{
//		return questionDB.createQuestion(this);
//	}
	
	public boolean delete(IQuestionPersistence questionDB)
	{
		return questionDB.deleteQuestion(id);
	}

	
	
}
