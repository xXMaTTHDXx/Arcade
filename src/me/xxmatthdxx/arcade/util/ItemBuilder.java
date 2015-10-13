package me.xxmatthdxx.arcade.util;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Matthew on 2015-10-11.
 */
public class ItemBuilder {

    private Material material;
    private int amount;
    private ItemMeta meta;
    private List<String> lore;
    private String name;
    private short data;
    private boolean isDataItem;

    public ItemBuilder(Material material, int amount, String name, short data, String... lore) {
        this.material = material;
        this.amount = amount;
        this.name = name;
        this.lore = Arrays.asList(lore);
        if (data == 0) {
            isDataItem = false;
        } else {
            isDataItem = true;
        }
    }

    public ItemStack build() {
        if (isDataItem) {
            ItemStack item = new ItemStack(material, amount);
            meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
            meta.setLore(lore);
            item.setItemMeta(meta);
            return item;
        }
        else {
            ItemStack item = new ItemStack(material, amount, data);
            meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
            meta.setLore(lore);
            item.setItemMeta(meta);
            return item;
        }
    }
}
