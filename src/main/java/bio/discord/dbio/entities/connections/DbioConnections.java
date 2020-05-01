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

package bio.discord.dbio.entities.connections;

import bio.discord.dbio.Helpers;
import com.google.gson.JsonObject;

public class DbioConnections
{

    private String github, website, instagram, snapchat, linkedin;

    public DbioConnections(JsonObject connections)
    {
        JsonObject nameHolder = connections.getAsJsonObject("github");
        github = Helpers.getNullableStringFromJson(nameHolder.get("name"));

        nameHolder = connections.getAsJsonObject("website");
        website = Helpers.getNullableStringFromJson(nameHolder.get("name"));

        nameHolder = connections.getAsJsonObject("instagram");
        instagram = Helpers.getNullableStringFromJson(nameHolder.get("name"));

        nameHolder = connections.getAsJsonObject("snapchat");
        snapchat = Helpers.getNullableStringFromJson(nameHolder.get("name"));

        nameHolder = connections.getAsJsonObject("linkedin");
        linkedin = Helpers.getNullableStringFromJson(nameHolder.get("name"));
    }

    /**
     * Get the linked github connection name to discord.bio.
     * @return The linked github name.
     */
    public String getGithubName()
    {
        return github;
    }

    /**
     * The url of the website connected to discord.bio.
     * @return URL of the linked webiste.
     */
    public String getWebsite()
    {
        return website;
    }

    /**
     * The name of the instagram account connected to discord.bio.
     * @return Instagram account name.
     */
    public String getInstagramName()
    {
        return instagram;
    }

    /**
     * The name of the snapchat account connected to discord.bio.
     * @return Snapchat account name.
     */
    public String getSnapchatName()
    {
        return snapchat;
    }

    /**
     * The name of the linked LinkedIn account connected to discord.bio.
     * @return LinkedIn acocunt name.
     */
    public String getLinkedinName()
    {
        return linkedin;
    }

    @Override
    public String toString()
    {
        return "DbioConnections{" +
                "github='" + github + '\'' +
                ", website='" + website + '\'' +
                ", instagram='" + instagram + '\'' +
                ", snapchat='" + snapchat + '\'' +
                ", linkedin='" + linkedin + '\'' +
                '}';
    }
}
