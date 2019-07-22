select p.playername, SUM(pl.runs)
from Role r 
inner join Player p on r.roleid=p.roleid
inner join Plays pl on pl.playerid = p.playerid
where r.roleid = 1
group by p.playerid
order by pl.runs desc
limit 5;

select p.playername, SUM(pl.wickets)
from Role r 
inner join Player p on r.roleid=p.roleid
inner join Plays pl on pl.playerid = p.playerid
where r.roleid = 2
group by p.playerid
order by pl.wickets desc
limit 5;

create view unionview as
select t.teamname, avg(m.team1score) as avgScore, t.teamid
from Team t
inner join Matches m on m.team1id = t.teamid
group by t.teamid
union
select t.teamname, avg(m.team2score) as avgScore, t.teamid
from Team t
inner join Matches m on m.team2id = t.teamid
group by t.teamid;

-- drop view unionview

select teamid, teamname , avg(avgScore)
from unionview
group by teamid;

create view finalview as
select teamid, teamname , avg(avgScore) as avgScore
from unionview
group by teamid;


update player set score = score + 10
where teamid = (select teamid from finalview where avgScore = (select min(avgScore) from finalview ));



