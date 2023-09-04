package voidcube.quests;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.units.qual.N;
import voidcube.quests.commands.Next;
import voidcube.quests.listeners.NpcListener;
import voidcube.quests.listeners.PlayerJoinListener;
import voidcube.quests.listeners.PlayerLeaveListener;
import voidcube.quests.tools.FileTools;


public final class Quests extends JavaPlugin {

    public static Quests instance;

    @Override
    public void onEnable() {

        instance = this;

        this.getCommand("next").setExecutor(new Next());
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new NpcListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerLeaveListener(), this);
        FileTools.GetProgress();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Quests getInstance() {
        return instance;
    }

}
