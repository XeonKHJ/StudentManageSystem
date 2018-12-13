create table Study
(
	Sno char(11),
	Cno nchar(10),
	Score int,
	FOREIGN KEY (Sno) REFERENCES Students(Sno) on delete cascade,
	FOREIGN KEY (Cno) REFERENCES Courses(Cno) on delete cascade,
	Primary key(Sno, Cno)
)