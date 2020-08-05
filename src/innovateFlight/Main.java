package innovateFlight;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	public static String version = "1.0.0";
	Logger logger = Bukkit.getLogger();

	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		this.logger.info("InnovateFlight " + version + " has been enabled.");
		new Fly();
		this.getCommand("fly").setExecutor(new Fly());
		this.getCommand("fly").setTabCompleter(new Fly());
	}
	public void onDisable() {
		this.logger.info("InnovateFlight " + version + " has been disabled.");
	}
}