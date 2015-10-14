package me.xxmatthdxx.arcade;

import javafx.scene.shape.Arc;
import me.xxmatthdxx.arcade.game.ArcadeHandler;
import me.xxmatthdxx.arcade.game.GameState;
import me.xxmatthdxx.arcade.kit.KitHandler;
import me.xxmatthdxx.arcade.listeners.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Matthew on 2015-10-10.
 */
public class Arcade extends JavaPlugin {

    private static Arcade instance;
    private KitHandler kitHandler;
    private ArcadeHandler arcadeHandler;
    private GameState state;

    /**
     * TODO list
     * Make lobby teleport you to highest block.
     * Make commands.
     * Figure out the ending of games - IMPORTANT
     */

    public void onEnable(){
        instance = this;
        kitHandler = new KitHandler();
        arcadeHandler = ArcadeHandler.getInstance();
        state = GameState.LOBBY;

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerListener(), this);
    }

    public void onDisable(){

    }

    public KitHandler getKitHandler() {
        return kitHandler;
    }

    public void setState(GameState state){
        this.state = state;
    }

    public void setKitHandler(KitHandler kitHandler) {
        this.kitHandler = kitHandler;
    }

    public ArcadeHandler getArcadeHandler() {
        return arcadeHandler;
    }

    public void setArcadeHandler(ArcadeHandler arcadeHandler) {
        this.arcadeHandler = arcadeHandler;
    }

    public static Arcade getInstance(){
        return instance;
    }

    public GameState getState(){
        return state;
    }
}
