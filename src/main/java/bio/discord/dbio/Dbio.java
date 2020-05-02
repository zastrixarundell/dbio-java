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

import bio.discord.dbio.entities.connections.DbioConnections;
import bio.discord.dbio.entities.UpvotedUser;
import bio.discord.dbio.entities.User;
import bio.discord.dbio.entities.connections.DiscordConnection;
import bio.discord.dbio.online.UserInfoFetcher;
import bio.discord.dbio.online.WebsiteInfoFetcher;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * Java class representing the main features of the library. In most cases the code entry-points for the library are here.
 * This is mainly focused on using {@link CompletableFuture} for async programming.
 *
 * @author zastrixarundell
 * @since 0.0.0
 */
public class Dbio
{

    /**
     * Async get the details about a specified user.
     * @param userId The ID of the user.
     * @return A {@link CompletableFuture} with the user details.
     */
    public static CompletableFuture<Optional<User>> getUserDetails(String userId)
    {
        return CompletableFuture.supplyAsync(() -> UserInfoFetcher.getSingletonInformation(userId));
    }

    /**
     * Async get the details about the website connections a user has.
     * @param userId The ID of the user.
     * @return A {@link CompletableFuture} with the website connections.
     */
    public static CompletableFuture<Optional<DbioConnections>> getUserDbioConnections(String userId)
    {
        return CompletableFuture.supplyAsync(() -> UserInfoFetcher.getUserInfoConnections(userId));
    }

    /**
     * Async get the details about the discord connections a user has.
     * @param userId The ID of the user.
     * @return A {@link CompletableFuture} of the user discord connections.
     */
    public static CompletableFuture<Optional<List<DiscordConnection>>> getUserDiscordConnections(String userId)
    {
        return CompletableFuture.supplyAsync(() -> UserInfoFetcher.getDiscordConnections(userId));
    }

    /**
     * Async get the total count of registered users on the website.
     * @return A {@link CompletableFuture} of the user count on the website.
     */
    public static CompletableFuture<Optional<Integer>> getTotalUserCount()
    {
        return CompletableFuture.supplyAsync(WebsiteInfoFetcher::getTotalUserCount);
    }

    /**
     * Asynch get the list of top-upvoted users on the website.
     * @return A {@link CompletableFuture} of the top-upvoted users.
     */
    public static CompletableFuture<Optional<List<UpvotedUser>>> getTopUpvotedUsers()
    {
        return CompletableFuture.supplyAsync(WebsiteInfoFetcher::getTopUpvotedUsers);
    }

}
