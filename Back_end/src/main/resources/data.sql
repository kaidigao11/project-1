

/*
drop table if exists ticket;
drop table if exists employee;
create table employee (
    employeeId int primary key auto_increment,
    username varchar(255) not null unique,
    password varchar(255),
    administrator boolean 
);
create table ticket (
    ticketId int primary key auto_increment,
    amount double(10,2), 
    ticketDescription varchar(255),
    ticketStatus varchar(255),
    ticketChangeable boolean,
    foreign key (submittedBy) references employee(employeeId)
    
);


*/

-- Starting test values with prefilled ids to avoid test issues

-- admin
insert into employee values (9999, TRUE, 'admin', 'admin');
--insert into employee values (9998, 'user', 'password', FALSE);
--insert into employee values (9997, 'user1', 'password', FALSE);

-- insert into ticket values (9999, 9998, 123.45, 'test ticket description', 'Pending', TRUE);
--insert into ticket values (9999, 9998, 1.23, 'test ticket description', 'Approved', FALSE);
--insert into ticket values (9999, 9998, 9876543.21, 'test ticket description', 'Denied', FALSE);





