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
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Test;

public class UserTests
{

    private static JsonParser parser = new JsonParser();

    private static JsonObject fakeApiResponse()
    {
        String testString = "{\"success\":true,\"payload\":{\"settings\":{\"name\":\"zastrix\",\"user_id\":\"192300733234675722\",\"premium_status\":0,\"verified\":0,\"upvotes\":0,\"created_at\":\"2020-04-28T10:35:48.000Z\",\"status\":null,\"description\":\"Backend software developer in Rails and Phoenix. I enjoy helping people out and creating discord bots. You can check out my work on github.com/zastrixarundell. I can as well sell my services of API management and Discord bots, PM me if you want. \",\"location\":\"Novi Sad, Serbia\",\"gender\":0,\"birthday\":\"2000-09-14T00:00:00.000Z\",\"email\":null,\"occupation\":\"Backend Developer\",\"banner\":\"https://s3.eu-west-2.amazonaws.com/discord.bio/banners/192300733234675722\",\"staff\":0},\"discord\":{\"id\":\"192300733234675722\",\"username\":\"Zastrix\",\"avatar\":\"4b63183d13632ebcb89a79c3031f5105\",\"discriminator\":\"9202\",\"public_flags\":131136}}}";
        return parser.parse(testString).getAsJsonObject();
    }

    private static User createFakeUser()
    {
        return new User(fakeApiResponse().getAsJsonObject("payload"));
    }

    @Test
    public void canExtractFromPayload()
    {
        createFakeUser();
    }

    @Test
    public void canShowUserInfoAsString()
    {
        System.out.println(createFakeUser());
    }

    @Test
    public void avatarIsCorrectWithExtension()
    {
        User user = createFakeUser();
        DiscordInformation discordInformation = user.getDiscordInformation();

        assert discordInformation.getAvatarUrl("png").equals("https://cdn.discordapp.com/avatars/192300733234675722/4b63183d13632ebcb89a79c3031f5105.png");
    }

    @Test
    public void doesGenerateCorrectFullUsername()
    {
        User user = createFakeUser();
        DiscordInformation information = user.getDiscordInformation();

        assert information.getFullUserUsername().equals("Zastrix#9202");
    }

}
