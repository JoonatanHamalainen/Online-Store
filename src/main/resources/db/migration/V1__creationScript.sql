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
  enabled BOOLEAN NOT NULL,
  PRIMARY KEY (Username)
);

CREATE TABLE Roles(
  RoleID INT NOT NULL,
  Name VARCHAR(45) NOT NULL,
  PRIMARY KEY (RoleID)
);

CREATE TABLE UserRoles(
  Username VARCHAR(25) NOT NULL,
  RoleID INT NOT NULL,
  FOREIGN KEY (RoleID) REFERENCES Roles (RoleID),
  FOREIGN KEY (Username) REFERENCES Users (Username)
);

CREATE TABLE Orders(
  OrderID UUID NOT NULL,
  OrderDate DATE NOT NULL,
  DeliveryStatus VARCHAR(50) NOT NULL,
  TotalPrice FLOAT NOT NULL,
  Username VARCHAR(25) NOT NULL,
  PRIMARY KEY (OrderID),
  FOREIGN KEY (Username) REFERENCES Users(Username)
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
  Username VARCHAR(25) NOT NULL,
  FOREIGN KEY (ProductID) REFERENCES Product(ProductID),
  FOREIGN KEY (Username) REFERENCES Users(Username  )
);