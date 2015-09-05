package me.xxmatthdxx.arcade.team;

import me.xxmatthdxx.arcade.player.ArcadePlayer;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matt on 2015-09-05.
 */
public class Team {

    private String name;
    private List<ArcadePlayer> players;
    private ChatColor color;

    public Team(String name, ChatColor color){
        this.name = name;
        this.color = color;
        this.players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ArcadePlayer> getPlayers() {
        return players;
    }

    public void setPlayers(List<ArcadePlayer> players) {
        this.players = players;
    }

    public ChatColor getColor() {
        return color;
    }

    public void setColor(ChatColor color) {
        this.color = color;
    }
}
