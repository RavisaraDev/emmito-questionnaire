package classes;

import java.io.Serializable;

public class Questions implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String answerOne;
	private String answerTwo;
	private String answerThree;

	public Questions(String answerOne, String answerTwo, String answerThree) {
		super();
		this.answerOne = answerOne;
		this.answerTwo = answerTwo;
		this.answerThree = answerThree;
	}
	
	public String getQuestionOneAnswer() {
		return answerOne;
	}
	
	public void setQuestionOneAnswer(String answerOne) {
		this.answerOne = answerOne;
	}
	
	public String getQuestionTwoAnswer() {
		return answerTwo;
	}
	
	public void setQuestionTwoAnswer(String answerTwo) {
		this.answerTwo = answerTwo;
	}
	
	public String getQuestionThreeAnswer() {
		return answerThree;
	}
	
	public void setQuestionThreeAnswer(String answerThree) {
		this.answerThree = answerThree;
	}
	
}
