package com.cped.demo.netesaeshop.items;

import com.cped.neteaseshop.ItemAchieve;
import org.bukkit.entity.Player;

public class ExpItem implements ItemAchieve {
    @Override
    public void run(Player player, String[] strings) {
        player.giveExp(Integer.valueOf(strings[1]));
    }

    @Override
    public String getType() {
        return "exp";
    }
}
