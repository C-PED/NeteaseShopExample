package com.cped.demo.netesaeshop;

import com.cped.demo.netesaeshop.items.ExpItem;
import com.cped.neteaseshop.NeteaseShop;
import com.neteasemc.spigotmaster.SpigotMaster;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class DemoShop extends JavaPlugin implements Listener {
    @Getter
    private static DemoShop instance;
    @Getter
    private static SpigotMaster master;
    @Getter
    private static NeteaseShop neteaseShop;


    @Override
    public void onLoad() {
        instance = this;
        master = (SpigotMaster) getServer().getPluginManager().getPlugin("SpigotMaster");
    }

    @Override
    public void onEnable() {
        //此处接口我们在开发者后台的实现指令就应该是exp:100
        //此处必须注册你所写的这个商品此处必须将初始化NeteaseShop放在onEnable()方法下
        neteaseShop = new NeteaseShop(master,new ShopAPIExample());
        getNeteaseShop().getFacaty().registerType(new ExpItem());
        getServer().getPluginManager().registerEvents(this,this);
    }

    @Override
    public void onDisable() {}

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();
        switch (event.getMessage()){
            case "shop":
                getMaster().openShop(player);
                break;
        }
    }
}
