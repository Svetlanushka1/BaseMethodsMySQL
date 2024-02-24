package examples;

public class SQLexample {/*
    -- Create Database
    CREATE DATABASE IF NOT EXISTS telran40;
    USE telran40;

-- Create Personal Table
    CREATE TABLE IF NOT EXISTS personal (
            person_id INT PRIMARY KEY AUTO_INCREMENT,
            first_name VARCHAR(50),
    last_name VARCHAR(50),
    birth_date DATE,
    address VARCHAR(100)
);

-- Create Customer Table
    CREATE TABLE IF NOT EXISTS customer (
            customer_id INT PRIMARY KEY AUTO_INCREMENT,
            person_id INT,
            email VARCHAR(100),
    phone_number VARCHAR(20),
    FOREIGN KEY (person_id) REFERENCES personal(person_id)
            );

-- Create Order Table
    CREATE TABLE IF NOT EXISTS order_table (
            order_id INT PRIMARY KEY AUTO_INCREMENT,
            customer_id INT,
            order_date DATE,
            total_amount DECIMAL(10, 2),
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
            );

-- Create Product Table
    CREATE TABLE IF NOT EXISTS product (
            product_id INT PRIMARY KEY AUTO_INCREMENT,
            product_name VARCHAR(50),
    price DECIMAL(8, 2)
);

-- Create Order_Item Table
    CREATE TABLE IF NOT EXISTS order_item (
            order_item_id INT PRIMARY KEY AUTO_INCREMENT,
            order_id INT,
            product_id INT,
            quantity INT,
            subtotal DECIMAL(10, 2),
    FOREIGN KEY (order_id) REFERENCES order_table(order_id),
    FOREIGN KEY (product_id) REFERENCES product(product_id)
            );

-- Insert Sample Data
    INSERT INTO personal (first_name, last_name, birth_date, address)
    VALUES ('John', 'Doe', '1990-01-01', '123 Main St'),
       ('Jane', 'Smith', '1985-05-15', '456 Oak St');

    INSERT INTO customer (person_id, email, phone_number)
    VALUES (1, 'john.doe@example.com', '555-1234'),
       (2, 'jane.smith@example.com', '555-5678');

    INSERT INTO product (product_name, price)
    VALUES ('Laptop', 999.99),
       ('Smartphone', 499.99);

    INSERT INTO order_table (customer_id, order_date, total_amount)
    VALUES (1, '2024-01-14', 1499.98),
       (2, '2024-01-15', 999.99);

    INSERT INTO order_item (order_id, product_id, quantity, subtotal)
    VALUES (1, 1, 2, 1999.98),
       (2, 2, 1, 499.99);

-- Create Views
    CREATE VIEW customer_order_view AS
    SELECT
    c.customer_id,
    CONCAT(p.first_name, ' ', p.last_name) AS customer_name,
    o.order_id,
    o.order_date,
    o.total_amount
            FROM
    customer c
    JOIN order_table o ON c.customer_id = o.customer_id
    JOIN personal p ON c.person_id = p.person_id;

-- Create Indexes
    CREATE INDEX idx_customer_email ON customer(email);
    CREATE INDEX idx_product_name ON product(product_name);
    CREATE INDEX idx_order_date ON order_table(order_date);

-- Example Join Query
    SELECT *
    FROM customer_order_view
    WHERE order_date >= '2024-01-14';
*/

}
