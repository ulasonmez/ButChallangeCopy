package me.Blume.RandomTwist.Item;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
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
	@SuppressWarnings("serial")
	@EventHandler
	public void craftstick(PrepareItemCraftEvent event) {
		CraftingInventory inv = event.getInventory();
		if(inv.getMatrix().length<9) return;
		checkCraft(Items.Printer,inv,new HashMap<Integer,ItemStack>(){{
			put(0,new ItemStack(Material.IRON_INGOT));
			put(1,new ItemStack(Material.IRON_INGOT));
			put(2,new ItemStack(Material.IRON_INGOT));
			put(3,new ItemStack(Material.IRON_INGOT));
			put(4,new ItemStack(Material.STICK));
			put(5,new ItemStack(Material.IRON_INGOT));
			put(6,new ItemStack(Material.IRON_INGOT));
			put(7,new ItemStack(Material.STICK));
			put(8,new ItemStack(Material.IRON_INGOT));
		}});


	}
	public void checkCraft(ItemStack result,CraftingInventory inv,HashMap<Integer, ItemStack> ingredients) {
		ItemStack[] matrix = inv.getMatrix();
		for(int i =0;i<9;i++) {
			if(ingredients.containsKey(i)) {
				if(matrix[i]==null || !matrix[i].equals(ingredients.get(i))) {
					return;
				}
			}
			else {
				if(matrix[i]!=null) {
					return;
				}
			}
		}
			inv.setResult(result);
	}
}
