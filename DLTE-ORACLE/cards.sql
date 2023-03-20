-- Create a table named credit_card
create table credit_card(card_number int not null, card_holder varchar(255) not null, card_pin int not null, card_expiry date not null,limit int not null);
--Add a primary key constraint to the table.The primary key is card_number
alter table credit_card add constraint card_number_seq PRIMARY KEY (card_number);

describe credit_card;

create sequence credit_card_seq start with 9876543201 increment by 1;
-- insert the 10 values to the table
insert into credit_card values(credit_card_seq.NEXTVAL,'Manvith',2345,'02-09-2024',50000);
insert into credit_card values(credit_card_seq.NEXTVAL,'Kira',7612,'09-18-2023',76000);
insert into credit_card values(credit_card_seq.NEXTVAL,'Ackerman',9812,'09-19-2025',80000);
insert into credit_card values(credit_card_seq.NEXTVAL,'Zeke',6701,'02-12-2026',30000);
insert into credit_card values(credit_card_seq.NEXTVAL,'Conan',8206,'18-11-2028',60000);
insert into credit_card values(credit_card_seq.NEXTVAL,'Raj',9207,'01-05-2028',20000);
insert into credit_card values(credit_card_seq.NEXTVAL,'Sheldon',7540,'07-05-2023',66000);
insert into credit_card values(credit_card_seq.NEXTVAL,'Stuart',8300,'04-11-2025',91000);
insert into credit_card values(credit_card_seq.NEXTVAL,'Leonard',9210,'11-22-2028',81000);
insert into credit_card values(credit_card_seq.NEXTVAL,'Walter',9274,'07-18-2026',51000);

--to display the table with inputs
select * from credit_card;

--update the table with respective conditions
update credit_card set card_expiry='07-23-2026' where card_holder='Ackerman';
update credit_card set card_expiry='12-22-2025' where card_holder='Stuart';
update credit_card set card_expiry='06-26-2024' where card_number='9876543209';

-- create a view for the main table
create view sub as select card_number,card_holder from credit_card where limit>=60000;
create view major as select card_holder,card_expiry from credit_card where card_number>=9876543204 and limit<60000;
select * from major;

--perform aggregate operation on the table
select cast(collect(card_holder) as info)"MYINFO" from credit_card;