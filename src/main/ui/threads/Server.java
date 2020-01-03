package ui.threads;

import ui.frames.ChatFrame;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Server {


    public static void main(String... args) throws IOException, InvocationTargetException, InterruptedException {
        ChatFrame cf = new ChatFrame();
        (new Listener(cf)).start();
        new Speaker(cf);


    }


}