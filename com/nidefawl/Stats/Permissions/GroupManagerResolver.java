package com.nidefawl.Stats.Permissions;

import java.util.logging.Logger;

import org.anjocaido.groupmanager.GroupManager;
import org.anjocaido.groupmanager.data.Group;
import org.anjocaido.groupmanager.data.User;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class GroupManagerResolver implements PermissionsResolver {
	public static final Logger log = Logger.getLogger("Minecraft");
	Plugin plugin = null;
	private GroupManager perms = null;

	public GroupManagerResolver(Plugin plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean load() {
		if (perms == null) {
			Plugin checkPlugin = plugin.getServer().getPluginManager().getPlugin("GroupManager");
			if (checkPlugin != null && checkPlugin.isEnabled() && checkPlugin instanceof GroupManager) {
				perms = (GroupManager) checkPlugin;
			} else
				return false;
		}
		return true;
	}

	@Override
	public boolean permission(CommandSender sender, String permCmd) {
		if(sender.isOp()) return true;
		if(!(sender instanceof Player)) return false;
		if (!load())
			return false;
		final Player player = (Player)sender;
		return perms.getWorldsHolder().getWorldData(player).getPermissionsHandler().has(player, permCmd);
	}


	@Override
	public boolean inGroup(Player player, String group) {
		if (!load())
			return false;
		Group g = perms.getWorldsHolder().getWorldData(player).getGroup(group);
		if(g==null) return false;
		User u = perms.getWorldsHolder().getWorldData(player).getUser(player.getName());
		if(u==null) return false;
		return u.containsSubGroup(g)||u.getGroup().equals(g);
	}

	@Override
	public void reloadPerms() {
	}

	@Override
    public String getGroup(Player player) {
		User u = perms.getWorldsHolder().getWorldData(player).getUser(player.getName());
		if(u==null) return "";
		return u.getGroupName();
    }

}
