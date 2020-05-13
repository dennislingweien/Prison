/**
 * 
 */
package com.Prison.main;
import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
/**
 * @author Wayne's Laptop
 *
 */
public class YamlManager {

	private Main main = new Main(); //reference to main directory
	
	public String readYAML(PlayerData pd, String key) {
		File file = new File(main.getDataFolder() + "/Player/" + pd.getPlayer().getUniqueId().toString() + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		return config.getConfigurationSection(key).toString();
	}
	public void writeYAML(PlayerData pd, String key, String data) {
		File file = new File(main.getDataFolder() + "/Player/" + pd.getPlayer().getUniqueId().toString() + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		config.set(key, data);
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
