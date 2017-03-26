package com.bluelife.bluereddit.businesslogic.backend;

import com.bluelife.bluereddit.businesslogic.settings.RedditSetting;

import net.dean.jraw.RedditClient;
import net.dean.jraw.paginators.Paginator;
import net.dean.jraw.paginators.SubredditPaginator;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by HiWin10 on 3/25/2017.
 */

@Singleton
public class PaginatorFactory {

    protected RedditClient redditClient;

    @Inject
    PaginatorFactory(RedditClient client){
        redditClient=client;
    }

    public Paginator create(String sub){
        Paginator paginator=null;
        if (sub.equals("frontpage")) {
            paginator = new SubredditPaginator(redditClient);
        } else if (!sub.contains(".")) {
            paginator = new SubredditPaginator(redditClient, sub);
        } else {
            //paginator = new DomainPaginator(Authentication.reddit, sub);
        }
        paginator.setSorting(RedditSetting.defaultSorting);
        //paginator.setTimePeriod(Reddit.getTime(subreddit));
        paginator.setLimit(RedditSetting.PAGINATOR_POST_LIMIT);
        return paginator;
    }

}
