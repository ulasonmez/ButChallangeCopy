package me.Blume.RandomTwist.Item;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.Blume.RandomTwist.Main;




public class ItemInteract implements Listener,CommandExecutor{
	private final Main plugin;
	Items item = new Items();
	public ItemInteract(Main plugin) {
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		item.createPrinter();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player && label.equalsIgnoreCase("copyandpaste") && sender.isOp()) {
			sender.sendMessage(ChatColor.GREEN+"Plugin started!");
			Items.randomtwistkomut=1;
			return true;
		}



		return false;
	}
	public Material block1;
	ItemStack item1 = Items.Printer;
	@EventHandler
	public void ClickonBlock(PlayerInteractEvent event) {
		if(Items.randomtwistkomut==1) {
			Player player = event.getPlayer();
			Block block = event.getClickedBlock();


			Action action = event.getAction();

			if(action.equals(Action.LEFT_CLICK_BLOCK) && player.getInventory().getItemInMainHand().equals(item1)) {
				block1 = Material.getMaterial(block.getType().name());
				player.sendMessage(ChatColor.AQUA+""+block.getType()+ChatColor.GREEN+" Kopyalandi");

			}
			if(action.equals(Action.RIGHT_CLICK_BLOCK) && player.getInventory().getItemInMainHand().equals(item1)) {

				block.setType(block1);

			}
		}
	}





}
