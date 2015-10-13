package me.xxmatthdxx.arcade.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Created by Matthew on 2015-10-10.
 */
public class ArcadePlayerJoinEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    private Player player;

    public ArcadePlayerJoinEvent(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
