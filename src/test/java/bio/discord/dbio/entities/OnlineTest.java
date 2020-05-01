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

import bio.discord.dbio.online.UserInfoFetcher;
import org.junit.Test;

import java.util.Optional;

public class OnlineTest
{

    @Test
    public void canGetInfoOnline()
    {
        assert UserInfoFetcher.getSingletonInformation("192300733234675722").isPresent();
    }

    @Test
    public void canShowOnlineUserInfo()
    {
        Optional<User> user = UserInfoFetcher.getSingletonInformation("192300733234675722");

        user.ifPresent(System.out::println);
    }

    @Test
    public void canGetUserInfoConnections()
    {
        assert UserInfoFetcher.getUserInfoConnections("192300733234675722").isPresent();
    }

    @Test
    public void canShowUserInfoConnections()
    {
        Optional<DbioConnections> connectionsOptional = UserInfoFetcher.getUserInfoConnections("192300733234675722");

        connectionsOptional.ifPresent(System.out::println);
    }

}
