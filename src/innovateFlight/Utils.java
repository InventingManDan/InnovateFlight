package innovateFlight;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Utils {
	public static boolean noPermission(Player p) {
		p.sendMessage(ChatColor.RED + "You don't have permission to do that");
		return false;
	}
	public static boolean isAdmin(Player p) {
		return p.hasPermission("fly.admin");
	}
	public static boolean isMod(Player p) {
		if (!(p.isOp())) {
			if (!(p.hasPermission("fly.admin"))) {
				return p.hasPermission("fly.mod");
			}
		}
		return false;
	}
	public static boolean isPlayer(Player p) {
		if (!(p.isOp())) {
			if(!(p.hasPermission("fly.admin"))) {
				if(!(p.hasPermission("fly.mod"))) {
					return true;
				}
			}
		}
		return false;
	}
	public static boolean isFlying(Player p) {
		if (p.isFlying() == true) {
			p.sendMessage(ChatColor.GRAY + "" + ChatColor.ITALIC + "[You are flying]");
		}
		if (p.isFlying() == false) {
			p.sendMessage(ChatColor.GRAY + "" + ChatColor.ITALIC + "[You are not flying]");
		}
		return false;
	}
	public static boolean flightSpeed(Player p) {
		if (p.getFlySpeed() == 0.1f) {
			p.sendMessage(ChatColor.GOLD + "Flight speed is " + ChatColor.RED + "0");
		}
		if (p.getFlySpeed() == 0.2f) {
			p.sendMessage(ChatColor.GOLD + "Flight speed is " + ChatColor.RED + "1");
		}
		if (p.getFlySpeed() == 0.3f) {
			p.sendMessage(ChatColor.GOLD + "Flight speed is " + ChatColor.RED + "2");
		}
		if (p.getFlySpeed() == 0.4f) {
			p.sendMessage(ChatColor.GOLD + "Flight speed is " + ChatColor.RED + "3");
		}
		if (p.getFlySpeed() == 0.5f) {
			p.sendMessage(ChatColor.GOLD + "Flight speed is " + ChatColor.RED + "4");
		}
		if (p.getFlySpeed() == 0.6f) {
			p.sendMessage(ChatColor.GOLD + "Flight speed is " + ChatColor.RED + "5");
		}
		if (p.getFlySpeed() == 0.7f) {
			p.sendMessage(ChatColor.GOLD + "Flight speed is " + ChatColor.RED + "6");
		}
		if (p.getFlySpeed() == 0.8f) {
			p.sendMessage(ChatColor.GOLD + "Flight speed is " + ChatColor.RED + "7");
		}
		if (p.getFlySpeed() == 0.9f) {
			p.sendMessage(ChatColor.GOLD + "Flight speed is " + ChatColor.RED + "8");
		}
		if (p.getFlySpeed() == 1.0f) {
			p.sendMessage(ChatColor.GOLD + "Flight speed is " + ChatColor.RED + "9");
		}
		return false; 
	}
	public static boolean flightEnabled(Player p) {
		return (p.getAllowFlight());
	}
	public static boolean flightOn(Player p) {
		p.setAllowFlight(true);
		p.setFlying(true);
		p.sendMessage(ChatColor.GOLD + "Flight set to " + ChatColor.RED + "On");
		return false;
	}
	public static boolean flightOff(Player p) {
		p.setAllowFlight(false);
		p.setFlying(false);
		p.sendMessage(ChatColor.GOLD + "Flight set to " + ChatColor.RED + "Off");
		return false;
	}
	public static boolean setSpeed(Player p, String[] args) {
		if (args[1].equalsIgnoreCase("0")) {
			p.setFlySpeed(0.1f);
			p.sendMessage(
					ChatColor.GOLD + "Flight speed set to " + ChatColor.RED + "O");
		}

		if (args[1].equalsIgnoreCase("1")) {
			p.setFlySpeed(0.2f);
			p.sendMessage(
					ChatColor.GOLD + "Flight speed set to " + ChatColor.RED + "1");
		}

		if (args[1].equalsIgnoreCase("2")) {
			p.setFlySpeed(0.3f);
			p.sendMessage(
					ChatColor.GOLD + "Flight speed set to " + ChatColor.RED + "2");
		}

		if (args[1].equalsIgnoreCase("3")) {
			p.setFlySpeed(0.4f);
			p.sendMessage(
					ChatColor.GOLD + "Flight speed set to " + ChatColor.RED + "3");
		}

		if (args[1].equalsIgnoreCase("4")) {
			p.setFlySpeed(0.5f);
			p.sendMessage(
					ChatColor.GOLD + "Flight speed set to " + ChatColor.RED + "4");
		}

		if (args[1].equalsIgnoreCase("5")) {
			p.setFlySpeed(0.6f);
			p.sendMessage(
					ChatColor.GOLD + "Flight speed set to " + ChatColor.RED + "5");
		}
		if (args[1].equalsIgnoreCase("6")) {
			p.setFlySpeed(0.7f);
			p.sendMessage(
					ChatColor.GOLD + "Flight speed set to " + ChatColor.RED + "6");
		}
		if (args[1].equalsIgnoreCase("7")) {
			p.setFlySpeed(0.8f);
			p.sendMessage(
					ChatColor.GOLD + "Flight speed set to " + ChatColor.RED + "7");
		}
		if (args[1].equalsIgnoreCase("8")) {
			p.setFlySpeed(0.9f);
			p.sendMessage(
					ChatColor.GOLD + "Flight speed set to " + ChatColor.RED + "8");
		}
		if (args[1].equalsIgnoreCase("9")) {
			p.setFlySpeed(1.0f);
			p.sendMessage(
					ChatColor.GOLD + "Flight speed set to " + ChatColor.RED + "9");
		}
		return false;
	}
	public static boolean fConfirm(Player p, String[] args) {
		p.sendMessage(ChatColor.GOLD + "Flight speed set to "
				+ ChatColor.RED + "O" + ChatColor.GOLD + " for "
				+ ChatColor.RED + args[1]);
		return false;
	}
}