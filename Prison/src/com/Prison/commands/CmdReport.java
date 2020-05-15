package com.Prison.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Prison.main.Main;
import com.Prison.main.YamlManager;

public class CmdReport implements CommandExecutor {

	private Main main;
	public CmdReport(Main main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("report")) {
			if(args.length >= 2) {
				Player target = Bukkit.getPlayer(args[0]);
				if(target == null) {

					return true;
				}
				Player p = (Player) sender;
				YamlManager yaml = new YamlManager(main);
				//add player head
				//create inventory
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < args.length; i++) {
					sb.append(args[i] + " ");
				}
				String reason = sb.toString();
				yaml.createYAML("reports");
				
				p.sendMessage("Report sent!");
				
				return true;
			}





		}





		return false;
	}

}
