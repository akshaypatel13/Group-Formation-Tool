package CSCI5308.GroupFormationTool.QuestionManage;

public class Options {

	private String description;
	private int storedas;

	public Options(int storedas) {
		this.storedas = storedas;
	}

	public Options() {

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStoredas() {
		return storedas;
	}

	public void setStoredas(int storedas) {
		this.storedas = storedas;
	}

}
