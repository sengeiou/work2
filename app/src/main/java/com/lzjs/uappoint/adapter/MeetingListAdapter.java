package com.lzjs.uappoint.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lzjs.uappoint.R;
import com.lzjs.uappoint.act.BodyAuthenticateActivity;
import com.lzjs.uappoint.act.ImagePagerActivity;
import com.lzjs.uappoint.bean.Article;
import com.lzjs.uappoint.bean.Meeting;
import com.lzjs.uappoint.myview.NoScrollGridView;
import com.lzjs.uappoint.util.DisplayUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2017/1/23.
 */

public class MeetingListAdapter extends BaseAdapter {
    private Context mContext;
    private List<Meeting> items;
    private boolean clickflag=false;
    public MeetingListAdapter(Context ctx, List<Meeting> items) {
        this.mContext = ctx;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items == null ? 0 : items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(mContext, R.layout.act_meeting_list_item, null);
            holder.iv_icon = (ImageView) convertView.findViewById(R.id.iv_icon);
            holder.tv_title=(TextView) convertView.findViewById(R.id.tv_title);
            holder.tv_date = (TextView) convertView.findViewById(R.id.tv_date);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Meeting itemEntity = items.get(position);
        holder.iv_icon.setImageDrawable("1".equals(itemEntity.getType()) ? convertView.getResources().getDrawable(R.drawable.wo_diaoyan) : convertView.getResources().getDrawable(R.drawable.wo_dingyue));
        holder.tv_title.setText(itemEntity.getTital());
        holder.tv_date.setText(itemEntity.getDate());
        return convertView;
    }
    /**
     * listview组件复用，防止“卡顿”
     *
     * @author Administrator
     *
     */
    class ViewHolder {
        private ImageView iv_icon;
        private TextView tv_title;
        private TextView tv_date;
    }
}
