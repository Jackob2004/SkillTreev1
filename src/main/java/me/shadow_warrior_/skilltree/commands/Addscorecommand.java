package me.shadow_warrior_.skilltree.commands;

import me.shadow_warrior_.skilltree.menagers.Test;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Addscorecommand implements CommandExecutor {
    private Test test;

    public Addscorecommand(Test test) {
        this.test = test;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (args.length == 0) {
            p.sendMessage("Wpisz nazwe gracza: /psm <player>");
        } else {
            String playerName = args[0];
            int num = Integer.parseInt(args[1]);
            Player target = Bukkit.getServer().getPlayerExact(playerName);
            if (target == null) {
                p.sendMessage("Ten gracz nie jest online");
            }else test.setScore(target,num);
        }
        return true;
    }
}

