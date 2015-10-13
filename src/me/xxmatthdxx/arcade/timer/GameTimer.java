package me.xxmatthdxx.arcade.timer;

import me.xxmatthdxx.arcade.Arcade;
import me.xxmatthdxx.arcade.events.ArcadeTickEvent;
import me.xxmatthdxx.arcade.events.GameStateChangeEvent;
import me.xxmatthdxx.arcade.game.GameState;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by Matthew on 2015-10-10.
 */
public class GameTimer extends BukkitRunnable {

    int lobbySeconds, gameSeconds;

    public GameTimer(int lobbySeconds, int gameSeconds){
        this.lobbySeconds = lobbySeconds;
        this.gameSeconds = gameSeconds;
    }

    @Override
    public void run() {
        GameState state = Arcade.getInstance().getState();
        if(state == GameState.LOBBY){
            Bukkit.getPluginManager().callEvent(new ArcadeTickEvent(state, lobbySeconds));
            lobbySeconds = (lobbySeconds-1);
        }
        else if(state == GameState.INGAME){
            Bukkit.getPluginManager().callEvent(new ArcadeTickEvent(state, gameSeconds));
            gameSeconds = (gameSeconds -1);
        }
    }

    public int getLobbySeconds() {
        return lobbySeconds;
    }

    public void setLobbySeconds(int lobbySeconds) {
        this.lobbySeconds = lobbySeconds;
    }

    public int getGameSeconds() {
        return gameSeconds;
    }

    public void setGameSeconds(int gameSeconds) {
        this.gameSeconds = gameSeconds;
    }
}
