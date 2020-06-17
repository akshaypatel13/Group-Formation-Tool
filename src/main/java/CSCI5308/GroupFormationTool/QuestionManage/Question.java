package CSCI5308.GroupFormationTool.QuestionManage;

import CSCI5308.GroupFormationTool.AccessControl.User;

import java.util.Date;

/**
 * 
 * @author nieruize
 *
 */
public class 	Question {
	
	private long id;
	private String title;
	private String description;
	private String type;
	private Date created;
	private long instruct_id;
	
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
		instruct_id=-1;
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


	public long getInstruct_id() {
		return instruct_id;
	}

	public void setInstruct_id(long instruct_id) {
		this.instruct_id = instruct_id;
	}



	public boolean insertQuestion(IQuestionPersistence questionDB, User user)
	{
		return questionDB.insertQuestion(this, user);
	}

	public boolean delete(IQuestionPersistence questionDB)
	{
		return questionDB.deleteQuestion(id);
	}


	
}
