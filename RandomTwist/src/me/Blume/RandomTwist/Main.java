package me.Blume.RandomTwist;


import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


import me.Blume.RandomTwist.Item.ItemInteract;


public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("randomtwist").setExecutor(new ItemInteract(this));
		getCommand("randomtwiststop").setExecutor(new ItemInteract(this));
	}

	@Override
	public void onDisable() {
		
	}
}

