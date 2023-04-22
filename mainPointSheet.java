package StudentPointSheet;

public class mainPointSheet {
	public static void main(String[] args) {
		// input objects
		Semester S1 = new Semester();
		S1.id = 1;
		S1.name = "HK 1";
		S1.multiplication = 1;

		Semester S2 = new Semester();
		S2.id = 2;
		S2.name = "HK 2";
		S2.multiplication = 2;

		Semester[] sems = { S1, S2 };

		// room, teacher, subject
		Room R1 = new Room();
		R1.id = "R201";

		Teacher teacherVu = new Teacher();
		teacherVu.id = 1;
		teacherVu.name = "Vu Ho";

		Teacher teacherDung = new Teacher();
		teacherDung.id = 2;
		teacherDung.name = "Duc Dung";

		Teacher[] teachers = { teacherVu, teacherDung };

		// class
		Clazz class10A1 = new Clazz();
		class10A1.id = 1;
		class10A1.name = "10A1";
		class10A1.room = R1;
		class10A1.primaryTeacher = teacherVu;

		Clazz class10A2 = new Clazz();
		class10A2.id = 2;
		class10A2.room = R1;
		class10A2.primaryTeacher = teacherDung;

		Subject subjectMath = new Subject();
		subjectMath.id = 1;
		subjectMath.name = "Math";
		subjectMath.multiplication = 2;

		Subject subjectHistory = new Subject();
		subjectHistory.id = 2;
		subjectHistory.name = "History";
		subjectHistory.multiplication = 1;

		Subject[] subjects = { subjectMath, subjectHistory };

		TeacherKnowledge dungTeachMath = new TeacherKnowledge();
		dungTeachMath.teacher = teacherDung;
		dungTeachMath.teachingSubject = subjectMath;

		TeacherKnowledge vuTeachMath = new TeacherKnowledge();
		vuTeachMath.teacher = teacherVu;
		vuTeachMath.teachingSubject = subjectMath;

		TeacherKnowledge vuTeachHistory = new TeacherKnowledge();
		vuTeachHistory.teacher = teacherVu;
		vuTeachHistory.teachingSubject = subjectHistory;

		// Student
		Student yen = new Student();
		yen.id = 1;
		yen.name = "Yen";
		yen.studentClass = class10A1;

		Student jijie = new Student();
		jijie.id = 2;
		jijie.name = "Ji Jie";
		jijie.studentClass = class10A2;

		Student[] students = { yen };

		// exam belong to a subject and a semester with different multiplication
		Exam exam15mS1Math = new Exam();
		exam15mS1Math.id = 1;
		exam15mS1Math.name = "15-minute";
		exam15mS1Math.semester = S1;
		exam15mS1Math.subject = subjectMath;
		exam15mS1Math.multiplication = 1;

		Exam exam15mS2Math = new Exam();
		exam15mS2Math.id = 2;
		exam15mS2Math.name = "15-minute";
		exam15mS2Math.semester = S2;
		exam15mS2Math.subject = subjectMath;
		exam15mS2Math.multiplication = 1;

		Exam examFinalS1Math = new Exam();
		examFinalS1Math.id = 3;
		examFinalS1Math.name = "Final";
		examFinalS1Math.semester = S1;
		examFinalS1Math.subject = subjectMath;
		examFinalS1Math.multiplication = 2;

		Exam examFinalS2Math = new Exam();
		examFinalS2Math.id = 4;
		examFinalS2Math.name = "Final";
		examFinalS2Math.semester = S2;
		examFinalS2Math.subject = subjectMath;
		examFinalS2Math.multiplication = 2;

		Exam examFinalS1History = new Exam();
		examFinalS1History.id = 5;
		examFinalS1History.name = "Final";
		examFinalS1History.semester = S1;
		examFinalS1History.subject = subjectHistory;
		examFinalS1History.multiplication = 2;

		Exam examFinalS2History = new Exam();
		examFinalS2History.id = 6;
		examFinalS2History.name = "Final";
		examFinalS2History.semester = S2;
		examFinalS2History.subject = subjectHistory;
		examFinalS2History.multiplication = 2;

		Exam[] exams = { exam15mS1Math, exam15mS2Math, examFinalS1Math, examFinalS2Math, examFinalS1History,
				examFinalS2History };

		// exam result
		ExamResult point1 = new ExamResult();
		point1.exam = exam15mS1Math;
		point1.student = yen;
		point1.point = 9;

		ExamResult point2 = new ExamResult();
		point2.exam = exam15mS2Math;
		point2.student = yen;
		point2.point = 10;

		ExamResult point3 = new ExamResult();
		point3.exam = examFinalS1Math;
		point3.student = yen;
		point3.point = 8;

		ExamResult point4 = new ExamResult();
		point4.exam = examFinalS2Math;
		point4.student = yen;
		point4.point = 7;

		ExamResult point5 = new ExamResult();
		point5.exam = examFinalS1History;
		point5.student = yen;
		point5.point = 9;

		ExamResult point6 = new ExamResult();
		point6.exam = examFinalS2History;
		point6.student = yen;
		point6.point = 8;

		ExamResult[] points = { point1, point2, point3, point4, point5, point6 };

		// PointSheet
		/*
		 * loop students each student --> print student name, class, primary teacher
		 * loop semester print semester name; loop subjects --> print subject --> loop
		 * exams --> get point --> calculate the avg subject point; calculate semester
		 * avg calculate year avg.
		 */
		for (Student printStudent : students) {
			System.out.println(printStudent.name + "--" + printStudent.studentClass.name + "--"
					+ printStudent.studentClass.primaryTeacher.name);

			double yearTotalPoint = 0;
			for (Semester printSem : sems) {
				System.out.println("Semester: " + printSem.name);
				double semTotalPoint = 0;
				int semTotalMultiplication = 0;

				for (Subject printSubject : subjects) {
					System.out.println(printSubject.name);
					double subjectTotalpoint = 0;
					double subjectTotalMultiplication = 0;

					for (ExamResult point : points) {
						if ((point.exam.subject == printSubject) && (point.student == printStudent)
								&& point.exam.semester == printSem) {
							System.out.println("   " + point.exam.name + " exam: " + point.point);
							subjectTotalpoint = subjectTotalpoint + point.point * point.exam.multiplication;
							subjectTotalMultiplication = subjectTotalMultiplication + point.exam.multiplication;
						}
					}
					double subjectAvg = subjectTotalpoint / subjectTotalMultiplication;
					System.out.println("   " + printSubject.name + " avg point: " + String.format("%.2f", subjectAvg));
					System.out.println("");

					semTotalPoint = semTotalPoint + subjectAvg * printSubject.multiplication;
					semTotalMultiplication = semTotalMultiplication + printSubject.multiplication;
				}
				double semAvg = semTotalPoint / semTotalMultiplication;
				System.out.println(printSem.name + " Avg point: " + String.format("%.2f", semAvg));
				System.out.println("------------");

				yearTotalPoint = yearTotalPoint + semAvg * printSem.multiplication;
			}
			System.out.println("");
			System.out.println("Year avg point: " + String.format("%.2f", yearTotalPoint / 3));
		}
	}
}
