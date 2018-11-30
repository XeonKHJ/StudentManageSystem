create table Study
(
	Sno char(11),
	Cno nchar(10),
	Score int,
	FOREIGN KEY (Sno) REFERENCES Students(Sno),
	FOREIGN KEY (Cno) REFERENCES Courses(Cno),
	Primary key(Sno, Cno)
)