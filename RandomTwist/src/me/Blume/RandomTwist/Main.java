package me.Blume.RandomTwist;


import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


import me.Blume.RandomTwist.Item.ItemInteract;


public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("copyandpaste").setExecutor(new ItemInteract(this));
		getCommand("copyandpastestop").setExecutor(new ItemInteract(this));
	}

	@Override
	public void onDisable() {
		
	}
}

