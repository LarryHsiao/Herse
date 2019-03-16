create table if not exists events
(
  id   integer primary key autoincrement,
  name text,
  amount integer
);

create table if not exists event_meta
(
  id       integer primary key autoincrement,
  event_id integer,
  start    integer,
  interval integer, -- either specify interval or set of year, month, day, week, weekday
  year     integer,
  month    integer,
  day      integer,
  week     integer,
  weekday  integer
);

-- Build data set
insert into events(name)
values ('Sample event');
insert into events(name)
values ('Another event');
insert into events(name)
values ('Third');

insert into event_meta(event_id, start, interval, year, month, day, week, weekday)
values (1, 1369008000, 604800, null, null, null, null, null);

insert into event_meta(event_id, start, interval, year, month, day, week, weekday)
values (1, 1368144000, 604800, null, null, null, null, null);

insert into event_meta(event_id, start, interval, year, month, day, week, weekday)
values (2, 1369008000, NULL, 2013, '*', '*', 2, 5);

insert into event_meta(event_id, start, interval, year, month, day, week, weekday)
values (3, 1369008000, NULL, '*', '*', '*', '*', 1);

drop table events;
drop table event_meta;

select * from events where id=1
;
select * from event_meta;

SELECT EV.*
FROM `events` EV
       left JOIN `event_meta` EM1 ON EM1.`event_id` = EV.`id`
WHERE  (( 1552405607 - start) % interval = 0 )
   OR (
    (year = 2013 OR year = '*' )
    AND
    (month = 6 OR month = '*' )
    AND
    (day = 7 OR day = '*' )
    AND
    (week = 3 OR week = '*' )
    AND
    (weekday = 1 OR weekday= '*' )
    AND start <= 1552405607
  )