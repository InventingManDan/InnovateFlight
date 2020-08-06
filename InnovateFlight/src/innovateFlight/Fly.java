package innovateFlight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

public class Fly extends Utils implements CommandExecutor, TabCompleter {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		switch (args.length) {
			case 0:
				if (sender.hasPermission("innovateflight.menu")) {
					sendMenu(sender);
				}
				break;

			case 1:
				if(sender instanceof Player) {
					Player player = (Player) sender;
					if (sender.hasPermission("innovateflight.toggle")) {
						if (args[0].equalsIgnoreCase("on")) {
							setFlight(player, true);
						} else if (args[0].equalsIgnoreCase("off")) {
							setFlight(player, false);
						}
					}
				}
				break;

			case 2:
				if (sender instanceof Player) {
					Player player = (Player) sender;
					if (sender.hasPermission("innovateflight.speed")) {
						if (args[0].equalsIgnoreCase("speed")) {
							try {
								int speed = Integer.parseInt(args[1]);
								setFlySpeed(player, speed);
								break;
							} catch (NumberFormatException e) {
								break;
							}
						}
					}
				}

				if (sender.hasPermission("innovateflight.toggle") && sender.hasPermission("innovateflight.setothers")) {
					Player requestedPlayer = Bukkit.getPlayerExact(args[1]);

					if (requestedPlayer == null) {
						sender.sendMessage(ChatColor.RED + args[1] + " is not online");
						break;
					}
					
					Boolean toggle = null;
					if (args[0].equalsIgnoreCase("on")) toggle = true;
					if (args[0].equalsIgnoreCase("off")) toggle = false;

					if (toggle != null) {
						setFlight(requestedPlayer, toggle);
						sender.sendMessage(ChatColor.GOLD + "Flight set to " + ChatColor.RED + args[0].toUpperCase()
								+ ChatColor.GOLD + " for " + ChatColor.RED + requestedPlayer.getName());
					}
				}
				break;

			case 3:
				if (sender.hasPermission("innovateflight.speed") && sender.hasPermission("innovateflight.setothers")) {
					if (args[0].equalsIgnoreCase("speed")) {
						Player requestedPlayer = Bukkit.getPlayerExact(args[1]);

						if (requestedPlayer == null) {
							sender.sendMessage(ChatColor.RED + args[1] + " is not online");
							break;
						}

						try {
							int speed = Integer.parseInt(args[2]);
							speed = setFlySpeed(requestedPlayer, speed);

							sender.sendMessage(ChatColor.GOLD + "Flight speed set to "
									+ ChatColor.RED + speed + ChatColor.GOLD + " for "
									+ ChatColor.RED + requestedPlayer.getDisplayName());
						} catch (NumberFormatException e) {
							break;
						}
					}
				}
		}
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender commandSender, Command command, String label, String[] args) {
		List<String> result = new ArrayList<>();

		switch (args.length) {
		case 1:
			if (commandSender.hasPermission("innovateflight.toggle")) {
				if("on".startsWith(args[0])) result.add("on");
				if("off".startsWith(args[0])) result.add("off");
			}

			if (commandSender.hasPermission("innovateflight.speed")) {
				if("speed".startsWith(args[0])) result.add("speed");
			}

			return result;

		case 2:
			if (args[0].equalsIgnoreCase("speed")) {
				if (commandSender.hasPermission("innovateflight.speed")) {
					for (int i = 1; i < 11; i++) {
						if(Integer.toString(i).startsWith(args[1])) result.add(Integer.toString(i));
					}
				}
				if (commandSender.hasPermission("innovateflight.setothers")) {
					for (Player player : Bukkit.getOnlinePlayers()) {
						if(player.getDisplayName().toLowerCase().startsWith(args[1])) result.add(player.getDisplayName());
					}
				}
			}

			if (args[0].equalsIgnoreCase("on") || args[0].equalsIgnoreCase("off")) {
				if (commandSender.hasPermission("innovateflight.toggle") && commandSender.hasPermission("innovateflight.setothers")) {
					for (Player player : Bukkit.getOnlinePlayers()) {
						if(player.getDisplayName().toLowerCase().startsWith(args[1])) result.add(player.getDisplayName());
					}
				}
			}

			return result;

		case 3:
			if (args[0].equalsIgnoreCase("speed")) {
				if (commandSender.hasPermission("innovateflight.speed") && commandSender.hasPermission("innovateflight.setothers")) {
					for (int i = 1; i < 11; i++) {
						if(Integer.toString(i).startsWith(args[2])) result.add(Integer.toString(i));
					}
				}
			}

			return result;
		}

		return Arrays.asList();
	}
}