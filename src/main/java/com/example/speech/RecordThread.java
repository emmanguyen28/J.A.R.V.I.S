package com.example.speech;

public class RecordThread {
	// records duration, in milliseconds
    static final long RECORD_TIME = 10000;  // 15 secs
 
	/**
     * Entry to run the program
     */
    public void record() {
        final JavaSoundRecorder recorder = new JavaSoundRecorder();
        
 
        /* creates a new thread that waits for a specified
         amount of time before stopping */
        Thread stopper = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(RECORD_TIME);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                recorder.finish();
            }
        });
 
        stopper.start();

        // start recording
        recorder.start();
    }
}
