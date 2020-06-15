package me.eccentric_nz.tardisshop;

import com.google.common.collect.ImmutableList;
import me.eccentric_nz.TARDIS.commands.TARDISCompleter;
import me.eccentric_nz.TARDIS.utility.TARDISStringUtils;
import me.eccentric_nz.tardisshop.database.InsertShopItem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TARDISShopCommand extends TARDISCompleter implements CommandExecutor, TabCompleter {

    private final TARDISShop plugin;
    private final ImmutableList<String> ROOT_SUBS = ImmutableList.of("add", "remove");
    private final List<String> ITEM_SUBS;

    public TARDISShopCommand(TARDISShop plugin) {
        this.plugin = plugin;
        ITEM_SUBS = new ArrayList(this.plugin.getItemsConfig().getKeys(false));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("tardisshop")) {
            Player player = null;
            if (sender instanceof Player) {
                player = (Player) sender;
            }
            if (player == null) {
                sender.sendMessage(plugin.getPluginName() + "Command can only be used by a player!");
                return true;
            }
            // do stuff
            if (args.length < 1) {
                player.sendMessage(plugin.getPluginName() + "Too few command arguments!");
                return true;
            }
            if (args[0].equalsIgnoreCase("remove")) {
                plugin.getRemovingItem().add(player.getUniqueId());
                player.sendMessage(plugin.getPluginName() + "Click the " + plugin.getBlockMaterial().toString() + " block to remove the database record.");
                return true;
            }
            if (args.length < 2) {
                player.sendMessage(plugin.getPluginName() + "Too few command arguments!");
                return true;
            }
            if (args[0].equalsIgnoreCase("add")) {
                String name = args[1].toLowerCase();
                if (!plugin.getItemsConfig().contains(name)) {
                    player.sendMessage(plugin.getPluginName() + "Too few command arguments!");
                    return true;
                }
                double cost = plugin.getItemsConfig().getDouble(name);
                TARDISShopItem item = new InsertShopItem(plugin).addNamedItem(TARDISStringUtils.capitalise(args[1]), cost);
                plugin.getSettingItem().put(player.getUniqueId(), item);
                player.sendMessage(plugin.getPluginName() + "Click the " + plugin.getBlockMaterial().toString() + " block to update the database record.");
                return true;
            }
            return true;
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        // Remember that we can return null to default to online player name matching
        String lastArg = args[args.length - 1];

        if (args.length <= 1) {
            return partial(args[0], ROOT_SUBS);
        } else if (args.length == 2) {
            String sub = args[0];
            if (sub.equalsIgnoreCase("add")) {
                return partial(lastArg, ITEM_SUBS);
            }
        }
        return ImmutableList.of();
    }
}
