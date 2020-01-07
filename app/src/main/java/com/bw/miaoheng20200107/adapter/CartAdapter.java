package com.bw.miaoheng20200107.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.miaoheng20200107.R;
import com.bw.miaoheng20200107.entity.CartEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 时间 :2020/1/7  9:03
 * 作者 :苗恒
 * 功能 :
 */
public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder> {
    Context context;
    List<CartEntity.ResultBean> result;


    public CartAdapter(Context context, List<CartEntity.ResultBean> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvCart.setText(result.get(position).getCategoryName());
        holder.rvProduct.setLayoutManager(new LinearLayoutManager(context));
        holder.rvProduct.setAdapter(new ProductAdapter(context,result.get(position).getShoppingCartList()));
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_cart)
        TextView tvCart;
        @BindView(R.id.rv_product)
        RecyclerView rvProduct;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
