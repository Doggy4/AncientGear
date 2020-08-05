package Listeners;

import Gathering.GatheringEnums;
import Gathering.Ore.Ore;
import Gathering.Ore.OreItems;
import Listeners.BaseListener;
import Utilities.GuiConstructor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GuiListener extends BaseListener {
    private static final Inventory guiTools = new GuiConstructor(27, GatheringEnums.menu.TOOLS.getDisplayName())
            .setItems(  OreItems.t1PickAxe, OreItems.t2PickAxe, OreItems.t3PickAxe,
                        OreItems.t4PickAxe, OreItems.t5PickAxe, OreItems.t6PickAxe)
            .bulid();

    private static final Inventory guiGathering = new GuiConstructor(4, GatheringEnums.menu.GATHERING.getDisplayName())
            .setItems(OreItems.oreMenu, OreItems.lumberMenu, OreItems.cropMenu, OreItems.fishingMenu)
            .bulid();

    private static final Inventory guiOre = new GuiConstructor(9, GatheringEnums.menu.ORE.getDisplayName())
            .setItems(  OreItems.stoneOre, OreItems.coalOre, OreItems.copperOre,
                        OreItems.tinOre, OreItems.ironOre, OreItems.goldOre,
                        OreItems.zincOre, OreItems.titanOre)
            .bulid();

    private static final Inventory guiLumber = new GuiConstructor(9, GatheringEnums.menu.LUMBER.getDisplayName())
            .setItems(OreItems.oreMenu, OreItems.lumberMenu, OreItems.cropMenu, OreItems.fishingMenu)
            .bulid();

    private static final Inventory guiFarming= new GuiConstructor(9, GatheringEnums.menu.CROP.getDisplayName())
            .setItems(OreItems.oreMenu, OreItems.lumberMenu, OreItems.cropMenu, OreItems.fishingMenu)
            .bulid();

    private static final Inventory guiFishing = new GuiConstructor(9, GatheringEnums.menu.FISHING.getDisplayName())
            .setItems(OreItems.oreMenu, OreItems.lumberMenu, OreItems.cropMenu, OreItems.fishingMenu)
            .bulid();

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if (!e.getItem().equals(OreItems.profMenu)) return;
        e.getPlayer().openInventory(guiGathering);
    }

    @EventHandler
    public void onInventoryDrag(final InventoryDragEvent e) {
        Inventory inv = e.getInventory();
        if (    inv == guiGathering || 
                inv == guiOre || 
                inv == guiLumber ||
                inv == guiFarming || 
                inv == guiFishing ||
                inv == guiTools
        
        )
            e.setCancelled(true);
    }
//    inv != guiOre ||
//    inv != guiLumber ||
//    inv != guiFarming ||
//    inv != guiFishing

    @EventHandler
    public void onToolGuiClick(final InventoryClickEvent e) {
        Inventory inv = e.getInventory();
        if (inv != guiTools)
            e.setCancelled(true);

        final ItemStack clickedItem = e.getCurrentItem();
        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;
        Player player = (Player) e.getWhoClicked();

        if (clickedItem.equals(OreItems.t1PickAxe)) {
            player.getInventory().addItem(OreItems.t1PickAxe);
        } else if (clickedItem.equals(OreItems.t2PickAxe)) {
            player.getInventory().addItem(OreItems.t2PickAxe);
        } else if (clickedItem.equals(OreItems.t3PickAxe)) {
            player.getInventory().addItem(OreItems.t3PickAxe);
        } else if (clickedItem.equals(OreItems.t4PickAxe)) {
            player.getInventory().addItem(OreItems.t4PickAxe);
        } else if (clickedItem.equals(OreItems.t5PickAxe)) {
            player.getInventory().addItem(OreItems.t5PickAxe);
        } else if (clickedItem.equals(OreItems.t6PickAxe)) {
            player.getInventory().addItem(OreItems.t6PickAxe);
        }
    }

    @EventHandler
    public void onOreGuiClick(final InventoryClickEvent e) {
        Inventory inv = e.getInventory();
        if (inv != guiOre)
            e.setCancelled(true);

        final ItemStack clickedItem = e.getCurrentItem();
        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;
        Player player = (Player) e.getWhoClicked();
        World world = player.getWorld();
        ArmorStand as =  (ArmorStand) world.spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);
        if (clickedItem.equals(OreItems.stoneOre)) {
            as = Ore.stoneOre;
            player.closeInventory();
        } else if (clickedItem.equals(OreItems.coalOre)) {
            as = Ore.coalOre;
            player.closeInventory();
        } else if (clickedItem.equals(OreItems.ironOre)) {
            as = Ore.ironOre;
            player.closeInventory();
        } else if (clickedItem.equals(OreItems.copperOre)) {
            as = Ore.copperOre;
            player.closeInventory();
        } else if (clickedItem.equals(OreItems.tinOre)) {
            as = Ore.tinOre;
            player.closeInventory();
        } else if (clickedItem.equals(OreItems.zincOre)) {
            as = Ore.zincOre;
            player.closeInventory();
        } else if (clickedItem.equals(OreItems.goldOre)) {
            as = Ore.goldOre;
            player.closeInventory();
        } else if (clickedItem.equals(OreItems.titanOre)) {
            as = Ore.titanOre;
            player.closeInventory();
        }
    }

    @EventHandler
    public void onGatheringGuiClick(final InventoryClickEvent e) {
        Inventory inv = e.getInventory();
        if (inv != guiGathering)
            e.setCancelled(true);
        
        final ItemStack clickedItem = e.getCurrentItem();
        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;
        Player player = (Player) e.getWhoClicked();
        if (clickedItem.equals(guiOre)) {
            player.closeInventory();
            player.openInventory(guiOre);
        } else if (clickedItem.equals(guiFarming)) {
            player.closeInventory();
            player.openInventory(guiFarming);
        } else if (clickedItem.equals(guiLumber)) {
            player.closeInventory();
            player.openInventory(guiLumber);
        } else if (clickedItem.equals(guiFishing)) {
            player.closeInventory();
            player.openInventory(guiFishing);
        } else {
            player.sendMessage(ChatColor.GREEN + "AVALON САСАТЬ!");
        }
    }
}