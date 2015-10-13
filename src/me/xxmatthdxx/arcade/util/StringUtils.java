package me.xxmatthdxx.arcade.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

/**
 * Created by Matthew on 2015-10-11.
 */
public class StringUtils {

    public static Location deserialize(String string){
        String[] split = string.split(",");
        if(split.length == 6){
            World world = Bukkit.getWorld(split[0]);
            double x = Double.valueOf(split[1]);
            double y = Double.valueOf(split[2]);
            double z = Double.valueOf(split[3]);
            float yaw = Float.valueOf(split[4]);
            float pitch = Float.valueOf(split[5]);
            return new Location(world, x,y,z,yaw,pitch);
        }
        else {
            World world = Bukkit.getWorld(split[0]);
            double x = Double.valueOf(split[1]);
            double y = Double.valueOf(split[2]);
            double z = Double.valueOf(split[3]);
            return new Location(world, x,y,z);
        }
    }
}
