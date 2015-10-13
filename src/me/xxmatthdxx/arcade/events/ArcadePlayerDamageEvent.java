package me.xxmatthdxx.arcade.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDamageEvent;

/**
 * Created by Matthew on 2015-10-10.
 */
public class ArcadePlayerDamageEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    private Player player;
    private double damage;
    private EntityDamageEvent.DamageCause cause;

    public ArcadePlayerDamageEvent(Player player, EntityDamageEvent.DamageCause cause, double damage) {
        this.player = player;
        this.damage = damage;
        this.cause = cause;
    }

    public Player getPlayer() {
        return player;
    }

    public double getDamage(){
        return damage;
    }

    public EntityDamageEvent.DamageCause getCause(){
        return cause;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
