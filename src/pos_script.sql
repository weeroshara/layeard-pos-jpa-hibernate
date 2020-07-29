drop database POS_System;
CREATE DATABASE POS_System;
USE POS_System;

CREATE TABLE Customer(
                         customerId VARCHAR(6) NOT NULL,
                         customerName VARCHAR(30) NOT NULL,
                         customerAddress VARCHAR(30),
                         CONSTRAINT PRIMARY KEY (customerId)
);


CREATE TABLE Item(
                     itemCode VARCHAR(6) NOT NULL,
                     description VARCHAR(50) NOT NULL,
                     unitPrice DECIMAL(6,2) NOT NULL,
                     qtyOnHand INT(5) NOT NULL,
                     CONSTRAINT PRIMARY KEY (itemCode)
);
Drop table Orders;
CREATE TABLE Orders(
                       orderID VARCHAR(6) NOT NULL,
                       orderDate DATE,
                       customerId VARCHAR(6) NOT NULL,
                       CONSTRAINT PRIMARY KEY (orderID),
                       CONSTRAINT FOREIGN KEY(customerId) REFERENCES Customer(customerId)
                           ON UPDATE CASCADE ON DELETE CASCADE
);

Drop table OrderDetail;
CREATE TABLE OrderDetail(
                            orderId VARCHAR(6) NOT NULL,
                            itemCode VARCHAR(6) NOT NULL,
                            orderQty INT(11) NOT NULL,
                            unitPrice DECIMAL(6,2) NOT NULL,
                            CONSTRAINT PRIMARY KEY (orderId,itemCode),
                            CONSTRAINT FOREIGN KEY (orderId) REFERENCES Orders(orderId)
                                ON UPDATE CASCADE ON DELETE CASCADE,
                            CONSTRAINT FOREIGN KEY (itemCode) REFERENCES Item(itemCode)
                                ON UPDATE CASCADE ON DELETE CASCADE
);


INSERT INTO Customer VALUES('C001','Danapala','No.20, Walana Panadura');
INSERT INTO Customer VALUES('C002','Gunapala','No.200, Thalpitiya Wadduwa');
INSERT INTO Customer VALUES('C003','Amarapala','No.100, Horawala Matugama');
INSERT INTO Customer VALUES('C004','Somapala','No.10, Ginigama Galle');
INSERT INTO Customer VALUES('C005','Jinapala','N0.34 Ginthota Aluthgama');
INSERT INTO Customer VALUES('C006','Gnanawathee','No.230, Galle Road Panadura');
INSERT INTO Customer VALUES('C007','Amarawathee','No.6, Galle Road Ambalangoda');
INSERT INTO Customer VALUES('C008','Leelawathee','No.12, Rathnapura Road Madampe');
INSERT INTO Customer VALUES('C009','Gunawathee','No.122, Kurunegala');
INSERT INTO Customer VALUES('C010','Dayapala','No.234, Dehiwala');
INSERT INTO Customer VALUES('C011','Sangapala','No.43, St Peters Road Negambo');
INSERT INTO Customer VALUES('C012','Ariyawathee','No.123, Maharagama');
INSERT INTO Customer VALUES('C013','Somawathee','No.345, Kalutara');
INSERT INTO Customer VALUES('C014','Somapala','No.8, Ragala Road Walapane');
INSERT INTO Customer VALUES('C015','Ariyapala','No.56, Trincomalee');
INSERT INTO Customer VALUES('C016','Siriyalatha','No.4, Nugegoda');
INSERT INTO Customer VALUES('C017','Premalatha','No.45, Trincomalee');
INSERT INTO Customer VALUES('C018','Chandralatha','No.100, Colombo');
INSERT INTO Customer VALUES('C019','Karunawathee','No.5, Baddegama Road Galle');
INSERT INTO Customer VALUES('C020','Arunachalam','No.56, Diggala Road Keselwatta');
INSERT INTO Customer VALUES('C021','Jinadasa','No.7, Kandy Road Jaffna');
INSERT INTO Customer VALUES('C022','Amaradasa','No.3, Katugastota Road Kandy');
INSERT INTO Customer VALUES('C023','Somadasa','No.2, Aranayaka Road Mawenella');
INSERT INTO Customer VALUES('C024','Gunalatha','No.9, Yatinuwara Sreet Kandy');
INSERT INTO Customer VALUES('C025','Premalatha','No.345, Anuradhapura');
INSERT INTO Customer VALUES('C026','Gnanalatha','No. 23,Nathathandiya');
INSERT INTO Customer VALUES('C027','Jayarathne','N0.340, Pannipitiya');
INSERT INTO Customer VALUES('C028','Jinasena','No.40,Panadura');
INSERT INTO Customer VALUES('C029','Jinadasa','No.124, Jaffna Road Rambawa');
INSERT INTO Customer VALUES('C030','Jinasoma','No.34, Kandy Road Matale');
INSERT INTO Customer VALUES('C031','Amarasena','No.89, Kandy Road Polonaruwa');
INSERT INTO Customer VALUES('C032','Jinasoma','No.99, Kandy Road Matugama');


INSERT INTO Item VALUES('I001','Keerisamba Retail',105.00,3000);
INSERT INTO Item VALUES('I002','Keerisamba 5Kg ',525.00,200);
INSERT INTO Item VALUES('I003','Keerisamba 10Kg',995.00,36);
INSERT INTO Item VALUES('I004','Keerisamba 50Kg',4100.00,36);
INSERT INTO Item VALUES('I005','Red Raw Rice',60.00,6000);
INSERT INTO Item VALUES('I006','Red Raw Rice 10Kg Pack',560.00,300);
INSERT INTO Item VALUES('I007','Red Raw Rice 50Kg Pack',5230.00,80);
INSERT INTO Item VALUES('I008','White Raw Rice 5Kg Pack',275.00,130);
INSERT INTO Item VALUES('I009','White Raw Rice 50Kg Pack',2600.00,13);
INSERT INTO Item VALUES('I010','Wattana Dhal 500g',90.00,83);
INSERT INTO Item VALUES('I011','Wattana Dhal 1Kg',170.00,40);
INSERT INTO Item VALUES('I012','Mysoor Dhal 500g',90.00,89);
INSERT INTO Item VALUES('I013','Mysoor Dhal 1Kg',180.00,59);
INSERT INTO Item VALUES('I014','Orient Green Gram 500g',118.00,39);
INSERT INTO Item VALUES('I015','Orient Green Gram 1Kg',220.00,12);
INSERT INTO Item VALUES('I016','Anchor F/C Milk powder 450g',220.00,93);
INSERT INTO Item VALUES('I017','Anchor F/C Milk powder 1Kg',580.00,40);
INSERT INTO Item VALUES('I018','Anchor N/F Milk powder 1Kg',560.00,33);
INSERT INTO Item VALUES('I019','Milo Packet 400g',240.00,33);
INSERT INTO Item VALUES('I020','Lipton Ceylon Tea 100g',107.00,40);
INSERT INTO Item VALUES('I021','Lipton Ceylon Tea 200g',198.00,40);
INSERT INTO Item VALUES('I022','Lipton Ceylon Tea 400g',360.00,20);
INSERT INTO Item VALUES('I023','White Suger 500g',55.00,45);
INSERT INTO Item VALUES('I024','White Suger 1Kg',109.00,25);
INSERT INTO Item VALUES('I025','Astra Margarine 250g',129.00,25);
INSERT INTO Item VALUES('I026','Astra Margarine 500g',229.00,15);
INSERT INTO Item VALUES('I027','Rice Noodle 200g',65.00,25);
INSERT INTO Item VALUES('I028','Rice Noodle 500g',140.00,35);
INSERT INTO Item VALUES('I029','Red Rice Noodle 500g',150.00,35);
INSERT INTO Item VALUES('I030','Coka Cola 1.5L',160.00,30);
INSERT INTO Item VALUES('I031','Coka Cola 500ml',60.00,30);
INSERT INTO Item VALUES('I032','Pepsi 500ml',55.00,30);
INSERT INTO Item VALUES('I033','Pepsi 1.5L',160.00,30);
INSERT INTO Item VALUES('I034','Sprite 500ml',55.00,30);
INSERT INTO Item VALUES('I035','Sprite 1.5L',160.00,30);
INSERT INTO Item VALUES('I036','Tomato Sauce Bottle',340.00,30);
INSERT INTO Item VALUES('I037','Chillie Sauce Bottle',320.00,30);
INSERT INTO Item VALUES('I038','Raw Chillie 100g',40.00,30);
INSERT INTO Item VALUES('I039','Raw Chillie 250g',95.00,30);
INSERT INTO Item VALUES('I040','Raw Chillie 500g',180.00,30);
INSERT INTO Item VALUES('I041','Goraka 100g',25.00,30);
INSERT INTO Item VALUES('I042','Sinnamon Stick 100g',25.00,30);
INSERT INTO Item VALUES('I043','Anchor 400g',425.00,120);


INSERT INTO Orders VALUES('D001','2008-2-5','C001');
INSERT INTO Orders VALUES('D002','2008-2-15','C001');
INSERT INTO Orders VALUES('D003','2008-2-20','C001');
INSERT INTO Orders VALUES('D004','2008-2-28','C001');
INSERT INTO Orders VALUES('D005','2008-3-20','C001');
INSERT INTO Orders VALUES('D006','2008-4-10','C001');
INSERT INTO Orders VALUES('D007','2008-5-10','C001');
INSERT INTO Orders VALUES('D008','2008-6-20','C001');
INSERT INTO Orders VALUES('D009','2008-8-12','C001');
INSERT INTO Orders VALUES('D010','2008-9-20','C001');
INSERT INTO Orders VALUES('D011','2008-2-6','C002');
INSERT INTO Orders VALUES('D012','2008-2-16','C002');
INSERT INTO Orders VALUES('D013','2008-2-20','C002');
INSERT INTO Orders VALUES('D014','2008-3-16','C002');
INSERT INTO Orders VALUES('D015','2008-4-15','C002');
INSERT INTO Orders VALUES('D016','2008-8-26','C002');
INSERT INTO Orders VALUES('D017','2008-2-16','C003');
INSERT INTO Orders VALUES('D018','2008-3-26','C003');
INSERT INTO Orders VALUES('D019','2008-6-11','C003');
INSERT INTO Orders VALUES('D020','2008-9-26','C003');


INSERT INTO OrderDetail VALUES('D006',	'I003',	9,995.00);
INSERT INTO OrderDetail VALUES('D006',	'I020',	8,107.00);
INSERT INTO OrderDetail VALUES('D007',	'I020',	10,107.00);
INSERT INTO OrderDetail VALUES('D008',	'I001',	3,105.00);
INSERT INTO OrderDetail VALUES('D009',	'I002',	2,525.00);
INSERT INTO OrderDetail VALUES('D009',	'I003',	2,995.00);
INSERT INTO OrderDetail VALUES('D001',	'I001',	3,105.00);
INSERT INTO OrderDetail VALUES('D001',	'I002',	5,525.00);
INSERT INTO OrderDetail VALUES('D001',	'I003',	8,995.00);
INSERT INTO OrderDetail VALUES('D001',	'I006',	10,560.00);
INSERT INTO OrderDetail VALUES('D002',	'I002',	4,525.00);
INSERT INTO OrderDetail VALUES('D002',	'I003',	4,995.00);
INSERT INTO OrderDetail VALUES('D002',	'I008',	3,275.00);
INSERT INTO OrderDetail VALUES('D002',	'I010',	12,90.00);
INSERT INTO OrderDetail VALUES('D002',	'I012',	3,90.00);
INSERT INTO OrderDetail VALUES('D003',	'I001',	9,105.00);
INSERT INTO OrderDetail VALUES('D003',	'I004',	6,4100.00);
INSERT INTO OrderDetail VALUES('D003',	'I016',	70,220.00);
INSERT INTO OrderDetail VALUES('D004',	'I002',	12,525.00);
INSERT INTO OrderDetail VALUES('D004',	'I005',	7,60.00);
INSERT INTO OrderDetail VALUES('D004',	'I008',	10,275.00);
INSERT INTO OrderDetail VALUES('D004',	'I013',	9,180.00);
INSERT INTO OrderDetail VALUES('D004',	'I015',	5,220.00);
INSERT INTO OrderDetail VALUES('D004',	'I016',	8,220.00);
INSERT INTO OrderDetail VALUES('D004',	'I020',	5,107.00);
INSERT INTO OrderDetail VALUES('D004',	'I021',	2,198.00);
INSERT INTO OrderDetail VALUES('D004',	'I022',	3,360.00);
INSERT INTO OrderDetail VALUES('D004',	'I024',	4,109.00);
INSERT INTO OrderDetail VALUES('D005',	'I001',	6,105.00);
INSERT INTO OrderDetail VALUES('D005',	'I003',	8,995.00);
INSERT INTO OrderDetail VALUES('D005',	'I007',	90,5230.00);
INSERT INTO OrderDetail VALUES('D009',	'I005',	2,60.00);
INSERT INTO OrderDetail VALUES('D009',	'I007',	9,5230.00);
INSERT INTO OrderDetail VALUES('D009',	'I008',	2,275.00);
INSERT INTO OrderDetail VALUES('D009',	'I010',	9,90.00);
INSERT INTO OrderDetail VALUES('D009',	'I023',	5,55.00);
INSERT INTO OrderDetail VALUES('D010',	'I010',	6,90.00);
INSERT INTO OrderDetail VALUES('D010',	'I012',	3,90.00);
INSERT INTO OrderDetail VALUES('D010',	'I014',	6,118.00);
INSERT INTO OrderDetail VALUES('D010',	'I015',	6,220.00);
INSERT INTO OrderDetail VALUES('D010',	'I016',	5,220.00);
INSERT INTO OrderDetail VALUES('D010',	'I040',	3,180.00);
INSERT INTO OrderDetail VALUES('D010',	'I041',	2,25.00);
INSERT INTO OrderDetail VALUES('D012',	'I001',	2,105.00);
INSERT INTO OrderDetail VALUES('D012',	'I003',	4,995.00);
INSERT INTO OrderDetail VALUES('D013',	'I005',	4,60.00);
INSERT INTO OrderDetail VALUES('D013',	'I009',	8,2600.00);
INSERT INTO OrderDetail VALUES('D014',	'I006',	9,560.00);
INSERT INTO OrderDetail VALUES('D014',	'I009',	4,2600.00);
INSERT INTO OrderDetail VALUES('D014',	'I019',	3,240.00);
INSERT INTO OrderDetail VALUES('D014',	'I020',	7,107.00);
INSERT INTO OrderDetail VALUES('D014',	'I021',	3,198.00);
INSERT INTO OrderDetail VALUES('D014',	'I025',	6,129.00);
INSERT INTO OrderDetail VALUES('D015',	'I021',	8,198.00);
INSERT INTO OrderDetail VALUES('D015',	'I022',	3,360.00);
INSERT INTO OrderDetail VALUES('D015',	'I027',	4,65.00);
INSERT INTO OrderDetail VALUES('D015',	'I029',	5,150.00);
INSERT INTO OrderDetail VALUES('D015',	'I032',	41,55.00);
INSERT INTO OrderDetail VALUES('D015',	'I034',	5,55.00);
INSERT INTO OrderDetail VALUES('D015',	'I036',	6,340.00);
INSERT INTO OrderDetail VALUES('D015',	'I038',	4,40.00);
INSERT INTO OrderDetail VALUES('D016',	'I001',	3,105.00);
INSERT INTO OrderDetail VALUES('D016',	'I003',	10,995.00);
INSERT INTO OrderDetail VALUES('D016',	'I007',	3,5230.00);
INSERT INTO OrderDetail VALUES('D016',	'I009',	19,2600.00);
INSERT INTO OrderDetail VALUES('D016',	'I011',	7,170.00);
INSERT INTO OrderDetail VALUES('D017',	'I001',	12,105.00);
INSERT INTO OrderDetail VALUES('D017',	'I004',	4,4100.00);
INSERT INTO OrderDetail VALUES('D017',	'I007',	7,5230.00);
INSERT INTO OrderDetail VALUES('D017',	'I009',	5,2600.00);
INSERT INTO OrderDetail VALUES('D017',	'I010',	5,90.00);
INSERT INTO OrderDetail VALUES('D017',	'I012',	4,90.00);
INSERT INTO OrderDetail VALUES('D017',	'I019',	4,240.00);
INSERT INTO OrderDetail VALUES('D018',	'I001',	4,105.00);
INSERT INTO OrderDetail VALUES('D018',	'I003',	4,995.00);
INSERT INTO OrderDetail VALUES('D018',	'I005',	3,60.00);
INSERT INTO OrderDetail VALUES('D018',	'I010',	3,90.00);
INSERT INTO OrderDetail VALUES('D018',	'I026',	9,229.00);
INSERT INTO OrderDetail VALUES('D019',	'I009',	2,2600.00);
INSERT INTO OrderDetail VALUES('D019',	'I010',	3,90.00);
INSERT INTO OrderDetail VALUES('D019',	'I018',	1,560.00);
INSERT INTO OrderDetail VALUES('D019',	'I019',	8,240.00);
INSERT INTO OrderDetail VALUES('D019',	'I031',	3,60.00);
INSERT INTO OrderDetail VALUES('D020',	'I001',	12,105.00);
INSERT INTO OrderDetail VALUES('D020',	'I004',	9,4100.00);
INSERT INTO OrderDetail VALUES('D020',	'I006',	12,60.00);
INSERT INTO OrderDetail VALUES('D020',	'I019',	12,240.00);





