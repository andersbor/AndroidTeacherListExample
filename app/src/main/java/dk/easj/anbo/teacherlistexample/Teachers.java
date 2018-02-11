package dk.easj.anbo.teacherlistexample;

public class Teachers {
    private static final Teacher[] teachers = new Teacher[]{
            new Teacher(1, "Anders", "anbo@easj.dk", 1000),
            new Teacher(2, "Peter", "pele@easj.dk", 1100),
            new Teacher(3, "Michael", "micl@easj.dk", 1200)
    };

    public static Teacher[] getAllTeachers() {
        return teachers;
    }

    public static Teacher getTeacherById(int id) {
        for (Teacher t : teachers) {
            if (t.getId() == id) return t;
        }
        return null;
    }
}