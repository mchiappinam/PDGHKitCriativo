package me.mchiappinam.pdghkit;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class Comando implements CommandExecutor, Listener {
	private Main plugin;
	public Comando(Main main) {
		plugin=main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("kit")) {
			if(args.length!=0) {
				sendHelp(sender);
				return true;
			}
			if (plugin.nb.contains(sender.getName().toLowerCase())) {
				sender.sendMessage("§3[Ⓚⓘⓣⓢ] §cAguarde para pedir esse kit novamente.");
				return true;
			}
			plugin.nb.add(sender.getName().toLowerCase());
			plugin.startTask((Player) sender);
			Kit((Player) sender);
			return true;
		}
		return false;
	}
	
	private void sendHelp(CommandSender sender) {
		sender.sendMessage("§3Ⓚⓘⓣⓢ ⓓⓘⓢⓟⓞⓝⓘⓥⓔⓘⓢ");
		sender.sendMessage("§2/kit -§a- Kit para x1.");
	}

	public void Kit(Player p) {
		ItemStack espada = new ItemStack(Material.DIAMOND_SWORD, 1);
	    espada.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
	    espada.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
	    ItemStack arco = new ItemStack(Material.BOW, 1);
	    arco.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE , 5);
	    arco.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 1);
	    arco.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
	    arco.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
	    ItemStack elmo = new ItemStack(Material.DIAMOND_HELMET, 1);
	    elmo.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL , 4);
	    elmo.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
	    ItemStack peito = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
	    peito.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL , 4);
	    peito.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
	    ItemStack calca = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
	    calca.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL , 4);
	    calca.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
	    ItemStack bota = new ItemStack(Material.DIAMOND_BOOTS, 1);
	    bota.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL , 4);
	    bota.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		p.getInventory().clear();
	    p.getInventory().addItem(espada);
	    p.getInventory().addItem(arco);
	    p.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 30, (short) 1));
	    p.getInventory().addItem(new ItemStack(Material.ARROW, 1));
		p.getInventory().setHelmet(elmo);
		p.getInventory().setChestplate(peito);
		p.getInventory().setLeggings(calca);
		p.getInventory().setBoots(bota);
    	p.sendMessage("§eKit §erecebido com sucesso.");
    	p.sendMessage("§eVocê poderá pedir seu kit novamente em 1 minuto.");
	}
	
}
