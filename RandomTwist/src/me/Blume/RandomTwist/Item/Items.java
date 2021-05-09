package me.Blume.RandomTwist.Item;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Items {
	public static final ItemStack Printer = new ItemStack(Material.STICK);
	public void createPrinter() {
		ItemMeta meta = Printer.getItemMeta();
		meta.setDisplayName("Printer");
		meta.addEnchant(Enchantment.DURABILITY, 100, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		Printer.setItemMeta(meta);
		
	}
}
