package me.xxmatthdxx.arcade.util;

import me.xxmatthdxx.arcade.Arcade;
import me.xxmatthdxx.arcade.player.ArcadePlayer;
import org.bukkit.Location;

import java.util.List;

/**
 * Created by Matthew on 2015-10-12.
 */
public class LocationUtil {

    public static void distribute(List<ArcadePlayer> players, List<Location> locs){
        for(int i = 0; i < players.size(); i++){
            players.get(i).getPlayer().teleport(locs.get(i));
        }
    }
}
