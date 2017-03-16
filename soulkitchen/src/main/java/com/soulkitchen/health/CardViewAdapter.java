package com.soulkitchen.health;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.SimpleCircleButton;
import com.nightonke.boommenu.BoomButtons.TextOutsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;
import com.soulkitchen.health.pojo.Recipies;
import com.soulkitchen.health.view.CustomTextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import jp.wasabeef.glide.transformations.BlurTransformation;

/**
 * Created by serifenuruysal on 09/03/17.
 */

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.MyViewHolder> {
    public static final String TAG="CardViewAdapter";
    private Context mContext;
    private List<Recipies> albumList;

    public void setList(List<Recipies> list) {
        this.albumList = list;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public CustomTextView title, count;
        public CircleImageView thumbnail, overflow;
        public BoomMenuButton bmb;
        public ImageView bluredView;

        public MyViewHolder(View view) {
            super(view);
            title = (CustomTextView) view.findViewById(R.id.title);
            count = (CustomTextView) view.findViewById(R.id.count);
            thumbnail = (CircleImageView) view.findViewById(R.id.thumbnail);
            bmb= (BoomMenuButton) view.findViewById(R.id.bmb);
            bluredView=(ImageView)view.findViewById(R.id.bluredView);
        }
    }


    public CardViewAdapter(Context mContext, List<Recipies> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipie_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Recipies album = albumList.get(position);

        holder.title.setText(album.getTitle()!=null?album.getTitle():"title");
//        holder.count.setText(album.getKcal());

        BlurTransformation blurTransformation = new BlurTransformation(mContext, 25, 5);
        Glide.with(mContext).load(album.getImageUrl()).centerCrop().into(holder.thumbnail);
//        Glide.with(mContext).load(album.getImageUrl()).fitCenter().override(600, 80).bitmapTransform(blurTransformation).into(holder.bluredView);


//        holder.overflow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                showPopupMenu(holder.overflow);
//            }
//        });

        assert holder.bmb != null;
        holder.bmb.setButtonEnum(ButtonEnum.SimpleCircle);
        holder.bmb.setPiecePlaceEnum(PiecePlaceEnum.DOT_1);
        holder.bmb.setButtonPlaceEnum(ButtonPlaceEnum.SC_1);
        holder.bmb.addBuilder(new SimpleCircleButton.Builder());

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1 )
            Glide.with(mContext).load(album.getImageUrl()).centerCrop().bitmapTransform(blurTransformation).into(holder.bluredView);

    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_recipie, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    /**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(mContext, "Play next", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return albumList!=null?albumList.size():0;
    }
}
