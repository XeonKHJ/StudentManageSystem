CREATE TABLE SP
(
	Sno char(11) not null,
	PS nchar(20) default '12345',
	Primary key(Sno),
	FOREIGN KEY (Sno) REFERENCES Students(Sno)
)