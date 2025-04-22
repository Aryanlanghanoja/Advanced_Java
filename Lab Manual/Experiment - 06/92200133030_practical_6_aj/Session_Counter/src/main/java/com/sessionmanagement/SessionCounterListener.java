package com.sessionmanagement;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;

@WebListener
public class SessionCounterListener implements HttpSessionListener {

    private static int activeSessions;

    public static int getActiveSessions() {
        return activeSessions;
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeSessions++;
//        System.out.println("Session Created:: Total Sessions: " + activeSessions);
        se.getSession().setAttribute("counter", new Counter());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        activeSessions--;
//        System.out.println("Session Destroyed:: Total Sessions: " + activeSessions);
    }

    public class Counter {
        private int count;

        public int getCount() {
            return count;
        }

        public void increment() {
            count++;
        }
    }
}