package application.models;

@SuppressWarnings("unused")
public class QuestionsHistory {
	
	private String question;
	private int answer;
	private boolean correct;
	private String player;
	private String difficulty;
	
	public QuestionsHistory(String question, int answer, boolean correct, String player, String difficulty) {
		super();
		this.question = question;
		this.answer = answer;
		this.correct = correct;
		this.player = player;
		this.difficulty = difficulty;
	}
}
