package vn.edu.tinhoc123.vieccanlam;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskRVadapter extends RecyclerView.Adapter<TaskRVadapter.TaskItemViewHolder> {
    List<Tasks> dataSource;

    public TaskRVadapter(List<Tasks> dataSource) {
        this.dataSource = dataSource;
    }

    public class TaskItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvTenVCL, tvDeadLine;

        public TaskItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tvTenVCL = itemView.findViewById(R.id.textViewTenVCL);
            // Sửa ID để khớp với task_item.xml (textViewThoiGian)
            tvDeadLine = itemView.findViewById(R.id.textViewThoiGian);
        }

        @Override
        public void onClick(View v) {
            int vtClicked = getAdapterPosition();
            if (vtClicked != RecyclerView.NO_POSITION) {
                Tasks taskClicked = dataSource.get(vtClicked);
                Toast.makeText(v.getContext(), "Bạn vừa chọn việc: " + taskClicked.getName(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @NonNull
    @Override
    public TaskItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item, parent, false);
        return new TaskItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskItemViewHolder holder, int position) {
        Tasks tasks = dataSource.get(position);
        holder.tvTenVCL.setText(tasks.getName());
        // Hiển thị ngày (Date)
        holder.tvDeadLine.setText(tasks.getDate());
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }
}
