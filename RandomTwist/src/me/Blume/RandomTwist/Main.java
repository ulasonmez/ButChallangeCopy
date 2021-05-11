package me.Blume.RandomTwist;


import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.Blume.RandomTwist.Item.ItemInteract;
import me.Blume.RandomTwist.Item.ItemInteract2;
import me.Blume.RandomTwist.Item.Items;


public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("copyandpaste").setExecutor(new ItemInteract(this));
		getCommand("copyandpastestop").setExecutor(new ItemInteract2(this));
		getServer().getPluginManager().registerEvents(new Items(), this);
	}

	@Override
	public void onDisable() {
		
	}
}

