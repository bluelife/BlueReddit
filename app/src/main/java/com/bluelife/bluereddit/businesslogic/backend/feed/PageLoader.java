package com.bluelife.bluereddit.businesslogic.backend.feed;

import com.bluelife.bluereddit.businesslogic.backend.PaginatorFactory;

import net.dean.jraw.models.Submission;
import net.dean.jraw.paginators.Paginator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by HiWin10 on 3/25/2017.
 */

@Singleton
public class PageLoader {

    protected Paginator paginator;
    PaginatorFactory paginatorFactory;

    @Inject
    PageLoader(PaginatorFactory factory){
        paginatorFactory=factory;
    }



    public Observable<List<Submission>> loadNewest(String subReddit){
        paginator=paginatorFactory.create(subReddit);
        return loadData();
    }

    public Observable<List<Submission>> loadNext(){
        return loadData();
    }

    private Observable<List<Submission>> loadData(){
        if(paginator.hasNext()){
            List<Submission> submissions=new ArrayList<>();
            submissions.addAll(paginator.next());
            return Observable.just(submissions);
        }
        else{
            return Observable.just(Collections.<Submission>emptyList());
        }
    }
}
