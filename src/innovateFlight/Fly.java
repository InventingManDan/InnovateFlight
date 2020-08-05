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
		if (sender instanceof Player) {
			if (command.getName().equalsIgnoreCase("fly")) {
				Player p = (Player) sender;
				if (isAdmin(p)) {
					if (args.length == 0) {
						p.sendMessage(
								ChatColor.GOLD + "----" + ChatColor.RED + "Innovate Flight" + ChatColor.GOLD + "----");
						p.sendMessage(ChatColor.GOLD + "Usage:");
						p.sendMessage("/fly <on|off> (Player)");
						p.sendMessage("/fly speed <0-9> (Player)");
						if (flightEnabled(p) == true) {
							p.sendMessage(ChatColor.GOLD + "Flight is " + ChatColor.RED + "enabled");
							flightSpeed(p);
							isFlying(p);
						}
						if (flightEnabled(p) == false) {
							p.sendMessage(ChatColor.GOLD + "Flight is " + ChatColor.RED + "disabled");
							flightSpeed(p);
						}
					}
					if (args.length == 1) {
						if (args[0].equalsIgnoreCase("on")) {
							flightOn(p);
						}
						if (args[0].equalsIgnoreCase("off")) {
							flightOff(p);
						}
					}
					if (args.length > 1) {
						Player f = Bukkit.getPlayerExact(args[1]);
						if (args[0].equalsIgnoreCase("on")) {
							if (f != null) {
								if (p.getName() == f.getName()) {
									flightOn(p);
								} else {
									flightOn(f);
									p.sendMessage(ChatColor.GOLD + "Flight set to " + ChatColor.RED + "On"
											+ ChatColor.GOLD + " for " + ChatColor.RED + f.getName());
								}
							} else {
								@SuppressWarnings("deprecation")
								OfflinePlayer o = Bukkit.getServer().getOfflinePlayer(args[1]);
								if (o.hasPlayedBefore()) {
									p.sendMessage(ChatColor.RED + o.getName() + " is not online");
								} else {
									p.sendMessage(ChatColor.RED + args[1] + " has never joined the server");
								}
							}
						}
						if (args[0].equalsIgnoreCase("off")) {
							if (f != null) {
								if (p.getName() == f.getName()) {
									flightOff(p);
								} else {
									flightOff(f);
									p.sendMessage(ChatColor.GOLD + "Flight set to " + ChatColor.RED + "Off"
											+ ChatColor.GOLD + " for " + ChatColor.RED + f.getName());
								}
							} else {
								@SuppressWarnings("deprecation")
								OfflinePlayer o = Bukkit.getServer().getOfflinePlayer(args[1]);
								if (o.hasPlayedBefore()) {
									p.sendMessage(ChatColor.RED + o.getName() + " is not online");
								} else {
									p.sendMessage(ChatColor.RED + args[1] + " has never joined the server");
								}
							}
						}
					}
					if (args.length == 2) {
						if (args[0].equalsIgnoreCase("speed")) {
							setSpeed(p, args);
						}
					}
					if (args.length > 2) {
						Player f = Bukkit.getPlayerExact(args[2]);
						if (args[0].equalsIgnoreCase("speed")) {
							if (f != null) {
								if (p.getName() == f.getName()) {
									setSpeed(p, args);
								} else {
									setSpeed(f, args);
									fConfirm(p, args);
								}
							} else {
								@SuppressWarnings("deprecation")
								OfflinePlayer o = Bukkit.getServer().getOfflinePlayer(args[2]);
								if (o.hasPlayedBefore()) {
									p.sendMessage(ChatColor.RED + o.getName() + " is not online");
								} else {
									p.sendMessage(ChatColor.RED + args[2] + " has never joined the server");
								}
							}
						}
					}
				}
				if (isMod(p)) {
					if (args.length == 0) {
						p.sendMessage(
								ChatColor.GOLD + "----" + ChatColor.RED + "Innovate Flight" + ChatColor.GOLD + "----");
						p.sendMessage(ChatColor.GOLD + "Usage:");
						p.sendMessage("/fly <on|off>");
						p.sendMessage("/fly speed <0-9>");
						if (flightEnabled(p) == true) {
							p.sendMessage(ChatColor.GOLD + "Flight is " + ChatColor.RED + "enabled");
							flightSpeed(p);
							isFlying(p);
						}
						if (flightEnabled(p) == false) {
							p.sendMessage(ChatColor.GOLD + "Flight is " + ChatColor.RED + "disabled");
							flightSpeed(p);
							isFlying(p);
						}
					}
					if (args.length == 1) {
						if (args[0].equalsIgnoreCase("on")) {
							flightOn(p);
						}
						if (args[0].equalsIgnoreCase("off")) {
							flightOff(p);
						}
					}
					if (args.length > 1) {
						Player f = Bukkit.getPlayerExact(args[1]);
						if (args[0].equalsIgnoreCase("on")) {
							if (f != null) {
								if (p.getName() == f.getName()) {
									flightOn(p);
								} else {
									noPermission(p);
								}
							} else {
								@SuppressWarnings("deprecation")
								OfflinePlayer o = Bukkit.getServer().getOfflinePlayer(args[1]);
								if (o.hasPlayedBefore()) {
									noPermission(p);
								} else {
									noPermission(p);
								}
							}
						}
						if (args[0].equalsIgnoreCase("off")) {
							if (f != null) {
								if (p.getName() == f.getName()) {
									flightOff(p);
								} else {
									flightOff(f);
									noPermission(p);
								}
							} else {
								@SuppressWarnings("deprecation")
								OfflinePlayer o = Bukkit.getServer().getOfflinePlayer(args[1]);
								if (o.hasPlayedBefore()) {
									noPermission(p);
								} else {
									noPermission(p);
								}
							}
						}
					}
					if (args.length == 2) {
						if (args[0].equalsIgnoreCase("speed")) {
							setSpeed(p, args);
						}
					}
					if (args.length > 2) {
						Player f = Bukkit.getPlayerExact(args[2]);
						if (args[0].equalsIgnoreCase("speed")) {
							if (f != null) {
								if (p.getName() == f.getName()) {
									setSpeed(p, args);
								} else {
									noPermission(p);
								}
							} else {
								@SuppressWarnings("deprecation")
								OfflinePlayer o = Bukkit.getServer().getOfflinePlayer(args[2]);
								if (o.hasPlayedBefore()) {
									noPermission(p);
								} else {
									noPermission(p);
								}
							}
						}
					}
				} else {
					if (isPlayer(p)) {
						if (args.length == 0) {
							if (flightEnabled(p) == true) {
								p.sendMessage(ChatColor.GOLD + "----" + ChatColor.RED + "Innovate Flight"
										+ ChatColor.GOLD + "----");
								p.sendMessage(ChatColor.GOLD + "Usage:");
								p.sendMessage("/fly speed <0-9>");
								p.sendMessage(ChatColor.GOLD + "Flight is " + ChatColor.RED + "enabled");
								flightSpeed(p);
								isFlying(p);
							}
							if (flightEnabled(p) == false) {
								p.sendMessage(ChatColor.GOLD + "Flight is " + ChatColor.RED + "disabled");
							}
						}
						if (args.length == 1) {
							if (args[0].equalsIgnoreCase("on")) {
								noPermission(p);
							}
							if (args[0].equalsIgnoreCase("off")) {
								noPermission(p);
							}
						}
						if (args.length > 1) {
							Player f = Bukkit.getPlayerExact(args[1]);
							if (args[0].equalsIgnoreCase("on")) {
								if (f != null) {
									if (p.getName() == f.getName()) {
										noPermission(p);
									} else {
										noPermission(p);
									}
								} else {
									@SuppressWarnings("deprecation")
									OfflinePlayer o = Bukkit.getServer().getOfflinePlayer(args[1]);
									if (o.hasPlayedBefore()) {
										noPermission(p);
									} else {
										noPermission(p);
									}
								}
							}
							if (args[0].equalsIgnoreCase("off")) {
								noPermission(p);
							}
						}
						if (args.length == 2) {
							if (args[0].equalsIgnoreCase("speed")) {
								setSpeed(p, args);
							}
						}
						if (args.length > 2) {
							Player f = Bukkit.getPlayerExact(args[2]);
							if (args[0].equalsIgnoreCase("speed")) {
								if (f != null) {
									if (p.getName() == f.getName()) {
										setSpeed(p, args);
									} else {
										noPermission(p);
									}
								} else {
									@SuppressWarnings("deprecation")
									OfflinePlayer o = Bukkit.getServer().getOfflinePlayer(args[2]);
									if (o.hasPlayedBefore()) {
										noPermission(p);
									} else {
										noPermission(p);
									}
								}
							}
						}
					}
				}
			}
		} else {
			if (sender instanceof ConsoleCommandSender) {
				if (args.length == 0) {
					sender.sendMessage(
							ChatColor.GOLD + "----" + ChatColor.RED + "Innovate Flight" + ChatColor.GOLD + "----");
					sender.sendMessage(ChatColor.GOLD + "Usage:");
					sender.sendMessage("fly <on|off> <Player>");
					sender.sendMessage("fly speed <0-9> <Player>");
				}
				if (args.length == 1) {
					if (args[0].equalsIgnoreCase("on")) {
						sender.sendMessage(ChatColor.RED + "Please enter a playername");
					}
					if (args[0].equalsIgnoreCase("off")) {
						sender.sendMessage(ChatColor.RED + "Please enter a playername");
					}
				}
				if (args.length > 1) {
					Player f = Bukkit.getPlayerExact(args[1]);
					if (args[0].equalsIgnoreCase("on")) {
						if (f != null) {
							flightOn(f);
							sender.sendMessage(ChatColor.GOLD + "Flight set to " + ChatColor.RED + "On" + ChatColor.GOLD
									+ " for " + ChatColor.RED + f.getName());
						} else {
							@SuppressWarnings("deprecation")
							OfflinePlayer o = Bukkit.getServer().getOfflinePlayer(args[1]);
							if (o.hasPlayedBefore()) {
								sender.sendMessage(ChatColor.RED + o.getName() + " is not online");
							} else {
								sender.sendMessage(ChatColor.RED + args[1] + " has never joined the server");
							}
						}
					} else {
						if (args[0].equalsIgnoreCase("off")) {
							if (f != null) {
								flightOff(f);
								sender.sendMessage(ChatColor.GOLD + "Flight set to " + ChatColor.RED + "Off"
										+ ChatColor.GOLD + " for " + ChatColor.RED + f.getName());
							}
						} else {
							@SuppressWarnings("deprecation")
							OfflinePlayer o = Bukkit.getServer().getOfflinePlayer(args[1]);
							if (o.hasPlayedBefore()) {
								sender.sendMessage(ChatColor.RED + o.getName() + " is not online");
							} else {
								sender.sendMessage(ChatColor.RED + args[1] + " has never joined the server");
							}
						}
					}
				}
				if (args.length == 2) {
					if (args[0].equalsIgnoreCase("speed")) {
						sender.sendMessage(ChatColor.RED + "Please enter a playername");
					}
				}
				if (args.length > 2) {
					Player f = Bukkit.getPlayerExact(args[2]);
					if (args[0].equalsIgnoreCase("speed")) {
						if (f != null) {
							setSpeed(f, args);
							sender.sendMessage(ChatColor.GOLD + "Flight speed set to " + ChatColor.RED + args[1]
									+ ChatColor.GOLD + " for " + ChatColor.RED + f.getName());
						} else {
							@SuppressWarnings("deprecation")
							OfflinePlayer o = Bukkit.getServer().getOfflinePlayer(args[2]);
							if (o.hasPlayedBefore()) {
								sender.sendMessage(ChatColor.RED + o.getName() + " is not online");
							} else {
								sender.sendMessage(ChatColor.RED + args[2] + " has never joined the server");
							}
						}
					}
				}
			}
		}
		return false;
	}

	List<String> admin = new ArrayList<>(Arrays.asList("on", "off", "speed"));

	List<String> player = new ArrayList<>(Arrays.asList("speed"));

	List<String> speed = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));

	@Override
	public List<String> onTabComplete(CommandSender commandSender, Command command, String label, String[] args) {
		List<String> result = new ArrayList<>();

		switch (args.length) {
		case 1:
			for (String a : admin) {
				if (commandSender.isOp() || commandSender.hasPermission("fly.admin")
						|| commandSender.hasPermission("fly.mod")) {
					if (a.toLowerCase().startsWith(args[0].toLowerCase())) {
						result.add(a);
					}
				}
			}
			return result;

		case 2:
			if (args[0].equalsIgnoreCase("speed")) {
				for (String a : speed) {
					if (a.toLowerCase().startsWith(args[1].toLowerCase())) {
						result.add(a);
					}
				}
			}
			return result;
		}
		return Arrays.asList();
	}
}