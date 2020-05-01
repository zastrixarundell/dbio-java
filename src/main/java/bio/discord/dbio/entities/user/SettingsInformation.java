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

package bio.discord.dbio.entities.user;

import bio.discord.dbio.Helpers;
import bio.discord.dbio.entities.User;
import com.google.gson.JsonObject;
import org.joda.time.Instant;

import java.util.Date;

public class SettingsInformation
{

    private String name, userId, description, location, email, occupation, banner;
    private boolean premium, verified, staff;
    private long upvotes;
    private Date createdAt = null, birthday = null;
    private User.UserGender gender;

    /**
     * Default constructor for the SettingsInformation objects. Expects a JSON object
     * which can be found on https://docs.discord.bio/ under payload.settings.
     * @param settings A new SettingsInformation object.
     */
    public SettingsInformation(JsonObject settings)
    {
        // The status field isn't user here as it's deprecated.
        name = Helpers.getNullableStringFromJson(settings.get("name"));
        userId = Helpers.getNullableStringFromJson(settings.get("user_id"));
        verified = settings.get("verified").getAsInt() == 1;
        upvotes = settings.get("upvotes").getAsLong();

        if(Helpers.getNullableStringFromJson(settings.get("created_at")) != null)
            createdAt = Instant.parse(Helpers.getNullableStringFromJson(settings.get("created_at"))).toDate();

        description = Helpers.getNullableStringFromJson(settings.get("description"));
        location = Helpers.getNullableStringFromJson(settings.get("location"));
        gender = decodeInt(settings.get("gender").getAsInt());

        if(Helpers.getNullableStringFromJson(settings.get("birthday")) != null)
            birthday = Instant.parse(Helpers.getNullableStringFromJson(settings.get("birthday"))).toDate();

        email = Helpers.getNullableStringFromJson(settings.get("email"));
        occupation = Helpers.getNullableStringFromJson(settings.get("occupation"));
        banner = Helpers.getNullableStringFromJson(settings.get("banner"));
        staff = settings.get("staff").getAsInt() == 1;
        premium = settings.get("premium_status").getAsInt() == 1;
    }



    private User.UserGender decodeInt(int codename)
    {
        User.UserGender gender;

        switch (codename)
        {
            case 0:
                gender = User.UserGender.MALE;
                break;
            case 1:
                gender = User.UserGender.FEMALE;
                break;
            case 2:
                gender = User.UserGender.NONBINARY;
                break;
            default:
                gender = User.UserGender.UNDISCLOSED;
        }

        return gender;
    }

    /**
     * Get the name of the user on discord.bio.
     * @return The name of the user on discord.bio.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Get the ID user of discord.bio.
     * @return The ID of the user on discord.bio.
     */
    public String getUserId()
    {
        return userId;
    }

    /**
     * Get the description of the user on discord.bio.
     * @return The description of the user on discord.bio.
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Get the location of the user on discord.bio.
     * @return The location of the user on discord.bio.
     */
    public String getLocation()
    {
        return location;
    }

    /**
     * Get the email of the user on discord.bio.
     * @return The location of the user on discord.bio.
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Get the occupation of the user on discord.bio.
     * @return The occupation of the user on discord.bio.
     */
    public String getOccupation()
    {
        return occupation;
    }

    /**
     * Get the banner of the user on discord.bio.
     * @return The banner of the user on discord.bio.
     */
    public String getBanner()
    {
        return banner;
    }

    /**
     * See if the user is premium on discord.bio.
     * @return Boolean if the user is premium on discord.bio.
     */
    public boolean isPremium()
    {
        return premium;
    }

    /**
     * See if the user is verified on discord.bio.
     * @return Boolean if the user is verified on discord.bio.
     */
    public boolean isVerified()
    {
        return verified;
    }

    /**
     * See if the user is staff on discord.bio.
     * @return Boolean if the user is staff on discord.bio.
     */
    public boolean isStaff()
    {
        return staff;
    }

    /**
     * See the upvoted the user has.
     * @return A long of the user upvotes on discord.bio.
     */
    public long getUpvotes()
    {
        return upvotes;
    }

    /**
     * See when is the user created.
     * @return The Date of when the user wes created on discord.bio.
     */
    public Date getCreatedAt()
    {
        return createdAt;
    }

    /**
     * See when the user has a birthday.
     * @return The Date of the user birthday on discord.bio.
     */
    public Date getBirthday()
    {
        return birthday;
    }

    /**
     * See the gender of the user.
     * @return The UserGender of the user on discord.bio.
     */
    public User.UserGender getGender()
    {
        return gender;
    }

    @Override
    public String toString()
    {
        return "SettingsInformation{" +
                "name='" + name + '\'' +
                ", userId='" + userId + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", email='" + email + '\'' +
                ", occupation='" + occupation + '\'' +
                ", banner='" + banner + '\'' +
                ", premium=" + premium +
                ", verified=" + verified +
                ", staff=" + staff +
                ", upvotes=" + upvotes +
                ", createdAt=" + createdAt +
                ", birthday=" + birthday +
                ", gender=" + gender +
                '}';
    }
}