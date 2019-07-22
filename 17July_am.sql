create table books (
	bookId int,
    bookTitle varchar(255),
    bookprice decimal(5,2),
    author varchar(255)
);

alter table books add constraint PRIMARY KEY(bookId);