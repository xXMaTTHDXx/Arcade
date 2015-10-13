package me.xxmatthdxx.arcade.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Created by Matthew on 2015-10-10.
 */
public class GameStateChangeEvent extends Event {


    private static final HandlerList handlers = new HandlerList();
    private String state;

    public GameStateChangeEvent(String state) {
        state = state;
    }

    public String getMessage() {
        return state;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
