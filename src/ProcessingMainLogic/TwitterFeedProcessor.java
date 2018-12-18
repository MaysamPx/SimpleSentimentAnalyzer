package ProcessingMainLogic;

import java.util.List;

import TwitterBridge.TwitterConnectionManager;
import twitter4j.PagableResponseList;
import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.User;
/**
 * Provides some utility method for twitter feeds.
 * @author MeysamPasdari
 * @since 13970615
 */
public class TwitterFeedProcessor {
	/**
	 * Returns a list of statutes which have been published. Accepts a parameter as a pagination factor.
	 * @author MeysamPasdari
	 * @since 13970615
	 * @throws TwitterException
	 */
	public static List<Status> getUserTimelineByGivenCount(String accountName, int givenCount) throws TwitterException{
		List<Status> finalResult = null;
		Paging totalCount = new Paging();
		totalCount.setCount(givenCount);
		try {
			finalResult = TwitterConnectionManager.getInstance().getTwitterObject().getUserTimeline(accountName, totalCount);
		} catch (TwitterException e) {
			throw e;
		}
		return finalResult;
	}
	
	/**
	 * Returns a list of statutes which have been published in a specific page number. Accepts second parameter as a pagination factor.
	 * @author MeysamPasdari
	 * @since 13970615
	 * @throws TwitterException
	 */
	public static List<Status> getUserTimelineByPagination(String accountName, int givenPageNumber) throws TwitterException{
		List<Status> finalResult = null;
		Paging pageNumber = new Paging();
		pageNumber.setCount(givenPageNumber);
		try {
			finalResult = TwitterConnectionManager.getInstance().getTwitterObject().getUserTimeline(accountName,pageNumber);
		} catch (TwitterException e) {
			throw e;
		}
		return finalResult;
	}
	
	/**
	 * Returns a list of last 20 statutes which have been published.
	 * @author MeysamPasdari
	 * @since 13970615
	 * @throws TwitterException
	 */
	public static List<Status> getLastTwentyPostOfUserTimeline(String accountName) throws TwitterException{
		List<Status> finalResult = null;
		try {
			finalResult = TwitterConnectionManager.getInstance().getTwitterObject().getUserTimeline(accountName);/* returns last 20 Tweets by default */
		} catch (TwitterException e) {
			throw e;
		}
		return finalResult;
	}
	
	/**
	 * @author MeysamPasdari
	 * @since 13970615
	 * @param username
	 * @return PagableResponseList<User>.
	 * @throws TwitterException
	 */
	public static PagableResponseList<User> getUserFollwers(String username) throws TwitterException {
		try {
			long lCursor = -1;
			return TwitterConnectionManager.getInstance().getTwitterObject().getFollowersList(username, lCursor , 200);
		} catch (TwitterException e) {
			throw e;
		}
	}
	
}
