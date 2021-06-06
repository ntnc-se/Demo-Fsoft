create database fsoft 

create table student_demo (
	id int primary key,
	name varchar(50),
	age int,
	major varchar(50),
	gender bit,
	studentCode varchar(50)
)

select student_demo.id, student_demo.name, student_demo.age, student_demo.major, student_demo.gender, student_demo.studentCode from student_demo

insert into student_demo values ('1','Nguyen Thuc Nguyen Chuong','21','Software Engineer', 1,'HE141612')

delete from student_demo where student_demo.id = 1
