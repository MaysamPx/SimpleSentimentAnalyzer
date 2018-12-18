
package Executors;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import ProcessingMainLogic.TwitterFeedProcessor;
import twitter4j.PagableResponseList;
import twitter4j.User;

public class GetFollowers {

	public static void main(String[] args) throws IOException {
		int i=1;
		HashMap<String, String> finalStatus = new HashMap<>();
		
		//String text = "Those who find ugly meanings in beautiful things are corrupt without being charming.";
		
		try {
		 	PagableResponseList<User> followerResult = TwitterFeedProcessor.getUserFollwers("@realDonaldTrump");
		 	for(int j=0; j< followerResult.size();j++){
		 		System.out.println(followerResult.get(j).getScreenName());
				
				System.out.println( "=========================================================================");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}

}
