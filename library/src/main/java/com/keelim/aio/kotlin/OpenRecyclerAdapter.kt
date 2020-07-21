package com.keelim.aio.kotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.keelim.aio.R

class OpenRecyclerAdapter // 생성자에서 데이터 리스트 객체를 전달받음.
(private val mContext: Context, //커스텀 adapter
 private val mData: List<OpenItem>) : RecyclerView.Adapter<OpenRecyclerAdapter.ViewHolder>() {

    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.view_open, parent, false)
        return ViewHolder(view)
    }

    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val text1 = mData[position].sector
        val text2 = mData[position].desc
        holder.openText1.text = text1
        holder.openText2.text = text2
    }

    // getItemCount() - 전체 데이터 갯수 리턴.
    override fun getItemCount(): Int {
        return mData.size
    }

    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    inner class ViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        val openText1: TextView
        val openText2: TextView

        init {

            /*view.setOnClickListener(v -> {
                int pos = getAdapterPosition();
                if (pos != RecyclerView.NO_POSITION) {
                    mData.set(pos, "item clicked. pos=" + pos);
                    Context context = v.getContext();
                    notifyItemChanged(pos);
                }
            });*/

            // 뷰 객체에 대한 참조. (hold strong reference)
            openText1 = view.findViewById(R.id.open_text1)
            openText2 = view.findViewById(R.id.open_text2)
        }
    }

}