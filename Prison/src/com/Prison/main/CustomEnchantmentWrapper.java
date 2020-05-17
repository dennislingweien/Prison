package com.Prison.main;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;

public abstract class CustomEnchantmentWrapper extends Enchantment{
	private static Main main = Main.getInstance();
		
	public CustomEnchantmentWrapper(String namespace) {
        super(new NamespacedKey(main, namespace));
    }
}
