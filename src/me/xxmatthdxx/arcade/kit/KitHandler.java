package me.xxmatthdxx.arcade.kit;

import me.xxmatthdxx.arcade.game.ArcadeHandler;
import me.xxmatthdxx.arcade.player.ArcadePlayer;
import me.xxmatthdxx.arcade.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;

/**
 * Created by Matthew on 2015-10-11.
 */
public class KitHandler {

    private HashMap<ArcadePlayer, Kit> playerKits = new HashMap<>();

    public KitHandler(){
    }

    public void openKitMenu(ArcadePlayer player){
        Player rawPlayer = player.getPlayer();
        Inventory inv = Bukkit.createInventory(null, ArcadeHandler.getInstance().getCurrentGame().getKits().size(), "Pick your kits!");

        for(Kit kit : ArcadeHandler.getInstance().getCurrentGame().getKits()){
            inv.addItem(new ItemBuilder(kit.getDisplayItem().getType(), 1, kit.getName(), (short) 0, kit.getDesc()).build());
        }
        rawPlayer.openInventory(inv);
    }

    public HashMap<ArcadePlayer, Kit> getPlayerKits() {
        return playerKits;
    }

    public Kit getKit(ArcadePlayer player){
        if(playerKits.get(player) != null){
            return playerKits.get(player);
        }
        else {
            return ArcadeHandler.getInstance().getCurrentGame().getKits().get(0);
        }
    }
}
