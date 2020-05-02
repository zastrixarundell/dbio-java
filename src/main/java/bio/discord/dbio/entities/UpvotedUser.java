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

import bio.discord.dbio.Helpers;
import bio.discord.dbio.entities.user.DiscordInformation;
import com.google.gson.JsonObject;

/**
 * Java class representing the information when the end-user uses the topUpvoted API endpoint.
 *
 * @author zastrixarundell
 * @since 0.0.0
 */
public class UpvotedUser
{

    private DiscordInformation discordInformation;

    private int id;

    private String userId, description, name;
    private long upvotes;
    private boolean verified, premium;


    public UpvotedUser(JsonObject payload)
    {
        id = payload.get("id").getAsInt();
        discordInformation = new DiscordInformation(payload.getAsJsonObject("discord"));

        JsonObject user = payload.getAsJsonObject("user");

        userId = Helpers.getNullableStringFromJson(user.get("user_id"));
        upvotes = user.get("upvotes").getAsLong();
        description = Helpers.getNullableStringFromJson(user.get("description"));
        verified = user.get("verified").getAsInt() == 1;
        premium = user.get("premium_status").getAsInt() == 1;
        name = Helpers.getNullableStringFromJson(user.get("name"));
    }

    /**
     * Get all of the relevant Discord information for the user.
     * @return DiscordInformation of the user.
     */
    public DiscordInformation getDiscordInformation()
    {
        return discordInformation;
    }

    /**
     * 0-indexed position of where the user is located in the list of top upvoted users.
     * @return Integer representing array index.
     */
    public int getId()
    {
        return id;
    }

    /**
     * The ID of the user.
     * @return ID of the user.
     */
    public String getUserId()
    {
        return userId;
    }

    /**
     * The description which the user has.
     * @return The description which the user has.
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * The name which the user has.
     * @return The name which the user has.
     */
    public String getName()
    {
        return name;
    }

    /**
     * The number of upvotes the user has.
     * @return The number of upvotes the user has.
     */
    public long getUpvotes()
    {
        return upvotes;
    }

    /**
     * See if the user is premium on discord.bio.
     * @return Boolean if the user is premium on discord.bio.
     */
    public boolean isPremium()
    {
        return premium;
    }

    /**
     * See if the user is verified on discord.bio.
     * @return Boolean if the user is verified on discord.bio.
     */
    public boolean isVerified()
    {
        return verified;
    }
}
