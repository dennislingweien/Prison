/**
 * 
 */
package com.Prison.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Prison.main.YamlManager;

/**
 * @author Wayne's Laptop
 *
 */
public class filetest implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		if(cmd.getName().equalsIgnoreCase("filetest")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage("");
				return true;
			}
			else {
				Player current = (Player)sender;
				YamlManager manager = new YamlManager();
				
				current.sendMessage(manager.readYAML(current, "Name"));
			}
		}
		return false;
	}

}