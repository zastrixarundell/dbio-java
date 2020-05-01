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

import com.google.gson.JsonObject;

public class DiscordConnection
{

    private String connectionType;
    private int id;
    private String name, url, icon;

    public DiscordConnection(JsonObject payload)
    {
        id = payload.get("id").getAsInt();
        connectionType = payload.get("connection_type").getAsString();
        name = payload.get("name").getAsString();
        url = payload.get("url").getAsString();
        icon = payload.get("icon").getAsString();
    }

    @Deprecated
    public String getConnectionType()
    {
        return connectionType;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getUrl()
    {
        return url;
    }

    public String getIcon()
    {
        return icon;
    }

    @Override
    public String toString()
    {
        return "DiscordConnection{" +
                "connectionType='" + connectionType + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
