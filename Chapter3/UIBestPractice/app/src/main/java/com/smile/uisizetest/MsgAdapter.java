package com.smile.uisizetest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by smile on 9/4/15.
 */
public class MsgAdapter extends ArrayAdapter<Msg> {

    private int resourceId;

    public MsgAdapter(Context context, int resourceId, ArrayList<Msg> data) {
        super(context, resourceId, data);
        this.resourceId = resourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        Msg msg = getItem(position);
        ViewHoler viewHoler = new ViewHoler();
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHoler.leftLayout = (LinearLayout) view.findViewById(R.id.left_layout);
            viewHoler.rightLayout = (LinearLayout) view.findViewById(R.id.right_layout);
            viewHoler.leftMsg = (TextView) view.findViewById(R.id.left_msg);
            viewHoler.rightMsg = (TextView) view.findViewById(R.id.right_msg);
            view.setTag(viewHoler);
        }else {
            view = convertView;
            viewHoler = (ViewHoler)view.getTag();
        }
        if (msg.getType() == Msg.RECEIVED) {
            viewHoler.leftLayout.setVisibility(View.VISIBLE);
            viewHoler.rightLayout.setVisibility(View.GONE);//换成INvisible试试
            viewHoler.leftMsg.setText(msg.getContent());
        }else {
            viewHoler.rightLayout.setVisibility(View.VISIBLE);//换成INvisible试试
            viewHoler.leftLayout.setVisibility(View.GONE);
            viewHoler.rightMsg.setText(msg.getContent());
        }
        return view;
    }

    public class ViewHoler {

        LinearLayout leftLayout;

        LinearLayout rightLayout;

        TextView leftMsg;

        TextView rightMsg;
    }
}
