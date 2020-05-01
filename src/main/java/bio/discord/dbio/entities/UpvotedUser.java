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

    public DiscordInformation getDiscordInformation()
    {
        return discordInformation;
    }

    public int getId()
    {
        return id;
    }

    public String getUserId()
    {
        return userId;
    }

    public String getDescription()
    {
        return description;
    }

    public String getName()
    {
        return name;
    }

    public long getUpvotes()
    {
        return upvotes;
    }

    public boolean isVerified()
    {
        return verified;
    }

    public boolean isPremium()
    {
        return premium;
    }
}
