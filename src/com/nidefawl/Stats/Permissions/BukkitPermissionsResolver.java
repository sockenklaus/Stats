/**
 * 
 */
package com.nidefawl.Stats.Permissions;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author socrates
 *
 */
public class BukkitPermissionsResolver implements PermissionsResolver {

	/* (non-Javadoc)
	 * @see com.nidefawl.Stats.Permissions.PermissionsResolver#load()
	 */
	@Override
	public boolean load() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.nidefawl.Stats.Permissions.PermissionsResolver#permission(org.bukkit.command.CommandSender, java.lang.String)
	 */
	@Override
	public boolean permission(CommandSender player, String permCmd) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.nidefawl.Stats.Permissions.PermissionsResolver#getGroup(org.bukkit.entity.Player)
	 */
	@Override
	public String getGroup(Player player) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.nidefawl.Stats.Permissions.PermissionsResolver#inGroup(org.bukkit.entity.Player, java.lang.String)
	 */
	@Override
	public boolean inGroup(Player player, String group) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.nidefawl.Stats.Permissions.PermissionsResolver#reloadPerms()
	 */
	@Override
	public void reloadPerms() {
		// TODO Auto-generated method stub
		
	}

}
