package me.xxmatthdxx.arcade.listeners;

import me.xxmatthdxx.arcade.events.ArcadePlayerDamageEvent;
import me.xxmatthdxx.arcade.events.ArcadePlayerJoinEvent;
import me.xxmatthdxx.arcade.events.ArcadePlayerLeaveEvent;
import me.xxmatthdxx.arcade.game.ArcadeHandler;
import me.xxmatthdxx.arcade.game.GameInfo;
import me.xxmatthdxx.arcade.player.ArcadePlayer;
import me.xxmatthdxx.arcade.player.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created by Matthew on 2015-10-10.
 */
public class PlayerListener implements Listener {


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player pl = e.getPlayer();
        Bukkit.getPluginManager().callEvent(new ArcadePlayerJoinEvent(pl));
        PlayerManager.getInstance().createPlayer(pl);
        ArcadeHandler.getInstance().getCurrentGame().getAllPlayers().add(PlayerManager.getInstance().getPlayer(pl.getName()));
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e){
        Player pl = e.getPlayer();
        Bukkit.getPluginManager().callEvent(new ArcadePlayerLeaveEvent(pl));
    }

    @EventHandler
    public void onPlayerDamage(EntityDamageEvent e){
        if(!(e.getEntity() instanceof Player)) return;

        Player pl = (Player) e.getEntity();
        EntityDamageEvent.DamageCause cause = e.getCause();
        Bukkit.getPluginManager().callEvent(new ArcadePlayerDamageEvent(pl,e.getCause(), e.getDamage()));
    }

    @EventHandler
    public void onPlayerBlockBreak(BlockBreakEvent e){
        GameInfo info = ArcadeHandler.getInstance().getCurrentGame().getInfo();
        if(info == null){
            return;
        }
        if(!info.isCanBreakBlocks()){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerBlockPlace(BlockPlaceEvent e){
        GameInfo info = ArcadeHandler.getInstance().getCurrentGame().getInfo();
        if(info == null){
            return;
        }
        if(!info.isCanPlaceBlocks()){
            e.setCancelled(true);
        }
    }
}
