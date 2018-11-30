create table Students
(
	Sno char(11),
	Sname char(10),
	Ssex char(2) check (Ssex = 'ÄÐ' or Ssex = 'Å®'),
	Sbirthday date,
	SenterYear int,
	SiconPath char(256),
	primary key(Sno),
)