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
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * JavaClass which has the task of getting the information about the service of discord.bio. It is generally
 * not a good idea to use this directly as the calls are sync, Take a look at {@link bio.discord.dbio.Dbio} for
 * async calls.
 *
 * @author zastrixarundell
 * @since 0.0.0
 */
public class WebsiteInfoFetcher
{

    /**
     * Get the total user count on the website.
     * @return An optional containing in integer for the amount of users using the website.
     */
    public static Optional<Integer> getTotalUserCount ()
    {
        try (
                CloseableHttpClient client = HttpClientBuilder.create().build()
        )
        {
            HttpGet get = new HttpGet("https://api.discord.bio/v1/totalUsers");
            HttpResponse response = client.execute(get);

            JsonParser parser = new JsonParser();
            InputStreamReader reader = new InputStreamReader(response.getEntity().getContent());

            JsonObject object = parser.parse(reader).getAsJsonObject();

            reader.close();

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
                CloseableHttpClient client = HttpClientBuilder.create().build()
        )
        {
            HttpGet get = new HttpGet("https://api.discord.bio/v1/topUpvoted");
            HttpResponse response = client.execute(get);

            JsonParser parser = new JsonParser();
            InputStreamReader reader = new InputStreamReader(response.getEntity().getContent());

            JsonObject object = parser.parse(reader).getAsJsonObject();

            reader.close();

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