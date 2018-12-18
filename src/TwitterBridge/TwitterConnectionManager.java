package TwitterBridge;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
/**
 * A Single-tone object class to manages a simple connection to the Twitter by the given parameters.
 * @author MaysamPasdari
 * @since 13970615
 */
public class TwitterConnectionManager {
	private static TwitterConnectionManager instance;
	private TwitterConnectionManager(){

	}
	
	public static TwitterConnectionManager getInstance(){
		if(instance == null){
			instance = new TwitterConnectionManager();
		}
		return instance;
	}
	
	/**
	 * @author MaysamPasdari
	 * @since 13970615
	 * @return a Twitter object.
	 */
	public Twitter getTwitterObject(){
		ConfigurationBuilder cb = new ConfigurationBuilder();
		//Put your own Authentication keys here.
		cb.setDebugEnabled(true)
		        .setOAuthConsumerKey("")
		        .setOAuthConsumerSecret("")
		        .setOAuthAccessToken("")
		        .setOAuthAccessTokenSecret("");
				
		Twitter twitter = new TwitterFactory(cb.build()).getInstance();
		return twitter;
	}
}
