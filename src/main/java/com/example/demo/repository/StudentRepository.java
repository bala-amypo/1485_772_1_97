public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByRollNumber(String rollNumber);
}