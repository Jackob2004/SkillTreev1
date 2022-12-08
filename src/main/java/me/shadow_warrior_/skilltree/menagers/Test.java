package me.shadow_warrior_.skilltree.menagers;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class Test {

    public static HashMap<UUID, Integer> test = new HashMap<>();

    public static HashMap<UUID, Integer> points = new HashMap<>();

    public void addScore(Player player, int amount) {
        test.putIfAbsent(player.getUniqueId(), 1);
        int currentAmount = test.get(player.getUniqueId());
        int newAmount = currentAmount + amount;
        test.put(player.getUniqueId(), newAmount);
        points.put(player.getUniqueId(), newAmount);
    }

    public void removeScore(Player player, int amount) {
        test.putIfAbsent(player.getUniqueId(), 1);
        int currentAmount = test.get(player.getUniqueId());
        int newAmount = currentAmount - amount;
        test.put(player.getUniqueId(), newAmount);
        points.put(player.getUniqueId(), newAmount);
    }

    public void setScore(Player player, int amount) {
        test.put(player.getUniqueId(), amount);
    }

    public int getScore(Player player) {
        test.putIfAbsent(player.getUniqueId(), 1);
        return test.get(player.getUniqueId());
    }




}
