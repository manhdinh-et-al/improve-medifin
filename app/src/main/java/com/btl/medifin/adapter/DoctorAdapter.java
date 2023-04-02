package com.btl.medifin.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.btl.medifin.activity.Booking;
import com.btl.medifin.R;
import com.btl.medifin.model.Users;

import java.util.List;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.DatLichViewHolder>{
    private List<Users> mList;

    public DoctorAdapter(List<Users> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public DatLichViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bac_si, parent, false);
        return new DatLichViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DatLichViewHolder holder, int position) {
            holder.name.setText(mList.get(position).getFullName());
            holder.btnDatLich.setOnClickListener(v -> {
                Intent intent = new Intent(v.getContext(), Booking.class);
                intent.putExtra("IDBS", mList.get(position).getUserName());
                intent.putExtra("TENBS", mList.get(position).getFullName());
                v.getContext().startActivity(intent);
            });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class DatLichViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView rating;
        private Button btnDatLich;

        public DatLichViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvNameBs_DatLich);
            rating = itemView.findViewById(R.id.tvRatingBs_DatLich);
            btnDatLich = itemView.findViewById(R.id.btnDatLichKham_DatLich);
        }
    }


}
