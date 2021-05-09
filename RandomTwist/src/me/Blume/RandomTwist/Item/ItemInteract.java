package me.Blume.RandomTwist.Item;


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
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.Blume.RandomTwist.Main;




public class ItemInteract implements Listener,CommandExecutor{
		private final Main plugin;
		public final ItemStack Printer;
	public ItemInteract(Main plugin) {
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		Printer = new ItemStack(Material.STICK);
		ItemMeta meta = Printer.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 100, true);
		meta.setDisplayName("Printer");
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		Printer.setItemMeta(meta);
	
	}
	private int randomtwistkomut;
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player && label.equalsIgnoreCase("copyandpaste") && sender.isOp()) {
			sender.sendMessage(ChatColor.GREEN+"Plugin started!");
			randomtwistkomut=1;
			return true;
		}
		else if(sender instanceof Player && label.equalsIgnoreCase("copyandpastestop") && sender.isOp()) {
			sender.sendMessage(ChatColor.GREEN+"Plugin stopped");
			randomtwistkomut=0;
			return true;
		}
		if(!sender.isOp()) {
			sender.sendMessage(ChatColor.RED+"You don't have permission.");
		}
		
		
	return false;
	}
	public Material block1;
	@EventHandler
	public void ClickonBlock(PlayerInteractEvent event) {
		if(randomtwistkomut==1) {
			Player player = event.getPlayer();
			Block block = event.getClickedBlock();
			Action action = event.getAction();
			
			if(action.equals(Action.LEFT_CLICK_BLOCK)) {
				if(Printer.isSimilar(player.getInventory().getItemInMainHand())) {
					player.sendMessage(ChatColor.GREEN+"Kopyalandi");
					block1=block.getType();
					}
				
				}
			if(action.equals(action.RIGHT_CLICK_BLOCK)) {
				if(Printer.isSimilar(player.getInventory().getItemInMainHand())) {
					block.setType(block1);
				}
			}
			}
		}
	@EventHandler
	public void craftstick(PrepareItemCraftEvent event) {
		CraftingInventory inv = event.getInventory();
		if(inv.getMatrix().length<9) return;
		//012
		//345
		//678
		ItemStack[] matrix = inv.getMatrix();
		
			
		
		if(randomtwistkomut==1) {
			if(matrix[0]!=null && matrix[1]!=null && matrix[2]!=null &&
					matrix[3]!=null && matrix[4]!=null && matrix[5]!=null &&
					matrix[6]!=null && matrix[7]!=null && matrix[8]!=null ) {
				boolean stickshape=true;
				for(int i =0;i<9;i++) {
				if(i==4 || i==7) {
					if(!(matrix[i].getType().equals(Material.STICK))) stickshape=false;
				}
				else {
					if(!(matrix[i].getType().equals(Material.IRON_INGOT))) stickshape = false;
				}
			}
				if(stickshape) {
					inv.setResult(Printer);
				}
			}
		}
}
	
	
	
}
