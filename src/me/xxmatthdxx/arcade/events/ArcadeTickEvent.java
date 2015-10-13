package me.xxmatthdxx.arcade.events;

import me.xxmatthdxx.arcade.game.GameState;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Created by Matthew on 2015-10-10.
 */
public class ArcadeTickEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    private int second;
    private GameState state;

    public ArcadeTickEvent(GameState state, int second) {
        this.second = second;
        this.state = state;
    }

    public int getSecond() {
        return second;
    }

    public GameState getState(){
        return state;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
