package com.example.minhaj.complexlayout;

import android.content.Context;
import android.support.v17.leanback.widget.HorizontalGridView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by minhaj on 29/08/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private final int ITEM_COUNT = 2;
    private Context context;
    private ArrayList<Model> arrayList;
    private MyAdapter adapter;

    public RecyclerAdapter(Context context){
        this.context = context;
        arrayList = new ArrayList<>();
        setUpModel();
        //adapter = new MyAdapter();
    }

    private void setUpModel() {
        arrayList.add(new Model(R.drawable.image,"image1"));
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("tag","on create view holder");
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.d("tag","on bind view holder:"+position);
        boolean isEvenPos = position%2 == 0;
        if (isEvenPos){
            //holder.gridView.setNumRows(1);
            GridLayoutManager linearLayoutManager = new GridLayoutManager(context,1,GridLayoutManager.HORIZONTAL,false);
            holder.gridView.setLayoutManager(linearLayoutManager);
        }else {
            //holder.gridView.setNumRows(2);
            GridLayoutManager linearLayoutManager = new GridLayoutManager(context,2,GridLayoutManager.HORIZONTAL,false);
            holder.gridView.setLayoutManager(linearLayoutManager);
        }

        holder.gridView.setAdapter(new NestedRvAdapter());
    }

    @Override
    public int getItemCount() {
        return ITEM_COUNT;
    }

    class NestedRvAdapter extends RecyclerView.Adapter<HorizontalViewHolder>{

        @Override
        public HorizontalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.grid_layout,parent,false);
            return new HorizontalViewHolder(view);
        }

        @Override
        public void onBindViewHolder(HorizontalViewHolder holder, int position) {
            Log.d("tag","bind "+position);
            Model model = arrayList.get(0);
            holder.imageView.setImageResource(model.getImgRes());
            holder.textView.setText(model.getText());
        }

        @Override
        public int getItemCount() {
            return 10;
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private RecyclerView gridView;
        public MyViewHolder(View itemView) {
            super(itemView);
            gridView = itemView.findViewById(R.id.gridView);
        }
    }

    class HorizontalAdapter extends RecyclerView.Adapter<HorizontalViewHolder>{


        @Override
        public HorizontalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.grid_layout,parent,false);
            return new HorizontalViewHolder(view);
        }

        @Override
        public void onBindViewHolder(HorizontalViewHolder holder, int position) {
            Log.d("tag","bind "+position);
            Model model = arrayList.get(0);
            holder.imageView.setImageResource(model.getImgRes());
            holder.textView.setText(model.getText());
        }

        @Override
        public int getItemCount() {
            return 10;
        }
    }

    class HorizontalViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public HorizontalViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }

    class MyAdapter extends BaseAdapter{

        private ImageView imageView;
        private TextView textView;
        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            Log.d("tag","grid pos:"+i);
            if (convertView == null){
                View view = layoutInflater.inflate(R.layout.grid_layout,viewGroup,false);
                convertView = view;
                //view.getTag();
            }
            Model model = arrayList.get(0);
            imageView = convertView.findViewById(R.id.imageView);
            textView = convertView.findViewById(R.id.textView);
            imageView.setImageResource(model.getImgRes());
            textView.setText(model.getText());

            return convertView;
        }
        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }


    }

}
