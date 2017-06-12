package com.soulkitchen.health.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.TextOutsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;
import com.soulkitchen.health.server.DefaultCallback;
import com.soulkitchen.health.R;
import com.soulkitchen.health.pojo.Recipies;
import com.soulkitchen.health.pojo.SavedRecipies;
import com.soulkitchen.health.utils.Session;
import com.soulkitchen.health.view.CustomTextView;

import java.io.File;
import java.io.IOException;
import java.util.List;

import jp.wasabeef.glide.transformations.BlurTransformation;

/**
 * Created by serifenuruysal on 09/03/17.
 */

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.MyViewHolder> {
    public static final String TAG = "CardViewAdapter";
    private Context mContext;
    private List<Recipies> recipieList;
    private CardViewAdapterListener listener;
    private boolean isFromProfil;

    public void setList(List<Recipies> list) {
        this.recipieList = list;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public CustomTextView title, count,cookTime,kcal,likeCount;
        public KenBurnsView thumbnail, overflow;
        public BoomMenuButton bmb;
        public ImageView bluredView;
        public CardView cardView;

        public MyViewHolder(View view) {
            super(view);
            title = (CustomTextView) view.findViewById(R.id.title);
            count = (CustomTextView) view.findViewById(R.id.count);
            kcal = (CustomTextView) view.findViewById(R.id.kcal);
            likeCount = (CustomTextView) view.findViewById(R.id.likecount);
            cookTime = (CustomTextView) view.findViewById(R.id.cooktimee);
            thumbnail = (KenBurnsView) view.findViewById(R.id.thumbnail);
            bmb = (BoomMenuButton) view.findViewById(R.id.bmb);
            bluredView = (ImageView) view.findViewById(R.id.bluredView);
            cardView = (CardView) view.findViewById(R.id.card_view);
        }
    }

    public interface CardViewAdapterListener {
        public void onClickCard(Recipies recipie);
        public void onClickActionFinish();
    }

    public CardViewAdapter(Context mContext, List<Recipies> recipieList, CardViewAdapterListener listener,boolean isFromProfil) {
        this.mContext = mContext;
        this.recipieList = recipieList;
        this.listener=listener;
        this.isFromProfil=isFromProfil;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipie_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Recipies album = recipieList.get(position);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickCard(recipieList.get(position));

            }
        });
        holder.title.setText(album.getTitle() != null ? album.getTitle() : "title");
//        holder.count.setText(album.getKcal());

        BlurTransformation blurTransformation = new BlurTransformation(mContext, 25, 5);
        Glide.with(mContext).load(album.getImageUrl()).centerCrop().into(holder.thumbnail);
//        Glide.with(mContext).load(album.getImageUrl()).fitCenter().override(600, 80).bitmapTransform(blurTransformation).into(holder.bluredView);

        holder.cookTime.setText(album.getCookTime()+"");
        holder.likeCount.setText(album.getLikeCount()+"");
        holder.kcal.setText(album.getKcal()+"");

        assert holder.bmb != null;
        holder.bmb.setButtonEnum(ButtonEnum.TextOutsideCircle);
        holder.bmb.setPiecePlaceEnum(PiecePlaceEnum.DOT_4_1);
        holder.bmb.setButtonPlaceEnum(ButtonPlaceEnum.SC_4_1);

        holder.bmb.addBuilder(new TextOutsideCircleButton.Builder()
                .normalImageRes(R.drawable.ic_list)
                .normalText("DETAY").listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {
                        listener.onClickCard(recipieList.get(position));
                    }
                }).imagePadding(new Rect(20, 20, 20, 20)));

        holder.bmb.addBuilder(new TextOutsideCircleButton.Builder()
                .normalImageRes(R.drawable.ic_share)
                .normalText("PAYLAŞ").listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {
                        share(album);

                    }
                })
                .imagePadding(new Rect(20, 20, 20, 20)));

        holder.bmb.addBuilder(new TextOutsideCircleButton.Builder()
                .normalImageRes(R.drawable.ic_download)
                .normalText(isFromProfil?"LİSTEMDEN ÇIKAR":"LİSTEME EKLE").listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {
                        if (isFromProfil){
                            removeSavedRecipie(album);
                        }else{
                            saveRecipie(album,holder);
                        }

                    }
                }).imagePadding(new Rect(20, 20, 20, 20)));

        holder.bmb.addBuilder(new TextOutsideCircleButton.Builder()
                .normalImageRes(R.drawable.ic_heart)
                .normalText("BEĞEN").listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {
                        likeRecipie(album,holder);
                    }
                }).imagePadding(new Rect(20, 20, 20, 20)));


        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1)
            Glide.with(mContext).load(album.getImageUrl()).centerCrop().bitmapTransform(blurTransformation).into(holder.bluredView);

    }

    private void removeSavedRecipie(Recipies recipies) {
        Backendless.Persistence.of(SavedRecipies.class).remove(new SavedRecipies(recipies.getObjectId()+""), new AsyncCallback<Long>() {
            @Override
            public void handleResponse(Long response) {

            }

            @Override
            public void handleFault(BackendlessFault backendlessFault) {

            }
        });
    }

    private void likeRecipie(final Recipies recipies,final MyViewHolder holder) {
        final int newCount=recipies.getLikeCount()+1;

        recipies.setLikeUsers(recipies.getLikeUsers()!=null?(recipies.getLikeUsers()+","): ""+Session.getSession().getUser().getUserId());
        recipies.setLikeCount(newCount);
        recipies.saveAsync( new DefaultCallback<Recipies>( mContext )
        {
            @Override
            public void handleResponse( Recipies response )
            {
                holder.likeCount.setText(newCount+"");

                super.handleResponse( response );

            }
        } );

    }
    private void saveRecipie(final Recipies recipies,final MyViewHolder holder) {
        int newCount=0;
        if (isFromProfil){
            newCount=recipies.getSaveCount()-1;
        }else{
            newCount=recipies.getSaveCount()+1;
        }
        recipies.setSaveCount(newCount);
        recipies.saveAsync( new DefaultCallback<Recipies>( mContext )
        {
            @Override
            public void handleResponse( Recipies response )
            {

                if (isFromProfil){
                    Backendless.Persistence.of( SavedRecipies.class ).remove(new SavedRecipies(recipies.getObjectId() + ""), new AsyncCallback<Long>() {
                        @Override
                        public void handleResponse(Long aLong) {
                            listener.onClickActionFinish();
                        }

                        @Override
                        public void handleFault(BackendlessFault backendlessFault) {

                        }
                    });

                }else{

//                    String whereClause = "ownerId ='"+(String) Session.getSession().getUser().getUserId()+"'";
//                    BackendlessDataQuery dataQuery = new BackendlessDataQuery();
//                    dataQuery.setWhereClause( whereClause );
                    Backendless.Persistence.save(new SavedRecipies(recipies.getObjectId()+""), new AsyncCallback<SavedRecipies>() {
                        @Override
                        public void handleResponse(SavedRecipies savedRecipies) {

                        }

                        @Override
                        public void handleFault(BackendlessFault backendlessFault) {

                        }
                    });
                }




                super.handleResponse( response );

            }
        } );
    }

    private void share(final Recipies album) {

        Glide.with(mContext).load(album.getImageUrl()).downloadOnly(new SimpleTarget<File>() {
            @Override
            public void onResourceReady(File resource, GlideAnimation<? super File> glideAnimation) {

                try {
                    File temporaryFile=null;
                    temporaryFile = File.createTempFile("temp", ".jpeg", mContext.getExternalCacheDir());
                    com.soulkitchen.health.utils.Utils.copyFile(resource, temporaryFile);
                    temporaryFile.deleteOnExit();

                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.setType("image/jpeg");

                    sendIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(temporaryFile));
                    sendIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    sendIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

                    sendIntent.putExtra(Intent.EXTRA_TEXT, album.getTitle());
                    sendIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(temporaryFile));
                    mContext.startActivity(Intent.createChooser(sendIntent, mContext.getResources().getText(R.string.text_inside_circle_button_text_highlighted)));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_recipie, popup.getMenu());
//        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
//        popup.show();
    }


    @Override
    public int getItemCount() {
        return recipieList != null ? recipieList.size() : 0;
    }
}
