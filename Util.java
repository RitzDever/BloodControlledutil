package me.ritzdever.game;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class BloodController {
	@SuppressWarnings("deprecation")
	public static void spawnBlood(Location location) {// Blood effect
		int distance;
		int radius = 64 * 64;

		for (Player player : Bukkit.getServer().getOnlinePlayers()) {
			if (!location.getWorld().equals(player.getWorld())) {
				continue;
			}
			distance = (int) player.getLocation().distanceSquared(location);
			if (distance <= radius) {
				if (!player.hasMetadata("BLOOD_PREF")) {
					player.playEffect(location, Effect.POTION_BREAK, 5);
				}
			}
		}
	}
}