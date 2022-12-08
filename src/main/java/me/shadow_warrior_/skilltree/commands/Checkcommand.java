package me.shadow_warrior_.skilltree.commands;
import me.shadow_warrior_.skilltree.menagers.Test;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Checkcommand implements CommandExecutor {

    private Test test;

    public Checkcommand(Test test){
        this.test = test;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;
        int num = test.getScore(p);
        p.sendMessage(String.valueOf(num));
        return true;
    }
}
