package me.xxmatthdxx.arcade.game;

import io.netty.util.internal.StringUtil;
import me.xxmatthdxx.arcade.exceptions.MapLoadException;
import me.xxmatthdxx.arcade.util.StringUtils;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.List;

/**
 * Created by Matthew on 2015-10-10.
 */
public class GameMap {

    private String name;
    private String[] desc;
    private String configLocation;

    private List<Location> spawns;
    private Location lobby;

    public GameMap(String name, String[] desc, String configLocation) {
        this.name = name;
        this.desc = desc;
        this.configLocation = configLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getDesc() {
        return desc;
    }

    public void setDesc(String[] desc) {
        this.desc = desc;
    }

    public String getConfigLocation() {
        return configLocation;
    }

    public void setConfigLocation(String configLocation) {
        this.configLocation = configLocation;
    }

    public Location getLobby() {
        if (lobby == null) {
            File file = new File(configLocation);
            if (file.exists()) {
                FileConfiguration config = YamlConfiguration.loadConfiguration(file);
                config.getConfigurationSection("maps").getKeys(false).stream().filter(name::equalsIgnoreCase).forEach(s -> {
                    Location lobby = StringUtils.deserialize(config.getString("s.lobby"));
                    this.lobby = lobby;
                });
            } else {
                try {
                    throw new MapLoadException("File does not exist!");
                } catch (MapLoadException e) {
                    e.printStackTrace();
                }
            }
        }
        return lobby;
    }
    public List<Location> getSpawns(){
        if(spawns.isEmpty()){
            File file = new File(configLocation);
            if (file.exists()) {
                FileConfiguration config = YamlConfiguration.loadConfiguration(file);
                config.getConfigurationSection("maps").getKeys(false).stream().filter(name::equalsIgnoreCase).forEach(s -> {
                    for(String spawn : config.getStringList(s + ".spawns")){
                        Location loc = StringUtils.deserialize(spawn);
                        this.spawns.add(loc);
                    }
                });
            } else {
                try {
                    throw new MapLoadException("File does not exist!");
                } catch (MapLoadException e) {
                    e.printStackTrace();
                }
            }
        }
        return spawns;
    }
}
