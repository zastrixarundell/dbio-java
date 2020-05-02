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

/**
 * Java class representing a user.
 * @author zastrixarundell
 * @since 0.0.0
 */
public class User
{

    private DiscordInformation discord;
    private SettingsInformation settings;

    /**
     * Get the user information from the payload object find on https://docs.discord.bio/.
     * @param payload The object representing a user on discord.bio.
     */
    public User(JsonObject payload)
    {
        discord = new DiscordInformation(payload.getAsJsonObject("discord"));
        settings = new SettingsInformation(payload.getAsJsonObject("settings"));
    }

    /**
     * Get all of the relevant Discord information for the user.
     * @return DiscordInformation of the user.
     */
    public DiscordInformation getDiscordInformation()
    {
        return discord;
    }

    /**
     * Get all of the relevant discord.bio settings for the user. Will be removed in the
     * following version.
     * @return SettingsInformation of the user.
     */
    @Deprecated
    public SettingsInformation getSettings()
    {
        return settings;
    }

    /**
     * Get all of the relevant discord.bio settings for the user. Will be removed in the
     * following version.
     * @return SettingsInformation of the user.
     */
    public SettingsInformation getSettingsInformation()
    {
        return settings;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "discord=" + discord +
                ", settings=" + settings +
                '}';
    }

    public enum UserGender
    {
        MALE, FEMALE, NONBINARY, UNDISCLOSED;
    }
}
