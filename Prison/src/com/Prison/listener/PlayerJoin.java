package com.Prison.listener;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import com.Prison.main.Main;
import com.Prison.main.PlayerData;
import com.Prison.main.Util;


public class PlayerJoin implements Listener {

	private Main main;
	public PlayerJoin(Main main) {
		this.main = main;
	}
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {

		Player p = e.getPlayer();

		//Bukkit.broadcastMessage(ChatColor.DARK_GREEN + " + " + ChatColor.GRAY + p.getName());	

		PlayerData pd = new PlayerData(p);
		setup(pd);
		setupScoreboard(p);
	}



	public void setup(PlayerData pd) {
		String uuid = pd.getPlayer().getUniqueId().toString();
		File file = new File(main.getDataFolder() + "/Player/"+ uuid + ".yml");	
		if(!file.exists()) {
			try {
				file.createNewFile();
				pd.getPlayer().sendMessage("File created");
				pd.loadYAML(main);
			} catch (IOException e) {
				e.printStackTrace();
				pd.getPlayer().sendMessage("Error creating");
			}
		}
		else {
			pd.getPlayer().sendMessage("file already created!");
		}

	}



	public void setupScoreboard(Player p) {
		Scoreboard board = Bukkit.getServer().getScoreboardManager().getNewScoreboard();
		int online = Bukkit.getOnlinePlayers().size();
		int max = Bukkit.getMaxPlayers();

		Objective obj = board.registerNewObjective("Test1", "test2", "test3");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);

		obj.setDisplayName(Util.setColor("    &3&lMytrix &r&lPrison    "));
		Score player = obj.getScore(Util.setColor("  &7Name: &r" + p.getName()));
		Score rank = obj.getScore(Util.setColor("  &7Rank: " + "[A]"));
		Score multi = obj.getScore(Util.setColor("  &7Multi: &r" + "1.5x"));
		Score bal = obj.getScore(Util.setColor("  &7Balance: &2$" + "200"));
		Score token = obj.getScore(Util.setColor("  &7Tokens: &c✪" + "1050"));
		Score vp = obj.getScore(Util.setColor("  &7Vote Party: &r" + "19/20"));
		Score count = obj.getScore(Util.setColor("  &7Online: &r" +  online + "/" + max));
		Score site = obj.getScore(Util.setColor("  &bbuy.mytrixstore.com"));
		Score head1 = obj.getScore(Util.setColor("&3&lPLAYER"));
		Score head2 = obj.getScore(Util.setColor("&3&lBALANCE"));
		Score head3 = obj.getScore(Util.setColor("&3&lSERVER"));


		Score spacer1 = obj.getScore("");
		Score spacer2 = obj.getScore(" ");
		Score spacer3 = obj.getScore("  ");
		Score spacer4 = obj.getScore("   ");

		spacer1.setScore(15);
		head1.setScore(14);
		player.setScore(13);
		rank.setScore(12);
		multi.setScore(11);
		spacer2.setScore(10);
		head2.setScore(9);
		bal.setScore(8);
		token.setScore(7);
		spacer3.setScore(6);
		head3.setScore(5);
		vp.setScore(4);
		count.setScore(3);
		spacer4.setScore(2);
		site.setScore(1);

		p.setScoreboard(board);
	}


}
