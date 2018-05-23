package com.android.autoland.recyclerviewwithclicklistener;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import android.widget.TextView;

import java.math.BigDecimal;
import java.util.List;



/**
 * Created by EMAsadov on 18.02.2016.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ItemHolder> {
    private final Context mContext;

    private int lastPosition = -1;
    private List<String> records;
    private LayoutInflater layoutInflater;

    public interface OnItemClickListener {
        void onItemClick(ItemHolder item, int position);
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        onItemClickListener = listener;
    }

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }


    public RecyclerViewAdapter(Context context, List<String> records) {
        this.mContext = context;
        layoutInflater = LayoutInflater.from(context);
        this.records = records;
    }


    @Override
    public ItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = layoutInflater.inflate(R.layout.list_item, viewGroup, false);
        return new ItemHolder(v, this);
    }

    @Override
    public void onBindViewHolder(ItemHolder viewHolder, int position) {
        String record = records.get(position);
        viewHolder.vDebtAmount.setText(record);


        //viewHolder.vName.setText(record.getName());



        // Here you apply the animation when the view is bound
        setAnimation(viewHolder.vDebtAmount, position);
    }

    private void setAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it'PaymentListField animated
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(mContext, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }


    @Override
    public int getItemCount() {
        return records.size();
    }

    public void removeAt(int position) {
        records.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, records.size());
    }


    /**
     * Реализация класса ItemHolder, хранящего ссылки на виджеты.
     */
    public static class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private RecyclerViewAdapter parent;
        // It'PaymentListField the view that will be animated


        protected TextView vDebtAmount;



        public ItemHolder(View v, RecyclerViewAdapter parent) {
            super(v);

            itemView.setOnClickListener(this);
            this.parent = parent;



            vDebtAmount =  v.findViewById(R.id.button);

        }

        @Override
        public void onClick(View v) {
            final OnItemClickListener listener = parent.getOnItemClickListener();
            if (listener != null) {
                listener.onItemClick(this, getAdapterPosition());
            }
        }
    }


}

