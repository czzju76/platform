package com.platform.pattern.Observer.updateForDelegate;

import java.util.Date;

/**
 * @Title: Demo
 * @Description:
 * @Auther:Lyon Chen
 * @Version: 1.0
 * @create 2020/9/24 17:14
 */
public class Demo {
    private static class WatchingTVListener {

        public WatchingTVListener()
        {
            System.out.println("watching TV");
        }

        public void stopWatchingTV(Date date)
        {
            System.out.println("stop watching" + date);
        }
    }

    private static class PlayingGameListener {
        public PlayingGameListener()
        {
            System.out.println("playing");
        }

        public void stopPlayingGame(Date date)
        {
            System.out.println("stop playing" + date);
        }
    }

    public static void main(String[] args) {
        Notifier goodNotifier = new ConcreteNotifier();

        PlayingGameListener playingGameListener = new PlayingGameListener();

        WatchingTVListener watchingTVListener = new WatchingTVListener();

        goodNotifier.addListener(playingGameListener, "stopPlayingGame", new Date());

        goodNotifier.addListener(watchingTVListener, "stopWatchingTV", new Date());

        goodNotifier.oNotify();
    }
}
