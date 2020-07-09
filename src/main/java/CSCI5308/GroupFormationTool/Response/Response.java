package CSCI5308.GroupFormationTool.Response;

public class Response {

	private long id;
	private String response;
	
	public Response() 
	{
		setDefaults();
	}
	
	public void setDefaults() 
	{
		id=-1;
		response="";
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}

}
