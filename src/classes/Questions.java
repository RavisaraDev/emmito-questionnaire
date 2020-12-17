package classes;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Questions.
 */
public class Questions implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The answer one. */
	private String answerOne;
	
	/** The answer two. */
	private String answerTwo;
	
	/** The answer three. */
	private String answerThree;

	/**
	 * Instantiates a new questions.
	 *
	 * @param answerOne the answer one
	 * @param answerTwo the answer two
	 * @param answerThree the answer three
	 */
	public Questions(String answerOne, String answerTwo, String answerThree) {
		super();
		this.answerOne = answerOne;
		this.answerTwo = answerTwo;
		this.answerThree = answerThree;
	}
	
	/**
	 * Gets the question one answer.
	 *
	 * @return the question one answer
	 */
	public String getQuestionOneAnswer() {
		return answerOne;
	}
	
	/**
	 * Sets the question one answer.
	 *
	 * @param answerOne the new question one answer
	 */
	public void setQuestionOneAnswer(String answerOne) {
		this.answerOne = answerOne;
	}
	
	/**
	 * Gets the question two answer.
	 *
	 * @return the question two answer
	 */
	public String getQuestionTwoAnswer() {
		return answerTwo;
	}
	
	/**
	 * Sets the question two answer.
	 *
	 * @param answerTwo the new question two answer
	 */
	public void setQuestionTwoAnswer(String answerTwo) {
		this.answerTwo = answerTwo;
	}
	
	/**
	 * Gets the question three answer.
	 *
	 * @return the question three answer
	 */
	public String getQuestionThreeAnswer() {
		return answerThree;
	}
	
	/**
	 * Sets the question three answer.
	 *
	 * @param answerThree the new question three answer
	 */
	public void setQuestionThreeAnswer(String answerThree) {
		this.answerThree = answerThree;
	}
	
}
