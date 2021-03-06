package com.keelim.aio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class OpenRecyclerAdapter extends RecyclerView.Adapter<OpenRecyclerAdapter.ViewHolder> { //리사이클러 뷰를 사용을 하기위 커스터 어댑터
    private final List<Open.OpenItem> mData;
    private final Context mContext;
    private final int resource;

    // 생성자에서 데이터 리스트 객체를 전달받음.
    public OpenRecyclerAdapter(Context context, List<Open.OpenItem> list, int resource) {
        this.mData = list;
        this.mContext = context;
        this.resource = resource;
    }

    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
    @NotNull
    @Override
    public OpenRecyclerAdapter.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(resource, parent, false);

        return new ViewHolder(view);
    }

    // onBindViewHolder() - position 에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(@NotNull OpenRecyclerAdapter.ViewHolder holder, int position) {
        String text1 = mData.get(position).getSector();
        String text2 = mData.get(position).getDesc();
        holder.openText1.setText(text1);
        holder.openText2.setText(text2);
    }

    // getItemCount() - 전체 데이터 갯수 리턴.
    @Override
    public int getItemCount() {
        return mData.size();
    }

    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView openText1;
        final TextView openText2;

        ViewHolder(View view) {
            super(view);

            /*view.setOnClickListener(v -> {
                int pos = getAdapterPosition();
                if (pos != RecyclerView.NO_POSITION) {
                    mData.set(pos, "item clicked. pos=" + pos);
                    Context context = v.getContext();
                    notifyItemChanged(pos);
                }
            });*/

            // 뷰 객체에 대한 참조. (hold strong reference)
            openText1 = view.findViewById(R.id.open_text1);
            openText2 = view.findViewById(R.id.open_text2);
        }
    }
}