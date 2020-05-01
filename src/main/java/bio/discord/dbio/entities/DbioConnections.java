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

    public String getGithub()
    {
        return github;
    }

    public String getWebsite()
    {
        return website;
    }

    public String getInstagram()
    {
        return instagram;
    }

    public String getSnapchat()
    {
        return snapchat;
    }

    public String getLinkedin()
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
