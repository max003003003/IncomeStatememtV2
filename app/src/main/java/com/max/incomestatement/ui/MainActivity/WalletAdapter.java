package com.max.incomestatement.ui.MainActivity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.max.incomestatement.R;

import com.max.incomestatement.model.Wallet;

import java.util.List;

/**
 * Created by Max on 2/15/2017.
 */

public class WalletAdapter extends RecyclerView.Adapter<WalletAdapter.ViewHolder>   {
    private final Context mContext;
    private final WalletAdapterOnItemClickHandler mClickHandler;
    private List<Wallet> mWallet;
    public WalletAdapter(@NonNull Context context, WalletAdapterOnItemClickHandler clickHandler) {
        mContext = context;
        mClickHandler = clickHandler;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name, balance;
        public AppCompatImageView icon;
        Context context;

        public ViewHolder(View itemView, Context c) {
            super(itemView);
            name=(TextView) itemView.findViewById(R.id.namelv);
            balance= (TextView) itemView.findViewById(R.id.balacelv);
            icon = (AppCompatImageView) itemView.findViewById(R.id.iconlv);
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
            context = c;

        }


        @Override
        public void onClick(View view) {
          int adapterPosition = getAdapterPosition();
           int id=  mWallet.get(adapterPosition).getId();
          mClickHandler.OnItemClick(id);

        }
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_row,parent,false);

        return new ViewHolder(itemView,mContext);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Wallet wallet = mWallet.get(position);
        holder.name.setText(wallet.getName());
        holder.balance.setText(wallet.getBalace());
        holder.icon.setImageResource(wallet.getIconImage());



    }

    @Override
    public int getItemCount() {
        if(mWallet == null)
            return  0;

        return mWallet.size();
    }

   public void setWallet(final List<Wallet> newWallet) {
        mWallet=newWallet;
        notifyDataSetChanged();
    }

    public interface WalletAdapterOnItemClickHandler{
        void OnItemClick(int id);
    }

}