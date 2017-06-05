package com.soulkitchen.health.fragment;

import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.BackendlessDataQuery;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.TextOutsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;
import com.soulkitchen.health.CardViewAdapter;
import com.soulkitchen.health.R;
import com.soulkitchen.health.pojo.Recipies;
import com.soulkitchen.health.pojo.SavedRecipies;
import com.soulkitchen.health.utils.Session;
import com.soulkitchen.health.utils.Utils;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by serifenuruysal on 07/03/17.
 */

public class ProfilFragment extends BaseFragment {

    private AppBarLayout mAppBarLayout;
    private Toolbar mToolbar;
    private List<Recipies> recipieList;
    private CardViewAdapter adapter;
    RecyclerView mRecyclerView;
    BoomMenuButton bmb;

    public static ProfilFragment newInstance() {
        ProfilFragment f = new ProfilFragment();
        Bundle localBundle = new Bundle(1);
        f.setArguments(localBundle);
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profil, container, false);
        mToolbar = (Toolbar) view.findViewById(R.id.toolbar);
        mAppBarLayout = (AppBarLayout) view.findViewById(R.id.appbar);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mToolbar.inflateMenu(R.menu.menu_recipie);
        bmb = (BoomMenuButton) view.findViewById(R.id.bmb);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getSavedRecipies();

        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        adapter = new CardViewAdapter(getContext(), recipieList, new CardViewAdapter.CardViewAdapterListener() {
            @Override
            public void onClickCard(Recipies recipie) {
                ProfilFragment.this.setFragment(ProfilFragment.this, RecipieDetailFragment.newInstance(recipie));
            }

            @Override
            public void onClickActionFinish() {
                getSavedRecipies();
            }
        }, true);

        assert bmb != null;
        bmb.setButtonEnum(ButtonEnum.TextOutsideCircle);
        bmb.setPiecePlaceEnum(PiecePlaceEnum.DOT_1);
        bmb.setButtonPlaceEnum(ButtonPlaceEnum.SC_1);

        bmb.addBuilder(new TextOutsideCircleButton.Builder()
                .normalImageRes(R.drawable.ic_list)
                .normalText("DETAY").listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {
                    }
                }).imagePadding(new Rect(20, 20, 20, 20)));


        mRecyclerView.setAdapter(adapter);
    }

    private void getSavedRecipies() {

        String whereClause = "ownerId ='"+(String) Session.getSession().getUser().getUserId()+"'";
        BackendlessDataQuery dataQuery = new BackendlessDataQuery();
        dataQuery.setWhereClause( whereClause );

        SavedRecipies.findAsync(dataQuery, new AsyncCallback<BackendlessCollection<SavedRecipies>>() {
            @Override
            public void handleResponse(BackendlessCollection<SavedRecipies> recipies) {
                if (recipies!=null&&recipies.getData()!=null&&recipies.getData().size()>0){
                    String userSavedRecipies="";
                    List<SavedRecipies> sr=recipies.getData();
                    for (int i=0;i<sr.size();i++){
                        userSavedRecipies=userSavedRecipies+"'"+sr.get(i).getRecipieId().trim()+"'";
                        if (i<sr.size()-1){
                            userSavedRecipies=userSavedRecipies+",";
                        }
                    }

                    String whereClause = "objectId IN (" + userSavedRecipies+")";
                    BackendlessDataQuery dataQuery = new BackendlessDataQuery();
                    dataQuery.setWhereClause(whereClause);
                    Recipies.findAsync(dataQuery, new AsyncCallback<BackendlessCollection<Recipies>>() {
                        @Override
                        public void handleResponse(BackendlessCollection<Recipies> recipies) {
                            if (recipies != null && recipies.getData() != null && recipies.getData().size() > 0) {
                                recipieList = recipies.getData();
                                adapter.setList(recipieList);
                                adapter.notifyDataSetChanged();
                            }
                            recipies.getTableName();

                        }

                        @Override
                        public void handleFault(BackendlessFault backendlessFault) {
                        }
                    });
                }
            }

            @Override
            public void handleFault(BackendlessFault backendlessFault) {

            }
        });


    }

}