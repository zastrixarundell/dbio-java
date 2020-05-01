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

package bio.discord.dbio.tests;

import bio.discord.dbio.Dbio;
import bio.discord.dbio.entities.UpvotedUser;
import bio.discord.dbio.entities.User;
import bio.discord.dbio.entities.connections.DbioConnections;
import bio.discord.dbio.entities.connections.DiscordConnection;
import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertTrue;

public class DbioTest
{

    @Test
    public void getAsyncUserInfo() throws ExecutionException, InterruptedException
    {
        Optional<User> userOptional = Dbio.getUserDetails("192300733234675722").get();
        assertTrue(userOptional.isPresent());
    }

    @Test
    public void getAsyncUserConnections() throws ExecutionException, InterruptedException
    {
       Optional<DbioConnections> connectionsOptional = Dbio.getUserDbioConnections("192300733234675722").get();
       assertTrue(connectionsOptional.isPresent());
    }

    @Test
    public void getAsyncUserCount() throws ExecutionException, InterruptedException
    {
        Optional<Integer> userCount = Dbio.getTotalUserCount().get();
        assertTrue(userCount.isPresent());
    }

    @Test
    public void getAsyncTopUpvotedUsers() throws ExecutionException, InterruptedException
    {
        Optional<List<UpvotedUser>> userList = Dbio.getTopUpvotedUsers().get();
        assertTrue(userList.isPresent());
    }

    @Test
    public void getAsyncDiscordUserConnections() throws ExecutionException, InterruptedException
    {
        Optional<List<DiscordConnection>> connectionList = Dbio.getUserDiscordConnections("192300733234675722").get();

        assertTrue(connectionList.isPresent());
    }

}
