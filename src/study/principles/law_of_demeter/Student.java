package study.principles.law_of_demeter;

/**
 * @author : Cattle_Horse
 * @date   : 2023/11/6 16:25
 * @description : 学生
 **/
public class Student {

    private String name;    // 学生姓名
    private int rank;       // 考试排名(总排名)
    private double grade;   // 考试分数(总分)

    public Student() {
    }

    public Student(String name, int rank, double grade) {
        this.name = name;
        this.rank = rank;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
