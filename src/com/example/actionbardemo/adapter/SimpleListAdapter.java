package com.example.actionbardemo.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.actionbardemo.R;
import com.example.actionbardemo.model.SimpleListModal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SimpleListAdapter extends BaseAdapter{
List<SimpleListModal> list = new ArrayList<SimpleListModal>();
Context context;

public SimpleListAdapter(List<SimpleListModal> listitems, Context ctx) {
	this.list = listitems;
	this.context = ctx;
}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return list.indexOf(getItem(position));
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View view = null;
		if(convertView == null)
		{
			LayoutInflater inflater = LayoutInflater.from(parent.getContext());
			view = inflater.inflate(R.layout.view_list, null);
		}
		else
		{
			view = convertView;
		}
		ViewHolder holder = new ViewHolder();
		holder.title = (TextView)view.findViewById(R.id.title);
		
		SimpleListModal obj = (SimpleListModal) getItem(position);
		
		holder.title.setText(obj.getName());
		return view;
	}

	static class ViewHolder
	{
		TextView title;
	}
}
