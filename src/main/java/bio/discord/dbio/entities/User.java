/*
 *         DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 *                     Version 2, December 2004
 *
 *  Copyright (C) 2004 Sam Hocevar <sam@hocevar.net>
 *
 *  Everyone is permitted to copy and distribute verbatim or modified
 *  copies of this license document, and changing it is allowed as long
 *  as the name is changed.
 *
 *             DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 *    TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION
 *
 *   0. You just DO WHAT THE FUCK YOU WANT TO.
 */

package bio.discord.dbio.entities;

import bio.discord.dbio.entities.user.DiscordInformation;
import bio.discord.dbio.entities.user.SettingsInformation;
import com.google.gson.JsonObject;

public class User
{

    DiscordInformation discord;
    SettingsInformation settings;

    public User(JsonObject payload)
    {

    }

    public JsonObject getSettings()
    {
        return settings;
    }

    public JsonObject getDiscord()
    {
        return discord;
    }
}
