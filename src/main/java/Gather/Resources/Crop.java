package Gather.Resources;

import Gather.Tools.ResourceTypeEnum;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

public class Crop extends Resource {
    public Crop(Location location, String name, Integer tier, net.minecraft.server.v1_16_R2.ItemStack material, ItemStack drop, Double chance, Integer cooldown, Integer durability) {
        super(location, name, ResourceTypeEnum.HOE, tier, material, drop, chance, cooldown, durability);
    }
}