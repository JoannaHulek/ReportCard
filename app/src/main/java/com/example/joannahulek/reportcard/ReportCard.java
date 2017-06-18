package com.example.joannahulek.reportcard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by Joasia on 18.06.2017.
 */

public class ReportCard {

    private final int studentID;
    private final String studentName;
    private final String schoolName;
    private final String className;
    private final String classTutor;
    private final String semester;
    private final Map<Subject, List<Grade>> studentsGrades;

    public ReportCard(int studentId, String studentName, String schoolName, String className, String classTutor, String semester, Map<Subject, List<Grade>> studentsGrades) {
        this.studentID = studentId;
        this.studentName = studentName;
        this.schoolName = schoolName;
        this.className = className;
        this.classTutor = classTutor;
        this.semester = semester;
        this.studentsGrades = checkForEmptySubjects(studentsGrades);
    }

    public int getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getClassName() {
        return className;
    }

    public String getClassTutor() {
        return classTutor;
    }

    public String getSemester() {
        return semester;
    }

    public List<Grade> getGrades(Subject subject) {
        return studentsGrades.get(subject);
    }

    public void addGrade(Subject subject, Grade grade) {
        getGrades(subject).add(grade);
    }

    private Map<Subject, List<Grade>> checkForEmptySubjects(Map<Subject, List<Grade>> studentsGrades) {
        for (Subject subject : Subject.values()) {
            if (!studentsGrades.containsKey(subject)) {
                addSubject(subject, studentsGrades);
            }
        }
        return studentsGrades;
    }

    private void addSubject(Subject subject, Map<Subject, List<Grade>> studentsGrades) {
        studentsGrades.put(subject, new ArrayList<Grade>());
    }

    @Override
    public String toString() {
        return "ReportCard{" +
                "studentID=" + studentID +
                ", studentName='" + studentName + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", className='" + className + '\'' +
                ", classTutor='" + classTutor + '\'' +
                ", semester='" + semester + '\'' +
                ", studentsGrades=" + studentsGrades +
                '}';
    }

    private enum Grade {
        A, B, C, D, F;
    }

    private enum Subject {
        MATH, ENGLISH, CHEMISTRY, BIOLOGY, HISTORY, IT, ART, PE, PHYSICS, MUSIC;
    }
}
