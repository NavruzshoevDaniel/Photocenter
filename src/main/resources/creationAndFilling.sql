

begin

CREATE TABLE Clients (
	ID INT PRIMARY KEY,
	Second_name VARCHAR2(50) NOT NULL,
	First_name VARCHAR2(50) NOT NULL,
	Middle_name VARCHAR2(50) NOT NULL,
	Is_Professional INT DEFAULT 0 CHECK (Is_Professional IN (0,1)) NOT NULL,
	Discount INT DEFAULT 0 CHECK (Discount >= 0 AND Discount <= 100) NOT NULL);

 
INSERT INTO Clients VALUES (1, 'Андреев', 'Мирон', 'Давидович', 0, 0);
INSERT INTO Clients VALUES (2, 'Петухов', 'Корней', 'Всеволодович', 1, 0);
INSERT INTO Clients VALUES (3, 'Наумов', 'Никифор', 'Донатович', 1, 0);
INSERT INTO Clients VALUES (4, 'Самсонов', 'Илларион', 'Кимович', 0, 1);
INSERT INTO Clients VALUES (5, 'Никитин', 'Арсений', 'Михайлович', 1, 1);
INSERT INTO Clients VALUES (6, 'Воронцов', 'Нинель', 'Ярославович', 0, 0);
INSERT INTO Clients VALUES (7, 'Мартынов', 'Евдоким', 'Иринеевич', 0, 0);
INSERT INTO Clients VALUES (8, 'Осипов', 'Феликс', 'Богданович', 1, 0);
INSERT INTO Clients VALUES (9, 'Афанасьев', 'Максимилиан', 'Данилович', 1, 0);
INSERT INTO Clients VALUES (10, 'Журавлёв', 'Леонард', 'Агафонович', 0, 1);
 

CREATE TABLE Outlet_types (
	ID INT PRIMARY KEY,
	Name VARCHAR2(200) UNIQUE NOT NULL);

 
INSERT INTO Outlet_types VALUES(1,'Филиал');
INSERT INTO Outlet_types VALUES(2,'Киоск');
INSERT INTO Outlet_types VALUES(3,'Фотомагазин');
 

CREATE TABLE Outlets (
	ID INT PRIMARY KEY,
	Type_ID INT NOT NULL REFERENCES Outlet_types(ID),
	Related_outlet_ID INT REFERENCES Outlets(ID),
	Address VARCHAR2(200) NOT NULL,
	CONSTRAINT Unique_set_outlets UNIQUE (Type_ID, Address));

 
INSERT INTO Outlets VALUES(1,1,NULL,'пр. Красный 54/1');
INSERT INTO Outlets VALUES(2,1,NULL,'ул. Пирогова 66');
INSERT INTO Outlets VALUES(3,1,NULL,'ул. Давыдовская 35');
--пр. Красный 54/1--
INSERT INTO Outlets VALUES(4,2,1,'пр. Красный 128');
INSERT INTO Outlets VALUES(5,3,1,'ул. Фрунзе 226/1');
INSERT INTO Outlets VALUES(6,3,1,'ул. Лубянский проезд 2');
--ул. Пирогова 66--
INSERT INTO Outlets VALUES(7,2,2,'ул. Институтская 59');
INSERT INTO Outlets VALUES(8,2,2,'ул. Арбузова 2');
INSERT INTO Outlets VALUES(9,3,2,'ул. Ильчиа 21');
--ул. Давыдовская 35--
INSERT INTO Outlets VALUES(10,2,3,'туп. Магазинный 3');
INSERT INTO Outlets VALUES(11,3,3,'ул. Савельева 12');
INSERT INTO Outlets VALUES(12,3,3,'ул. Малая Дмитровка 77');
 

CREATE TABLE Professions (
	ID INT PRIMARY KEY,
	Profession VARCHAR2(200) UNIQUE NOT NULL);

INSERT INTO Professions VALUES(1, 'Менеджер');
INSERT INTO Professions VALUES(2, 'Проявитель');
INSERT INTO Professions VALUES(3, 'Охранник');
INSERT INTO Professions VALUES(4, 'Бухгалтер');
INSERT INTO Professions VALUES(5, 'Человек, печатающий фотографии');
INSERT INTO Professions VALUES(6, 'Системный администратор');
INSERT INTO Professions VALUES(7, 'Продавец');
INSERT INTO Professions VALUES(8, 'Фотограф');

CREATE TABLE Jobs (
	ID INT PRIMARY KEY,
	Outlet_ID INT NOT NULL REFERENCES Outlets(ID),
	Profession_ID INT NOT NULL REFERENCES Professions(ID),
	Amount INT DEFAULT 1 CHECK(Amount >= 0) NOT NULL,
	CONSTRAINT Unique_set_jobs UNIQUE (Outlet_ID, Profession_ID));

 

--пр. Красный проспект 54/1(Филиал)--
INSERT INTO Jobs VALUES(1,1,1,2);
INSERT INTO Jobs VALUES(2,1,2,2);
INSERT INTO Jobs VALUES(3,1,3,1);
INSERT INTO Jobs VALUES(4,1,4,2);
INSERT INTO Jobs VALUES(5,1,5,2);
INSERT INTO Jobs VALUES(6,1,6,1);
INSERT INTO Jobs VALUES(31,1,7,1);
--ул. Пирогова 66(Филиал)--
INSERT INTO Jobs VALUES(7,2,1,1);
INSERT INTO Jobs VALUES(8,2,2,1);
INSERT INTO Jobs VALUES(9,2,4,1);
INSERT INTO Jobs VALUES(10,2,5,1);
INSERT INTO Jobs VALUES(32,2,7,1);
--ул. Давыдовская 54(Филиал)--
INSERT INTO Jobs VALUES(11,3,1,4);
INSERT INTO Jobs VALUES(12,3,2,3);
INSERT INTO Jobs VALUES(13,3,3,1);
INSERT INTO Jobs VALUES(14,3,4,2);
INSERT INTO Jobs VALUES(15,3,5,3);
INSERT INTO Jobs VALUES(16,3,6,2);
INSERT INTO Jobs VALUES(33,3,7,1);
--ул. Красный проспект 128(Киоски и фотомагазины)--
INSERT INTO Jobs VALUES(17,4,7,1);--пр. Красный 128
INSERT INTO Jobs VALUES(18,5,7,1);--ул. Фрунзе 226/1
INSERT INTO Jobs VALUES(19,5,8,1);--ул. Фрунзе 226/1
INSERT INTO Jobs VALUES(20,6,7,1);--ул. Лубянский проезд 2
INSERT INTO Jobs VALUES(21,6,8,1);--ул. Лубянский проезд 2
--ул. Пирогова 66(Киоски и фотомагазины)--
INSERT INTO Jobs VALUES(22,7,7,1);--ул. Институтская 59
INSERT INTO Jobs VALUES(23,8,7,1);--ул. Арбузова 2
INSERT INTO Jobs VALUES(24,9,7,1);--ул. Ильчиа 21
INSERT INTO Jobs VALUES(25,9,8,1);--ул. Ильчиа 21
--ул. Давыдовская 54(Киоски и фотомагазины)--
INSERT INTO Jobs VALUES(26,10,7,1);--туп. Магазинный 3
INSERT INTO Jobs VALUES(27,11,7,2);--ул. Савельева 12
INSERT INTO Jobs VALUES(28,11,8,1);--ул. Савельева 12
INSERT INTO Jobs VALUES(29,12,7,3);--ул. Малая Дмитровка 77
INSERT INTO Jobs VALUES(30,12,8,1);--ул. Малая Дмитровка 77
 

CREATE TABLE Firms (
	ID INT PRIMARY KEY,
	Name VARCHAR2(100) UNIQUE NOT NULL);

 
INSERT INTO Firms VALUES (1, 'Lomond');
INSERT INTO Firms VALUES (2, 'Kodak');
INSERT INTO Firms VALUES (3, 'Fomapan');
INSERT INTO Firms VALUES (4, 'Darkroom');
INSERT INTO Firms VALUES (5, 'Canon');
INSERT INTO Firms VALUES (6, 'Fujifilm');
INSERT INTO Firms VALUES (7, 'Sony');
 

CREATE TABLE Items (
	ID INT PRIMARY KEY,
	Firm_ID INT NOT NULL REFERENCES Firms(ID),
	Product_name VARCHAR2(100) NOT NULL,
	Price NUMBER(15, 2) CHECK(Price >= 0),
	CONSTRAINT Unique_set_items UNIQUE (Firm_ID, Product_name));

 
--Расходники для филиалов
INSERT INTO Items VALUES (1, 1, 'Матовая фотобумага', null);
INSERT INTO Items VALUES (2, 1, 'Глянцевая фотобумага', null);
INSERT INTO Items VALUES (3, 1, 'Атластная фотобумага', null);
INSERT INTO Items VALUES (9, 4, 'Проявитель сухой', null);
--Фототовары для киоска
INSERT INTO Items VALUES (4, 2, 'Фотопленка 300/35', 890);
INSERT INTO Items VALUES (5, 2, 'Фотопленка 400/35', 1120);
INSERT INTO Items VALUES (6, 2, 'Фотопленка 200/36', 760);
INSERT INTO Items VALUES (7, 3, 'Фотопленка 400/36', 480);
INSERT INTO Items VALUES (8, 3, 'Фотопленка 200/36', 330);
--Фототовары для магазина
INSERT INTO Items VALUES (10, 5, 'Зеркальная камера 2000d', 32990);
INSERT INTO Items VALUES (11, 5, 'Зеркальная камера 250d', 46990);
INSERT INTO Items VALUES (12, 5, 'Зеркальная камера Mark II', 87990);
INSERT INTO Items VALUES (13, 5, 'Объектив 50mm', 25490);
INSERT INTO Items VALUES (14, 5, 'Объектив 18-200mm', 39990);
INSERT INTO Items VALUES (15, 6, 'Беззеркальная камера X-T30', 74990);
INSERT INTO Items VALUES (16, 6, 'Беззеркальная камера X-T2', 110990);
INSERT INTO Items VALUES (17, 6, 'Беззеркальная камера X-100F', 94490);
INSERT INTO Items VALUES (18, 6, 'Объектив 30mm', 32990);
INSERT INTO Items VALUES (19, 6, 'Объектив 18-55mm', 35990);
INSERT INTO Items VALUES (20, 7, 'Фотоаппарт Alpha A6000', 37990);
INSERT INTO Items VALUES (21, 7, 'Экш-камера FDRX3000', 35990);
 

CREATE TABLE Storage (
	ID INT PRIMARY KEY,
	Outlet_ID INT NOT NULL REFERENCES Outlets(ID),
	Item_ID INT NOT NULL REFERENCES Items(ID),
	Balance INT DEFAULT 0 NOT NULL CHECK(Balance >= 0),
	CONSTRAINT Unique_set_storage UNIQUE (Outlet_ID, Item_ID));

 
INSERT INTO Storage VALUES (1, 1, 1, 772);
INSERT INTO Storage VALUES (2, 1, 2, 174);
INSERT INTO Storage VALUES (3, 1, 3, 725);
INSERT INTO Storage VALUES (4, 1, 9, 457);
INSERT INTO Storage VALUES (5, 2, 1, 13);
INSERT INTO Storage VALUES (6, 2, 2, 975);
INSERT INTO Storage VALUES (7, 2, 3, 271);
INSERT INTO Storage VALUES (8, 2, 9, 542);
INSERT INTO Storage VALUES (9, 3, 1, 134);
INSERT INTO Storage VALUES (10, 3, 2, 838);
INSERT INTO Storage VALUES (11, 3, 3, 992);
INSERT INTO Storage VALUES (12, 3, 9, 15);
INSERT INTO Storage VALUES (13, 5, 10, 0);
INSERT INTO Storage VALUES (14, 5, 11, 7);
INSERT INTO Storage VALUES (15, 5, 12, 0);
INSERT INTO Storage VALUES (16, 5, 13, 1);
INSERT INTO Storage VALUES (17, 5, 14, 5);
INSERT INTO Storage VALUES (18, 5, 15, 9);
INSERT INTO Storage VALUES (19, 5, 16, 8);
INSERT INTO Storage VALUES (20, 5, 17, 9);
INSERT INTO Storage VALUES (21, 5, 18, 6);
INSERT INTO Storage VALUES (22, 5, 19, 9);
INSERT INTO Storage VALUES (23, 5, 20, 0);
INSERT INTO Storage VALUES (24, 5, 21, 2);
INSERT INTO Storage VALUES (25, 6, 10, 5);
INSERT INTO Storage VALUES (26, 6, 11, 5);
INSERT INTO Storage VALUES (27, 6, 12, 5);
INSERT INTO Storage VALUES (28, 6, 13, 4);
INSERT INTO Storage VALUES (29, 6, 14, 5);
INSERT INTO Storage VALUES (30, 6, 15, 5);
INSERT INTO Storage VALUES (31, 6, 16, 9);
INSERT INTO Storage VALUES (32, 6, 17, 8);
INSERT INTO Storage VALUES (33, 6, 18, 4);
INSERT INTO Storage VALUES (34, 6, 19, 6);
INSERT INTO Storage VALUES (35, 6, 20, 9);
INSERT INTO Storage VALUES (36, 6, 21, 4);
INSERT INTO Storage VALUES (37, 9, 10, 8);
INSERT INTO Storage VALUES (38, 9, 11, 7);
INSERT INTO Storage VALUES (39, 9, 12, 1);
INSERT INTO Storage VALUES (40, 9, 13, 1);
INSERT INTO Storage VALUES (41, 9, 14, 6);
INSERT INTO Storage VALUES (42, 9, 15, 3);
INSERT INTO Storage VALUES (43, 9, 16, 0);
INSERT INTO Storage VALUES (44, 9, 17, 9);
INSERT INTO Storage VALUES (45, 9, 18, 7);
INSERT INTO Storage VALUES (46, 9, 19, 5);
INSERT INTO Storage VALUES (47, 9, 20, 5);
INSERT INTO Storage VALUES (48, 9, 21, 6);
INSERT INTO Storage VALUES (49, 11, 10, 1);
INSERT INTO Storage VALUES (50, 11, 11, 9);
INSERT INTO Storage VALUES (51, 11, 12, 3);
INSERT INTO Storage VALUES (52, 11, 13, 5);
INSERT INTO Storage VALUES (53, 11, 14, 4);
INSERT INTO Storage VALUES (54, 11, 15, 7);
INSERT INTO Storage VALUES (55, 11, 16, 5);
INSERT INTO Storage VALUES (56, 11, 17, 0);
INSERT INTO Storage VALUES (57, 11, 18, 6);
INSERT INTO Storage VALUES (58, 11, 19, 9);
INSERT INTO Storage VALUES (59, 11, 20, 5);
INSERT INTO Storage VALUES (60, 11, 21, 6);
INSERT INTO Storage VALUES (61, 12, 10, 3);
INSERT INTO Storage VALUES (62, 12, 11, 8);
INSERT INTO Storage VALUES (63, 12, 12, 4);
INSERT INTO Storage VALUES (64, 12, 13, 8);
INSERT INTO Storage VALUES (65, 12, 14, 0);
INSERT INTO Storage VALUES (66, 12, 15, 3);
INSERT INTO Storage VALUES (67, 12, 16, 2);
INSERT INTO Storage VALUES (68, 12, 17, 1);
INSERT INTO Storage VALUES (69, 12, 18, 2);
INSERT INTO Storage VALUES (70, 12, 19, 9);
INSERT INTO Storage VALUES (71, 12, 20, 8);
INSERT INTO Storage VALUES (72, 12, 21, 8);
INSERT INTO Storage VALUES (73, 4, 4, 0);
INSERT INTO Storage VALUES (74, 4, 5, 3);
INSERT INTO Storage VALUES (75, 4, 6, 4);
INSERT INTO Storage VALUES (76, 4, 7, 5);
INSERT INTO Storage VALUES (77, 4, 8, 9);
INSERT INTO Storage VALUES (78, 7, 4, 2);
INSERT INTO Storage VALUES (79, 7, 5, 1);
INSERT INTO Storage VALUES (80, 7, 6, 5);
INSERT INTO Storage VALUES (81, 7, 7, 3);
INSERT INTO Storage VALUES (82, 7, 8, 1);
INSERT INTO Storage VALUES (83, 8, 4, 5);
INSERT INTO Storage VALUES (84, 8, 5, 8);
INSERT INTO Storage VALUES (85, 8, 6, 1);
INSERT INTO Storage VALUES (86, 8, 7, 1);
INSERT INTO Storage VALUES (87, 8, 8, 5);
INSERT INTO Storage VALUES (88, 10, 4, 4);
INSERT INTO Storage VALUES (89, 10, 5, 2);
INSERT INTO Storage VALUES (90, 10, 6, 9);
INSERT INTO Storage VALUES (91, 10, 7, 6);
INSERT INTO Storage VALUES (92, 10, 8, 1);
 

CREATE TABLE Vendors (
	ID INT PRIMARY KEY,
	Name VARCHAR2(100) UNIQUE NOT NULL);

 
INSERT INTO Vendors VALUES (1, 'ООО «Черный слон»');
INSERT INTO Vendors VALUES (2, 'ООО «Восходящее солнце»');
INSERT INTO Vendors VALUES (3, 'ООО «Яркий»');
INSERT INTO Vendors VALUES (4, 'ООО «Много чернил»');
 

CREATE TABLE Vendor_Items (
	Vendor_ID INT NOT NULL REFERENCES Vendors(ID),
	Item_ID INT NOT NULL REFERENCES Items(ID),
	CONSTRAINT Unique_set_ven_items UNIQUE (Vendor_ID, Item_ID));

 
INSERT INTO Vendor_Items VALUES (4, 1);
INSERT INTO Vendor_Items VALUES (4, 2);
INSERT INTO Vendor_Items VALUES (4, 3);
INSERT INTO Vendor_Items VALUES (3, 4);
INSERT INTO Vendor_Items VALUES (3, 5);
INSERT INTO Vendor_Items VALUES (3, 6);
INSERT INTO Vendor_Items VALUES (3, 7);
INSERT INTO Vendor_Items VALUES (3, 8);
INSERT INTO Vendor_Items VALUES (4, 9);
INSERT INTO Vendor_Items VALUES (2, 10);
INSERT INTO Vendor_Items VALUES (2, 11);
INSERT INTO Vendor_Items VALUES (2, 12);
INSERT INTO Vendor_Items VALUES (2, 13);
INSERT INTO Vendor_Items VALUES (2, 14);
INSERT INTO Vendor_Items VALUES (2, 15);
INSERT INTO Vendor_Items VALUES (2, 16);
INSERT INTO Vendor_Items VALUES (2, 17);
INSERT INTO Vendor_Items VALUES (2, 18);
INSERT INTO Vendor_Items VALUES (2, 19);
INSERT INTO Vendor_Items VALUES (1, 20);
INSERT INTO Vendor_Items VALUES (1, 21);
 

CREATE TABLE Deliveries (
	ID INT PRIMARY KEY,
	Outlet_ID INT NOT NULL REFERENCES Outlets(ID),
	Item_ID INT NOT NULL REFERENCES Items(ID),
	Vendor_ID INT NOT NULL REFERENCES Vendors(ID),
	Amount INT NOT NULL CHECK(Amount > 0),
	Delivery_Date DATE NOT NULL,
	Purchase_price NUMBER(15, 2) CHECK(Purchase_price >= 0));

 
INSERT INTO Deliveries VALUES (1, 4, 4, 3, 95, TO_DATE('20.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (2, 4, 5, 3, 7, TO_DATE('27.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (3, 4, 6, 3, 7, TO_DATE('16.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (4, 4, 7, 3, 70, TO_DATE('4.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (5, 4, 8, 3, 40, TO_DATE('4.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (6, 7, 4, 3, 7, TO_DATE('1.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (7, 7, 5, 3, 63, TO_DATE('3.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (8, 7, 6, 3, 80, TO_DATE('21.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (9, 7, 7, 3, 26, TO_DATE('18.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (10, 7, 8, 3, 41, TO_DATE('18.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (11, 8, 4, 3, 67, TO_DATE('10.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (12, 8, 5, 3, 24, TO_DATE('6.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (13, 8, 6, 3, 54, TO_DATE('27.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (14, 8, 7, 3, 33, TO_DATE('8.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (15, 8, 8, 3, 66, TO_DATE('5.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (16, 10, 4, 3, 43, TO_DATE('18.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (17, 10, 5, 3, 67, TO_DATE('5.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (18, 10, 6, 3, 73, TO_DATE('17.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (19, 10, 7, 3, 9, TO_DATE('9.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (20, 10, 8, 3, 6, TO_DATE('24.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (21, 1, 1, 4, 822, TO_DATE('25.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (22, 1, 2, 4, 191, TO_DATE('14.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (23, 1, 3, 4, 267, TO_DATE('21.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (24, 1, 9, 4, 820, TO_DATE('17.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (25, 2, 1, 4, 235, TO_DATE('17.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (26, 2, 2, 4, 974, TO_DATE('12.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (27, 2, 3, 4, 711, TO_DATE('9.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (28, 2, 9, 4, 502, TO_DATE('5.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (29, 3, 1, 4, 130, TO_DATE('20.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (30, 3, 2, 4, 829, TO_DATE('31.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (31, 3, 3, 4, 881, TO_DATE('26.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (32, 3, 9, 4, 57, TO_DATE('24.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (33, 5, 10, 2, 6, TO_DATE('25.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (34, 5, 11, 2, 4, TO_DATE('4.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (35, 5, 12, 2, 12, TO_DATE('15.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (36, 5, 13, 2, 6, TO_DATE('5.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (37, 5, 14, 2, 1, TO_DATE('15.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (38, 5, 15, 2, 9, TO_DATE('9.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (39, 5, 16, 2, 8, TO_DATE('26.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (40, 5, 17, 2, 4, TO_DATE('2.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (41, 5, 18, 2, 6, TO_DATE('29.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (42, 5, 19, 2, 4, TO_DATE('14.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (43, 6, 10, 2, 7, TO_DATE('17.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (44, 6, 11, 2, 8, TO_DATE('23.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (45, 6, 12, 2, 7, TO_DATE('13.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (46, 6, 13, 2, 7, TO_DATE('17.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (47, 6, 14, 2, 9, TO_DATE('9.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (48, 6, 15, 2, 3, TO_DATE('30.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (49, 6, 16, 2, 1, TO_DATE('2.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (50, 6, 17, 2, 8, TO_DATE('26.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (51, 6, 18, 2, 7, TO_DATE('25.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (52, 6, 19, 2, 3, TO_DATE('20.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (53, 9, 10, 2, 7, TO_DATE('10.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (54, 9, 11, 2, 5, TO_DATE('5.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (55, 9, 12, 2, 8, TO_DATE('14.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (56, 9, 13, 2, 9, TO_DATE('14.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (57, 9, 14, 2, 9, TO_DATE('5.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (58, 9, 15, 2, 7, TO_DATE('31.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (59, 9, 16, 2, 3, TO_DATE('30.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (60, 9, 17, 2, 7, TO_DATE('12.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (61, 9, 18, 2, 2, TO_DATE('29.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (62, 9, 19, 2, 1, TO_DATE('13.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (63, 11, 10, 2, 2, TO_DATE('19.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (64, 11, 11, 2, 8, TO_DATE('24.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (65, 11, 12, 2, 2, TO_DATE('25.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (66, 11, 13, 2, 9, TO_DATE('21.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (67, 11, 14, 2, 3, TO_DATE('2.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (68, 11, 15, 2, 7, TO_DATE('11.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (69, 11, 16, 2, 5, TO_DATE('27.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (70, 11, 17, 2, 1, TO_DATE('23.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (71, 11, 18, 2, 3, TO_DATE('20.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (72, 11, 19, 2, 6, TO_DATE('21.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (73, 12, 10, 2, 4, TO_DATE('24.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (74, 12, 11, 2, 3, TO_DATE('23.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (75, 12, 12, 2, 5, TO_DATE('21.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (76, 12, 13, 2, 9, TO_DATE('20.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (77, 12, 14, 2, 4, TO_DATE('20.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (78, 12, 15, 2, 4, TO_DATE('13.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (79, 12, 16, 2, 7, TO_DATE('31.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (80, 12, 17, 2, 7, TO_DATE('10.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (81, 12, 18, 2, 6, TO_DATE('18.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (82, 12, 19, 2, 9, TO_DATE('6.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (83, 5, 20, 1, 1, TO_DATE('10.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (84, 5, 21, 1, 9, TO_DATE('22.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (85, 6, 20, 1, 4, TO_DATE('31.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (86, 6, 21, 1, 8, TO_DATE('3.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (87, 9, 20, 1, 8, TO_DATE('15.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (88, 9, 21, 1, 6, TO_DATE('27.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (89, 11, 20, 1, 3, TO_DATE('20.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (90, 11, 21, 1, 8, TO_DATE('13.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (91, 12, 20, 1, 4, TO_DATE('6.01.2021', 'dd.mm.yyyy'), null);
INSERT INTO Deliveries VALUES (92, 12, 21, 1, 5, TO_DATE('8.01.2021', 'dd.mm.yyyy'), null);
 


CREATE TABLE Receipts (
	ID INT PRIMARY KEY ,
	Client_ID INT NOT NULL REFERENCES Clients(ID),
	Outlet_ID INT NOT NULL REFERENCES Outlets(ID),
	Current_date DATE NOT NULL,
	Total NUMBER(15, 2) DEFAULT 0 CHECK(Total >= 0));

 
--Чек из филиала
INSERT INTO Receipts VALUES(1,1,1,TO_DATE('20.01.2021', 'dd.mm.yyyy'),0);
INSERT INTO Receipts VALUES(2,2,3,TO_DATE('19.01.2021', 'dd.mm.yyyy'),0);
INSERT INTO Receipts VALUES(10,10,2,TO_DATE('29.01.2021', 'dd.mm.yyyy'),0);
--Чек из киоска
INSERT INTO Receipts VALUES(3,3,4,TO_DATE('10.01.2021', 'dd.mm.yyyy'),0);
INSERT INTO Receipts VALUES(6,5,7,TO_DATE('30.01.2021', 'dd.mm.yyyy'),0);
INSERT INTO Receipts VALUES(7,7,8,TO_DATE('14.02.2021', 'dd.mm.yyyy'),0);
INSERT INTO Receipts VALUES(9,9,10,TO_DATE('10.01.2021', 'dd.mm.yyyy'),0);
--Чек из магазина
INSERT INTO Receipts VALUES(4,4,6,TO_DATE('01.02.2021', 'dd.mm.yyyy'),0);
INSERT INTO Receipts VALUES(5,6,5,TO_DATE('04.02.2021', 'dd.mm.yyyy'),0);
INSERT INTO Receipts VALUES(8,8,9,TO_DATE('23.01.2021', 'dd.mm.yyyy'),0);
 

CREATE TABLE Orders (
	ID INT PRIMARY KEY,
	Receipt_ID INT NOT NULL REFERENCES Receipts(ID),
	Is_urgent INT DEFAULT 0 CHECK (Is_urgent IN (0,1)) NOT NULL );

 
--Заказы в филиале
INSERT INTO Orders VALUES(1,1,0);
INSERT INTO Orders VALUES(2,1,0);
INSERT INTO Orders VALUES(3,1,1);
INSERT INTO Orders VALUES(10,2,0);
INSERT INTO Orders VALUES(5,2,1);
--Заказы в киоске
INSERT INTO Orders VALUES(4,3,1);
INSERT INTO Orders VALUES(15,9,0);
INSERT INTO Orders VALUES(9,9,0);
INSERT INTO Orders VALUES(13,7,0);
--Зазазы в магазине
INSERT INTO Orders VALUES(6,4,0);
INSERT INTO Orders VALUES(7,4,1);
INSERT INTO Orders VALUES(8,5,0);
INSERT INTO Orders VALUES(11,8,1);
INSERT INTO Orders VALUES(12,8,0);
INSERT INTO Orders VALUES(14,8,0);
 

CREATE TABLE Service_types (
	ID INT PRIMARY KEY,
	Name VARCHAR2(100) UNIQUE NOT NULL,
	Price NUMBER(15, 2) NOT NULL CHECK(Price >= 0));

 
INSERT INTO Service_types VALUES (1, 'Фотография на документы', 800);	
INSERT INTO Service_types VALUES (2, 'Художественная съемка', 3400);	
INSERT INTO Service_types VALUES (3, 'Прокат фотоаппарта', 1200);	
INSERT INTO Service_types VALUES (4, 'Оцифровка видео', 300);	
INSERT INTO Service_types VALUES (5, 'Реставрация фотография', 250);
 

CREATE TABLE Service_orders (
	Order_ID INT PRIMARY KEY REFERENCES Orders(ID),
	Service_type_ID INT NOT NULL REFERENCES Service_types(ID));

 
INSERT INTO Service_orders VALUES(6,4);
INSERT INTO Service_orders VALUES(8,1);
INSERT INTO Service_orders VALUES(12,5);
INSERT INTO Service_orders VALUES(11,2);
 

CREATE TABLE Paper_sizes (
	ID INT PRIMARY KEY,
	Name VARCHAR2(30) UNIQUE NOT NULL);

 
INSERT INTO Paper_sizes VALUES(1,'A0');
INSERT INTO Paper_sizes VALUES(2,'A1');
INSERT INTO Paper_sizes VALUES(3,'A2');
INSERT INTO Paper_sizes VALUES(4,'A3');
INSERT INTO Paper_sizes VALUES(5,'A4');
INSERT INTO Paper_sizes VALUES(6,'A5');
INSERT INTO Paper_sizes VALUES(7,'A6');
INSERT INTO Paper_sizes VALUES(8,'A7');
INSERT INTO Paper_sizes VALUES(9,'A8');
 

CREATE TABLE Paper_types (
	ID INT PRIMARY KEY,
	Name VARCHAR2(30) UNIQUE NOT NULL);

 
INSERT INTO Paper_types VALUES(1,'Матовая');
INSERT INTO Paper_types VALUES(2,'Глянцевая');
INSERT INTO Paper_types VALUES(3,'Атластная');
 

CREATE TABLE Print_prices (
	ID INT PRIMARY KEY,
	Paper_size_ID INT NOT NULL REFERENCES Paper_sizes(ID),
	Paper_type_ID INT NOT NULL REFERENCES Paper_types(ID),
	Price NUMBER(15, 2) NOT NULL CHECK(Price >= 0),
	CONSTRAINT Unique_set_print_prices UNIQUE (Paper_size_ID, Paper_type_ID));

 
INSERT INTO Print_prices VALUES(1,1, 1, 240);
INSERT INTO Print_prices VALUES(2,2, 1, 230);
INSERT INTO Print_prices VALUES(3,3, 1, 220);
INSERT INTO Print_prices VALUES(4,4, 1, 210);
INSERT INTO Print_prices VALUES(5,5, 1, 200);
INSERT INTO Print_prices VALUES(6,6, 1, 190);
INSERT INTO Print_prices VALUES(7,7, 1, 180);
INSERT INTO Print_prices VALUES(8,8, 1, 170);
INSERT INTO Print_prices VALUES(9,1, 2, 280);
INSERT INTO Print_prices VALUES(10,2, 2, 270);
INSERT INTO Print_prices VALUES(11,3, 2, 260);
INSERT INTO Print_prices VALUES(12,4, 2, 250);
INSERT INTO Print_prices VALUES(13,5, 2, 240);
INSERT INTO Print_prices VALUES(14,6, 2, 230);
INSERT INTO Print_prices VALUES(15,7, 2, 220);
INSERT INTO Print_prices VALUES(16,8, 2, 210);
INSERT INTO Print_prices VALUES(17,1, 3, 320);
INSERT INTO Print_prices VALUES(18,2, 3, 310);
INSERT INTO Print_prices VALUES(19,3, 3, 300);
INSERT INTO Print_prices VALUES(20,4, 3, 290);
INSERT INTO Print_prices VALUES(21,5, 3, 280);
INSERT INTO Print_prices VALUES(22,6, 3, 270);
INSERT INTO Print_prices VALUES(23,7, 3, 260);
INSERT INTO Print_prices VALUES(24,8, 3, 250);
 

CREATE TABLE Print_discounts (
	ID INT PRIMARY KEY,
	Photo_amount INT UNIQUE NOT NULL CHECK(Photo_amount > 0),
	Discount INT NOT NULL CHECK(Discount >= 0 AND Discount <= 100));

 
INSERT INTO Print_discounts VALUES(1,50,5);
INSERT INTO Print_discounts VALUES(2,100,10);
INSERT INTO Print_discounts VALUES(3,250,15);
 

CREATE TABLE Print_orders (
	Order_ID INT PRIMARY KEY REFERENCES Orders(ID),
	Discount INT DEFAULT 0 NOT NULL CHECK(Discount >= 0 AND Discount <= 100));

 
INSERT INTO Print_orders VALUES(1,0);
INSERT INTO Print_orders VALUES(4,0);
INSERT INTO Print_orders VALUES(5,0);
 

CREATE TABLE Frames (
	ID INT PRIMARY KEY,
	Print_order_ID INT NOT NULL REFERENCES Print_orders(Order_ID),
	Paper_size_ID INT NOT NULL REFERENCES Paper_sizes(ID),
	Paper_type_ID INT NOT NULL REFERENCES Paper_types(ID),
	Frame_code VARCHAR2(80) NOT NULL,
	Amount INT DEFAULT 1 NOT NULL CHECK(Amount > 0),
	CONSTRAINT Unique_set_frames UNIQUE (Frame_code, Paper_size_ID, Paper_type_ID, Print_order_ID));

 
INSERT INTO Frames VALUES(1, 1, 1, 2, 'IMG_7312.jpg', 2);
INSERT INTO Frames VALUES(2, 1, 2, 3, 'IMG_7313.jpg', 1);
INSERT INTO Frames VALUES(3, 1, 6, 3, 'IMG_7314.jpg', 2);
INSERT INTO Frames VALUES(4, 1, 5, 1, 'IMG_7315.jpg', 2);
INSERT INTO Frames VALUES(5, 1, 6, 3, 'IMG_7316.jpg', 1);
INSERT INTO Frames VALUES(6, 1, 3, 3, 'IMG_7317.jpg', 1);
INSERT INTO Frames VALUES(7, 1, 5, 1, 'IMG_7318.jpg', 2);
INSERT INTO Frames VALUES(8, 1, 5, 1, 'IMG_7319.jpg', 2);
INSERT INTO Frames VALUES(9, 1, 8, 2, 'IMG_7320.jpg', 1);
INSERT INTO Frames VALUES(10, 1, 2, 3, 'IMG_7321.jpg', 2);
INSERT INTO Frames VALUES(11, 1, 6, 1, 'IMG_7322.jpg', 1);
INSERT INTO Frames VALUES(12, 1, 2, 1, 'IMG_7323.jpg', 1);
INSERT INTO Frames VALUES(13, 1, 1, 2, 'IMG_7324.jpg', 2);
INSERT INTO Frames VALUES(14, 1, 2, 1, 'IMG_7325.jpg', 1);
INSERT INTO Frames VALUES(15, 1, 8, 3, 'IMG_7326.jpg', 1);
INSERT INTO Frames VALUES(16, 1, 3, 2, 'IMG_7327.jpg', 2);
INSERT INTO Frames VALUES(17, 1, 4, 1, 'IMG_7328.jpg', 2);
INSERT INTO Frames VALUES(18, 1, 2, 1, 'IMG_7329.jpg', 1);
INSERT INTO Frames VALUES(19, 1, 1, 1, 'IMG_7330.jpg', 1);
INSERT INTO Frames VALUES(20, 1, 1, 1, 'IMG_7331.jpg', 1);
INSERT INTO Frames VALUES(21, 1, 8, 2, 'IMG_7332.jpg', 1);
INSERT INTO Frames VALUES(22, 1, 8, 1, 'IMG_7333.jpg', 1);
INSERT INTO Frames VALUES(23, 1, 8, 1, 'IMG_7334.jpg', 2);
INSERT INTO Frames VALUES(24, 1, 4, 1, 'IMG_7335.jpg', 1);
INSERT INTO Frames VALUES(25, 1, 1, 1, 'IMG_7336.jpg', 2);
INSERT INTO Frames VALUES(26, 1, 7, 3, 'IMG_7337.jpg', 1);
INSERT INTO Frames VALUES(27, 1, 3, 1, 'IMG_7338.jpg', 2);
INSERT INTO Frames VALUES(28, 1, 8, 1, 'IMG_7339.jpg', 1);
INSERT INTO Frames VALUES(29, 1, 8, 1, 'IMG_7340.jpg', 1);
INSERT INTO Frames VALUES(30, 1, 7, 1, 'IMG_7341.jpg', 1);
INSERT INTO Frames VALUES(31, 1, 3, 3, 'IMG_7342.jpg', 2);
INSERT INTO Frames VALUES(32, 1, 3, 3, 'IMG_7343.jpg', 1);
INSERT INTO Frames VALUES(33, 4, 9, 3, 'Sochi2020#1.jpg', 1);
INSERT INTO Frames VALUES(34, 4, 2, 1, 'Sochi2020#2.jpg', 1);
INSERT INTO Frames VALUES(35, 4, 9, 2, 'Sochi2020#3.jpg', 1);
INSERT INTO Frames VALUES(36, 4, 1, 3, 'Sochi2020#4.jpg', 1);
INSERT INTO Frames VALUES(37, 4, 2, 3, 'Sochi2020#5.jpg', 1);
INSERT INTO Frames VALUES(38, 4, 4, 1, 'Sochi2020#6.jpg', 1);
INSERT INTO Frames VALUES(39, 4, 4, 2, 'Sochi2020#7.jpg', 1);
INSERT INTO Frames VALUES(40, 4, 7, 1, 'Sochi2020#8.jpg', 1);
INSERT INTO Frames VALUES(41, 4, 6, 1, 'Sochi2020#9.jpg', 1);
INSERT INTO Frames VALUES(42, 4, 1, 3, 'Sochi2020#10.jpg', 1);
INSERT INTO Frames VALUES(43, 4, 7, 2, 'Sochi2020#11.jpg', 1);
INSERT INTO Frames VALUES(44, 4, 9, 3, 'Sochi2020#12.jpg', 1);
INSERT INTO Frames VALUES(45, 4, 1, 3, 'Sochi2020#13.jpg', 1);
INSERT INTO Frames VALUES(46, 4, 7, 2, 'Sochi2020#14.jpg', 1);
INSERT INTO Frames VALUES(47, 4, 6, 1, 'Sochi2020#15.jpg', 1);
INSERT INTO Frames VALUES(48, 4, 3, 3, 'Sochi2020#16.jpg', 1);
INSERT INTO Frames VALUES(49, 4, 8, 2, 'Sochi2020#17.jpg', 1);
INSERT INTO Frames VALUES(50, 4, 6, 1, 'Sochi2020#18.jpg', 1);
INSERT INTO Frames VALUES(51, 4, 8, 1, 'Sochi2020#19.jpg', 1);
INSERT INTO Frames VALUES(52, 4, 8, 3, 'Sochi2020#20.jpg', 1);
INSERT INTO Frames VALUES(53, 4, 3, 2, 'Sochi2020#21.jpg', 1);
INSERT INTO Frames VALUES(54, 4, 6, 1, 'Sochi2020#22.jpg', 1);
INSERT INTO Frames VALUES(55, 4, 4, 2, 'Sochi2020#23.jpg', 1);
INSERT INTO Frames VALUES(56, 4, 1, 1, 'Sochi2020#24.jpg', 1);
INSERT INTO Frames VALUES(57, 4, 8, 1, 'Sochi2020#25.jpg', 1);
INSERT INTO Frames VALUES(58, 4, 1, 3, 'Sochi2020#26.jpg', 1);
INSERT INTO Frames VALUES(59, 4, 8, 1, 'Sochi2020#27.jpg', 1);
INSERT INTO Frames VALUES(60, 4, 7, 1, 'Sochi2020#28.jpg', 1);
INSERT INTO Frames VALUES(61, 4, 2, 2, 'Sochi2020#29.jpg', 1);
INSERT INTO Frames VALUES(62, 4, 6, 1, 'Sochi2020#30.jpg', 1);
INSERT INTO Frames VALUES(63, 4, 8, 3, 'Sochi2020#31.jpg', 1);
INSERT INTO Frames VALUES(64, 4, 5, 3, 'Sochi2020#32.jpg', 1);
INSERT INTO Frames VALUES(65, 4, 7, 2, 'Sochi2020#33.jpg', 1);
INSERT INTO Frames VALUES(66, 4, 2, 2, 'Sochi2020#34.jpg', 1);
INSERT INTO Frames VALUES(67, 4, 9, 1, 'Sochi2020#35.jpg', 1);
INSERT INTO Frames VALUES(68, 4, 2, 1, 'Sochi2020#36.jpg', 1);
INSERT INTO Frames VALUES(69, 4, 4, 2, 'Sochi2020#37.jpg', 1);
INSERT INTO Frames VALUES(70, 4, 1, 2, 'Sochi2020#38.jpg', 1);
INSERT INTO Frames VALUES(71, 4, 6, 2, 'Sochi2020#39.jpg', 1);
INSERT INTO Frames VALUES(72, 4, 5, 1, 'Sochi2020#40.jpg', 1);
INSERT INTO Frames VALUES(73, 4, 7, 2, 'Sochi2020#41.jpg', 1);
INSERT INTO Frames VALUES(74, 4, 1, 1, 'Sochi2020#42.jpg', 1);
INSERT INTO Frames VALUES(75, 4, 9, 1, 'Sochi2020#43.jpg', 1);
INSERT INTO Frames VALUES(76, 4, 5, 1, 'Sochi2020#44.jpg', 1);
INSERT INTO Frames VALUES(77, 4, 1, 1, 'Sochi2020#45.jpg', 1);
INSERT INTO Frames VALUES(78, 4, 9, 2, 'Sochi2020#46.jpg', 1);
INSERT INTO Frames VALUES(79, 4, 5, 1, 'Sochi2020#47.jpg', 1);
INSERT INTO Frames VALUES(80, 4, 5, 3, 'Sochi2020#48.jpg', 1);
INSERT INTO Frames VALUES(81, 4, 4, 2, 'Sochi2020#49.jpg', 1);
INSERT INTO Frames VALUES(82, 4, 1, 2, 'Sochi2020#50.jpg', 1);
INSERT INTO Frames VALUES(83, 4, 7, 3, 'Sochi2020#51.jpg', 1);
INSERT INTO Frames VALUES(84, 4, 6, 2, 'Sochi2020#52.jpg', 1);
INSERT INTO Frames VALUES(85, 4, 5, 1, 'Sochi2020#53.jpg', 1);
INSERT INTO Frames VALUES(86, 4, 3, 1, 'Sochi2020#54.jpg', 1);
INSERT INTO Frames VALUES(87, 4, 5, 2, 'Sochi2020#55.jpg', 1);
INSERT INTO Frames VALUES(88,5,6,2,'BurgerKing-flyer.png',230);
 

CREATE TABLE Developer_prices (
	ID INT PRIMARY KEY,
	Price_name VARCHAR2(200) UNIQUE NOT NULL,
	Price NUMBER(15, 2) NOT NULL CHECK(Price > 0));

INSERT INTO Developer_prices VALUES(1, 'Стандартная проявка', 500);

CREATE TABLE Developer_orders (
	Order_ID INT PRIMARY KEY REFERENCES Orders(ID),
	Film_receipt_ID INT REFERENCES Receipts(ID));

 
INSERT INTO Developer_orders VALUES(2, null);
INSERT INTO Developer_orders VALUES(3, null);
INSERT INTO Developer_orders VALUES(10, null);
INSERT INTO Developer_orders VALUES(15, null);
 

CREATE TABLE Sale_orders (
	Order_ID INT PRIMARY KEY REFERENCES Orders(ID),
	Product_ID INT NOT NULL REFERENCES Items(ID),
	Amount INT DEFAULT 1 NOT NULL CHECK(Amount > 0));

 
INSERT INTO Sale_orders VALUES(7, 14, 1);
INSERT INTO Sale_orders VALUES(9, 5, 2);
INSERT INTO Sale_orders VALUES(14, 20, 1);
INSERT INTO Sale_orders VALUES(13, 7, 10);
 
end;