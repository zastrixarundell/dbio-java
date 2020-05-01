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

package bio.discord.dbio.online;

import bio.discord.dbio.entities.DbioConnections;
import bio.discord.dbio.entities.User;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStreamReader;
import java.net.URL;
import java.util.Optional;

public class UserInfoFetcher
{
    public static Optional<User> getSingletonInformation(String userId)
    {
        try (
            InputStreamReader reader = new InputStreamReader(new URL("https://api.discord.bio/v1/user/details/" + userId).openStream());
        )
        {
            JsonParser parser = new JsonParser();
            JsonObject object = parser.parse(reader).getAsJsonObject();

            if (object.get("success").getAsBoolean())
                return Optional.of(new User(object.getAsJsonObject("payload")));
        }
        catch (Exception ignore)
        {

        }

        return Optional.empty();
    }

    public static Optional<DbioConnections> getUserInfoConnections(String userId)
    {
        try (
            InputStreamReader reader = new InputStreamReader(new URL("https://api.discord.bio/v1/user/connections/" + userId).openStream());
        )
        {
            JsonParser parser = new JsonParser();
            JsonObject object = parser.parse(reader).getAsJsonObject();

            if (object.get("success").getAsBoolean())
                return Optional.of(new DbioConnections(object.getAsJsonObject("payload")));
        }
        catch (Exception ignore)
        {

        }

        return Optional.empty();
    }

    public static Optional<Integer> getTotalUserCount()
    {
        try (
                InputStreamReader reader = new InputStreamReader(new URL("https://api.discord.bio/v1/totalUsers").openStream());
        )
        {
            JsonParser parser = new JsonParser();
            JsonObject object = parser.parse(reader).getAsJsonObject();

            if (object.get("success").getAsBoolean())
                return Optional.of(object.get("payload").getAsInt());
        }
        catch (Exception ignore)
        {

        }

        return Optional.empty();
    }
}
