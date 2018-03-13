package dk.easj.anbo.teacherlistexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {
    private ArrayAdapter<Teacher> adapter;
    private final Teacher[] allTeachers = Teachers.getAllTeachers();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Want to update the Adapters data when coming back from the child activity
        ListView teacherListView = findViewById(R.id.teacherListView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, allTeachers);
        teacherListView.setAdapter(adapter);
        teacherListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(), TeacherDetailActivity.class);
                Log.d("MINE", "Position: " + position + " id: " + id);
                Teacher theTeacher = (Teacher) adapterView.getItemAtPosition(position);
                intent.putExtra(TeacherDetailActivity.TEACHER, theTeacher);
                startActivity(intent);
            }
        });
    }

    public void orderByNameClicked(View view) {
        Arrays.sort(allTeachers, new Comparator<Teacher>() {
            // modern Java does have Lambda expressions
            @Override
            public int compare(Teacher t1, Teacher t2) {
                return t1.getName().compareToIgnoreCase(t2.getName());
            }
        });
        adapter.notifyDataSetChanged();
    }

    public void orderByEmailClicked(View view) {
        Arrays.sort(allTeachers, new Comparator<Teacher>() {
            @Override
            public int compare(Teacher t1, Teacher t2) {
                return t1.getEmail().compareToIgnoreCase(t2.getEmail());
            }
        });
        adapter.notifyDataSetChanged();
    }

    public void orderBySalaryClicked(View view) {
        Arrays.sort(allTeachers, new Comparator<Teacher>() {
            @Override
            public int compare(Teacher t1, Teacher t2) {
                return t1.getSalary() - t2.getSalary();
            }
        });
        adapter.notifyDataSetChanged();
    }
}
