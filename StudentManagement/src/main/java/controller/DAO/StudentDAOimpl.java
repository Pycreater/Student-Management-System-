package controller.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import controller.api.Student;
import controller.rowmapper.StudentRowMapper;

@Repository
public class StudentDAOimpl implements StudentDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate; 

    @Override
    public List<Student> loadStudents() {
        List<Student> studentList = new ArrayList<>();

        String sql = "SELECT * FROM students";

        List<Student> theListOfStudent = jdbcTemplate.query(sql, new StudentRowMapper());

        
        
        return theListOfStudent;
    }

	@Override
	public void saveStudent(Student student) {
		
		Object[] sqlParameter = {student.getName(),student.getMobile(),student.getCountry()};
		
		String sql = "insert into students(name,mobile,country) values (?,?,?)";
		
		jdbcTemplate.update(sql, sqlParameter);
		
		System.out.println("1 record inserted !!!");
	}

	@Override
	public Student getStudent(int id) {
		
		String sql = "SELECT * FROM STUDENTS WHERE ID = ?";
		
		Student student = jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
		
		return student;
	}

	@Override
	public void update(Student student) {
		String sql = "update students set name = ?,mobile = ?,country = ? where id=?";
		
		jdbcTemplate.update(sql,student.getName(),student.getMobile(),student.getCountry(),student.getId());
		System.out.println("1 record updated");
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		
		String sql="delete from students where id = ?";
		
		jdbcTemplate.update(sql, id);
		
	}

}
