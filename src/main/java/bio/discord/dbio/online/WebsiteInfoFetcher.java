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

import bio.discord.dbio.entities.UpvotedUser;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WebsiteInfoFetcher
{

    /**
     * Get the total user count on the website.
     * @return An optional containing in integer for the amount of users using the website.
     */
    public static Optional<Integer> getTotalUserCount ()
    {
        try (
                InputStreamReader reader = new InputStreamReader(new URL("https://api.discord.bio/v1/totalUsers").openStream())
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

    /**
     * Get a the list of top-upvoted users on the website.
     * @return An optional containing a list of top-upvoted users.
     */
    public static Optional<List<UpvotedUser>> getTopUpvotedUsers ()
    {
        try (
                InputStreamReader reader = new InputStreamReader(new URL("https://api.discord.bio/v1/topUpvoted").openStream())
        )
        {
            JsonParser parser = new JsonParser();
            JsonObject object = parser.parse(reader).getAsJsonObject();

            if (object.get("success").getAsBoolean())
            {
                JsonArray users = object.getAsJsonArray("payload");
                ArrayList<UpvotedUser> userArrayList = new ArrayList<>();

                users.forEach(user ->
                        userArrayList.add(new UpvotedUser(user.getAsJsonObject()))
                );

                return Optional.of(userArrayList);
            }
        }
        catch (Exception ignore)
        {

        }

        return Optional.empty();
    }
}