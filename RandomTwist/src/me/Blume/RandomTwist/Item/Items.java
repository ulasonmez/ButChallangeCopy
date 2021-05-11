package me.Blume.RandomTwist.Item;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Items implements Listener {
	public static int randomtwistkomut;
	public static ItemStack Printer = new ItemStack(Material.STICK);
	public void createPrinter() {
		ItemMeta meta = Printer.getItemMeta();
		meta.setDisplayName("Printer");
		meta.addEnchant(Enchantment.DURABILITY, 100, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		Printer.setItemMeta(meta);
		
	}
	@EventHandler
	public void craftstick(PrepareItemCraftEvent event) {
		CraftingInventory inv = event.getInventory();
		if(inv.getMatrix().length<9) return;
		//012
		//345
		//678
		ItemStack[] matrix = inv.getMatrix();
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
					if(Items.randomtwistkomut==1) {
						inv.setResult(Items.Printer);
					}
					else return;
				}
			}
		
		
}
}
