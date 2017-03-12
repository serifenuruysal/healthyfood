package com.soulkitchen.health.fragment;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;
import com.soulkitchen.health.CardViewAdapter;
import com.soulkitchen.health.R;
import com.soulkitchen.health.pojo.Recipies;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.backendless.media.SessionBuilder.TAG;

/**
 * Created by serifenuruysal on 12/03/17.
 */

public class RecyclerViewFragment extends Fragment {

    private static final boolean GRID_LAYOUT = false;
    private static final int ITEM_COUNT = 100;
    private List<Recipies> recipieList;
    private CardViewAdapter adapter;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    public static RecyclerViewFragment newInstance() {
        return new RecyclerViewFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        final List<Object> items = new ArrayList<>();

        for (int i = 0; i < ITEM_COUNT; ++i) {
            items.add(new Object());
        }


        //setup materialviewpager

        if (GRID_LAYOUT) {
            mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        } else {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        }
        mRecyclerView.setHasFixedSize(true);

        //Use this now
        mRecyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());
        adapter=new CardViewAdapter(getContext(),recipieList);
        mRecyclerView.setAdapter(adapter);
        Backendless.Persistence.of(Recipies.class ).find(new AsyncCallback<BackendlessCollection<Recipies>>(){
            @Override
            public void handleResponse( BackendlessCollection<Recipies> recipies )
            {
                if (recipies!=null&&recipies.getData()!=null&&recipies.getData().size()>0){
                    recipieList=recipies.getData();
                    adapter.setList(recipieList);
                    adapter.notifyDataSetChanged();
                }
                recipies.getTableName();
                // every loaded object from the "Contact" table is now an individual java.util.Map
            }
            @Override
            public void handleFault( BackendlessFault fault )
            {
                Log.e(TAG, "handleFault: "+fault.getMessage(),null );
                // an error has occurred, the error code can be retrieved with fault.getCode()
            }
        });
    }
}
