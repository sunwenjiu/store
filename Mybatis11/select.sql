
select uall.user_id,uall.username,uall.password,uall.age,
uall.address,uall.sex,dall.dept_id,dall.pname,dall.dept_name from 
(select u.user_id,u.username,u.password,u.dept_id,
uif.age,uif.address,uif.sex 
from user u join user_info uif
on u.user_id=uif.uesr_info_id) uall
join
(select d1.dept_id,d1.dept_name ,d2.dept_name pname from dept d1 left join dept d2 
on d1.parent_id=d2.dept_id) dall
on uall.dept_id=dall.dept_id;
