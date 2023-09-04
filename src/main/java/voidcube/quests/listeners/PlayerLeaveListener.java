package voidcube.quests.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import voidcube.quests.tools.FileTools;

import static voidcube.quests.tools.FileTools.progress;

public class PlayerLeaveListener implements Listener {

    @EventHandler
    public static void onPlayerLeave(PlayerQuitEvent event) {
        if (1 <= progress.get(event.getPlayer().getName()) && progress.get(event.getPlayer().getName()) <= 6) {
            progress.put(event.getPlayer().getName(), 0);
            FileTools.WriteProgress();
        }
    }

}
