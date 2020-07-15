
CREATE TABLE Users
(
  UserID UUID NOT NULL,
  Gender VARCHAR(50) NOT NULL,
  Phone VARCHAR(50) NOT NULL,
  Username VARCHAR(50) NOT NULL,
  Fullname VARCHAR(50) NOT NULL,
  UserPassword VARCHAR(50) NOT NULL,
  Email VARCHAR(50) NOT NULL,
  Birthdate DATE NOT NULL,
  Address VARCHAR(50) NOT NULL,
  PRIMARY KEY (UserID)
);


CREATE TABLE Orders
(
  OrderID UUID NOT NULL,
  OrderDate DATE NOT NULL,
  DeliveryStatus VARCHAR(50) NOT NULL,
  TotalPrice FLOAT NOT NULL,
  UserID UUID NOT NULL,
  PRIMARY KEY (OrderID),
  FOREIGN KEY (UserID) REFERENCES Users(UserID)
);

CREATE TABLE ProductTypes
(
  ProductTypeID INT NOT NULL,
  ProductTypeName VARCHAR(50) NOT NULL,
  PRIMARY KEY (ProductTypeID)
);

CREATE TABLE Product
(
  ProductID UUID NOT NULL,
  Price FLOAT NOT NULL,
  ProductName VARCHAR(50) NOT NULL,
  ImageSource VARCHAR(500) NOT NULL,
  Stock INT NOT NULL,
  Description VARCHAR(255) NOT NULL,
  ProductTypeID INT NOT NULL,
  PRIMARY KEY (ProductID),
  FOREIGN KEY (ProductTypeID) REFERENCES ProductTypes(ProductTypeID)
);

CREATE TABLE OrderProduct
(
  Quantity INT NOT NULL,
  OrderID UUID NOT NULL,
  ProductID UUID NOT NULL,
  FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
  FOREIGN KEY (ProductID) REFERENCES Product(ProductID)
);

CREATE TABLE ShoppingCart
(
  Quantity INT NOT NULL,
  ProductID UUID,
  UserID UUID NOT NULL,
  FOREIGN KEY (ProductID) REFERENCES Product(ProductID),
  FOREIGN KEY (UserID) REFERENCES Users(UserID)
);




