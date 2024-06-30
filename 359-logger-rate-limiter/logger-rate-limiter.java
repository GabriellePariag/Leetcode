class Logger {
    HashMap<String, Integer> map = new HashMap<>();

    public Logger() {

    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        // check the last timestamp the message has been printed
        int lastTime = map.getOrDefault(message, -1);
        // if the message has never been printed, add in current timestamp and return true
        if(lastTime == -1 || timestamp - lastTime >= 10) {
            map.put(message, timestamp);
            return true;
        }
        else {
            return false;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */