import com.szc.pojo.Student;
import com.szc.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;



public class MyBatisTest {
    @Test
    public void findStudentByNameTest() {
        SqlSession session = MyBatisUtils.getSession();
        Student student = new Student();
        student.setName("张三");
        student.setMajor("英语");
        List<Student> students = session.selectList("com.szc.mapper.StudentMapper.findStudentByName", student);
        for (Student student2 : students) {
            System.out.println(student2);
        }
        session.close();
    }

    @Test
    public void findByListTest() {
        SqlSession session = MyBatisUtils.getSession();
        int i;
        List<Integer> id = new ArrayList<>();
        for (i=1; i<5; i++){
            id.add(i);
        }
        List<Student> student2 = session.selectList("com.szc.mapper.StudentMapper.findByList",id);
        for (Student student : student2) {
            System.out.println(student);
        }
        session.close();
    }
}
