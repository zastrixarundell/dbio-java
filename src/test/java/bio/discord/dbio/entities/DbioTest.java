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

import bio.discord.dbio.Dbio;
import org.junit.Test;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

public class DbioTest
{

    @Test
    public void getAsyncUserInfo() throws ExecutionException, InterruptedException
    {
        Optional<User> userOptional = Dbio.getUserDetails("192300733234675722").get();
        assert userOptional.isPresent();
    }

    @Test
    public void getAsyncUserConnections() throws ExecutionException, InterruptedException
    {
       Optional<DbioConnections> connectionsOptional = Dbio.getUserConnections("192300733234675722").get();
       assert connectionsOptional.isPresent();
    }

    @Test
    public void getAsyncUserCount() throws ExecutionException, InterruptedException
    {
        Optional<Integer> userCount = Dbio.getTotalUserCount().get();
        assert userCount.isPresent();
    }

}