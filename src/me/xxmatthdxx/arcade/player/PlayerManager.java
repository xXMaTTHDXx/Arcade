package me.xxmatthdxx.arcade.player;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matt on 13/10/2015.
 */
public class PlayerManager {

    private static PlayerManager instance = new PlayerManager();

    private List<ArcadePlayer> players = new ArrayList<>();

    public static PlayerManager getInstance(){
        return instance;
    }

    public ArcadePlayer getPlayer(String name){
        for(ArcadePlayer pl : players){
            if(pl.getPlayer().getName().equalsIgnoreCase(name)){
                return pl;
            }
        }
        return null;
    }

    public void createPlayer(Player player){
        players.add(new ArcadePlayer(player));
    }
}
