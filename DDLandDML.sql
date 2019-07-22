create database WorldCup;
use WorldCup;

create table Team
(
teamid int,
teamname varchar(255)
);
alter table Team
add constraint primary key (teamid);

create table Role
(
roleid int,
rolename varchar(255)
);
alter table Role
add constraint primary key (roleid);

create table Player
(
playerid int,
primary key(playerid),
teamid int,
FOREIGN KEY (teamid) REFERENCES Team(teamid),
playername varchar(255),
roleid int,
FOREIGN KEY (roleid) REFERENCES Role(roleid)
);

alter table Player add column score int;
update Player set score = 200;

insert into Player
values(1,1,'ind1',1);
insert into Player
values(2,1,'ind2',2);
insert into Player
values(3,1,'ind3',1);
insert into Player
values(4,1,'ind4',1);
insert into Player
values(5,1,'ind5',1);

insert into Player
values(6,2,'pak1',1);
insert into Player
values(7,2,'pak2',2);
insert into Player
values(8,2,'pak3',1);
insert into Player
values(9,2,'pak4',1);
insert into Player
values(10,2,'pak5',1);

create table Matches
(
matchid int,
primary key(matchid),
team1id int,
FOREIGN KEY (team1id) REFERENCES Team(teamid),
team2id int,
FOREIGN KEY (team2id) REFERENCES Team(teamid),
team1score int,
team2score int,
winnerteam int
);
insert into matches values(1,1,2,245,267,2);
insert into matches values(2,3,1,312,293,1);
insert into matches values(3,1,4,289,275,1);
insert into matches values(4,2,3,197,234,2);
insert into matches values(5,4,2,267,89,1);
insert into matches values(6,3,4,189,240,2);

create table  plays
(
playerid int,
FOREIGN KEY (playerid) REFERENCES Player(playerid),
matchid int,
FOREIGN KEY (matchid) REFERENCES Matches(matchid),
teamid int,
FOREIGN KEY (teamid) REFERENCES Team(teamid),
runs int,
wickets int
);
alter table plays add constraint primary key(playerid);

insert into plays
values(1,null,1,200,9);
insert into plays
values(2,null,1,400,2);
insert into plays
values(3,null,1,500,4);
insert into plays
values(4,null,1,100,1);
insert into plays
values(5,null,1,300,93);

delete from plays
where playerid = 1;

insert into Team
values(1,'India');
insert into Team
values(2,'Paksitan');
insert into Team
values(3,'England');
insert into Team
values(4,'Aus');

insert into Role
values(1,'Batsman');
insert into Role
values(2,'Baller');



