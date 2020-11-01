create table OperationLogs (
id integer,
package varchar(64),
class_name varchar(64),
method varchar(64),
message varchar(64),
d date,
primary key (id)
);

create table ExceptionLogs (
id integer,
package varchar(64),
class_name varchar(64),
d date,
message_only varchar(64),
exception varchar(64),
level_code int,
uptime int,
primary key (id)
);
