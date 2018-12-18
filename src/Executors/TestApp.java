
package Executors;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.stanford_nlp.SentimentAnalyzer.SentimentAnalyzer;
import com.stanford_nlp.model.SentimentResult;

import Model.TweetSentimentResult;
import ProcessingMainLogic.TwitterFeedProcessor;
import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.TwitterException;

public class TestApp {

	public static void main(String[] args) throws IOException {
		long i=1;
		HashMap<Long, TweetSentimentResult> finalStatus = new HashMap<>();
		
		try {
			Paging p = new Paging();
			p.setCount(200);

			List<Status> statuses = TwitterFeedProcessor.getUserTimelineByPagination("@sanaycto", 200);
			for(Status status: statuses){
				
				SentimentAnalyzer sentimentAnalyzer = new SentimentAnalyzer();
				sentimentAnalyzer.initialize();
				SentimentResult sentimentResult = sentimentAnalyzer.getSentimentResult(status.getText());
				
				TweetSentimentResult tweetSentimentResult = new TweetSentimentResult();
				tweetSentimentResult.setTweet(status);
				tweetSentimentResult.setScore(sentimentResult.getSentimentScore());
				tweetSentimentResult.setType(sentimentResult.getSentimentType());
				tweetSentimentResult.setPositiveScore(sentimentResult.getSentimentClass().getPositive());
				tweetSentimentResult.setVeryNegativeScore( sentimentResult.getSentimentClass().getVeryNegative());
				tweetSentimentResult.setVeryPositiveScore(sentimentResult.getSentimentClass().getVeryPositive());
				tweetSentimentResult.setNegative(sentimentResult.getSentimentClass().getNegative());
				tweetSentimentResult.setNeutral(sentimentResult.getSentimentClass().getNeutral());
				System.out.flush();
				finalStatus.put(i++,tweetSentimentResult);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for (Map.Entry<Long, TweetSentimentResult> entry : finalStatus.entrySet()) {
		    System.out.println(entry.getKey() + " - Content: " + entry.getValue().getTweet().getText() + "\n Sentiment Type: "  +entry.getValue().getType() + " \n Score : " + entry.getValue().getScore());
		    
		}

	}

}
