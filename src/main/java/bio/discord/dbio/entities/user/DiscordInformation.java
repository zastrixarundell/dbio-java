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

package bio.discord.dbio.entities.user;

import com.google.gson.JsonObject;

/**
 * Java class representing the discord information a user has. This does not show the {@link bio.discord.dbio.entities.connections.DiscordConnection}
 * information as that is from a different API endpoint.
 *
 * @author zastrixarundell
 * @since 0.0.0
 */
public class DiscordInformation
{

    private String id, username, avatar, discriminator;
    private int flags;

    /**
     * Default constructor for the DiscordInformation objects. Expects a JSON object
     * which can be found on https://docs.discord.bio/ under payload.discord.
     * @param discord A new DiscordInformation object.
     */
    public DiscordInformation(JsonObject discord)
    {
        id = discord.get("id").getAsString();
        username = discord.get("username").getAsString();
        avatar = discord.get("avatar").getAsString();
        discriminator = discord.get("discriminator").getAsString();
        flags = discord.get("public_flags").getAsInt();
    }

    /**
     * Return the Discord ID of the user.
     * @return ID of the user.
     */
    public String getId()
    {
        return id;
    }

    /**
     * Get the Discord username of the user without the discriminator.
     * @return The username of the user without the discriminator.
     */
    public String getUsername()
    {
        return username;
    }

    /**
     * Get the discriminator of the user.
     * @return The discriminator of the user.
     */
    public String getDiscriminator()
    {
        return discriminator;
    }

    /**
     * Get the full Discord username with the username and discriminator
     * @return Full username with the username and discriminator.
     */
    public String getFullUserUsername()
    {
        return username + "#" + discriminator;
    }

    /**
     * Return the file of the the avatar which the user has. If you want to get the full avatar URL,
     * see `getAvatarUrl()`
     * @return The filename of the user avatar.
     */
    public String getAvatar()
    {
        return avatar;
    }

    /**
     * Get the URL of the avatar corresponding to the user.
     * @param extension The extension of the image.
     * @return A direct link to the user image.
     */
    public String getAvatarUrl(String extension)
    {
        extension = extension == null || extension.equals("") ? "png" : extension;
        return "https://cdn.discordapp.com/avatars/" + id + "/" + avatar + "." + extension;
    }

    /**
     * Get the discord flags of the user.
     * @return Discord flags of the user.
     */
    public int getFlags()
    {
        return flags;
    }

    @Override
    public String toString()
    {
        return "DiscordInformation{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", avatar='" + avatar + '\'' +
                ", discriminator='" + discriminator + '\'' +
                ", flags=" + flags +
                '}';
    }
}
