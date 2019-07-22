/*Q1*/
SELECT 
    first_name, hire_date
FROM
    employees
WHERE
    YEAR(hire_date) BETWEEN 2002 AND 2005;

/*Q2*/
SELECT 
    d.*
FROM
    employees e
        INNER JOIN
    departments d ON e.department_id = d.department_id
WHERE
    e.salary > 10000
GROUP BY d.department_id;

/*Q3*/
SELECT 
    l.city,
    d.department_name,
    SUM(e.employee_id) AS NumberOfEmployee
FROM
    locations l
        INNER JOIN
    departments d ON l.location_id = d.location_id
        INNER JOIN
    employees e ON e.department_id = d.department_id
GROUP BY d.department_id;

/*Q4*/
SELECT 
    d.*
FROM
    employees e
        INNER JOIN
    departments d ON e.department_id = d.department_id
GROUP BY d.department_id
HAVING COUNT(e.employee_id) > 5;

/*Q5*/ 
CREATE TABLE color (
    color_id INT PRIMARY KEY,
    color_name VARCHAR(255)
);

CREATE TABLE sizes (
    size_code VARCHAR(2) PRIMARY key,
    descriptions VARCHAR(255)
);

insert into color values (1, 'Red');
insert into color values (2, 'Green');
insert into color values (3, 'Blue');
insert into color values (4, 'Purple');

insert into sizes values ('XS', 'EXTRA SMALL');
insert into sizes values ('S', 'SMALL');
insert into sizes values ('M', 'MEDIUM');
insert into sizes values ('L', 'LARGE');
insert into sizes values ('XL', 'EXTRA LARGE');
insert into sizes values ('XXL', 'EXTRA EXTRA LARGE');

SELECT 
    s.size_code, c.color_name
FROM
    sizes s
        CROSS JOIN
    color c;

/*Q6*/
CREATE TABLE Cricket_Match (
    Match_Number INT,
    Player CHAR(255),
    Score INT,
    PRIMARY KEY (Match_Number , Player)
);

insert into Cricket_Match values(1,"A",0);
insert into Cricket_Match values(1,"B",101);
insert into Cricket_Match values(1,"C",55);
insert into Cricket_Match values(1,"D",23);
insert into Cricket_Match values(1,"E",12);
insert into Cricket_Match values(1,"F",100);
insert into Cricket_Match values(2,"A",146);
insert into Cricket_Match values(2,"B",120);
insert into Cricket_Match values(2,"C",104);
insert into Cricket_Match values(2,"D",3);
insert into Cricket_Match values(2,"E",54);
insert into Cricket_Match values(2,"F",111);

SELECT DISTINCT
    (M1.Player)
FROM
    Cricket_Match M1
        INNER JOIN
    Cricket_Match M2 ON M1.PLAYER = M2.PLAYER
WHERE
    M1.SCORE > 100 AND M2.SCORE > 100;
    
SELECT DISTINCT
    (M1.Player)
FROM
    Cricket_Match M1
        INNER JOIN
    Cricket_Match M2 ON M1.PLAYER = M2.PLAYER
WHERE
    M1.SCORE < 100 AND M2.SCORE > 100 OR M1.SCORE > 100 AND M2.SCORE <100;
    
    
/*Q7*/
CREATE TABLE friend_list (
    P_name CHAR(255),
    Friend_Name CHAR(255),
    PRIMARY KEY (P_name , Friend_Name)
);

insert into friend_list values("Sam","Ram");
insert into friend_list values("Sam","Vamsi");
insert into friend_list values("Vamsi","Ram");
insert into friend_list values("Vamsi","Jhon");
insert into friend_list values("Ram","Vijay");
insert into friend_list values("Ram","Anand");	

-- SELECT 
--     FRIEND_NAME
-- FROM
--     FRIEND_LIST
-- WHERE
--     P_NAME IN (SELECT 
--             FRIEND_NAME
--         FROM
--             FRIEND_LIST
--         WHERE
--             P_NAME = 'SAM');
            
SELECT 
    F1.P_NAME, F2.FRIEND_NAME AS FRIEND_OF_FRIEND_OF_SAM
FROM
    FRIEND_LIST F1
        INNER JOIN
    FRIEND_LIST F2 ON F1.FRIEND_NAME = F2.P_NAME
WHERE
    F1.P_NAME = 'SAM';

/*Q8*/
DELIMITER //
CREATE FUNCTION UDF_CALC_NEW_SALARY(EMP_ID INT, HIKE_PCT INT) RETURNS INT DETERMINISTIC
BEGIN
DECLARE CURR_SAL INT;
SELECT 
    SALARY
FROM
    EMPLOYEES
WHERE
    employee_id = EMP_ID INTO CURR_SAL;
RETURN CURR_SAL + (CURR_SAL * HIKE_PCT /100);
END;
//

SELECT 
    EMPLOYEE_ID,
    SALARY AS OLD_SAL,
    UDF_CALC_NEW_SALARY(EMPLOYEE_ID, 13) AS NEW_SAL
FROM
    EMPLOYEES;

/*Q9*/
DELIMITER //
CREATE PROCEDURE UPDATE_EMPLOYEE_SAL(IN EMP_ID INT)
BEGIN 
	UPDATE 
		EMPLOYEES 
	SET 
		SALARY = UDF_CALC_NEW_SALARY(EMP_ID , 13) 
	WHERE 
		EMPLOYEE_ID = EMP_ID;
END
//

CALL UPDATE_EMPLOYEE_SAL(101);

SELECT * FROM EMPLOYEES;
