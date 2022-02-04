import java.text.SimpleDateFormat;
import java.util.Date;

/*
    Question :
    Create a rate limiter which ensures that no more than n requests are allowed per second.
    
    Leetcode question link :
    https://leetcode.com/discuss/interview-question/124558/Uber-or-Rate-Limiter
    
    Approach :
    Maintain a counter which represents the number of requests that can be allowed so as to not exceed the limit. This counter should be incremented every (1 / n)th second till a max value of n. When processing a request, if the counter's value is greater than zero, it is decremented and the request is allowed to pass through. If the counter's value is zero, then the request is rejected.
    
    Time complexity :
    O(1) per request
    
    Space complexity : 
    O(1)
*/
public class RateLimiterClass {
    
    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateLimiter(1);
        System.out.println("Created a rate limiter with a limit of 1 QPS");
        SimpleDateFormat timestampFormatter = new SimpleDateFormat("HH.mm.ss aa");
        
        for (int requestCount = 1;requestCount <= 20;requestCount++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Caught an InterruptedException while sleeping, exiting now " + e.getMessage());
                return;
            }
            
            
            boolean allowed = rateLimiter.shouldAllow();
            String currentFormattedTime = timestampFormatter.format(new Date());
            System.out.println("Request no." + requestCount + " with timestamp " + currentFormattedTime + " was allowed : " + allowed);
        }
    }
    
    private static void handleValidation(boolean passed, String errorMessage) {
        if (!passed) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
    
    public static class RateLimiter {
        
        private final int qpsLimit;
        private final Object mutex;
        
        private int allowableRequests;
        private double lastProcessedTimestampInMs;
        
        RateLimiter(int qpsLimit) {
            handleValidation(qpsLimit > 0, "qpsLimit has to be greater than zero");
            
            this.qpsLimit = qpsLimit;
            this.mutex = new Object();
            this.allowableRequests = 0;
            this.lastProcessedTimestampInMs = lastProcessedTimestampInMs;
        }
        
        public boolean shouldAllow() {
            synchronized(mutex) {
                updateParameters();

                if (allowableRequests > 0) {
                    allowableRequests--;
                    return true;
                }
                
                return false;
            }
        }
        
        private void updateParameters() {
            double incrementIntervalInMs = ((double)1000) / ((double)qpsLimit);
            long currentTimeInMs = System.currentTimeMillis();
            double elapsedTimeSinceLastRequestInMs = ((double) currentTimeInMs) - lastProcessedTimestampInMs;
            int additionalAllowableRequests = (int) Math.floor(elapsedTimeSinceLastRequestInMs / incrementIntervalInMs);
            
            allowableRequests = Math.min(allowableRequests + additionalAllowableRequests, qpsLimit);
            lastProcessedTimestampInMs += (((double)additionalAllowableRequests) * incrementIntervalInMs);
        }
    }
}
