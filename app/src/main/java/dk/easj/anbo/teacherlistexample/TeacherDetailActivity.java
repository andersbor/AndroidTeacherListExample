package dk.easj.anbo.teacherlistexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TeacherDetailActivity extends AppCompatActivity {
    public static final String TEACHER = "teacher";
    private int teacherId;
    private EditText nameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_detail);

        Intent intent = getIntent();
        Teacher teacher = (Teacher) intent.getSerializableExtra(TEACHER);
        teacherId = teacher.getId();

        TextView textView = findViewById(R.id.teacherDetailIdTextView);
        textView.setText("Id: " + teacher.getId());

        TextView emailView = findViewById(R.id.teacherDetailEmailTextView);
        emailView.setText("Email " + teacher.getEmail());

        TextView salaryView = findViewById(R.id.teacherDetailSalaryTextView);
        salaryView.setText("Salary " + teacher.getSalary());

        nameView = findViewById(R.id.teacherDetailNameEditTExt);
        nameView.setText(teacher.getName());
    }

    public void teacherDetailUpdateButtonClicked(View view) {
        Teacher teacher = Teachers.getTeacherById(teacherId);
        if (teacher != null) {
            String newName = nameView.getText().toString();
            teacher.setName(newName);
        }
    }

    public void teacherDetailBackButtonClicked(View view) {
        finish();
    }
}
