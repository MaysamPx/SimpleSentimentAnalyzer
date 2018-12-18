package Model;

import twitter4j.Status;

/**
 * Contains result of sentiment analysis for a specific tweet.
 * @author MaysamPasdari
 * @since 13970615
 */

public class TweetSentimentResult {
	private Status tweet;
	private double score;
	private String type;
	private double veryPositiveScore;
	private double positiveScore;
	private double negative;
	private double neutral;
	private double negativeScore;
	private double veryNegativeScore;

	public Status getTweet() {
		return tweet;
	}

	public void setTweet(Status tweet) {
		this.tweet = tweet;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getVeryPositiveScore() {
		return veryPositiveScore;
	}

	public void setVeryPositiveScore(double veryPositiveScore) {
		this.veryPositiveScore = veryPositiveScore;
	}

	public double getPositiveScore() {
		return positiveScore;
	}

	public void setPositiveScore(double positiveScore) {
		this.positiveScore = positiveScore;
	}

	public double getNegative() {
		return negative;
	}

	public void setNegative(double negative) {
		this.negative = negative;
	}

	public double getNeutral() {
		return neutral;
	}

	public void setNeutral(double neutral) {
		this.neutral = neutral;
	}

	public double getNegativeScore() {
		return negativeScore;
	}

	public void setNegativeScore(double negativeScore) {
		this.negativeScore = negativeScore;
	}

	public double getVeryNegativeScore() {
		return veryNegativeScore;
	}

	public void setVeryNegativeScore(double veryNegativeScore) {
		this.veryNegativeScore = veryNegativeScore;
	}
}
