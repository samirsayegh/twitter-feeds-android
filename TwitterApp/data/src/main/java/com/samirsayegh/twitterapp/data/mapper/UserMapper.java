package com.samirsayegh.twitterapp.data.mapper;

import com.samirsayegh.twitterapp.domain.entities.TwitterUser;
import com.twitter.sdk.android.core.models.User;

/**
 * Created by Samir DK on 6/4/2017.
 * Samir Dev
 */

public class UserMapper {

    public static TwitterUser toTwitterUser(User user) {
        TwitterUser twitterUser = new TwitterUser();
        twitterUser.setId(user.id);
        twitterUser.setName(user.name);
        twitterUser.setProfileImage(user.profileImageUrl);
        return twitterUser;
    }
}
