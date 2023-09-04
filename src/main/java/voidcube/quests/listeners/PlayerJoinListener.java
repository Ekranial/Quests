package voidcube.quests.listeners;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import voidcube.quests.Quests;
import voidcube.quests.tools.FileTools;

import static voidcube.quests.tools.FileTools.progress;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public static void onPlayerJoinEvent(PlayerLoginEvent event) {

        FileTools.CheckNew(event.getPlayer().getName());

        if (progress.get(event.getPlayer().getName()).equals(0)) {

            Bukkit.getScheduler().runTaskLater(Quests.getInstance(), () -> {
                Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
                Objective objective = scoreboard.registerNewObjective("quests", "quests");

                objective.setDisplaySlot(DisplaySlot.SIDEBAR);
                objective.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Задания");

                objective.getScore(ChatColor.GREEN + "").setScore(0);
                objective.getScore(ChatColor.GREEN + "- Поговорить с барменом").setScore(0);
                objective.getScore(ChatColor.GREEN + "").setScore(0);

                Bukkit.getPlayer(event.getPlayer().getName()).setScoreboard(scoreboard);

            }, 40L);
        } else if (progress.get(event.getPlayer().getName()).equals(7)) {

            Bukkit.getScheduler().runTaskLater(Quests.getInstance(), () -> {
                Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
                Objective objective = scoreboard.registerNewObjective("quests", "quests");

                objective.setDisplaySlot(DisplaySlot.SIDEBAR);
                objective.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Задания");

                objective.getScore(ChatColor.GREEN + "").setScore(0);
                objective.getScore(ChatColor.GREEN + "- Посетите торговцев на рынке").setScore(0);
                objective.getScore(ChatColor.GREEN + "").setScore(0);

                Bukkit.getPlayer(event.getPlayer().getName()).setScoreboard(scoreboard);

            }, 40L);
        } else if (progress.get(event.getPlayer().getName().equals()))
    }
}
