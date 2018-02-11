package dk.easj.anbo.teacherlistexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TeacherDetailActivity extends AppCompatActivity {

    private int teacherId;
    private EditText nameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_detail);

        Intent intent = getIntent();
        Teacher teacher = (Teacher)intent.getSerializableExtra(MainActivity.TEACHER);
        teacherId = teacher.getId();

        TextView textView = (TextView)findViewById(R.id.teacher_detail_id_textview);
        textView.setText("Id: " + teacher.getId());

        nameView = (EditText) findViewById(R.id.teacher_detail_name_textview);
        nameView.setText(teacher.getName());

    }

    public void teacherDetailUpdateButtonClicked(View view) {
        Teacher teacher = Teachers.getTeacherById(teacherId);
        teacher.setName(nameView.getText().toString());
    }

    public void teacherDetailBackButtonClicked(View view) {
        finish();
    }
}
