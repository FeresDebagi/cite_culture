package com.codename1.flurry;


/**
 *  Utility class to use the Flurry API
 * 
 *  @author Chen
 */
public class FlurryManager {

	/**
	 *  Creates a FlurryManager instance
	 * 
	 *  @param apiKey flurry api key
	 */
	public FlurryManager() {
	}

	/**
	 *  Init the flurry with the api key
	 * 
	 *  @param apiKey
	 */
	public void init(String apiKey) {
	}

	/**
	 *  An initializer that takes into account the SDK that is in use.  This 
	 *  allows init() to be called multiple times, and only the one for the
	 *  current platform will be effectual.  This is required because
	 *  the Android app will need a different API key than the IOS app.
	 *  @param apiKey The unique flurry API key.
	 *  @param sdk The SDK that this key corresponds to.
	 */
	public void init(String apiKey, FlurryManager.SDK sdk) {
	}

	/**
	 *  Start Session
	 */
	public void startSession() {
	}

	/**
	 *  End Session
	 */
	public void endSession() {
	}

	/**
	 *  Should be called before initFlurry
	 */
	public void setCrashReportingEnabled(boolean enable) {
	}

	/**
	 *  Should be called before initFlurry
	 */
	public void setLogEvents(boolean enable) {
	}

	/**
	 *  Use logEvent to track user events that happen during a session.
	 * 
	 *  @param eventId event id
	 */
	public void logEvent(String eventId) {
	}

	/**
	 *  Use logEvent to track timed user events that happen during a session.
	 * 
	 *  @param eventId event id
	 *  @param timed if timed true call endTimedEvent once the event ended
	 */
	public void logEvent(String eventId, boolean timed) {
	}

	/**
	 *  Use endTimedEvent to end the timed event
	 * 
	 *  @param eventId event id
	 */
	public void endTimedEvent(String eventId) {
	}

	/**
	 *  Use onPageView to report page view count
	 */
	public void onPageView() {
	}

	/**
	 *  Use this to log the user's assigned ID or username in your system. This should be called before ini
	 */
	public void setUserID(String name) {
	}

	/**
	 *  Use this to log the user's age after identifying the user. Valid inputs are 0 or greater.
	 */
	public void setAge(int age) {
	}

	/**
	 *  Use this to log the user's gender after identifying the user. 
	 *  Valid inputs are m (male) or f (female)
	 */
	public void setGender(String gender) {
	}

	/**
	 *  This should be called before startSession
	 */
	public void setAdSpaceName(String adSpace) {
	}

	public boolean isAdReady() {
	}

	public void fetchAd() {
	}

	public void displayAd() {
	}

	public void destroyAd() {
	}

	public void setAdsListener(FlurryAdsListener l) {
	}

	public static final class SDK {


		public static final FlurryManager.SDK ANDROID;

		public static final FlurryManager.SDK IPHONE;

		public static FlurryManager.SDK[] values() {
		}

		public static FlurryManager.SDK valueOf(String name) {
		}
	}
}
