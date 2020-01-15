package com.codename1.flurry;


/**
 * 
 *  @author Chen
 */
public interface FlurryNative extends com.codename1.system.NativeInterface {

	/**
	 *  call initFlurry to start a flurry session
	 */
	public void initFlurry(String apiKey);

	/**
	 *  start session
	 */
	public void startSession();

	/**
	 *  end session
	 */
	public void endSession();

	/**
	 *  Should be called before initFlurry, this is off by default on ios
	 */
	public void setCrashReportingEnabled(boolean param);

	/**
	 *  Should be called before initFlurry
	 */
	public void setLogEvents(boolean enable);

	/**
	 *  Use logEvent to track timed user events that happen during a session.
	 *  
	 *  @param eventId event id
	 *  @param timed if timed true call endTimedEvent once the event ended
	 */
	public void logEvent(String eventId, boolean timed);

	/**
	 *  Use endTimedEvent to end the timed event
	 *  
	 *  @param eventId event id
	 */
	public void endTimedEvent(String eventId);

	/**
	 *  Use onPageView to report page view count
	 */
	public void onPageView();

	/**
	 *  Use this to log the user's assigned ID or username in your system. This should be called before ini
	 */
	public void setUserID(String name);

	/**
	 *  Use this to log the user's age after identifying the user. Valid inputs are 0 or greater.
	 */
	public void setAge(int age);

	/**
	 *  Use this to log the user's gender after identifying the user. 
	 *  Valid inputs are m (male) or f (female)
	 */
	public void setGender(String gender);

	/**
	 *  Flurry Interstitial Ads
	 */
	public void setAdSpaceName(String adSpace);

	public void fetchAd();

	public void displayAd();

	public void destroyAd();

	public boolean isAdReady();
}
