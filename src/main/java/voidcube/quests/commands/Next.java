package voidcube.quests.commands;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.jetbrains.annotations.NotNull;
import voidcube.quests.tools.FileTools;

import java.util.Objects;

import static voidcube.quests.tools.FileTools.progress;

public class Next implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (progress.get(commandSender.getName()) == 0) {
            FileTools.SetProgress(commandSender.getName(), 1);

            commandSender.sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "Влад" + ChatColor.GRAY + "] "
                    + ChatColor.GOLD + "-> " + ChatColor.RESET + "О, наш ночной герой явился, конечно-конечно. " +
                    "Только оплати свой двухдневный долг, и я тебе сразу хоть мëду с сыром подам!");

            TextComponent message = new TextComponent(ChatColor.GOLD + "Дальше");
            message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/next"));

            Bukkit.getPlayer(commandSender.getName()).playSound(Bukkit.getPlayer(commandSender.getName()), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
            commandSender.sendMessage(message);

        } else if (progress.get(commandSender.getName()) == 1) {
            FileTools.SetProgress(commandSender.getName(), 2);

            commandSender.sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "Итер" + ChatColor.GRAY + "] "
                    + ChatColor.GOLD + "-> " + ChatColor.RESET + "Да, конечно, секунду..");

            TextComponent message = new TextComponent(ChatColor.GOLD + "Дальше");
            message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/next"));

            Bukkit.getPlayer(commandSender.getName()).playSound(Bukkit.getPlayer(commandSender.getName()), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
            commandSender.sendMessage(message);

        } else if (progress.get(commandSender.getName()) == 2) {
            FileTools.SetProgress(commandSender.getName(), 3);

            commandSender.sendMessage(ChatColor.GRAY + "" + ChatColor.ITALIC + "Осмотрев инвентарь, вы обнаруживаете," +
                    " что не имеете при себе ни денег, ни чего-нибудь, что можно было бы предложить в качестве оплаты.");

            TextComponent message = new TextComponent(ChatColor.GOLD + "Дальше");
            message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/next"));

            Bukkit.getPlayer(commandSender.getName()).playSound(Bukkit.getPlayer(commandSender.getName()), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
            commandSender.sendMessage(message);

        } else if (progress.get(commandSender.getName()) == 3) {
            FileTools.SetProgress(commandSender.getName(), 4);

            commandSender.sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "Итер" + ChatColor.GRAY + "] "
                    + ChatColor.GOLD + "-> " + ChatColor.RESET + "Кхм.. Прости, но за душой ни гроша.. ");

            TextComponent message = new TextComponent(ChatColor.GOLD + "Дальше");
            message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/next"));

            Bukkit.getPlayer(commandSender.getName()).playSound(Bukkit.getPlayer(commandSender.getName()), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
            commandSender.sendMessage(message);

        } else if (progress.get(commandSender.getName()) == 4) {
            FileTools.SetProgress(commandSender.getName(), 5);

            commandSender.sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "Влад" + ChatColor.GRAY + "] "
                    + ChatColor.GOLD + "-> " + ChatColor.RESET + "Да ты издеваешься! Ты хоть представляешь," +
                    " сколько ты задолжал? С тебя 2 золотых, не меньше! Я больше терпеть это не намерен!" +
                    " Ты изначально показался мне надёжным человеком, но и моему терпению есть предел." +
                    " Если к вечеруне вернешь задолженность, то луна станет твоим одеялом, а голая земля постелью!");

            TextComponent message = new TextComponent(ChatColor.GOLD + "Дальше");
            message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/next"));

            Bukkit.getPlayer(commandSender.getName()).playSound(Bukkit.getPlayer(commandSender.getName()), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
            commandSender.sendMessage(message);

        } else if (progress.get(commandSender.getName()) == 5) {
            FileTools.SetProgress(commandSender.getName(), 6);

            commandSender.sendMessage(ChatColor.GRAY + "" + ChatColor.ITALIC + "От криков бармена" +
                    " ваша голова заболела лишь сильнее." +
                    " На уме были лишь две вещи: жажда и желание заработать до вечера хотя бы половину нужной суммы.");

            TextComponent message = new TextComponent(ChatColor.GREEN + "->  " + ChatColor.GOLD + "За душой, ни гроша..  " + ChatColor.GREEN + "<-");
            message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/next"));

            Bukkit.getPlayer(commandSender.getName()).playSound(Bukkit.getPlayer(commandSender.getName()), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
            commandSender.sendMessage(message);

        } else if (progress.get(commandSender.getName()) == 6) {
            FileTools.SetProgress(commandSender.getName(), 7);

            Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
            Objective objective = scoreboard.registerNewObjective("quests", "quests");

            objective.setDisplaySlot(DisplaySlot.SIDEBAR);
            objective.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Задания");

            objective.getScore(ChatColor.GREEN + "").setScore(0);
            objective.getScore(ChatColor.GREEN + "- Посетите торговцев на рынке").setScore(0);
            objective.getScore(ChatColor.GREEN + "").setScore(0);

            Player player = Bukkit.getPlayer(commandSender.getName());

            player.setScoreboard(scoreboard);
            player.sendTitle(ChatColor.GOLD + "За душой, ни гроша..", ChatColor.GREEN + "Задание принято");
            player.playSound(player, Sound.ENTITY_VILLAGER_YES  , 3, 1);

        }
        return false;
    }
}
