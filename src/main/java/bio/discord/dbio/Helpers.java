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

import com.google.gson.JsonElement;

/**
 * Java class which contains helper methods which are used in different classes.
 *
 * @author zastrixarundell
 * @since 0.0.0
 */
public class Helpers
{

    /**
     * If the specified JsonElement is null or has an exception, return a `null`, else it returns the String
     * value of it.
     * @param element The Json Element.
     * @return A String or null value.
     */
    public static String getNullableStringFromJson(JsonElement element)
    {
        try
        {
            return element.getAsString();
        }
        catch (Exception ignore)
        {
            return null;
        }
    }

}
