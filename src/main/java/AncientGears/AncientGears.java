package AncientGears;

import Commands.CommandKit;
import Commands.CommandRegenAll;
import Commands.CommandTest;
import Gathering.ResourceManager;
import Listeners.*;
import Locations.InitializeLocations;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import static Gathering.InitializeGathering.InitializeOre;
import static Gathering.InitializeGathering.InitializeTools;
import static Gathering.Ore.OreItems.InitializeOreItems;
import static Recipes.BlastFurnaceRecipesManager.InitializeBlastFurnaceRecipes;
import static GUI.GUIManager.InitializeInventoryItems;
import static Locations.InitializeLocations.InitializeAllLocations;

public final class AncientGears extends JavaPlugin {
    private static AncientGears instance;
    public static String prefix = ChatColor.GOLD + "[AncientGears] " + ChatColor.WHITE;

    @Override
    public void onEnable() {
        AncientGears.instance = this;
        getLogger().info("Plugin is enabled!");

        this.getCommand("kit").setExecutor(new CommandKit());
        this.getCommand("regenAll").setExecutor(new CommandRegenAll());
        this.getCommand("test").setExecutor(new CommandTest());

        InitializeOreItems();
        InitializeOre();
        InitializeTools();
        InitializeInventoryItems();
        InitializeAllLocations();
        InitializeBlastFurnaceRecipes();
        registerListeners();

    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin is disabled!");
    }

    public static AncientGears getInstance() {
        return AncientGears.instance;
    }

    public void registerListeners() {
        AncientGears.getInstance().getLogger().info("Listeners Initialization");
        new InventoryListener();
        new GatheringListener();
        new ResourceManager();
        new GuiListener();
        new DropListener();
        new MoveListener();
        new PlayerListener();
    }
}
