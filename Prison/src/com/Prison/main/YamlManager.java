/**
 * 
 */
package com.Prison.main;
import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
/**
 * @author Wayne's Laptop
 *
 */
public class YamlManager {
	private final Main main;
	
	public YamlManager() {
		this.main = new Main();
	}
	
	
	public String readYAML(Player p, String key) {
		File file = new File(main.getDataFolder() + "/Player/" + p.getUniqueId().toString() + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		return config.getConfigurationSection(key).toString();
	}
	
	public void writeYAML(Player p, String key, String data) {
		File file = new File(main.getDataFolder() + "/Player/" + p.getUniqueId().toString() + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		config.set(key, data);
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
