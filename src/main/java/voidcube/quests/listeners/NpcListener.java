package voidcube.quests.listeners;

import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import static voidcube.quests.tools.FileTools.progress;


public class NpcListener implements Listener {

    @EventHandler
    public static void onNpcClick(NPCRightClickEvent event) {

        if(event.getNPC().getName().equals("Влад") && progress.get(event.getClicker().getName()) == 0) {

            event.getClicker().sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "Итер" + ChatColor.GRAY + "] "
                    + ChatColor.GOLD + "-> " + ChatColor.RESET + "Доброе утро, слушай, можно воды..");

            TextComponent message = new TextComponent(ChatColor.GOLD + "Дальше");
            message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/next"));

            event.getClicker().sendMessage(message);
            event.getClicker().playSound(event.getClicker(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);

            event.getClicker().playSound(event.getClicker(), Sound.ENTITY_VILLAGER_TRADE, 1, 1);

        }

    }

}
