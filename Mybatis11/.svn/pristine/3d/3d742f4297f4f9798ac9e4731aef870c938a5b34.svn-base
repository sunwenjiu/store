select * from
(select u.*,p.age,p.address,p.sex from user u left join 
(select * from user_info) p
on u.user_id=p.uesr_info_id) uall
join
(select d1.*,d2.dept_name pname from dept d1 left 
join dept d2 on d1.parent_id=d2.dept_id) dall
on uall.dept_id=dall.dept_id;