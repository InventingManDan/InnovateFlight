package innovateFlight;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Utils {

	public static void sendMenu(CommandSender sender) {
		sender.sendMessage(
				ChatColor.GOLD + "----" + ChatColor.RED + "Innovate Flight" + ChatColor.GOLD + "----");
		sender.sendMessage(ChatColor.GOLD + "Usage:");

		if (sender.hasPermission("innovateflight.toggle")) {
			sender.sendMessage("/fly <on|off>" + (sender.hasPermission("innovateflight.setothers") ? " [Player]" : ""));
		}

		if (sender.hasPermission("innovateflight.speed")) {
			sender.sendMessage("/fly speed <0-9>" + (sender.hasPermission("innovateflight.setothers") ? " [Player]" : ""));
		}

		if (!(sender instanceof Player)) {
			return;
		}
		Player player = (Player) sender;

		sender.sendMessage(ChatColor.GOLD + "Flight is " + ChatColor.RED + (player.getAllowFlight() ? "enabled" : "disabled"));

		player.sendMessage(ChatColor.GOLD + "Flight speed is " + ChatColor.RED + Math.round(player.getFlySpeed() * 10));
		player.sendMessage(ChatColor.GRAY + "" + ChatColor.ITALIC + (player.isFlying() ? "[You are flying]" : "[You are not flying]"));
	}

	public static void setFlight(Player player, boolean toggle) {
		player.setAllowFlight(toggle);
		player.setFlying(toggle);
		player.sendMessage(ChatColor.GOLD + "Flight set to " + ChatColor.RED + (toggle ? "ON" : "OFF"));
	}

	public static int setFlySpeed(Player player, int speed) {
		if (speed < 1) speed = 1;
		if (speed > 10) speed = 10;

		player.setFlySpeed(speed/10f);
		player.sendMessage(
				ChatColor.GOLD + "Flight speed set to " + ChatColor.RED + speed);

		return speed;
	}
}