--test veritabanınızda employee isimli sütun bilgileri id(INTEGER), name VARCHAR(50), birthday DATE, email VARCHAR(100) olan bir tablo oluşturalım.
create table employee(
	id bigint not null,
	name varchar(50),
	birthday DATE,
	email varchar(100) not null);
	
--Oluşturduğumuz employee tablosuna 'Mockaroo' servisini kullanarak 50 adet veri ekleyelim.
insert into employee (id, name, birthday, email) values (1, 'Gwenneth', '2021-05-29', 'gmantha0@privacy.gov.au');
insert into employee (id, name, birthday, email) values (2, 'Leonanie', '2021-11-13', 'lshufflebotham1@taobao.com');
insert into employee (id, name, birthday, email) values (3, 'Lanna', '2021-10-24', 'lvertey2@google.fr');
insert into employee (id, name, birthday, email) values (4, 'Marylou', '2021-04-16', 'mweigh3@shareasale.com');
insert into employee (id, name, birthday, email) values (5, 'Clarette', '2021-11-25', 'cmattingson4@cbsnews.com');
insert into employee (id, name, birthday, email) values (6, 'Thibaud', '2021-04-02', 'tpatterfield5@newyorker.com');
insert into employee (id, name, birthday, email) values (7, null, '2021-08-02', 'mmcgovern6@seattletimes.com');
insert into employee (id, name, birthday, email) values (8, 'Ezequiel', '2021-12-18', 'ehoffner7@bravesites.com');
insert into employee (id, name, birthday, email) values (9, 'Karly', '2021-12-13', 'kbrouncker8@myspace.com');
insert into employee (id, name, birthday, email) values (10, 'Patin', '2021-04-17', 'pselcraig9@webs.com');
insert into employee (id, name, birthday, email) values (11, null, null, 'ayegorovnina@sogou.com');
insert into employee (id, name, birthday, email) values (12, 'Sara-ann', '2021-07-09', 'stitcumbb@weather.com');
insert into employee (id, name, birthday, email) values (13, 'Horst', '2021-07-16', 'hdawidsohnc@alexa.com');
insert into employee (id, name, birthday, email) values (14, 'Binnie', '2021-07-31', 'blabuschd@merriam-webster.com');
insert into employee (id, name, birthday, email) values (15, 'Jacenta', '2021-08-15', 'jhaldenee@admin.ch');
insert into employee (id, name, birthday, email) values (16, 'Rog', '2021-11-06', 'rbushrodf@yahoo.com');
insert into employee (id, name, birthday, email) values (17, 'Edwin', '2021-11-28', 'emoodeyg@harvard.edu');
insert into employee (id, name, birthday, email) values (18, 'Christophe', '2021-12-26', 'cknapperh@skype.com');
insert into employee (id, name, birthday, email) values (19, 'Elnar', '2021-09-17', 'egasperoi@mail.ru');
insert into employee (id, name, birthday, email) values (20, 'Chicky', '2021-05-12', 'cjellicoj@google.co.jp');
insert into employee (id, name, birthday, email) values (21, 'Elinor', '2022-01-15', 'eklammtk@intel.com');
insert into employee (id, name, birthday, email) values (22, 'Rutherford', '2021-11-20', 'rfishel@icq.com');
insert into employee (id, name, birthday, email) values (23, 'Melisent', '2021-09-27', 'mclineckm@goo.gl');
insert into employee (id, name, birthday, email) values (24, 'Alvie', '2021-03-24', 'adeeksn@eepurl.com');
insert into employee (id, name, birthday, email) values (25, 'Jakob', '2021-12-02', 'jbraddono@xrea.com');
insert into employee (id, name, birthday, email) values (26, 'Francisca', '2021-07-21', 'ffinlryp@bloomberg.com');
insert into employee (id, name, birthday, email) values (27, 'Justis', '2021-04-17', 'jbiltq@fc2.com');
insert into employee (id, name, birthday, email) values (28, 'Webster', '2021-10-29', 'wmedlerr@guardian.co.uk');
insert into employee (id, name, birthday, email) values (29, 'Dawn', '2022-02-03', 'dflintuffs@seesaa.net');
insert into employee (id, name, birthday, email) values (30, 'Agnese', '2021-09-09', 'asprullt@squidoo.com');
insert into employee (id, name, birthday, email) values (31, 'Gene', '2021-08-29', 'gstaddartu@webeden.co.uk');
insert into employee (id, name, birthday, email) values (32, null, null, 'alarrosav@un.org');
insert into employee (id, name, birthday, email) values (33, 'Kimberlee', '2021-10-19', 'kriddlesw@msn.com');
insert into employee (id, name, birthday, email) values (34, 'Benedetto', '2021-10-24', 'bwylemanx@networksolutions.com');
insert into employee (id, name, birthday, email) values (35, 'Clarie', '2021-03-14', 'cborgy@oakley.com');
insert into employee (id, name, birthday, email) values (36, 'Rory', '2021-09-07', 'rbonassz@marketwatch.com');
insert into employee (id, name, birthday, email) values (37, 'Maribelle', '2021-07-18', 'mlorek10@infoseek.co.jp');
insert into employee (id, name, birthday, email) values (38, 'Glenden', '2022-02-27', 'gatger11@blogspot.com');
insert into employee (id, name, birthday, email) values (39, 'Bibby', null, 'bbossingham12@globo.com');
insert into employee (id, name, birthday, email) values (40, 'Boniface', '2022-01-04', 'bhadden13@vinaora.com');
insert into employee (id, name, birthday, email) values (41, 'Davidson', '2021-03-13', 'dleehane14@google.pl');
insert into employee (id, name, birthday, email) values (42, 'Ermina', '2022-01-17', 'eedginton15@foxnews.com');
insert into employee (id, name, birthday, email) values (43, 'Lula', '2021-12-30', 'ltrill16@mit.edu');
insert into employee (id, name, birthday, email) values (44, 'Zacharie', '2021-09-15', 'zregorz17@webs.com');
insert into employee (id, name, birthday, email) values (45, 'Bentlee', '2021-10-19', 'bkibblewhite18@studiopress.com');
insert into employee (id, name, birthday, email) values (46, 'Piotr', '2021-04-11', 'penga19@ted.com');
insert into employee (id, name, birthday, email) values (47, 'Bernarr', '2021-05-29', 'belleton1a@mac.com');
insert into employee (id, name, birthday, email) values (48, 'Alejoa', '2021-09-05', 'acherry1b@google.co.uk');
insert into employee (id, name, birthday, email) values (49, 'Zelig', '2021-06-18', 'zjosilowski1c@youku.com');
insert into employee (id, name, birthday, email) values (50, 'Cthrine', '2021-04-19', 'cspare1d@irs.gov');

--Sütunların her birine göre diğer sütunları güncelleyecek 5 adet UPDATE işlemi yapalım.
update employee set birthday='2022-04-06' where id=50;
update employee set name='xyz' where id=24;
update employee set email='xyz@gmail.com' where id=20;
update employee set birthday='2000-01-01' where id=1;
update employee set email='clarette@gmail.com' where name='Clarette';

--Sütunların her birine göre ilgili satırı silecek 5 adet DELETE işlemi yapalım.
delete from employee where name='Davidson';
delete from employee where id=5;
delete from employee where email='acherry1b@google.co.uk';
delete from employee where birthday='2022-02-27';
delete from employee where id=40;