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

package bio.discord.dbio;

import bio.discord.dbio.entities.DbioConnections;
import bio.discord.dbio.entities.UpvotedUser;
import bio.discord.dbio.entities.User;
import bio.discord.dbio.online.UserInfoFetcher;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class Dbio
{

    public static CompletableFuture<Optional<User>> getUserDetails(String userId)
    {
        return CompletableFuture.supplyAsync(() -> UserInfoFetcher.getSingletonInformation(userId));
    }

    public static CompletableFuture<Optional<DbioConnections>> getUserConnections(String userId)
    {
        return CompletableFuture.supplyAsync(() -> UserInfoFetcher.getUserInfoConnections(userId));
    }

    public static CompletableFuture<Object> getDiscordConnections(String userId)
    {
        return CompletableFuture.completedFuture(userId);
    }

    public static CompletableFuture<Optional<Integer>> getTotalUserCount()
    {
        return CompletableFuture.supplyAsync(UserInfoFetcher::getTotalUserCount);
    }

    public static CompletableFuture<Optional<List<UpvotedUser>>> getTopUpvotedUsers()
    {
        return CompletableFuture.supplyAsync(UserInfoFetcher::getTopUpvotedUsers);
    }

}
