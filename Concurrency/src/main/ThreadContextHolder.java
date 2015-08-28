package main;

/**
 * Created by forando on 28.08.15.<br>
 *     this class holds all data unique for each thread.
 */
public class ThreadContextHolder {
    public static final ThreadLocal<String>id = new ThreadLocal<String>();

    public static final String getThreadID(){
        return id.get();
    }

    public static final void setThreadID(String val){
        id.set(val);
    }
}
