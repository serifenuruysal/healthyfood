package com.soulkitchen.health.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.BackendlessDataQuery;
import com.soulkitchen.health.adapters.CardViewAdapter;
import com.soulkitchen.health.R;
import com.soulkitchen.health.pojo.Recipies;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by serifenuruysal on 12/03/17.
 */

public class CategoryFragment extends BaseFragment {
public static final String TAG="CategoryFragment";
    private static final boolean GRID_LAYOUT = false;
    private static final int ITEM_COUNT = 100;
    private List<Recipies> recipieList;
    private CardViewAdapter adapter;
    private Integer categoryId;


    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    public static CategoryFragment newInstance(Integer categoryId) {
        CategoryFragment f = new CategoryFragment();
        Bundle localBundle = new Bundle(1);
        localBundle.putInt("CATEGORY_TYPE", categoryId);
        f.setArguments(localBundle);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        String whereClause = "categoryId ="+CategoryFragment.this.getArguments().getInt("CATEGORY_TYPE");
        BackendlessDataQuery dataQuery = new BackendlessDataQuery();
        dataQuery.setWhereClause( whereClause );
        Recipies.findAsync(dataQuery, new AsyncCallback<BackendlessCollection<Recipies>>() {
            @Override
            public void handleResponse(BackendlessCollection<Recipies> recipies) {
                if (recipies!=null&&recipies.getData()!=null&&recipies.getData().size()>0){
                    recipieList=recipies.getData();
                    adapter.setList(recipieList);
                    adapter.notifyDataSetChanged();
                }
                recipies.getTableName();

            }

            @Override
            public void handleFault(BackendlessFault backendlessFault) {

            }
        });

//        if (GRID_LAYOUT) {
            mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
//        } else {
//            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        }
//        mRecyclerView.setHasFixedSize(true);

        //Use this now
//        mRecyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());
        adapter=new CardViewAdapter(getContext(), recipieList, new CardViewAdapter.CardViewAdapterListener() {
            @Override
            public void onClickCard(Recipies recipie) {
                CategoryFragment.this.setFragment(CategoryFragment.this,RecipieDetailFragment.newInstance(recipie));
            }

            @Override
            public void onClickActionFinish() {

            }
        },false);
        mRecyclerView.setAdapter(adapter);
    }
}
