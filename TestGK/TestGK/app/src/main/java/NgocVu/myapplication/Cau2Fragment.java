package NgocVu.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;

public class Cau2Fragment extends Fragment {
    ListView lvMonAn;
    ArrayList<String> dsMonAn;

    public Cau2Fragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cau2, container, false);
        lvMonAn = view.findViewById(R.id.DanhSachMonAn);

        dsMonAn = new ArrayList<>();
        dsMonAn.add("Phở Hà Nội");
        dsMonAn.add("Bún Bò Huế");
        dsMonAn.add("Cơm Tấm");
        dsMonAn.add("bún thịt nướng");
        dsMonAn.add("Cơm gà");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, dsMonAn);
        lvMonAn.setAdapter(adapter);

        lvMonAn.setOnItemClickListener((parent, v, position, id) -> {
            String monSelected = dsMonAn.get(position);
            Toast.makeText(getActivity(), "Chọn: " + monSelected, Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getActivity(), ChiTietMonActivity.class);
            i.putExtra("ten_mon", monSelected);
            startActivity(i);
        });
        return view;
    }
}