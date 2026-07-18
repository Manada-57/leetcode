# Write your MySQL query statement below
select e.name as Employee from employee e inner join employee e1 on e.managerId=e1.id where e.salary>e1.salary;