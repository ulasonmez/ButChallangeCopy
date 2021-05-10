package me.Blume.RandomTwist.Item;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ItemInteract2 implements CommandExecutor {
	Items item = new Items();
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player && label.equalsIgnoreCase("copyandpastestop") && sender.isOp()) {
			sender.sendMessage(ChatColor.GREEN+"Plugin stopped");
			Items.randomtwistkomut=0;
			return true;
		}
		if(!sender.isOp()) {
			sender.sendMessage(ChatColor.RED+"You don't have permission.");
		}
		return false;
	}
	
}
