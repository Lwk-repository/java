--声明变量 赋值 输出
declare @a int
set @a=5
print @a

--select语句赋值
declare @user1 nvarchar(50)
select @user1 = '张三'
print @user1

declare @user2 nvarchar(50)
select @user2 = issue from cs_demand_apply where id = 10001
print @user2

--更新语句赋值
declare @user3 nvarchar(50)
update cs_demand_apply set @user3 = issue where id = 10001
print @user3

--创建临时表
create table #tem(
	id int not null,
	name nvarchar(50) not null,
	password nvarchar(50) not null
);

--向临时表插入数据
insert into #tem (id,name,password) values(1,'aa','bb')

--从其他表查询数据，填充到新的临时表
select id,issue,issuer_name into #tem2 from cs_demand_apply

--查询并联合两临时表，列数必须一致，列类型必须一致
select * from #tem union select * from #tem2

--删除临时表
drop table #tem
drop table #tem2

--创建临时表
--创建临时表
create table #tem(
	id int not null,
	name nvarchar(50) not null,
	password nvarchar(50) not null
);

--将查询结果集插入临时表
insert into #tem select id,issue,issuer_name from cs_demand_apply

--添加一列，为int型自增长子段
alter table #tem add myid int not null identity(1,1)

--添加一列，默认填充全球唯一标识
alter table #tem add myid1 uniqueidentifier not null default(newid())

--给查询结果集增加自增长列：无主键时
--查询cs表，填充至临时表#t，增加自增长列myid
select IDENTITY(int,1,1) as myid,issue,issuer_name into #t from cs_demand_apply
--有主键时
select (select SUM(1) from cs_demand_apply where ID<= a.ID) as myID,* from cs_demand_apply a order by myID

--定义表变量
declare @t table
(
	id int not null,
	msg nvarchar(50) null
)
insert into @t values(1,'2'),(2,'3')
select * from @t

--while循环计算1到100的和
declare @a int
declare @sum int
set @a=1
set @sum=0
while @a<=100
begin
	set @sum+=@a
	set @a+=1
end
print @sum

--if,else判断语句
if(1+11=2)
	begin
		print 'aa'
		print 'bb'
	end
else
	begin
		print 'cc'
		print	'dd'
	end
	
--when then条件分支
declare @today int 
declare @week nvarchar(50)
set @today = 4
set @week = 
		case
		when @today = 1 then 'aa'
		when @today = 2 then 'bb'
		when @today = 3 then 'cc'
		else 'dd'
		end
print @week


------------------------------------------游标-----------------------------------------------------
--定义变量
declare @name int
declare @age nvarchar(50)
--定义一个游标
declare t_cur CURSOR for select id,issue from cs_demand_apply
--打开游标
open t_cur
--读取游标的值到变量
fetch next from t_cur into @name,@age
--success 0,failed -1,找不到 -2
while @@fetch_status=0
	begin
		print @name
		print @age
		fetch next from t_cur into @name,@age
	end
--关闭游标
close t_cur
--释放游标
deallocate t_cur


----------------------------------触发器-------------------------------------------
--创建触发器
create trigger t_update
	on cs_demand_apply
	after UPDATE
as
begin
	declare @msg nvarchar(50)
	--@msg记录修改情况
	select @msg = '姓名从' + deleted.issue + '修改为' + inserted.issue from inserted,deleted
	print @msg
end

--删除触发器
drop trigger t_update

update cs_demand_apply set issue = '德玛西亚' where id=10001


-------------------------------存储过程-------------------------------
create procedure pr_sum
	@a int,
	@b int,
	@sum int output
as
begin
	set @sum=@a+@b
end

drop procedure pr_ret
go

declare @mysum int
execute pr_sum 1345,14235,@mysum output
print @mysum


create procedure pr_ret
	@a int,
	@b int
as
begin
	return @a+@b
end


----------------------自定义函数----------------------------
--新建标量值函数
create function FUNC_Sum1
(
	@a int,
	@b int
)
--设置返回值类型
returns int
as
begin
	return @a+@b
end
--调用标量值函数
declare @s int
set @s=dbo.FUNC_Sum1(123,312)
print @s


--新建内联表值函数
create function FUNC_UserTab_1
(
	@myId int
)
returns table
as
return (select * from cs_demand_apply where id<@myId)
--调用表值函数
select * from FUNC_UserTab_1(10003)


--新建多语句表值函数
create function FUNC_UserTab_2
(
	@myId int
)
returns @t table
(
	[id] [int] not null,
	[name] [nvarchar](50) not null
)
as
begin
	insert into @t select id,issue from cs_demand_apply where id < @myId
	return
end

--调用表值函数
select * from FUNC_UserTab_2(10006)

--删除表值函数，标量值函数
drop function FUNC_UserTab_2


---------------------------内置函数--------------------------
--第一个值不为空则返回，否则返回第二个值
select isnull(null,2)
--时间函数
select getdate()


---------------------cte表达式--------------------------
--查询临时结果集
--加括号指定列名，可以不加，参数量与查询量一致
WITH cte(id,name)
as(
	select id,issue from cs_demand_apply(nolock)
)
select * from cte
--cte递归测试表
create table aaauser
(
    UserID int,
    ManagerID int,
    Name Nvarchar(10)
)
insert into aaauser values
(1,-1,N'boss'),
(11,1,N'A1'),
(12,1,N'A2'),
(13,1,N'A3'),
(111,11,N'B1'),
(112,11,N'B2'),
(121,12,N'C1')


;with cte as
(
	select UserID,ManagerID,name,name as ManagerName
	from aaauser
	where ManagerID=-1
	
	union all
	select c.UserID,c.ManagerID,c.Name,p.name as ManagerName
from cte P
inner join aaauser c
    on p.UserID=c.ManagerID
)
select UserID,ManagerID,Name,ManagerName from cte order by UserID


----------------------------------------------接收返回值------------------------------------------------
CREATE PROCEDURE aaaaaaaaa
	@a int
as
begin
	
	IF (@a <> 0) RETURN 100 ELSE RETURN 200
end

declare @num int;
EXEC @num = aaaaaaaaa 1
print @num;



CREATE PROCEDURE aaa
	@a int,
	@b int OUTPUT
as
begin
	
	IF (@a <> 0) set @b = 100 ELSE set @b = 200
end

declare @num int;
EXEC aaa 0, @num OUTPUT
print @num



set @rowc += @@ROWCOUNT --返回上次sql语句影响行数