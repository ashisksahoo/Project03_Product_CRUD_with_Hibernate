# Product Management System with Hibernate

A Java console application that implements a complete Product Management System using Hibernate ORM for database operations. This project demonstrates CRUD (Create, Read, Update, Delete) operations with MySQL database using Hibernate framework.

## 📋 Project Overview

This application enables store administrators to manage product inventory through a console-based interface. It provides functionality to create product tables, insert new products, view all product details, and update or delete existing product records using Hibernate ORM for seamless database interactions.

## 🎯 Features

- **Create Product Table**: Initialize database with product table structure using Hibernate
- **Insert Product**: Add new product records to the database
- **View All Products**: Display all product details in the console
- **Update Product**: Modify existing product information
- **Delete Product**: Remove product records from the database
- **Hibernate ORM**: Object-Relational Mapping for database operations
- **DAO Pattern**: Clean separation of business logic and data access layer

## 🛠️ Technologies Used

- **Java**: Core programming language
- **Hibernate ORM**: Object-Relational Mapping framework
- **MySQL**: Relational database management system
- **JPA Annotations**: Java Persistence API for entity mapping
- **Maven/Manual Dependency Management**: Project build and dependency management
- **DAO Pattern**: Data Access Object design pattern

## 📁 Project Structure

```
Project03_Product_CRUD_with_Hibernate/
├── .settings/              # IDE configuration files
├── bin/                    # Compiled class files
├── lib/                    # Hibernate and dependency JAR files
│   ├── hibernate-core.jar
│   ├── mysql-connector.jar
│   └── other dependencies...
├── src/
│   └── com/techpalle/
│       ├── controller/
│       │   └── ProductMainClass.java  # Main class with menu
│       ├── dao/
│       │   └── ProductDAO.java        # Data Access Object
│       ├── model/
│       │   └── Product.java           # Entity/Bean class
│       └── hibernate.cfg.xml          # Hibernate configuration
├── .classpath              # Java classpath configuration
└── .project                # Project configuration
```

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- MySQL Server 5.7 or higher
- Hibernate Framework 5.x or higher
- MySQL JDBC Driver (Connector/J)
- IDE (Eclipse, IntelliJ IDEA, or similar)

### Required Hibernate Dependencies

Add the following JAR files to your `lib/` folder:
- `hibernate-core-5.x.x.jar`
- `hibernate-commons-annotations.jar`
- `hibernate-jpa-2.1-api.jar`
- `jboss-logging.jar`
- `jboss-transaction-api.jar`
- `dom4j.jar`
- `mysql-connector-java-8.x.x.jar`

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/ashisksahoo/Project03_Product_CRUD_with_Hibernate.git
   cd Project03_Product_CRUD_with_Hibernate
   ```

2. **Set up MySQL Database**
   ```sql
   CREATE DATABASE product_store;
   ```

3. **Configure Hibernate**
   
   Update `src/hibernate.cfg.xml` with your database credentials:
   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <!DOCTYPE hibernate-configuration PUBLIC
       "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
       "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
   <hibernate-configuration>
       <session-factory>
           <!-- Database connection settings -->
           <property name="connection.driver_class">com.mysql.cj.jdbc.Driver</property>
           <property name="connection.url">jdbc:mysql://localhost:3306/product_store</property>
           <property name="connection.username">root</property>
           <property name="connection.password">your_password</property>
           
           <!-- JDBC connection pool settings -->
           <property name="connection.pool_size">10</property>
           
           <!-- SQL dialect -->
           <property name="dialect">org.hibernate.dialect.MySQL8Dialect</property>
           
           <!-- Echo all executed SQL to stdout -->
           <property name="show_sql">true</property>
           <property name="format_sql">true</property>
           
           <!-- Drop and re-create the database schema on startup -->
           <property name="hbm2ddl.auto">update</property>
           
           <!-- Mapping classes -->
           <mapping class="com.techpalle.model.Product"/>
       </session-factory>
   </hibernate-configuration>
   ```

4. **Add Dependencies**
   - Place all required Hibernate JAR files in the `lib/` folder
   - Add them to your project's build path

5. **Compile and Run**
   ```bash
   javac -d bin -cp "lib/*" src/com/techpalle/**/*.java
   java -cp "bin:lib/*" com.techpalle.controller.ProductMainClass
   ```

## 💻 Usage

When you run the application, you'll see a menu with the following options:

```
=== Product Management System ===
1. Add New Product
2. View All Products
3. Update Product
4. Delete Product
5. Search Product by ID
6. Exit

Enter your choice:
```

### Example Operations

**Add Product**
- Enter product details:
  - Product Name
  - Product Category
  - Product Price
  - Quantity in Stock
- Product will be saved using Hibernate

**View All Products**
- Displays all products in formatted output
- Shows: Product ID, Name, Category, Price, Stock

**Update Product**
- Enter product ID to update
- Modify product details
- Changes persisted through Hibernate

**Delete Product**
- Enter product ID to delete
- Confirmation displayed after deletion

**Search Product**
- Enter product ID to search
- Displays detailed product information

## 🏗️ Architecture

The project follows the **DAO (Data Access Object)** pattern with **Hibernate ORM**:

### Model Layer
```java
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    
    @Column(name = "product_name", nullable = false)
    private String productName;
    
    @Column(name = "category")
    private String category;
    
    @Column(name = "price")
    private double price;
    
    @Column(name = "stock_quantity")
    private int stockQuantity;
    
    // Getters and setters
}
```

### DAO Layer
- **ProductDAO.java**: Handles all database operations using Hibernate Session
  - `save(Product product)` - Insert product
  - `findAll()` - Retrieve all products
  - `findById(int id)` - Get product by ID
  - `update(Product product)` - Update product
  - `delete(int id)` - Delete product

### Controller Layer
- **ProductMainClass.java**: Main application with console menu and user interaction

## 📊 Database Schema

```sql
CREATE TABLE products (
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(100) NOT NULL,
    category VARCHAR(50),
    price DECIMAL(10, 2),
    stock_quantity INT,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

*Note: Hibernate automatically creates/updates the table based on `@Entity` annotations and `hbm2ddl.auto` setting.*

## 🔑 Key Hibernate Features Used

- **Session Management**: Proper opening and closing of Hibernate sessions
- **Transaction Management**: ACID compliance for all operations
- **Annotations**: JPA annotations for entity mapping
- **HQL (Hibernate Query Language)**: Object-oriented queries
- **Automatic Schema Generation**: Using `hbm2ddl.auto` property
- **Connection Pooling**: Efficient database connection management

## 🆚 Advantages Over JDBC

| Feature | JDBC | Hibernate |
|---------|------|-----------|
| Code Complexity | High | Low |
| SQL Queries | Manual | Automatic |
| Database Independence | Low | High |
| Caching | Manual | Built-in |
| Object Mapping | Manual | Automatic |
| Maintenance | Difficult | Easy |

## ⚙️ Configuration Options

### hibernate.cfg.xml Properties

```xml
<!-- Show SQL queries in console -->
<property name="show_sql">true</property>

<!-- Format SQL for readability -->
<property name="format_sql">true</property>

<!-- Schema generation options -->
<property name="hbm2ddl.auto">update</property>
<!-- Options: create, create-drop, update, validate, none -->
```

## 🔒 Best Practices Implemented

- ✅ Proper session management with try-catch-finally blocks
- ✅ Transaction rollback on errors
- ✅ Resource cleanup (closing sessions)
- ✅ Use of JPA annotations for entity mapping
- ✅ Separation of concerns (DAO pattern)
- ✅ Exception handling throughout the application

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 Future Enhancements

- [ ] Add product search by name/category
- [ ] Implement pagination for large product lists
- [ ] Add product image storage
- [ ] Generate inventory reports
- [ ] Implement low-stock alerts
- [ ] Add batch operations (bulk insert/update)
- [ ] Create web-based UI using Spring Boot
- [ ] Add REST API endpoints

## 🐛 Troubleshooting

### Common Issues

**Issue**: `ClassNotFoundException: org.hibernate.cfg.Configuration`
- **Solution**: Ensure all Hibernate JAR files are in the `lib/` folder and added to classpath

**Issue**: `No Dialect mapping for JDBC type`
- **Solution**: Update dialect to match your MySQL version in `hibernate.cfg.xml`

**Issue**: `Unable to build EntityManagerFactory`
- **Solution**: Check database credentials and ensure MySQL server is running

## 📄 License

This project is open source and available for educational purposes.

## 👤 Author

**Ashisk Sahoo**
- GitHub: [@ashisksahoo](https://github.com/ashisksahoo)

## 🙏 Acknowledgments

- Tech Palle for project guidance
- Hibernate ORM documentation
- MySQL documentation
- Java Persistence API (JPA) community

## 📚 Learning Resources

- [Hibernate Official Documentation](https://hibernate.org/orm/documentation/)
- [JPA Annotations Guide](https://www.baeldung.com/jpa-entities)
- [MySQL Documentation](https://dev.mysql.com/doc/)

## 📧 Support

For issues, questions, or suggestions:
- Open an issue in the GitHub repository
- Contact the author through GitHub

---

**Note**: This is an educational project demonstrating Hibernate ORM usage with the DAO pattern. The project showcases the advantages of using ORM frameworks over traditional JDBC for database operations.
