package me.xxmatthdxx.arcade.player;

import me.xxmatthdxx.arcade.Arcade;
import org.bukkit.entity.Player;

/**
 * Created by Matthew on 2015-10-11.
 */
public class ArcadePlayer {

    private Player player;

    public enum PlayerType {
        SPECTATOR, PLAYER;
    }

    PlayerType type = PlayerType.PLAYER;

    public ArcadePlayer(Player player){
        this.player = player;
    }

    public ArcadePlayer(Player player, PlayerType type){
        this.player = player;
        this.type = type;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public PlayerType getType() {
        return type;
    }

    public void setType(PlayerType type) {
        this.type = type;
    }
}
