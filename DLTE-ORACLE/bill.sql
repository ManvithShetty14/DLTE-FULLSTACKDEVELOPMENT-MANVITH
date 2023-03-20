create table bill(bill_id int not null,card int not null, bill_amount int not null,due_date date not null,min_bill int not null);

alter table bill add CONSTRAINT bill_id_seq PRIMARY KEY(bill_id);

create SEQUENCE bill_id_seq start with 7654321 increment by 1;

alter table bill add FOREIGN KEY(CARD) REFERENCES credit_card(card_number);

insert into bill values(bill_id_seq.NEXTVAL,9876543204,3000,'07-23-2023',1500);
insert into bill values(bill_id_seq.NEXTVAL,9876543207,2000,'02-19-2024',500);
insert into bill values(bill_id_seq.NEXTVAL,9876543203,5000,'10-29-2023',3300);
insert into bill values(bill_id_seq.NEXTVAL,9876543205,9000,'11-04-2023',5300);
insert into bill values(bill_id_seq.NEXTVAL,9876543202,1300,'04-14-2023',500);
insert into bill values(bill_id_seq.NEXTVAL,9876543209,6900,'08-01-2023',1740);
insert into bill values(bill_id_seq.NEXTVAL,9876543211,7000,'12-12-2023',5000);
insert into bill values(bill_id_seq.NEXTVAL,9876543204,3200,'09-22-2023',1000);
insert into bill values(bill_id_seq.NEXTVAL,9876543207,5000,'03-30-2023',3100);
insert into bill values(bill_id_seq.NEXTVAL,9876543204,9000,'04-22-2023',7240);
select * from bill;


update bill set bill_amount=2810 , min_bill=1800 where bill_id=7654325;
select * from bill;

select card_holder, card_number, bill_amount , due_date from(credit_card inner join bill on card_number=card);
select card_holder, card_number, bill_amount , due_date from(credit_card left outer join bill on card_number=card);
