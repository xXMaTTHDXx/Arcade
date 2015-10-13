package me.xxmatthdxx.arcade;

import me.xxmatthdxx.arcade.game.ArcadeGame;
import me.xxmatthdxx.arcade.game.GameMap;
import me.xxmatthdxx.arcade.kit.Kit;
import org.bukkit.plugin.java.JavaPlugin;


/**
 * Created by Matthew on 2015-10-10.
 */
public interface GameCore {

    ArcadeGame setupGame();

    Kit[] registerKits();

    GameMap[] registerMaps();
}
