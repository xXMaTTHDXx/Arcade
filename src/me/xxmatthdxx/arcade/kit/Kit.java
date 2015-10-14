package me.xxmatthdxx.arcade.kit;

import jdk.nashorn.internal.objects.annotations.Getter;
import me.xxmatthdxx.arcade.player.ArcadePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Matthew on 2015-10-10.
 */
public abstract class Kit {

    ItemStack[] armor;
    ItemStack[] items;
    String name;
    String[] desc;
    ItemStack displayItem;



    public Kit(String name){
        this.name = name;
    }

    public Kit(ItemStack[] armor, ItemStack[] items, ItemStack displayItem, String name, String[] desc) {
        this.armor = armor;
        this.items = items;
        this.name = name;
        this.desc = desc;
        this.displayItem = displayItem;
    }

    public abstract void giveKit(ArcadePlayer player);

    public abstract ItemStack[] getArmor();

    public abstract ItemStack[] getItems();

    public abstract String[] getDesc();

    public abstract String getName();

    public abstract ItemStack getDisplayItem();
}
